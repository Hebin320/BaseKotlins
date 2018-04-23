package com.hebin.project.mInterface

import android.content.Context

/**
 * Author Hebin
 * <p>
 * created at 2018/4/16 10:54
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：网络请求成功后，数据回调接口，功能是将通用的网络请求中的数据传给调用接口的P层
 */
interface SuccessListener {
    fun onSuccess(context: Context, type: Any, results: String)
}
