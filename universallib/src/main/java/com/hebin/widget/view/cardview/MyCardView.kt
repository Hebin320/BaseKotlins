package com.hebin.widget.view.cardview

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.support.v7.widget.CardView
import android.util.AttributeSet
import com.hebin.universalelib.R

/**
 * Author Hebin
 *
 *
 * created at 2017/6/5 15:52
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * 说明：重写CardView，解决CardView在5.0以下版本，出现边距的问题
 */
@SuppressLint("Recycle")
class MyCardView : CardView {

    constructor(context: Context) : super(context) {
        setElevation(null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        setElevation(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setElevation(attrs)
    }

    fun setElevation(attrs: AttributeSet?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
           val a = context.obtainStyledAttributes(attrs, R.styleable.MyCardView)
            this.cardElevation = a.getDimension(R.styleable.MyCardView_card_elevation, resources.getDimension(R.dimen.dp_10))
        } else {
            this.cardElevation = resources.getDimension(R.dimen.dp_0)
        }
    }

}
