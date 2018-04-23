package com.hebin.base

import android.support.v4.app.Fragment
import com.hebin.project.anko.hideLoad
import com.hebin.project.anko.showLoad
import com.hebin.project.mInterface.BaseView

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
class BaseFragment : Fragment(), BaseView {
    override fun showLoading() {
        context.showLoad()
    }

    override fun hideLoading() {
        hideLoad()
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