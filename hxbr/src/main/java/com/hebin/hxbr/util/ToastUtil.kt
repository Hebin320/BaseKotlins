@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr.util

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.hebin.hxbr.R
import kotlinx.android.synthetic.main.layout_simple_toast.view.*


@SuppressLint("InflateParams")
class ToastUtil {


    companion object {
        private var oldMsg: String? = null
        private var toast: Toast? = null
        private var oneTime: Long = 0
        private var twoTime: Long = 0

        fun showToast(context: Context, string: String) {
            val toastRoot = LayoutInflater.from(context).inflate(R.layout.layout_simple_toast, null)
            val textView = toastRoot.tv_toast
            textView.text = string
            if (toast == null) {
                toast = Toast.makeText(context, string, Toast.LENGTH_SHORT)
                toast!!.setGravity(Gravity.CENTER, 0, 0)
                toast!!.view = toastRoot
                toast!!.show()
                oneTime = System.currentTimeMillis()
            } else {
                twoTime = System.currentTimeMillis()
                if (string == oldMsg) {
                    if (twoTime - oneTime > Toast.LENGTH_SHORT) {
                        toast!!.setGravity(Gravity.CENTER, 0, 0)
                        toast!!.view = toastRoot
                        toast!!.show()
                    }
                } else {
                    oldMsg = string
                    toast!!.setGravity(Gravity.CENTER, 0, 0)
                    toast!!.view = toastRoot
                    toast!!.show()
                }
            }
            oneTime = twoTime
        }

        /**
         * 网络连接失败时的Toast
         */
        fun showErro(context: Context) {
            showToast(context, "请检查你的网络连接")
        }

        /**
         * 获取失败，请稍后重试的Toast
         */
        fun showGetFail(context: Context) {
            showToast(context, "获取失败，请稍后重试")
        }

        fun printData(string: String) {
            println("Hebin$string")
        }

        fun printData(tag: String, string: String) {
            println("$tag$string")
        }

        fun printLog(string: String) {
            Log.e("Hebin", string)
        }

        fun printLog(tag: String, string: String) {
            Log.e(tag, string)
        }
    }

}



