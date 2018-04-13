@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.Switch

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
 *  是否为0
 * */
inline fun Int.zeroOrNot(isZero: () -> Unit, isNotZero: () -> Unit) {
    if (0 == this) {
        isZero()
    } else {
        isNotZero()
    }
}

/**
 *  是否为最后一行
 * */
inline fun lastOrNot(position: Int, all: Int, isLast: () -> Unit, isNotLast: () -> Unit) {
    if (position == all - 1) {
        isLast()
    } else {
        isNotLast()
    }
}

/**
 *  字符串是否为空
 * */
inline fun String.isEmpty(isEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    }
}

/**
 *  字符串是否为空
 * */
inline fun String.isNotEmpty(isNotEmpty: () -> Unit) {
    if (this.isNotEmpty()) {
        isNotEmpty()
    }
}

/**
 *  字符串是否为空
 * */
inline fun String.emptyOrNot(isEmpty: () -> Unit, isNotEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    } else {
        isNotEmpty()
    }
}

/**
 *  多个字符串全部不为空或者部分为空
 * */
inline fun ArrayList<String>.allNotEmpty(allNotEmpty: () -> Unit, someOneEmpty: () -> Unit) {
    var isAllEmpty = true
    for (string in this) {
        if (string.isEmpty()) {
            isAllEmpty = false
        }
    }
    if (isAllEmpty) {
        allNotEmpty()
    } else {
        someOneEmpty()
    }
}

/**
 *  多个字符串全部为空或者部分不为空
 * */
inline fun ArrayList<String>.allEmpty(allEmpty: () -> Unit, someOneNotEmpty: () -> Unit) {
    var isAllEmpty = true
    for (string in this) {
        if (string.isNotEmpty()) {
            isAllEmpty = false
        }
    }
    if (isAllEmpty) {
        allEmpty()
    } else {
        someOneNotEmpty()
    }
}

/**
 *  显示布局
 * */
inline fun View.setVisible() {
    this.visibility = View.VISIBLE
}

/**
 *  隐藏布局
 * */
inline fun View.setGone() {
    this.visibility = View.GONE
}

/**
 *  占位隐藏布局
 * */
inline fun View.setInvisible() {
    this.visibility = View.INVISIBLE
}
