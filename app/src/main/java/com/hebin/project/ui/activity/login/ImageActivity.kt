package com.hebin.project.ui.activity.login

import android.os.Bundle
import com.hebin.hxbr.getStringExtra
import com.hebin.hxbr.glideNormalImage
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        glideNormalImage(getStringExtra("url"), ivPic)
    }
}
