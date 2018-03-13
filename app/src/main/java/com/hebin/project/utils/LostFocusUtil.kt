package com.hebin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager

/**
 * Author Hebin
 *
 *
 * created at 2017/5/5 10:27
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

@SuppressLint("ClickableViewAccessibility")
class LostFocusUtil  {


    companion object {

        /**
         * 视图被触碰时，隐藏输入法

         * @param viewGroup 布局
         */
        fun lostByViewGroup(context: Context, viewGroup: ViewGroup) {
            viewGroup.setOnTouchListener { _, _ ->
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(viewGroup.windowToken, 0)
                false
            }
        }

        /**
         * 视图被触碰时，隐藏输入法

         * @param view 控件
         */


        fun lostByView(context: Context, view: View) {
            view.setOnTouchListener { _, _ ->
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                false
            }
        }


        /**
         * 隐藏输入法

         * @param view 控件
         */

        fun hideImmByView(context: Context, view: View) {
            val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }


        /**
         * 初始列表失去焦点

         * @param viewGroup 布局
         */
        fun listLostByViewGroup(viewGroup: ViewGroup) {
            viewGroup.isFocusable = true
            viewGroup.isFocusableInTouchMode = true
            viewGroup.requestFocus()
        }

        /**
         * 初始列表失去焦点

         * @param view 控件
         */
        fun listLostByView(view: View) {
            view.isFocusable = true
            view.isFocusableInTouchMode = true
            view.requestFocus()
        }
    }

}
