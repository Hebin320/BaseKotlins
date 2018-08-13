@file:Suppress("SENSELESS_COMPARISON", "NOTHING_TO_INLINE")

package com.taorouw.utils

import android.content.Context
import com.hebin.hxbr.loadString
import com.hebin.project.ui.activity.universal.MainActivity
import com.hebin.project.base.BaseFile
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.singleTop


@Suppress("NOTHING_TO_INLINE")
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


/**
 * 登录失败的操作
 */

inline fun Context.checkLoad(info: String) {
    if (info.contains("授权信息错误") || info.contains("请重新登录") || info.contains("授权参数错误")) {
        BaseFile.cleanUserData(this)
    }
}

/**
 * 是否已经登录过了
 */

inline fun Context.checkLogin(): Boolean {
    return if (this.loadString(BaseFile.TOKEN).isEmpty()) {
        this.startActivity(this.intentFor<MainActivity>().singleTop())
        false
    } else {
        true
    }
}


