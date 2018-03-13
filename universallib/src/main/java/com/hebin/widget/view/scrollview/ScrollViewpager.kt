@file:Suppress("NAME_SHADOWING", "DEPRECATED_IDENTITY_EQUALS", "VARIABLE_WITH_REDUNDANT_INITIALIZER")

package com.taorouw.widget.view.viewpager

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.View


/**
 * Author Hebin
 *<p>
 * created at 2017/7/17 15:20
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：解决scrollview中，viewpager不显示的问题
 */
class ScrollViewpager : ViewPager {


    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    @SuppressLint("WrongConstant")
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasureSpec = heightMeasureSpec

        var height = 0
        for (i in 0..childCount - 1) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height)
                height = h
        }

        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

}
