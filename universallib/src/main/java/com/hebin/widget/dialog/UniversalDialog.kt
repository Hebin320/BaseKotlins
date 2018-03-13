package com.hebin.widget.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import com.hebin.universalelib.R

/**
 * Author Hebin
 * <p>
 * created at 2017/7/21
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：设置通用的Dialog
 */
class UniversalDialog(val context: Context) {

    companion object {

        @SuppressLint("StaticFieldLeak")
        private var universalDialog: UniversalDialog? = null


        fun create(context: Context): UniversalDialog {
            if (universalDialog == null) {
                universalDialog = UniversalDialog(context)
            }
            return universalDialog!!
        }

    }

    private var isTransparent: Boolean = true
    private var type: String = "1"
    private var layoutId: Int = 0
    private var animations: Int = 0
    private var marginX: Int = 0
    private var marginY: Int = 0
    private var gravity: Int = Gravity.CENTER


    // 设置背景透明，默认背景是模糊的
    fun setTransparent(): UniversalDialog {
        isTransparent = true
        return universalDialog!!
    }

    // 对话框类型，1 = 宽高自适应 2 = 宽全屏高自适应 3 = 宽自适应高全屏 4 = 宽高全屏
    fun setType(type: String): UniversalDialog {
        this.type = type
        return universalDialog!!
    }

    // 布局
    fun setLayoutId(layoutId: Int): UniversalDialog {
        this.layoutId = layoutId
        return universalDialog!!
    }

    // 动画
    fun setAnimations(animations: Int): UniversalDialog {
        this.animations = animations
        return universalDialog!!
    }

    // 位置，默认居中
    fun setGravity(gravity: Int): UniversalDialog {
        this.gravity = gravity
        return universalDialog!!
    }

    // X轴边距
    fun setMarginX(marginX: Int): UniversalDialog {
        this.marginX = marginX
        return universalDialog!!
    }

    // Y轴边距
    fun setMarginY(marginY: Int): UniversalDialog {
        this.marginY = marginY
        return universalDialog!!
    }


    fun show(): Dialog {
        val dialog = if (isTransparent) {
            Dialog(context, R.style.dialog_transparent)
        } else {
            Dialog(context, R.style.dialog_dimenabled)
        }
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(layoutId)
        val dialogwindow = dialog.window!!
        dialogwindow.setWindowAnimations(animations)
        val lp = dialogwindow.attributes
        dialogwindow.setGravity(gravity)
        lp.x = marginX
        lp.y = marginY
        when (type) {
            "1" -> {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            "2" -> {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT
                lp.height = ViewGroup.LayoutParams.WRAP_CONTENT
            }
            "3" -> {
                lp.width = ViewGroup.LayoutParams.WRAP_CONTENT
                lp.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
            "4" -> {
                lp.width = ViewGroup.LayoutParams.MATCH_PARENT
                lp.height = ViewGroup.LayoutParams.MATCH_PARENT
            }
        }
        dialogwindow.attributes = lp
        dialog.show()
        return dialog
    }
}