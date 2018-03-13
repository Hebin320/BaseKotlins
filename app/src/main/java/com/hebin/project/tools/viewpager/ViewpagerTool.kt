package com.hebin.tools.viewpager

import android.support.v4.view.ViewPager
import android.widget.RadioButton

/**
 * Author Hebin
 * <p>
 * created at 2017/6/14 11:39
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：Viewpager一些通用功能的封装
 */
class ViewpagerTool  {

    companion object {
        fun setRBCheck(viewPager: ViewPager, radioButton: Array<RadioButton>) {
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

                override fun onPageSelected(position: Int) {
                    for (i in radioButton.indices) {
                        radioButton[i].isChecked = i == position
                    }
                }
                override fun onPageScrollStateChanged(state: Int) {}
            })

        }
    }


}
