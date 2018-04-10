package com.hebin.hxbr.util

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class ScaleAnimatorUtil {


    companion object {

        /**
         *  收藏与取消收藏的动画效果
         * */
        fun setScalse(view: View) {
            val set = AnimatorSet()
            val animator_x = ObjectAnimator.ofFloat(view, "scaleX", 1.5f, 1.2f, 1f, 0.5f, 0.7f, 1f)
            val animator_y = ObjectAnimator.ofFloat(view, "scaleY", 1.5f, 1.2f, 1f, 0.5f, 0.7f, 1f)
            set.play(animator_x).with(animator_y)
            set.duration = 500
            set.start()
        }
    }
}
