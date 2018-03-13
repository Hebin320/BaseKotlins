package com.hebin.project.widget

import android.content.Context
import android.view.Gravity
import com.hebin.project.R
import com.hebin.widget.dialog.UniversalDialog

/**
 * Author Hebin
 * <p>
 * created at 2018/3/13
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class TestDialog(val context: Context) {

    fun show() {
        UniversalDialog.create(context)
                .setTransparent()
                .setType("1")
                .setLayoutId(R.layout.activity_main)
                .setAnimations(R.style.AnimTop)
                .show()
    }
}