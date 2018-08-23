@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.base

import android.content.Context
import com.hebin.hxbr.loadString
import com.hebin.hxbr.printData
import com.hebin.hxbr.printLog
import com.hebin.hxbr.util.BaseFile.Companion.loadString

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
    val doMain = if (loadString(context, BaseFile.DOMAIN) == "") {
        "https://www.baidu.com"
    } else {
        loadString(context, BaseFile.DOMAIN)
    }
    return doMain
}

fun getWebDomain(context: Context): String {
    val doMain = if (loadString(context, BaseFile.WEBDOMAIN) == "") {
        "https://www.baidu.com"
    } else {
        loadString(context, BaseFile.WEBDOMAIN)
    }
    return doMain
}

fun getFileDomain(context: Context): String {
    val doMain = if (loadString(context, BaseFile.FILEDOMAIN) == "") {
        "https://www.baidu.com"
    } else {
        loadString(context, BaseFile.FILEDOMAIN)
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

