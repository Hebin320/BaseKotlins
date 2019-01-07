package com.huburt.library.ui

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import com.huburt.library.*
import com.huburt.library.adapter.ImageFolderAdapter
import com.huburt.library.adapter.ImageRecyclerAdapter
import com.huburt.library.bean.ImageFolder
import com.huburt.library.bean.ImageItem
import com.huburt.library.util.CameraUtil
import com.huburt.library.util.Utils
import com.huburt.library.util.isSameDate
import com.huburt.library.view.FolderPopUpWindow
import com.huburt.library.view.GridSpacingItemDecoration
import kotlinx.android.synthetic.main.activity_image_grid.*
import kotlinx.android.synthetic.main.include_top_bar.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by hubert
 *
 * Created on 2017/10/12.
 */
class ImageGridActivity : BaseActivity(), View.OnClickListener, ImageDataSource.OnImagesLoadedListener, ImageRecyclerAdapter.OnImageItemClickListener {
    companion object {

        val REQUEST_PERMISSION_STORAGE = 0x12
        val REQUEST_PERMISSION_CAMERA = 0x13
        val REQUEST_CAMERA = 0x23
        val REQUEST_PREVIEW = 0x9
        val REQUEST_CROP = 0x10
        val INTENT_MAX = 1000

        /**
         * @param takePhoto 是否直接开启拍照
         */
        fun startForResult(activity: Activity, requestCode: Int, takePhoto: Boolean) {
            val intent = Intent(activity, ImageGridActivity::class.java)
            intent.putExtra(C.EXTRA_TAKE_PHOTO, takePhoto)
            activity.startActivityForResult(intent, requestCode)
        }
    }

    private val pickerHelper: PickHelper = ImagePicker.pickHelper
    private val imageDataSource = ImageDataSource(this)
    private lateinit var adapter: ImageRecyclerAdapter
    private lateinit var mFolderPopupWindow: FolderPopUpWindow
    private lateinit var mImageFolderAdapter: ImageFolderAdapter
    private lateinit var imageFolders: List<ImageFolder>
    private lateinit var takeImageFile: File
    private var takePhoto: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_grid)
        //是否直接打开相机
        takePhoto = intent.extras[C.EXTRA_TAKE_PHOTO] as Boolean
        if (takePhoto) {
            onCameraClick()
        }

        initView()
        initPopWindow()
        loadData()
    }

    private fun loadData() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), REQUEST_PERMISSION_STORAGE)
        } else {
            imageDataSource.loadImage(this)
        }
    }

    override fun onResume() {
        super.onResume()
        //数据刷新
        adapter.notifyDataSetChanged()
        onCheckChanged(pickerHelper.selectedImages.size, pickerHelper.limit)
    }

    private fun initView() {
        ll_dir.setOnClickListener(this)
        btn_ok.setOnClickListener(this)
        btn_back.setOnClickListener(this)
        btn_preview.setOnClickListener(this)

        recycler.layoutManager = GridLayoutManager(this, 3)
        recycler.addItemDecoration(GridSpacingItemDecoration(3, Utils.dp2px(this, 2f), false))
        adapter = ImageRecyclerAdapter(this, pickerHelper)
        adapter.listener = this
        recycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (tv_date.visibility == View.VISIBLE) {
                        tv_date.animation = AnimationUtils.loadAnimation(this@ImageGridActivity, R.anim.fade_out)
                        tv_date.visibility = View.GONE
                    }
                } else {
                    if (tv_date.visibility == View.GONE) {
                        tv_date.animation = AnimationUtils.loadAnimation(this@ImageGridActivity, R.anim.fade_in)
                        tv_date.visibility = View.VISIBLE
                    }
                    val gridLayoutManager = recycler.layoutManager as GridLayoutManager
                    val position = gridLayoutManager.findFirstCompletelyVisibleItemPosition()
                    val addTime = adapter.getItem(position)?.addTime
                    Log.d("hubert", "图片，position：$position ,addTime: $addTime")
                    if (addTime != null) {
                        val calendar = Calendar.getInstance()
                        calendar.timeInMillis = addTime * 1000
                        if (isSameDate(calendar.time, Calendar.getInstance().time)) {
                            tv_date.text = "本周"
                        } else {
                            val format = SimpleDateFormat("yyyy/MM", Locale.getDefault())
                            tv_date.text = format.format(calendar.time)
                        }
                    }
                }
            }
        })

        if (pickerHelper.isMultiMode) {
            btn_ok.visibility = View.VISIBLE
            btn_preview.visibility = View.VISIBLE
        } else {
            btn_ok.visibility = View.GONE
            btn_preview.visibility = View.GONE
        }
    }

    private fun initPopWindow() {
        mImageFolderAdapter = ImageFolderAdapter(this, null)
        mFolderPopupWindow = FolderPopUpWindow(this, mImageFolderAdapter)
        mFolderPopupWindow.setOnItemClickListener(object : FolderPopUpWindow.OnItemClickListener {
            override fun onItemClick(adapterView: AdapterView<*>, view: View, position: Int, l: Long) {
                mImageFolderAdapter.selectIndex = position
                mFolderPopupWindow.dismiss()
                val imageFolder = adapterView.adapter?.getItem(position) as ImageFolder
                adapter.refreshData(imageFolder.images)
                tv_dir.text = imageFolder.name
            }
        })
        footer_bar.post({ mFolderPopupWindow.setMargin(footer_bar.height) })
    }

    private fun showPopupFolderList() {
        mImageFolderAdapter.refreshData(imageFolders.toMutableList())  //刷新数据
        if (mFolderPopupWindow.isShowing) {
            mFolderPopupWindow.dismiss()
        } else {
            mFolderPopupWindow.showAtLocation(footer_bar, Gravity.NO_GRAVITY, 0, 0)
            //默认选择当前选择的上一个，当目录很多时，直接定位到已选中的条目
            var index = mImageFolderAdapter.selectIndex
            index = if (index == 0) index else index - 1
            mFolderPopupWindow.setSelection(index)
        }
    }

    override fun onImageItemClick(imageItem: ImageItem, position: Int) {
        if (pickerHelper.isMultiMode) {
            var images = adapter.images
            var p = position
            if (images.size > INTENT_MAX) {//数据量过大
                val s: Int
                val e: Int
                if (position < images.size / 2) {//点击position在list靠前
                    s = Math.max(position - INTENT_MAX / 2, 0)
                    e = Math.min(s + INTENT_MAX, images.size)
                } else {
                    e = Math.min(position + INTENT_MAX / 2, images.size)
                    s = Math.max(e - INTENT_MAX, 0)
                }
                p = position - s
                Log.e("hubert", "start:$s , end:$e , position:$p")
//            images = ArrayList()
//            for (i in s until e) {
//                images.add(adapter.images[i])
//            }
                //等同于上面，IDE提示换成的Kotlin的高阶函数
                images = (s until e).mapTo(ArrayList()) { adapter.images[it] }
            }
            ImagePreviewActivity.startForResult(this, REQUEST_PREVIEW, p, images)
        } else {
            pickerHelper.selectedImages.clear()
            pickerHelper.selectedImages.add(imageItem)
            if (pickerHelper.isCrop) {//需要裁剪
                ImageCropActivity.start(this, REQUEST_CROP)
            } else {
                setResult()
            }
        }
    }

    override fun onCheckChanged(selected: Int, limit: Int) {
        if (selected == 0) {
            btn_ok.isEnabled = false
            btn_ok.text = getString(R.string.ip_complete)
            btn_ok.setTextColor(resources.getColor(R.color.ip_text_secondary_inverted))
            btn_preview.isEnabled = false
            btn_preview.text = getString(R.string.ip_preview)
            btn_preview.setTextColor(resources.getColor(R.color.ip_text_secondary_inverted))
        } else {
            btn_ok.isEnabled = true
            btn_ok.text = getString(R.string.ip_select_complete, selected, limit)
            btn_ok.setTextColor(resources.getColor(R.color.ip_text_primary_inverted))
            btn_preview.isEnabled = true
            btn_preview.text = getString(R.string.ip_preview_count, selected)
            btn_preview.setTextColor(resources.getColor(R.color.ip_text_primary_inverted))
        }
    }

    override fun onCameraClick() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),
                    ImageGridActivity.REQUEST_PERMISSION_CAMERA)
        } else {
            takeImageFile = CameraUtil.takePicture(this, REQUEST_CAMERA)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSION_STORAGE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                imageDataSource.loadImage(this)
            } else {
                showToast("权限被禁止，无法选择本地图片")
            }
        } else if (requestCode == REQUEST_PERMISSION_CAMERA) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                takeImageFile = CameraUtil.takePicture(this, REQUEST_CAMERA)
            } else {
                showToast("权限被禁止，无法打开相机")
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CAMERA) {//相机返回
            if (resultCode == Activity.RESULT_OK) {
                Log.e("hubert", takeImageFile.absolutePath)
                //广播通知新增图片
                val mediaScanIntent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                mediaScanIntent.data = Uri.fromFile(takeImageFile)
                sendBroadcast(mediaScanIntent)

                val imageItem = ImageItem(takeImageFile.absolutePath)
                pickerHelper.selectedImages.clear()
                pickerHelper.selectedImages.add(imageItem)

                if (pickerHelper.isCrop) {//需要裁剪
                    ImageCropActivity.start(this, REQUEST_CROP)
                } else {
                    setResult()
                }
            } else if (takePhoto) {//直接拍照返回时不再展示列表
                finish()
            }
        } else if (requestCode == REQUEST_PREVIEW) {//预览界面返回
            if (resultCode == Activity.RESULT_OK) {
                setResult()
            }
        } else if (requestCode == REQUEST_CROP) {//裁剪结果
            if (resultCode == Activity.RESULT_OK) {
                setResult()
            }
        }
    }

    private fun setResult() {
        val result = Intent()
        result.putExtra(C.EXTRA_IMAGE_ITEMS, pickerHelper.selectedImages)
        setResult(Activity.RESULT_OK, result)
        finish()
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.ll_dir -> showPopupFolderList()
            R.id.btn_ok -> setResult()
            R.id.btn_preview -> ImagePreviewActivity.startForResult(this, REQUEST_PREVIEW, 0, pickerHelper.selectedImages)
            R.id.btn_back -> {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
    }

    override fun onImagesLoaded(imageFolders: List<ImageFolder>) {
        this.imageFolders = imageFolders
        if (imageFolders.isNotEmpty()) {
            adapter.refreshData(imageFolders[0].images)
        }
        recycler.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        imageDataSource.destroyLoader()
    }

}
