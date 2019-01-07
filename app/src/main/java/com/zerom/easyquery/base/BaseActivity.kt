@file:Suppress("LeakingThis")

package com.zerom.easyquery.base

import android.content.Context
import android.support.v7.app.AppCompatActivity
import com.zerom.easyquery.anko.hideDialog
import com.zerom.easyquery.anko.showDialog
import com.zerom.easyquery.hxbinterface.BaseView


/**
 * Author Hebin
 * <p>
 * created at 2017/6/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：BaseActivity，所有的Activity都会继承这个Activity，在此Activity中，实现一些公用方法
 */
@Suppress("DEPRECATION")
open class BaseActivity : AppCompatActivity(), BaseView {

    var context: Context = this@BaseActivity



    override fun showLoading() {
        showDialog()
    }

    override fun hideLoading() {
        hideDialog()
    }

    override fun showNullLayout(img: Any) {
    }

    override fun hideNullLayout() {
    }

    override fun showErroLayout() {
    }

    override fun hideErroLayout() {
    }

    override fun getFailed(type: Any, T: Any) {
    }

}