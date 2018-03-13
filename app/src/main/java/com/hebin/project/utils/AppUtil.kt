@file:Suppress("SENSELESS_COMPARISON")

package com.taorouw.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.telephony.TelephonyManager
import com.hebin.project.ui.universal.MainActivity
import com.taorouw.base.BaseFile
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop
import java.util.*


/**
 * Author Hebin
 *
 *
 * created at 2017/5/17
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：
 */
class AppUtil  {

    companion object {


        /**
         * 获取唯一机械码
         */
        @SuppressLint("WrongConstant", "MissingPermission")
        private fun getImei(context: Context, imei: String): String {
            var imei = imei
            try {

                val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
                imei = telephonyManager.deviceId
            } catch (ignored: Exception) {
            }

            return imei
        }

        /**
         * 获取版本名称
         */
        fun getVersion(context: Context): String {
            try {
                val manager = context.packageManager.getPackageInfo(
                        context.packageName, 0)
                return manager.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                return "Unknown"
            }

        }

        /**
         * 获取版本号
         */
        fun getlocalVersion(context: Context): Int {
            var localversion = 0
            try {
                val info = context.packageManager.getPackageInfo(context.packageName, 0)
                localversion = info.versionCode
            } catch (e: PackageManager.NameNotFoundException) {
                e.printStackTrace()
            }

            return localversion
        }

        /**
         * 登录失败的操作
         */

        fun checkLoad(context: Context, info: String) {
            if (info.contains("授权信息错误") || info.contains("请重新登录") || info.contains("授权参数错误")) {
                BaseFile.cleanUserData(context)
            }
        }

        /**
         * 是否已经登录过了
         */

        fun checkLogin(context: Context): Boolean {
            if (BaseFile.loadString(context, BaseFile.TOKEN).isEmpty()) {
                context.startActivity(context.intentFor<MainActivity>().singleTop())
                return false
            } else {
                return true
            }
        }

        /**
         * 把list转换为一个用逗号分隔的字符串
         */
        fun listToString(list: ArrayList<String>): String {
            val sb = StringBuilder()
            if (list != null && list.size > 0) {
                for (i in list.indices) {
                    if (i < list.size - 1) {
                        sb.append(list[i] + ",")
                    } else {
                        sb.append(list[i])
                    }
                }
            }
            return sb.toString()
        }
    }

}
