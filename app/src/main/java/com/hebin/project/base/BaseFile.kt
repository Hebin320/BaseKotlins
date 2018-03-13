package com.taorouw.base

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

        val TOKEN = "TOKEN"
        val USERID = "USERID"
        val SHOPID = "SHOPID"
        val DOMAIN = "DOMAIN"
        val WEBDOMAIN = "WEBDOMAIN"


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

        /**
         * 保存类型为字符串的数据到本地

         * @param infoKey 保存数据的唯一标识，用于值的提取与清除
         * *
         * @param info    需要保存到本地的数据的值
         */
        fun saveString(context: Context, infoKey: String, info: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(infoKey, info)
            editor.apply()
        }

        /**
         * 读取类型为“字符串”的本地数据

         * @param infoKey 本地数据的唯一标识，用于值的提取
         * *
         * @param info    如果本地数据值为空，info则为默认提取的值
         */
        fun loadString(context: Context, infoKey: String): String {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getString(infoKey, "")
        }

        /**
         * 保存类型为“布尔值”的数据到本地

         * @param infoKey 保存数据的唯一标识，用于值的提取与清除
         * *
         * @param isTrue  需要保存到本地的数据的值
         */
        fun saveBoolean(context: Context, infoKey: String, isTrue: Boolean) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(infoKey, isTrue)
            editor.apply()
        }

        /**
         * 读取类型为“布尔值”的本地数据

         * @param infoKey 本地数据的唯一标识，用于值的提取
         * *
         * @param isTrue  如果本地数据值为空，info则为默认提取的值
         */
        fun loadBoolean(context: Context, infoKey: String): Boolean {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getBoolean(infoKey, false)
        }

        /**
         * 保存类型为“整数”的数据到本地

         * @param infoKey  保存数据的唯一标识，用于值的提取与清除
         * *
         * @param position 需要保存到本地的数据的值
         */
        fun saveInt(context: Context, infoKey: String, position: Int) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putInt(infoKey, position)
            editor.apply()
        }

        /**
         * 读取类型为“整数”的本地数据

         * @param infoKey  本地数据的唯一标识，用于值的提取
         * *
         * @param position 如果本地数据值为空，info则为默认提取的值
         */
        fun loadInt(context: Context, infoKey: String): Int {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getInt(infoKey, 0)
        }
    }
}