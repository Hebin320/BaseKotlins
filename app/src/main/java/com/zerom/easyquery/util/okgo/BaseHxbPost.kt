package com.zerom.easyquery.util.okgo

import android.content.Context
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.request.BaseRequest
import com.zerom.easyquery.hxbinterface.SuccessListener
import com.zerom.easyquery.hxbinterface.UniversalView
import com.zerom.easyquery.anko.prinString
import com.zerom.easyquery.anko.printLog
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
class BaseHxbPost {


    var type: Int = 0
    var url: String? = null
    var isShow: Boolean = true
    var universal: UniversalView? = null
    var successListener: SuccessListener? = null
    var map: HashMap<String, String>? = null
    var urlMap: List<String>? = null
    var urlMapKey: String? = null

    fun setType(type: Int): BaseHxbPost {
        this.type = type
        return this
    }

    fun showLoading(isShow: Boolean): BaseHxbPost {
        this.isShow = isShow
        return this
    }

    fun setUrl(url: String): BaseHxbPost {
        this.url = url
        return this
    }

    fun setMap(map: HashMap<String, String>): BaseHxbPost {
        this.map = map
        return this
    }

    fun setUrlMapKey(urlMapKey: String): BaseHxbPost {
        this.urlMapKey = urlMapKey
        return this
    }

    fun setUrlMap(urlMap: List<String>): BaseHxbPost {
        this.urlMap = urlMap
        printLog(urlMap.toString())
        return this
    }

    fun setView(universal: UniversalView): BaseHxbPost {
        this.universal = universal
        return this
    }

    fun setListener(successListener: SuccessListener): BaseHxbPost {
        this.successListener = successListener
        return this
    }


    fun request(context: Context) {
        printLog(map.toString())
        OkGo.post(url)
                .params(map)
                .addUrlParams(urlMapKey, urlMap)
                .execute(object : StringCallback() {
                    override fun onBefore(request: BaseRequest<*>?) {
                        if (isShow) {
                            universal?.showLoading()
                        }
                    }

                    override fun onSuccess(s: String, call: Call, response: Response) {
                        prinString(s)
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