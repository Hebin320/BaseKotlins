package com.hebin.project.tools.recyclerview

import android.content.Context
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.hebin.project.R

import com.hebin.superrecyclerview.recycleview.ProgressStyle
import com.hebin.superrecyclerview.recycleview.SuperRecyclerView
import com.taorouw.utils.SingletonUtil

/**
 * Created by Hebin
 * blog: http://blog.csdn.net/hebin320320
 * GitHub: https://github.com/Hebin320
 *
 *
 * RecyclerView的一些基础属性设置
 */
class RecyclerViewTool {


    companion object {


        /**
         * 不可滚动的Recyclerview，用于Scrollview中嵌套的Recyclerview
         */
        fun setSimpleLinearNoScroll(context: Context, recyclerView: RecyclerView) {
            val layoutManager: LinearLayoutManager
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
        }

        /**
         * 可滚动的Recyclerview
         */
        fun setSimpleLinearRecyclerView(context: Context, recyclerView: RecyclerView) {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
        }

        /**
         * 九宫格布局的Recyclerview
         * @param size 九宫格，一行的个数
         */
        fun setSimpleGridRecyclerView(context: Context, recyclerView: RecyclerView, size: Int) {
            val layoutManager = GridLayoutManager(context, size)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
        }

        /**
         * 不可滚动的SuperRecyclerview，用于Scrollview中嵌套的Recyclerview
         */
        fun setSuperLinearNoScoll(context: Context, recyclerView: SuperRecyclerView) {
            val layoutManager: LinearLayoutManager
            layoutManager = object : LinearLayoutManager(context) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.setLoadMoreEnabled(false)
            recyclerView.setRefreshEnabled(false)
        }

        /**
         * 可滚动的SuperRecyclerview，一般SuperRecyclerview的基础属性设置
         */
        fun setLinearRecyclerView(context: Context, recyclerView: SuperRecyclerView) {
            val layoutManager = LinearLayoutManager(context)
            layoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setArrowImageView(R.drawable.ic_downgrey)
        }

        /**
         * 九宫格布局的SuperRecyclerview
         * @param size 九宫格，一行的个数
         */
        fun setGridRecyclerView(context: Context, recyclerView: SuperRecyclerView, size: Int) {
            val layoutManager = GridLayoutManager(context, size)
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setArrowImageView(R.drawable.ic_downgrey)
        }

        /**
         * 九宫格布局的SuperRecyclerview不可滚动
         * @param size 九宫格，一行的个数
         */
        fun setGridNoScroll(context: Context, recyclerView: SuperRecyclerView, size: Int) {
            val layoutManager = object : GridLayoutManager(context, size) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            recyclerView.layoutManager = layoutManager
            recyclerView.itemAnimator = DefaultItemAnimator()
            recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
            recyclerView.setArrowImageView(R.drawable.ic_downgrey)
        }
    }

}
