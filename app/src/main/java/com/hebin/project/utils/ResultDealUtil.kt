package com.hebin.project.utils

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import com.taorouw.utils.AppUtil
import com.taorouw.utils.ToastUtil
import org.json.JSONObject
import java.util.*

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
class ResultDealUtil(val context: Context, val results: String) {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var resultDealUtil: ResultDealUtil? = null

        fun set(context: Context, results: String): ResultDealUtil {
            if (resultDealUtil == null) {
                resultDealUtil = ResultDealUtil(context, results)
            }
            return resultDealUtil!!
        }
    }


    fun getResult(listener: Listener): ResultDealUtil {
        val json = JSONObject(results)
        if (json.getBoolean("status")) {
            listener.getSuccess()
            if (successToast) {
                ToastUtil.showToast(context, json.getString("info"))
            }
        } else {
            listener.getFailed(json)
            AppUtil.checkLoad(context, json.getString("info"))
            if (failedToast) {
                ToastUtil.showToast(context, json.getString("info"))
            }
        }
        if (allToast) {
            ToastUtil.showToast(context, json.getString("info"))
        }
        return resultDealUtil!!
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


    interface Listener {
        fun getSuccess()
        fun getFailed(json: JSONObject) {}
    }


}