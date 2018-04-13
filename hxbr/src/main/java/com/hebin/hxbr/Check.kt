@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

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
inline fun RadioButton.checkOrNot(noinline isCheck: (radioButton: CompoundButton) -> Unit, noinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
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
inline fun CheckBox.checkOrNot(noinline isCheck: (checkBox: CompoundButton) -> Unit, noinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
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
inline fun Switch.checkOrNot(noinline isCheck: (switch: CompoundButton) -> Unit, noinline isNotCheck: (switch: CompoundButton) -> Unit) {
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
inline fun Boolean.checkOrNot(noinline isCheck: () -> Unit, noinline isNotCheck: () -> Unit) {
    if (this) {
        isCheck()
    } else {
        isNotCheck()
    }
}

/**
 *  选中
 * */
inline fun RadioButton.isCheck(noinline isCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun CheckBox.isCheck(noinline isCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  选中
 * */
inline fun Switch.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun RadioButton.isNotCheck(noinline isNotCheck: (radioButton: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun CheckBox.isNotCheck(noinline isNotCheck: (checkBox: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  未选中
 * */
inline fun Switch.isNotCheck(noinline isNotCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (!b) {
            isNotCheck(compoundButton)
        }
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<RadioButton>.onlyRadioButton() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<CheckBox>.onlyCheckBox() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}

/**
 *  只选中一个
 * */
inline fun ArrayList<Switch>.onlySwitch() {
    for (i in this.indices) {
        this[i].setOnCheckedChangeListener { _, isCheck ->
            if (isCheck) {
                for (k in this.indices) {
                    if (i != k) {
                        this[k].isChecked = false
                    }
                }
            }
        }
    }
}