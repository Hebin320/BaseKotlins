package com.hebin.project.base.okgo

import android.content.Context
import com.lzy.okgo.OkGo
import com.lzy.okgo.callback.StringCallback
import com.lzy.okgo.request.BaseRequest
import com.hebin.project.utils.printData
import com.zerom.management.mInterface.base.SuccessListener
import com.zerom.management.mInterface.base.UniversalView
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
 * 说明： Post请求
 *<p>
 * Okgo网络请求的通用类，显示、隐藏对话框以及网络（访问后台）出现问题的一致处理
 * 请求成功得到的数据可进行回调给其他Model处理
 */
open class OkgoPostForRecyclerView {

    companion object {

        /**
         * @param type 用于一个Activity有多个网络请求的时候，在Presenter中区分回调类型
         *
         * @param showLoading 用户有列表的界面，第一次访问网络，显示加载对话框，下拉刷新或上拉刷新时不显示加载对话框
         *
         * @param url 请求网址
         *
         * */

        fun getData(context: Context, showLoading: Boolean, type: Int, url: String, map: HashMap<String, String>,
                    universal: UniversalView, successListener: SuccessListener) {
            OkGo.post(url)
                    .params(map)
                    .execute(object : StringCallback() {
                        override fun onBefore(request: BaseRequest<*>?) {
                            if (showLoading) {
                                universal.showLoading()
                            }
                        }

                        override fun onSuccess(s: String, call: Call, response: Response) {
                            printData(s)
                            universal.hideErroLayout()
                            successListener.onSuccess(context, type, s)
                        }


                        override fun onError(call: Call?, response: Response?, e: Exception?) {
                            universal.showErroLayout()
                        }

                        override fun onAfter(s: String?, e: Exception?) {
                            if (showLoading) {
                                universal.hideLoading()
                            }
                        }
                    })
        }
    }
}