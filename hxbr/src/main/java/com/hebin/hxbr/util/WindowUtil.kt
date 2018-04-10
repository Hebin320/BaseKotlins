@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr.util

import android.app.Activity
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager


class WindowUtil {

    companion object {
        /**
        *  获取状态栏高度
        * */
        fun getStatusbar(activity: Activity): Int {
            val rectangle = Rect()
            val window = activity.window
            window.decorView.getWindowVisibleDisplayFrame(rectangle)
            return rectangle.top
        }

        /**
        *  获取屏幕宽度
        * */
        fun getSwidth(activity: Activity): Int {
            var realWidth = 0
            try {
                val display = activity.windowManager.defaultDisplay
                val metrics = DisplayMetrics()
                display.getMetrics(metrics)
                if (Build.VERSION.SDK_INT >= 17) {
                    val size = Point()
                    display.getRealSize(size)
                    realWidth = size.x
                } else if (Build.VERSION.SDK_INT < 17) {
                    val mGetRawW = Display::class.java.getMethod("getRawWidth")
                    realWidth = mGetRawW.invoke(display) as Int
                } else {
                    realWidth = metrics.widthPixels
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return realWidth
        }

        /**
        *  获取屏幕高度
        * */
        fun getShigh(activity: Activity): Int {
            var realHeight = 0
            try {
                val display = activity.windowManager.defaultDisplay
                val metrics = DisplayMetrics()
                display.getMetrics(metrics)
                if (Build.VERSION.SDK_INT >= 17) {
                    val size = Point()
                    display.getRealSize(size)
                    realHeight = size.y
                } else if (Build.VERSION.SDK_INT < 17) {
                    val mGetRawH = Display::class.java.getMethod("getRawHeight")
                    realHeight = mGetRawH.invoke(display) as Int
                } else {
                    realHeight = metrics.heightPixels
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return realHeight
        }

        /**
        *  全屏显示
        * */
        fun setFullScreen(activity: Activity) {
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }

}
