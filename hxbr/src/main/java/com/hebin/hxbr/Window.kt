@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.view.View
import android.view.ViewGroup
import com.hebin.hxbr.util.WindowUtil
import com.hebin.hxbr.util.LostFocusUtil
import com.hebin.hxbr.util.ScaleAnimatorUtil

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
 *  获取状态栏高度
 * */
inline fun Activity.getStatusbar() = WindowUtil.getStatusbar(this)

/**
 *  获取屏幕宽度
 * */
inline fun Activity.getSwidth() = WindowUtil.getSwidth(this)

/**
 *  获取屏幕高度
 * */
inline fun Activity.getShigh() = WindowUtil.getShigh(this)

/**
 *  设置全屏
 * */
inline fun Activity.setFullScreen() = WindowUtil.setFullScreen(this)

/**
 *  收藏与取消收藏的动画工具类
 * */
inline fun setScalse(view: View) = ScaleAnimatorUtil.setScalse(view)

/**
 *  视图被触碰时，隐藏输入法
 * */
inline fun Context.lostByViewGroup(viewGroup: ViewGroup) = LostFocusUtil.lostByViewGroup(this, viewGroup)

/**
 *  视图被触碰时，隐藏输入法
 * */
inline fun Context.lostByView(view: View) = LostFocusUtil.lostByView(this, view)

/**
 *  初始列表失去焦点
 * */
inline fun listLostByViewGroup(view: ViewGroup) = LostFocusUtil.listLostByViewGroup(view)

/**
 *  初始列表失去焦点
 * */
inline fun listLostByView(view: View) = LostFocusUtil.listLostByView(view)

/**
 *  隐藏输入法
 * */
inline fun Context.hideImmByView(view: View) = LostFocusUtil.hideImmByView(this, view)

/**
 *  打开设置界面
 * */

inline fun Activity.appSetting(tag: Int) {
    val packageURI = Uri.parse("package:$packageName")
    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI)
    this.startActivityForResult(intent, tag)
}