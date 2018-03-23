@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.utils

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import com.hebin.universalelib.R
import kotlinx.android.synthetic.main.layout_simple_toast.view.*


/**
 * Author Hebin
 *
 *
 * created at 2017/5/12 15:39
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
@SuppressLint("InflateParams")
class ToastUtil {


    companion object {
        /**
         * 之前显示的内容
         */
        private var oldMsg: String? = null
        /**
         * Toast对象
         */
        private var toast: Toast? = null
        /**
         * 第一次时间
         */
        private var oneTime: Long = 0
        /**
         * 第二次时间
         */
        private var twoTime: Long = 0


        /**
         * 显示输入文本的Toast
         */
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
         * 全局静态网络连接失败时的Toast
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

        /**
         * 打印数据
         */
        fun printData(string: String) {
            println("Hebin$string")
        }

        fun printLog(string: String) {
            Log.e("Hebin", string)
        }
    }

}



