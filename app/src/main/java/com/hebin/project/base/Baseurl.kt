@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.base

import android.content.Context
import com.hebin.hxbr.loadString
import com.hebin.hxbr.printData
import com.hebin.hxbr.printLog

/**
 * Author Hebin
 * <p>
 * created at 2018/3/13 10:17
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：APP中用到的所有的网址的集合
 */

fun getDoMain(context: Context): String {
    val doMain = when (context.loadString(BaseFile.DOMAIN)) {
        "" -> "http://www.baidu.com"
    // 正式服务器
        "domain" -> "http://www.baidu.com"
    // 测试服务器
        "test" -> "http://www.baidu.com"
    // 自定义服务器
        else -> context.loadString(BaseFile.DOMAIN)
    }
    return doMain
}

fun getWebDomain(context: Context): String {
    val doMain = when (context.loadString(BaseFile.WEBDOMAIN)) {
        "" -> "http://www.baidu.com"
    // 正式服务器
        "domain" -> "www.baidu.com"
    // 测试服务器
        "test" -> "http://www.baidu.com"
    // 自定义服务器
        else -> context.loadString(BaseFile.WEBDOMAIN)
    }
    return doMain
}


/**
 * 随便看看
 */
inline fun look(context: Context): String {
    val string = "${getDoMain(context)}/diagnosis/v2/overt/look"
    printLog(string)
    return string
}

/**
 * 随便看看
 */
inline fun time(context: Context): String {
    val string = "${getDoMain(context)}/diagnosis/v2/overt/time"
    printLog(string)
    return string
}

/**
 * 斗鱼数据
 */
inline fun douyu(page: Int): String {
    val string = "http://capi.douyucdn.cn/api/v1/getVerticalRoom?limit=60&offset=$page"
    printLog(string)
    return string
}

