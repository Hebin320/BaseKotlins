@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.app.Activity
import android.content.Context

/**
 * Author Hebin
 * <p>
 * created at 2018/4/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
/**
 *  传值获取 -> 类型、字符串
 * */
inline fun Activity.getStringExtra(mTAG: String):String {
    return this.intent.getStringExtra(mTAG)
}

/**
 *  传值获取 -> 类型、数字
 * */
inline fun Activity.getIntExtra(mTAG: String):Int {
    return this.intent.getIntExtra(mTAG, 0)
}

/**
 *  传值获取 -> 类型、布尔值
 * */
inline fun Activity.getBooleanExtra(mTAG: String):Boolean {
    return this.intent.getBooleanExtra(mTAG, false)
}