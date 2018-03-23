@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import com.hebin.universalelib.R
import kotlinx.android.synthetic.main.public_loading.*

/**
 * Author Hebin
 *
 *
 * created at 2017/5/22 11:34
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：加载中的对话框
 */
class DialogUtil {

    companion object {

        private var progressDialog: Dialog? = null


        @SuppressLint("WrongConstant")
        //显示一个加载中的全屏对话框
        fun showDialog(context: Context) {
            if (progressDialog == null || !progressDialog!!.isShowing) {
                progressDialog = Dialog(context, R.style.dialog_dimenabled)
                progressDialog?.setCanceledOnTouchOutside(false)
                progressDialog?.show()
                progressDialog?.setContentView(R.layout.public_loading)
                progressDialog?.llLoading?.visibility = View.VISIBLE
                progressDialog?.avLoading?.layoutParams = LinearLayout.LayoutParams(WindowUtil.getSwidth(context as Activity) / 8, WindowUtil.getSwidth(context) / 8)
                val window = progressDialog!!.window!!
                val layoutParams = window.attributes
                layoutParams.width = (WindowUtil.getSwidth(context) / 3.2).toInt()
                layoutParams.height = (WindowUtil.getSwidth(context) / 3.2).toInt()
                window.setGravity(Gravity.CENTER)
                window.attributes = layoutParams
            }
        }

        //关闭progressdialog
        fun hideDialog() {
            if (progressDialog != null) {
                progressDialog!!.dismiss()
                progressDialog = null
            }
        }
    }

}

