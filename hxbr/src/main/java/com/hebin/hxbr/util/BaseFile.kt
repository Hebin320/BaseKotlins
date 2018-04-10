package com.hebin.hxbr.util

import android.content.Context


class BaseFile {

    companion object {

        /**
        *  保存信息到本地 ——> 类型、字符串
        * */
        fun saveString(context: Context, infoKey: String, info: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(infoKey, info)
            editor.apply()
        }
        /**
        *  保存信息到本地 ——> 类型、字符串
        * */
        fun saveString(context: Context,localName:String, infoKey: String, info: String) {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(infoKey, info)
            editor.apply()
        }

        /**
         *  读取本地保存的信息 ——> 类型、字符串
         * */
        fun loadString(context: Context, infoKey: String): String {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getString(infoKey, "")
        }
        /**
         *  读取本地保存的信息 ——> 类型、字符串
         * */
        fun loadString(context: Context, localName: String,infoKey: String): String {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            return preferences.getString(infoKey, "")
        }

        /**
         *  保存信息到本地 ——> 类型、布尔值
         * */
        fun saveBoolean(context: Context, infoKey: String, isTrue: Boolean) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(infoKey, isTrue)
            editor.apply()
        }
        /**
         *  保存信息到本地 ——> 类型、布尔值
         * */
        fun saveBoolean(context: Context, localName: String,infoKey: String, isTrue: Boolean) {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putBoolean(infoKey, isTrue)
            editor.apply()
        }

        /**
         *  读取本地保存的信息 ——> 类型、布尔值
         * */
        fun loadBoolean(context: Context, infoKey: String): Boolean {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getBoolean(infoKey, false)
        }
        /**
         *  读取本地保存的信息 ——> 类型、布尔值
         * */
        fun loadBoolean(context: Context, localName: String,infoKey: String): Boolean {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            return preferences.getBoolean(infoKey, false)
        }

        /**
         *  保存信息到本地 ——> 类型、数字
         * */
        fun saveInt(context: Context, infoKey: String, position: Int) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putInt(infoKey, position)
            editor.apply()
        }
        /**
         *  保存信息到本地 ——> 类型、数字
         * */
        fun saveInt(context: Context, localName: String,infoKey: String, position: Int) {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putInt(infoKey, position)
            editor.apply()
        }
        /**
         *  读取本地保存的信息 ——> 类型、数字
         * */
        fun loadInt(context: Context, infoKey: String): Int {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            return preferences.getInt(infoKey, 0)
        }
        /**
         *  读取本地保存的信息 ——> 类型、数字
         * */
        fun loadInt(context: Context,localName: String, infoKey: String): Int {
            val preferences = context.getSharedPreferences(localName, Context.MODE_PRIVATE)
            return preferences.getInt(infoKey, 0)
        }
    }
}