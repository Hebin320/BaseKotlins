@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.RadioButton
import android.widget.Switch

inline fun Switch.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

inline fun RadioButton.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}

inline fun CheckBox.isCheck(noinline isCheck: (switch: CompoundButton) -> Unit) {
    this.setOnCheckedChangeListener { compoundButton, b ->
        if (b) {
            isCheck(compoundButton)
        }
    }
}