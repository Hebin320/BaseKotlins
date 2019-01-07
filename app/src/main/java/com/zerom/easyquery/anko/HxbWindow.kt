@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.app.Activity
import android.graphics.Point
import android.graphics.Rect
import android.os.Build
import android.util.DisplayMetrics
import android.view.Display
import android.view.WindowManager

// 获取状态栏高度
inline fun Activity.getStatusbar() = HxbWindow.getStatusbar(this)

// 获取屏幕宽度
inline fun Activity.getWindowWidth() = HxbWindow.getSwidth(this)

// 获取屏幕高度
inline fun Activity.getWindowHeigth() = HxbWindow.getShigh(this)

// 全屏显示
inline fun Activity.setFullScreen() = HxbWindow.setFullScreen(this)


class HxbWindow {
    companion object {

        /**
         * 获取状态栏高度
         */
        fun getStatusbar(activity: Activity): Int {
            val rectangle = Rect()
            val window = activity.window
            window.decorView.getWindowVisibleDisplayFrame(rectangle)
            return rectangle.top
        }

        /**
         * 获取屏幕宽度
         */
        fun getSwidth(activity: Activity): Int {
            var realWidth = 0
            try {
                val display = activity.windowManager.defaultDisplay
                val metrics = DisplayMetrics()
                display.getMetrics(metrics)
                realWidth = when {
                    Build.VERSION.SDK_INT >= 17 -> {
                        val size = Point()
                        display.getRealSize(size)
                        size.x
                    }
                    Build.VERSION.SDK_INT < 17 -> {
                        val mGetRawW = Display::class.java.getMethod("getRawWidth")
                        mGetRawW.invoke(display) as Int
                    }
                    else -> metrics.widthPixels
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }

            return realWidth
        }

        /**
         * 获取屏幕高度
         */
        fun getShigh(activity: Activity): Int {
            var realHeight = 0
            try {
                val display = activity.windowManager.defaultDisplay
                val metrics = DisplayMetrics()
                display.getMetrics(metrics)
                realHeight = if (Build.VERSION.SDK_INT >= 17) {
                    val size = Point()
                    display.getRealSize(size)
                    size.y
                } else if (Build.VERSION.SDK_INT < 17) {
                    val mGetRawH = Display::class.java.getMethod("getRawHeight")
                    mGetRawH.invoke(display) as Int
                } else {
                    metrics.heightPixels
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return realHeight
        }


        /**
         * 全屏显示
         * 此方法写在setContentView之前
         */
        fun setFullScreen(activity: Activity) {
            activity.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    }
}