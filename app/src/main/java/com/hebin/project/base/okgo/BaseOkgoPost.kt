package com.zerom.management.base.okgo

import android.content.Context
import com.lzy.okgo.request.BaseRequest
import com.hebin.project.utils.printData
import com.zerom.management.mInterface.base.SuccessListener
import com.zerom.management.mInterface.base.UniversalView

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

    companion object {

        /**
         * @param type 用于一个Activity有多个网络请求的时候，在Presenter中区分回调类型
         *
         * @param map post 的参数
         *
         * @param url 请求网址
         *
         * */

        fun getData(context: Context, type: Int, url: String, map: HashMap<String, String>, universalView: UniversalView, successListener: SuccessListener) {
            com.lzy.okgo.OkGo.post(url)
                    .params(map)
                    .execute(object : com.lzy.okgo.callback.StringCallback() {
                        override fun onBefore(request: com.lzy.okgo.request.BaseRequest<out BaseRequest<*>>?) {
                            super.onBefore(request)
                            universalView.showLoading()
                        }

                        override fun onSuccess(result: String?, p1: okhttp3.Call?, p2: okhttp3.Response?) {
                            universalView.hideErroLayout()
                            successListener.onSuccess(context, type, result!!)
                            printData(result)
                        }

                        override fun onAfter(t: String?, e: java.lang.Exception?) {
                            super.onAfter(t, e)
                            universalView.hideLoading()
                        }

                        override fun onError(call: okhttp3.Call?, response: okhttp3.Response?, e: java.lang.Exception?) {
                            super.onError(call, response, e)
                            universalView.showErroLayout()
                        }

                    })
        }
    }

}