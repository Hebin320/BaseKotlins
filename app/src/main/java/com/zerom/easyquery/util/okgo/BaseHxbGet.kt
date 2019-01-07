package com.zerom.easyquery.util.okgo

import android.content.Context
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.request.BaseRequest
import com.zerom.easyquery.hxbinterface.SuccessListener
import com.zerom.easyquery.hxbinterface.UniversalView
import com.zerom.easyquery.anko.prinString
import okhttp3.Call
import okhttp3.Response

/**
 * Author Hebin
 *<p>
 * created at 2017/5/5 10:26
 *<p>
 * blog: http://blog.csdn.net/hebin320320
 *<p>
 * GitHub: https://github.com/Hebin320
 *<p>
 * 说明： Get请求
 *<p>
 * Okgo网络请求的通用类，显示、隐藏对话框以及网络（访问后台）出现问题的一致处理
 * 请求成功得到的数据可进行回调给其他Model处理
 */
open class BaseHxbGet {

    var type: Int? = null
    var url: String? = null
    var isShow: Boolean = true
    var universal: UniversalView? = null
    var successListener: SuccessListener? = null


    fun setType(type: Int): BaseHxbGet {
        this.type = type
        return this
    }

    fun setUrl(url: String): BaseHxbGet {
        this.url = url
        return this
    }

    fun showLoading(isShow: Boolean): BaseHxbGet {
        this.isShow = isShow
        return this
    }

    fun setView(universal: UniversalView): BaseHxbGet {
        this.universal = universal
        return this
    }

    fun setListener(successListener: SuccessListener): BaseHxbGet {
        this.successListener = successListener
        return this
    }


    fun request(context: Context) {
        OkGo.get(url)
                .execute(object : StringCallback() {
                    override fun onBefore(request: BaseRequest<*>?) {
                        if (isShow) {
                            universal?.showLoading()
                        }
                    }

                    override fun onSuccess(s: String, call: Call, response: Response) {
                        prinString(s)
                        universal?.hideErroLayout()
                        successListener?.onSuccess(context, type!!, s)
                    }


                    override fun onError(call: Call?, response: Response?, e: Exception?) {
                        universal?.showErroLayout()
                    }

                    override fun onAfter(s: String?, e: Exception?) {
                        if (isShow) {
                            universal?.hideLoading()
                        }
                    }
                })
    }
}

