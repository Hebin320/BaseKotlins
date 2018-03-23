package com.hebin.project.widget

import android.content.Context
import android.widget.Toast

/**
 * Author Hebin
 * <p>
 * created at 2018/3/22
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

inline operator fun Int.invoke(hxb: ()-> Unit) {
    if (0 == this) {
        hxb()
    }else{

    }
}
