package com.hebin.tools.textview

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.os.CountDownTimer
import android.text.*
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import com.hebin.mInterface.DoSomeThing


/**
 * Created by Hebin
 * blog: http://blog.csdn.net/hebin320320
 * GitHub: https://github.com/Hebin320
 *
 *
 * EditText的一些方法的封装
 */
@SuppressLint("WrongConstant")
class EditTextTool {

    /**
     * 显示、隐藏EditText的内容
     * @param checkBox 眼睛图标
     * *
     * @param editText 文本框
     */
    fun showOrHideEye(checkBox: Array<CheckBox>, editText: Array<EditText>): EditTextTool {
        for (i in editText.indices) {
            if (checkBox[i].isChecked) {
                editText[i].transformationMethod = PasswordTransformationMethod.getInstance()
                checkBox[i].isChecked = false
            } else {
                editText[i].transformationMethod = HideReturnsTransformationMethod.getInstance()
                checkBox[i].isChecked = true
            }
        }
        return editTextTool!!
    }

    /**
     * 隐藏EditText的内容
     */
    fun setEditTextHide(editText: Array<EditText>): EditTextTool {
        for (anEditText in editText) {
            anEditText.transformationMethod = PasswordTransformationMethod.getInstance()
        }
        return editTextTool!!
    }


    /**
     * 改变EditText底部线条的颜色
     */
    fun setLineChangeByLostFocus(editTexts: Array<EditText>, views: Array<View>): EditTextTool {
        for (i in editTexts.indices) {
            val position = i
            editTexts[i].setOnFocusChangeListener { view, b ->
                if (b) {
                    views[position].setBackgroundColor(Color.parseColor("#29c98f"))
                } else {
                    views[position].setBackgroundColor(Color.parseColor("#e7e7e7"))
                }
            }
        }
        return editTextTool!!
    }

    /**
     * 改变EditText底部线条的颜色
     */
    fun setLineChangeByLostFocus(editTexts: Array<EditText>, views: Array<View>, viewDelete: Array<View>): EditTextTool {
        for (i in editTexts.indices) {
            val position = i
            editTexts[i].setOnFocusChangeListener { view, b ->
                if (b) {
                    views[position].setBackgroundColor(Color.parseColor("#29c98f"))
                    viewDelete[position].visibility = View.VISIBLE
                } else {
                    views[position].setBackgroundColor(Color.parseColor("#e7e7e7"))
                    viewDelete[position].visibility = View.GONE
                }
            }

            editTexts[i].addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

                }

                override fun afterTextChanged(editable: Editable) {
                    if (editable.isNotEmpty()) {
                        viewDelete[position].visibility = View.VISIBLE
                    } else {
                        viewDelete[position].visibility = View.GONE
                    }
                }
            })
        }
        return editTextTool!!
    }

    /**
     * 为TextView中的文字增加下划线
     */
    fun setUnderline(textViews: Array<TextView>): EditTextTool {
        for (textView in textViews) {
            textView.paint.flags = Paint.UNDERLINE_TEXT_FLAG //下划线
            textView.paint.isAntiAlias = true//抗锯齿
        }
        return editTextTool!!
    }

    /**
     * 监听文本框内容，显示或隐藏删除按钮
     */

    fun showOrHideDelete(editTexts: Array<EditText>, views: Array<View>): EditTextTool {
        if (editTexts.size == views.size) {
            for (i in editTexts.indices) {
                val position = i
                editTexts[i].addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                    }

                    override fun afterTextChanged(editable: Editable) {
                        if (editable.isNotEmpty()) {
                            views[position].visibility = View.VISIBLE
                        } else {
                            views[position].visibility = View.GONE
                        }
                    }
                })
            }
        }
        return editTextTool!!
    }

    fun etChangeDoSomeThing(editTexts: EditText, doSomeThing: DoSomeThing): EditTextTool {
        editTexts.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                doSomeThing.doSomeThing(ET_CHANGE_DOSOMETHING_TAG, editable.toString())
            }
        })
        return editTextTool!!
    }

    /**
     * 改变部分字体颜色

     * @param textView    显示的文本框
     * *
     * @param allString   整个字符串
     * *
     * @param colorString 需要改变字体颜色的字符串
     */
    fun colorString(textView: TextView, allString: String, colorString: String): EditTextTool {
        val fstart = allString.indexOf(colorString)
        val fend = fstart + colorString.length
        val style = SpannableStringBuilder(allString)
        style.setSpan(ForegroundColorSpan(Color.parseColor("#10b478")), fstart, fend, Spannable.SPAN_EXCLUSIVE_INCLUSIVE)
        textView.text = style
        return editTextTool!!
    }


    /**
     * 发送验证码倒计时

     * @param textView 倒计时按钮文本框
     */
    fun setTimer(textView: TextView): EditTextTool {
        object : CountDownTimer(60000, 1000) {
            @SuppressLint("SetTextI18n")
            override fun onTick(millisUntilFinished: Long) {
                textView.text = (millisUntilFinished / 1000).toString() + "秒后重发"
                textView.setTextColor(Color.parseColor("#aeaeae"))
                textView.isEnabled = false
            }

            override fun onFinish() {
                textView.setTextColor(Color.parseColor("#8b9bb4"))
                textView.text = "发送验证码"
                textView.isEnabled = true
            }
        }.start()
        return editTextTool!!
    }

    /***
     * 获得隐藏的手机号（用*号进行遮掩处理）
     * @param phone 手机号码
     */
    @SuppressLint("SetTextI18n")
    fun hidePhoneWithStar(textView: TextView, phone: String): EditTextTool {
        if (!TextUtils.isEmpty(phone)) {
            if (phone.length == 11) {
                textView.text = phone.substring(0, 3) + "****" + phone.substring(7, 11)
            }
        }
        return editTextTool!!
    }

    /**
     * 多个CheckBox的时候，点击一个，设置其他为非选中状态
     */
    fun cbCheckedChange(checkBoxes: Array<CheckBox>): EditTextTool {
        for (i in checkBoxes.indices) {
            val finalI = i
            checkBoxes[i].setOnCheckedChangeListener { _, b ->
                if (b) {
                    checkBoxes.indices
                            .filter { it != finalI }
                            .forEach { checkBoxes[it].isChecked = false }
                }
            }
        }
        return editTextTool!!
    }

    companion object {

        var editTextTool: EditTextTool? = null

        fun creat(): EditTextTool {
            if (editTextTool == null) {
                synchronized(EditTextTool::class.java) {
                    if (editTextTool == null) {
                        editTextTool = EditTextTool()
                    }
                }
            }
            return editTextTool!!
        }

        /**
         * 监听文本框内容，自定义操作
         */
        const val ET_CHANGE_DOSOMETHING_TAG = "ET_CHANGE_DOSOMETHING_TAG"
    }


}
