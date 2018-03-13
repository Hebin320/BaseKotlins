package com.hebin.widget.view.scrollview

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Author Hebin
 *<p>
 * created at 2017/6/5 15:53
 *<p>
 * blog: http://blog.csdn.net/hebin320320
 *<p>
 * GitHub: https://github.com/Hebin320
 *<p>
 * 说明：重写Viewpager，实现不可左右滑动的Viewpager
 */
class DisableScrollViewpager : ViewPager {

    private var isPagingEnabled = false

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    //设置该方法，即可实现Viewpager的不可滚动
    fun setPagingEnabled(b: Boolean) {
        this.isPagingEnabled = b
    }
}
