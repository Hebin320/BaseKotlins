@file:Suppress("NOTHING_TO_INLINE", "ConflictingExtensionProperty")

package com.zerom.easyquery.anko

import android.graphics.Color
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import org.jetbrains.anko.internals.AnkoInternals

inline fun TextView.getString() = HxbTextview.getString(this)

inline fun EditText.getString() = HxbTextview.getString(this)

inline fun Button.getString() = HxbTextview.getString(this)

inline fun RadioButton.getString() = HxbTextview.getString(this)

inline fun CheckBox.getString() = HxbTextview.getString(this)

inline fun Switch.getString() = HxbTextview.getString(this)

inline fun EditText.setEdTexts(string: String) {
    this.setText(string)
}

var EditText.texts: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setEdTexts(v)

inline fun EditText.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var EditText.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

inline fun TextView.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var TextView.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

inline fun Button.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var Button.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

inline fun RadioButton.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var RadioButton.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

inline fun CheckBox.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var CheckBox.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)

inline fun Switch.setTextColor(colorCode: String) {
    this.setTextColor(Color.parseColor(colorCode))
}

var Switch.textColors: String
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v)


inline fun EditText.addTextChangedListener(noinline mAfterTextChanged: (p0: Editable) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable) {
            mAfterTextChanged(p0)
        }

        override fun beforeTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence, p1: Int, p2: Int, p3: Int) {
        }
    })
}

class HxbTextview {

    companion object {

        fun getString(textview: TextView): String {
            return if (textview.text.toString().isEmpty()) {
                ""
            } else {
                textview.text.toString()
            }
        }

        fun getString(editText: EditText): String {
            return if (editText.text.toString().isEmpty()) {
                ""
            } else {
                editText.text.toString()
            }
        }

        fun getString(button: Button): String {
            return if (button.text.toString().isEmpty()) {
                ""
            } else {
                button.text.toString()
            }
        }

        fun getString(radioButton: RadioButton): String {
            return if (radioButton.text.toString().isEmpty()) {
                ""
            } else {
                radioButton.text.toString()
            }
        }

        fun getString(checkBox: CheckBox): String {
            return if (checkBox.text.toString().isEmpty()) {
                ""
            } else {
                checkBox.text.toString()
            }
        }

        fun getString(switch: Switch): String {
            return if (switch.text.toString().isEmpty()) {
                ""
            } else {
                switch.text.toString()
            }
        }
    }
}

