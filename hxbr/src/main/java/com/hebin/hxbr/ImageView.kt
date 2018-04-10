@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.hxbr

import android.content.Context
import android.widget.ImageView
import com.hebin.hxbr.util.ImageUtil

/**
 * Author Hebin
 * <p>
 * created at 2018/4/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */


/**
 *  加载圆形图片
 * */
inline fun Context.glideCircleImage(url: Any, imageView: ImageView) = ImageUtil.glideCircleImage(this, url, imageView)

/**
 *  加载正常图片
 * */
inline fun Context.glideNormalImage(url: Any, imageView: ImageView) = ImageUtil.glideNormalImage(this, url, imageView)

/**
 *  加载圆角图片
 * */
inline fun Context.glideRoundImage(url: Any, roundSize: Int, imageView: ImageView) = ImageUtil.glideRoundImage(this, url, roundSize, imageView)