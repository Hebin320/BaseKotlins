@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.hebin.project.ui.universal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.TextView
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.hebin.project.ui.login.TestRecyclerviewActivity
import com.hebin.utils.ImageUtil
import kotlinx.android.synthetic.main.activity_main.*
import me.nereo.multi_image_selector.MultiImageSelectorActivity
import org.jetbrains.anko.startActivity
import java.util.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 不开启侧滑关闭Activity
        swipeBackLayout.setEnableGesture(false)
        tvPic.setOnClickListener { ImageUtil.selectImage(this, 9, 0x11) }
        tvWebView.setOnClickListener { startActivity<WebviewActivity>() }
        tvDomain.setOnClickListener {
            startActivity<TestRecyclerviewActivity>()
        }

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 1) {
            if (resultCode === Activity.RESULT_OK) {
                // 获取返回的图片列表
                val path: ArrayList<String> = data?.getStringArrayListExtra(MultiImageSelectorActivity.EXTRA_RESULT) as ArrayList<String>
                for (s in path) {
                    Log.e("Hebin", s)
                }
            }
        }
    }


}

