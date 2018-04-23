@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.anko

import android.content.Context
import com.hebin.utils.DialogUtil

/**
 * Author Hebin
 * <p>
 * created at 2018/4/16
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

inline fun Context.showLoad() = DialogUtil.showDialog(this)

inline fun hideLoad() = DialogUtil.hideDialog()
