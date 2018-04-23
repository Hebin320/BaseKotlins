package com.hebin.project.presenter

import android.content.Context
import com.hebin.project.base.look
import com.hebin.project.base.time
import com.hebin.project.base.okgo.BaseOkgoGet
import com.hebin.project.mInterface.SuccessListener
import com.hebin.project.mInterface.UniversalView
import com.hebin.project.utils.ResultDealUtil

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
                .setUrl(look(context))
                .setView(view)
                .setListener(this)
                .request(context)

    }

    fun time(isShow: Boolean) {
        BaseOkgoGet()
                .showLoading(isShow)
                .setType(SUCCESS_FOR_LOGIN)
                .setUrl(time(context))
                .setView(view)
                .setListener(this)
                .request(context)
    }

    override fun onSuccess(context: Context, type: Any, results: String) {
        when (type) {
            SUCCESS_FOR_LOGIN -> {
                ResultDealUtil()
                        .creat(context)
                        .setResult(results)
                        .allToast()
                        .getSuccess {

                        }.getFailed {

                        }
            }
        }
    }
}