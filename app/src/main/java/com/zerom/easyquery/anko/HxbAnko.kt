@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.app.Activity


inline fun Activity.getStringExtra(tag: String) = HxbAnko.getStringExtra(this, tag)

inline fun Activity.getStringArrayExtra(tag: String) = HxbAnko.getStringArrayExtra(this, tag)

inline fun Activity.getStringArrayListExtra(tag: String) = HxbAnko.getStringArrayListExtra(this, tag)


class HxbAnko {

    companion object {

        fun getStringExtra(activity: Activity, tag: String): String {
            return if (activity.intent.getStringExtra(tag) == null) {
                ""
            } else {
                activity.intent.getStringExtra(tag)
            }
        }

        fun getStringArrayExtra(activity: Activity, tag: String): Array<String> {
            return if (activity.intent.getStringArrayExtra(tag) == null) {
                emptyArray()
            } else {
                activity.intent.getStringArrayExtra(tag)
            }
        }


        fun getStringArrayListExtra(activity: Activity, tag: String): ArrayList<String> {
            return if (activity.intent.getStringArrayListExtra(tag) == null) {
                ArrayList()
            } else {
                activity.intent.getStringArrayListExtra(tag)
            }
        }
    }
}