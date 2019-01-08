package com.zerom.easyquery.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zerom.easyquery.anko.hideDialog
import com.zerom.easyquery.anko.showDialog
import com.zerom.easyquery.hxbinterface.BaseView

/**
 * Author Hebin
 * <p>
 * created at 2019/1/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class BaseFragment : Fragment(), BaseView {

    override fun showLoading() {
        activity?.showDialog()
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