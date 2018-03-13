package com.hebin.utils

import android.content.Context
import android.util.TypedValue

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
 * 说明：常用单位转换的辅助类
 */
class DensityUtil private constructor()  {

    init {
        throw UnsupportedOperationException("cannot be instantiated")
    }


    companion object {

        /**
         * dp转px
         */
        fun dp2px(context: Context, dpVal: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    dpVal, context.resources.displayMetrics).toInt()
        }

        /**
         * sp转px
         */
        fun sp2px(context: Context, spVal: Float): Int {
            return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                    spVal, context.resources.displayMetrics).toInt()
        }

        /**
         * px转dp
         */
        fun px2dp(context: Context, pxVal: Float): Float {
            val scale = context.resources.displayMetrics.density
            return pxVal / scale
        }

        /**
         * px转sp
         */
        fun px2sp(context: Context, pxVal: Float): Float {
            return pxVal / context.resources.displayMetrics.scaledDensity
        }

        /**
         * dip转px
         */
        fun dip2px(ctx: Context, dpValue: Float): Int {
            val scale = ctx.resources.displayMetrics.density
            return (dpValue * scale + 0.5f).toInt()
        }
    }


}