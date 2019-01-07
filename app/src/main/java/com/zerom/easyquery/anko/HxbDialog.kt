@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.widget.LinearLayout
import com.zerom.easyquery.R
import kotlinx.android.synthetic.main.public_loading.*

inline fun Context.showDialog() = HxbDialog.showDialog(this)

inline fun hideDialog() = HxbDialog.hideDialog()

class HxbDialog {

    companion object {

        private var progressDialog: Dialog? = null

        @SuppressLint("WrongConstant")
        //显示一个加载中的全屏对话框
        fun showDialog(context: Context) {
            if (progressDialog == null || !progressDialog!!.isShowing) {
                progressDialog = Dialog(context, R.style.dialog_dimenabled)
                progressDialog!!.setCanceledOnTouchOutside(false)
                progressDialog!!.show()
                progressDialog!!.setContentView(R.layout.public_loading)
                progressDialog!!.llLoading.setVisible()
                progressDialog!!.avLoading.layoutParams = LinearLayout.LayoutParams((context as Activity).getWindowWidth() / 8, context.getWindowWidth() / 8)
                val window = progressDialog!!.window!!
                val layoutParams = window.attributes
                layoutParams.width = (context.getWindowWidth() / 3.2).toInt()
                layoutParams.height = (context.getWindowWidth() / 3.2).toInt()
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
