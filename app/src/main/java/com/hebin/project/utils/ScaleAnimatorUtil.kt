package com.hebin.utils

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

/**
 * Author Hebin
 *
 *
 * created at 2017/5/5 10:27
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：收藏与取消收藏的动画工具类
 */
class ScaleAnimatorUtil  {


    companion object {

        /**
         * 设置缩放动画

         * @param view
         */
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
