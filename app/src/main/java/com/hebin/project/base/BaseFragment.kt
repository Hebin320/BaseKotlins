package com.hebin.base

import android.support.v4.app.Fragment
import com.taorouw.utils.DialogUtil
import com.hebin.project.mInterface.base.BaseView

/**
 * Author Hebin
 * <p>
 * created at 2017/6/28
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
class BaseFragment : Fragment() , BaseView {
    override fun showLoading() {
        DialogUtil.showDialog(context)
    }

    override fun hideLoading() {
        DialogUtil.hideDialog()
    }

    override fun showNullLayout() {
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