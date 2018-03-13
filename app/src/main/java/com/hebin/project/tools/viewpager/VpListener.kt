package com.taorouw.tools.viewpager

import android.content.Context
import android.support.v4.view.ViewPager
import android.widget.ImageView
import android.widget.LinearLayout
import com.hebin.project.R
import org.jetbrains.anko.dip

/**
 * Author Hebin
 * <p>
 * created at 2017/7/12
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：随Viewpager切换而切换的原点
 */
class VpListener( var imageViews: ArrayList<ImageView>,  var viewPager: ViewPager) : ViewPager.OnPageChangeListener {


    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {
        for (i in imageViews.indices) {
            if (i == position) {
                imageViews[i].setBackgroundResource(R.drawable.color_circle)
            } else {
                imageViews[i].setBackgroundResource(R.drawable.gray_circle)
            }
        }
    }

    override fun onPageScrollStateChanged(state: Int) {}

    companion object {


        fun getImageViews(context: Context, linearLayout: LinearLayout, listSize: Int): ArrayList<ImageView> {
            linearLayout.removeAllViews()
            val imageViews: ArrayList<ImageView> = ArrayList()
            for (i in 0..(listSize - 1)) {
                val img = ImageView(context)
                val layoutParams = LinearLayout.LayoutParams(context.dip(8), context.dip(8))
                layoutParams.setMargins(0, 0, 8, 0)
                img.layoutParams = layoutParams
                if (i == 0) {
                    img.setBackgroundResource(R.drawable.color_circle)
                } else {
                    img.setBackgroundResource(R.drawable.gray_circle)
                }
                imageViews.add(img)
                linearLayout.addView(imageViews[i])
            }
            return imageViews
        }
    }
}