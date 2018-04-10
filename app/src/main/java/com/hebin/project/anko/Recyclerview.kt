@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.anko

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hebin.project.tools.recyclerview.RecyclerViewTool

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
 *  Recyclerview 多布局数据源设置
 * */
inline fun setMultiple(num: Int) = RecyclerViewTool().setMultiple(num)
