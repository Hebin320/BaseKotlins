@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.hebin.project.tools.recyclerview.RecyclerViewTool
import com.hebin.utils.*
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout


/**
 *  toast(string)
 * */
inline fun Context.showToast(string: String) = ToastUtil.showToast(this, string)

/**
 * toast("请检查你的网络连接")
 * */
inline fun Context.showErro() = ToastUtil.showErro(this)

/**
 * toast("获取失败，请稍后重试")
 * */
inline fun Context.showGetFail() = ToastUtil.showGetFail(this)

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
 *  Recyclerview 多布局数据源设置
 * */
inline fun setMultiple(num: Int) = RecyclerViewTool().setMultiple(num)


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
inline fun String.emptyOrNot(isEmpty: () -> Unit, isNotEmpty: () -> Unit) {
    if (this.isEmpty()) {
        isEmpty()
    } else {
        isNotEmpty()
    }
}

/**
 *  刷新方法重写
 * */
inline fun TwinklingRefreshLayout.setOnRefreshListener(crossinline mRefresh: () -> Unit, crossinline mLoadMore: () -> Unit) {
    this.setOnRefreshListener(object : RefreshListenerAdapter() {

        override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
            super.onRefresh(refreshLayout)
            mRefresh()
        }

        override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
            super.onLoadMore(refreshLayout)
            mLoadMore()
        }

    })
}

/**
 *  选择图片
 * */
inline fun Activity.selectImage(size: Int, code: Int) = ImageUtil.selectImage(this, size, code)

/**
 *  加载圆形图片
 * */
inline fun Context.glideCircleImage(url: Any, imageView: ImageView) = ImageUtil.glideCircleImage(this, url, imageView)

/**
 *  加载正常图片
 * */
inline fun Context.glideNormalImage(url: Any, imageView: ImageView) = ImageUtil.glideNormalImage(this, url, imageView)

/**
 *  加载圆角图片
 * */
inline fun Context.glideRoundImage(url: Any, roundSize: Int, imageView: ImageView) = ImageUtil.glideRoundImage(this, url, roundSize, imageView)
