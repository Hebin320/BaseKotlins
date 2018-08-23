package com.hebin.project.base

import android.content.Context


/**
 * Author Hebin
 * <p>
 * created at 2017/6/19
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：存储（读取、删除）数据到本地的方法
 */
class BaseFile {

    companion object {

        const val TOKEN = "TOKEN"
        const val USERID = "USERID"
        const val SHOPID = "SHOPID"
        val DOMAIN = "DOMAIN"
        val DOMAINTAG = "DOMAINTAG"
        val WEBDOMAIN = "WEBDOMAIN"
        val WEBDOMAINTAG = "WEBDOMAINTAG"
        val FILEDOMAIN = "FILEDOMAIN"
        val FILEDOMAINTAG = "FILEDOMAINTAG"
        val DOMAINTEXT = "DOMAINTEXT"
        val DOMAINTESTTEXT = "DOMAINTESTTEXT"
        val DOMAINLOCALTEXT = "DOMAINLOCALTEXT"
        val DOMAINDEVTEXT = "DOMAINDEVTEXT"
        val WEBDOMAINTEXT = "WEBDOMAINTEXT"
        val WEBDOMAINTESTTEXT = "WEBDOMAINTESTTEXT"
        val WEBDOMAINLOCALTEXT = "WEBDOMAINLOCALTEXT"
        val WEBDOMAINDEVTEXT = "WEBDOMAINDEVTEXT"
        val FILEDOMAINTEXT = "FILEDOMAINTEXT"
        val FILEDOMAINTESTTEXT = "FILEDOMAINTESTTEXT"
        val FILEDOMAINLOCALTEXT = "FILEDOMAINLOCALTEXT"
        val FILEDOMAINDEVTEXT = "FILEDOMAINDEVTEXT"


        /**
         * 记录（读取或者清除）基础用户信息
         */
        fun saveUserData(context: Context, token: String, userid: String, name: String, typeid: String, mobile: String, shopid: String, openid: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(TOKEN, token)
            editor.putString(USERID, userid)
            editor.putString("name", name)
            editor.putString("typeid", typeid)
            editor.putString("mobile", mobile)
            editor.putString(SHOPID, shopid)
            editor.putString("openid", openid)
            editor.apply()
        }

        fun cleanUserData(context: Context) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.remove(TOKEN)
            editor.remove(USERID)
            editor.remove("name")
            editor.remove("typeid")
            editor.remove("mobile")
            editor.remove(SHOPID)
            editor.remove("openid")
            editor.apply()
        }
    }
}