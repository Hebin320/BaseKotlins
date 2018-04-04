@file:Suppress("SENSELESS_COMPARISON")

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
class ResultDealUtil(val context: Context, private val results: String) {


    private var successToast = false
    private var failedToast = false
    private var allToast = false


    fun successToast(): ResultDealUtil {
        successToast = true
        return this
    }

    fun failedToast(): ResultDealUtil {
        failedToast = true
        return this
    }

    fun allToast(): ResultDealUtil {
        allToast = true
        return this
    }


    fun getSuccess(success: () -> Unit): ResultDealUtil {
        if (results != null && results.isNotEmpty()) {
            val json = JSONObject(results)
            if (json.getBoolean("status") != null) {
                if (json.getBoolean("status")) {
                    success()
                    if (successToast) {
                        ToastUtil.showToast(context, json.getString("info"))
                        successToast = false
                    }
                }
                if (allToast) {
                    ToastUtil.showToast(context, json.getString("info"))
                    allToast = false
                }
            }
        }
        return this
    }

    fun getFailed(failed: (json: JSONObject) -> Unit): ResultDealUtil {
        if (results != null && results.isNotEmpty()) {
            val json = JSONObject(results)
            if (json.getBoolean("status") != null) {
                if (!json.getBoolean("status")) {
                    failed(json)
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
        }
        return this
    }


}