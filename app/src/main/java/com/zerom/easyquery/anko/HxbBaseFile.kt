@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.content.Context
import com.zerom.easyquery.base.BaseFile


// 保存字符串
inline fun Context.saveString(infoKey: String, info: String) = HxbBaseFile.saveString(this, infoKey, info)

// 提取字符串
inline fun Context.loadString(infoKey: String) = HxbBaseFile.loadString(this, infoKey)

// 保存布尔值
inline fun Context.saveBoolean(infoKey: String, isTrue: Boolean) = HxbBaseFile.saveBoolean(this, infoKey, false)

// 提取布尔值
inline fun Context.loadBoolean(infoKey: String) = HxbBaseFile.loadBoolean(this, infoKey)

// 保存数字
inline fun Context.saveInt(infoKey: String, position: Int) = HxbBaseFile.saveInt(this, infoKey, position)

// 提取数字
inline fun Context.loadInt(infoKey: String) = HxbBaseFile.loadInt(this, infoKey)


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class HxbBaseFile {

    companion object {
        /**
         * 记录（读取或者清除）基础用户信息
         */
        fun saveUserData(context: Context, token: String, name: String, typeid: String, mobile: String, userid: String, flag: String, img: String) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString(BaseFile.TOKEN, token)
            editor.putString(BaseFile.USERID, userid)
            editor.putString(BaseFile.NAME, name)
            editor.putString(BaseFile.TYPEID, typeid)
            editor.putString(BaseFile.MOBILE, mobile)
            editor.putString(BaseFile.FLAG, flag)
            editor.putString(BaseFile.IMAGE, img)
            editor.apply()
        }

        fun cleanUserData(context: Context) {
            val preferences = context.getSharedPreferences("userdata", Context.MODE_PRIVATE)
            val editor = preferences.edit()
            editor.remove(BaseFile.TOKEN)
            editor.remove(BaseFile.USERID)
            editor.remove(BaseFile.NAME)
            editor.remove(BaseFile.TYPEID)
            editor.remove(BaseFile.MOBILE)
            editor.remove(BaseFile.FLAG)
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