@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.view.View

inline fun View.setGone() = HxbView.setGone(this)

inline fun View.setVisible() = HxbView.setVisible(this)

inline fun View.setInvisible() = HxbView.setInvisible(this)

class HxbView {
    companion object {
        fun setGone(view: View) {
            view.visibility = View.GONE
        }

        fun setVisible(view: View) {
            view.visibility = View.VISIBLE
        }

        fun setInvisible(view: View) {
            view.visibility = View.INVISIBLE
        }
    }
}