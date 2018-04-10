@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.anko

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import com.hebin.utils.ImageUtil

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
 *  选择图片
 * */
inline fun Activity.selectImage(size: Int, code: Int) = ImageUtil.selectImage(this, size, code)
