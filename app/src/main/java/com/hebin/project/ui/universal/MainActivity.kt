@file:Suppress("DEPRECATED_IDENTITY_EQUALS")

package com.hebin.project.ui.universal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.hebin.project.widget.TestDialog
import kotlinx.android.synthetic.main.activity_main.*
import me.nereo.multi_image_selector.MultiImageSelector
import me.nereo.multi_image_selector.MultiImageSelectorActivity
import org.jetbrains.anko.startActivity


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvPic.setOnClickListener {
            MultiImageSelector.create()
                    .showCamera(true) // 是否显示相机. 默认为显示
                    .count(6) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                    .single() // 单选模式
                    .multi() // 多选模式, 默认模式;
                    .start(this, 1)
        }
        tvWebView.setOnClickListener {
            //            startActivity<WebviewActivity>()
            TestDialog(context).show()
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
