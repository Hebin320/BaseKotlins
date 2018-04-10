package com.hebin.project.base.okgo

import android.content.Context
import com.hebin.hxbr.printData
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.request.BaseRequest
import com.zerom.management.mInterface.base.SuccessListener
import com.zerom.management.mInterface.base.UniversalView
import okhttp3.Call
import okhttp3.Response


/**
 * Author Hebin
 * <p>
 * created at 2017/6/14
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
class BaseOkgoPost {


    var type: Int = 0
    var url: String? = null
    var isShow: Boolean = true
    var universal: UniversalView? = null
    var successListener: SuccessListener? = null
    var map: HashMap<String, String>? = null


    fun setType(type: Int): BaseOkgoPost {
        this.type = type
        return this
    }

    fun showLoading(isShow: Boolean): BaseOkgoPost {
        this.isShow = isShow
        return this
    }

    fun setUrl(url: String): BaseOkgoPost {
        this.url = url
        return this
    }

    fun setMap(map: HashMap<String, String>): BaseOkgoPost {
        this.map = map
        return this
    }

    fun setView(universal: UniversalView): BaseOkgoPost {
        this.universal = universal
        return this
    }

    fun setListener(successListener: SuccessListener): BaseOkgoPost {
        this.successListener = successListener
        return this
    }


    fun request(context: Context) {
        OkGo.post(url)
                .params(map)
                .execute(object : StringCallback() {
                    override fun onBefore(request: BaseRequest<*>?) {
                        if (isShow) {
                            universal?.showLoading()
                        }
                    }

                    override fun onSuccess(s: String, call: Call, response: Response) {
                        printData(s)
                        universal?.hideErroLayout()
                        successListener?.onSuccess(context, type, s)
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