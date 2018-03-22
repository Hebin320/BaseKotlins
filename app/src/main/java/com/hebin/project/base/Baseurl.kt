package com.hebin.base

import android.content.Context
import android.util.Log
import com.taorouw.base.BaseFile

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
class Baseurl {

    companion object {
        private fun getDoMain(context: Context): String {
            val doMain = when (BaseFile.loadString(context, BaseFile.DOMAIN)) {
                "" -> "http://www.baidu.com"
            // 正式服务器
                "domain" -> "http://www.baidu.com"
            // 测试服务器
                "test" -> "http://www.baidu.com"
            // 自定义服务器
                else -> BaseFile.loadString(context, BaseFile.DOMAIN)
            }
            return doMain
        }

        private fun getWebDomain(context: Context): String {
            val doMain = when (BaseFile.loadString(context, BaseFile.WEBDOMAIN)) {
                "" -> "http://www.baidu.com"
            // 正式服务器
                "domain" -> "www.baidu.com"
            // 测试服务器
                "test" -> "http://www.baidu.com"
            // 自定义服务器
                else -> BaseFile.loadString(context, BaseFile.WEBDOMAIN)
            }
            return doMain
        }

        /**
         * 打印数据
         */
        private fun printData(string: String) {
            Log.e("Hebin", string)
        }

        /**
         * 随便看看
         */
        fun look(context: Context): String {
            val string = "${getDoMain(context)}/diagnosis/v2/overt/look"
            printData(string)
            return string
        }

    }

}
