package com.hebin.project.utils

import android.annotation.SuppressLint
import android.content.Context
import com.taorouw.utils.AppUtil
import com.hebin.utils.ToastUtil
import org.json.JSONObject

/**
 * Author Hebin
 * <p>
 * created at 2018/3/14
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
@SuppressLint("StaticFieldLeak")
class ResultDealUtil(val context: Context) {

    companion object {

        var resultDealUtil: ResultDealUtil? = null

        fun creat(context: Context): ResultDealUtil {
            if (resultDealUtil == null) {
                resultDealUtil = ResultDealUtil(context)
            }
            return resultDealUtil!!
        }
    }


    private var successToast = false
    private var failedToast = false
    private var allToast = false


    fun successToast(): ResultDealUtil {
        successToast = true
        return resultDealUtil!!
    }

    fun failedToast(): ResultDealUtil {
        failedToast = true
        return resultDealUtil!!
    }

    fun allToast(): ResultDealUtil {
        allToast = true
        return resultDealUtil!!
    }


    fun getResult(results: String, listener: Listener) {
        val json = JSONObject(results)
        if (json.getBoolean("status")) {
            listener.getSuccess()
            if (successToast) {
                ToastUtil.showToast(context, json.getString("info"))
                successToast = false
            }
        } else {
            listener.getFailed(json)
            AppUtil.checkLoad(context, json.getString("info"))
            if (failedToast) {
                ToastUtil.showToast(context, json.getString("info"))
                failedToast = false
            }
        }
        if (allToast) {
            ToastUtil.showToast(context, json.getString("info"))
            allToast = false
        }
    }


    interface Listener {
        fun getSuccess()
        fun getFailed(json: JSONObject) {}
    }


}