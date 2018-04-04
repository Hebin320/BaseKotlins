package com.hebin.project.utils

import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Switch

/**
 * Author Hebin
 * <p>
 * created at 2018/4/4
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

/**
 *  是否被选中
 * */
inline fun RadioButton.checkOrNot(crossinline isCheck: (radioButton: CompoundButton) -> Unit, crossinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  是否被选中
 * */
inline fun CheckBox.checkOrNot(crossinline isCheck: (checkBox: CompoundButton) -> Unit, crossinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  是否被选中
 * */
inline fun Switch.checkOrNot(crossinline isCheck: (switch: CompoundButton) -> Unit, crossinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        } else {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun RadioButton.isCheck(crossinline isCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun CheckBox.isCheck(crossinline isCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun Switch.isCheck(crossinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun RadioButton.isNotCheck(crossinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun CheckBox.isNotCheck(crossinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun Switch.isNotCheck(crossinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}