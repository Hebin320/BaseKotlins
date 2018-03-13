package com.zerom.management.mInterface.base

import android.content.Context


/**
 * Author Hebin
 *
 *
 * created at 2017/5/5 10:25
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：网络请求成功后，数据回调接口，功能是将通用的网络请求中的数据传给调用接口的P层
 */
interface SuccessListener {
    fun onSuccess(context: Context, type: Any, results: String)
}
