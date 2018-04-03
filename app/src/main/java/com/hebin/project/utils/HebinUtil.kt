@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.utils

import android.app.Activity
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.hebin.project.tools.recyclerview.RecyclerViewTool
import com.hebin.utils.LostFocusUtil
import com.hebin.utils.ScaleAnimatorUtil
import com.hebin.utils.ToastUtil
import com.hebin.utils.WindowUtil

/**
 * Author Hebin
 * <p>
 * created at 2018/3/23
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

/**
 *  toast(string)
 * */
inline fun showToast(context: Context, string: String) = ToastUtil.showToast(context, string)

/**
 * toast("请检查你的网络连接")
 * */
inline fun showErro(context: Context) = ToastUtil.showErro(context)

/**
 * toast("获取失败，请稍后重试")
 * */
inline fun showGetFail(context: Context) = ToastUtil.showGetFail(context)

/**
 * print(string)
 * */
inline fun printData(string: String) = ToastUtil.printData(string)

/**
 * Log.e(string)
 * */
inline fun printLog(string: String) = ToastUtil.printLog(string)

/**
 *  获取状态栏高度
 * */
inline fun getStatusbar(activity: Activity) = WindowUtil.getStatusbar(activity)

/**
 *  获取屏幕宽度
 * */
inline fun getSwidth(activity: Activity) = WindowUtil.getSwidth(activity)

/**
 *  获取屏幕高度
 * */
inline fun getShigh(activity: Activity) = WindowUtil.getShigh(activity)

/**
 *  设置全屏
 * */
inline fun setFullScreen(activity: Activity) = WindowUtil.setFullScreen(activity)

/**
 *  收藏与取消收藏的动画工具类
 * */
inline fun setScalse(view: View) = ScaleAnimatorUtil.setScalse(view)

/**
 *  视图被触碰时，隐藏输入法
 * */
inline fun lostByViewGroup(context: Context, viewGroup: ViewGroup) = LostFocusUtil.lostByViewGroup(context, viewGroup)

/**
 *  视图被触碰时，隐藏输入法
 * */
inline fun lostByView(context: Context, view: View) = LostFocusUtil.lostByView(context, view)

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
inline fun hideImmByView(context: Context, view: View) = LostFocusUtil.hideImmByView(context, view)

/**
 *  Recyclerview 多布局数据源设置
 * */
inline fun setMultiple(num: Int) = RecyclerViewTool().setMultiple(num)
