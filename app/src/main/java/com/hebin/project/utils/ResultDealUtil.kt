@file:Suppress("SENSELESS_COMPARISON")

package com.hebin.project.utils

import android.annotation.SuppressLint
import android.content.Context
import com.hebin.hxbr.showToast
import com.taorouw.utils.checkLoad
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
class ResultDealUtil() {


    private var context: Context? = null
    private var results: String = ""
    private var successToast = false
    private var failedToast = false
    private var allToast = false


    fun creat(context: Context): ResultDealUtil {
        this.context = context
        return this
    }

    fun setResult(result: String): ResultDealUtil {
        this.results = result
        return this
    }

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


    fun getSuccess(success: (json: JSONObject) -> Unit): ResultDealUtil {
        if (results != null && results.isNotEmpty()) {
            val json = JSONObject(results)
            if (json.getBoolean("status") != null) {
                if (json.getBoolean("status")) {
                    success(json)
                    if (successToast) {
                        context?.showToast(json.getString("info"))
                        successToast = false
                    }
                }
                if (allToast) {
                    context?.showToast(json.getString("info"))
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
                    context?.checkLoad(json.getString("info"))
                    if (failedToast) {
                        context?.showToast(json.getString("info"))
                        failedToast = false
                    }
                }
                if (allToast) {
                    context?.showToast(json.getString("info"))
                    allToast = false
                }
            }
        }
        return this
    }


}