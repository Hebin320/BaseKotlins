@file:Suppress("LeakingThis")

package com.hebin.project.base

import android.content.Context
import com.hebin.project.anko.hideLoad
import com.hebin.project.anko.showLoad
import com.hebin.utils.ActivityManagerUtil
import com.hebin.project.mInterface.BaseView
import me.imid.swipebacklayout.lib.app.SwipeBackActivity


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
open class BaseActivity : SwipeBackActivity(), BaseView {

    var context: Context = this@BaseActivity

    override fun onStart() {
        super.onStart()
        // 创建Activity的时候，将Activity添加到Activity管理器中
        ActivityManagerUtil.addActivity(this)
    }


    override fun onDestroy() {
        super.onDestroy()
        // 销毁Activity的时候，从Activity管理器中移除
        ActivityManagerUtil.removeActivity(this)
    }


    override fun showLoading() {
        showLoad()
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