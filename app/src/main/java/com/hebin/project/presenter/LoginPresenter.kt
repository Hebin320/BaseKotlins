package com.hebin.project.presenter

import android.content.Context
import com.hebin.base.Baseurl
import com.hebin.project.anko.*
import com.hebin.project.base.okgo.BaseOkgoGet
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout
import com.zerom.management.mInterface.base.SuccessListener
import com.zerom.management.mInterface.base.UniversalView

/**
 * Author Hebin
 * <p>
 * created at 2018/4/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class LoginPresenter(val context: Context, val view: UniversalView) : SuccessListener {

    companion object {
        const val SUCCESS_FOR_LOGIN = 1
    }

    fun login(isShow: Boolean) {
        BaseOkgoGet()
                .showLoading(isShow)
                .setType(SUCCESS_FOR_LOGIN)
                .setUrl(Baseurl.look(context))
                .setView(view)
                .setListener(this)
                .request(context)

    }

    fun time(isShow: Boolean) {
        BaseOkgoGet()
                .showLoading(isShow)
                .setType(SUCCESS_FOR_LOGIN)
                .setUrl(Baseurl.time(context))
                .setView(view)
                .setListener(this)
                .request(context)
    }

    override fun onSuccess(context: Context, type: Any, results: String) {
    }
}