@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

// 垂直线性布局
inline fun RecyclerView.verticalLayout(context: Context) = HxbRecyclerview.verticalLinear(this, context)

// 水平线性布局
inline fun RecyclerView.horizontalLayout(context: Context) = HxbRecyclerview.horizontalLinear(this, context)

// 九宫格布局
inline fun RecyclerView.grideLayout(context: Context, count: Int) = HxbRecyclerview.grideLayout(this, context, count)


class HxbRecyclerview {
    companion object {
        fun verticalLinear(recyclerView: RecyclerView, context: Context) {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
        }

        fun horizontalLinear(recyclerView: RecyclerView, context: Context) {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            recyclerView.layoutManager = layoutManager
        }


        fun grideLayout(recyclerView: RecyclerView, context: Context, count: Int) {
            val layoutManager = GridLayoutManager(context, count)
            recyclerView.layoutManager = layoutManager
        }


    }
}