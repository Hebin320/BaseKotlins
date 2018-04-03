@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.tools.recyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hebin.entity.MultipleItem
import com.hebin.project.R


//@Suppress("NOTHING_TO_INLINE")
/**
 * Created by Hebin
 * blog: http://blog.csdn.net/hebin320320
 * GitHub: https://github.com/Hebin320
 *
 *
 * RecyclerView的一些基础属性设置
 */


/**
 * 不可滚动的Recyclerview，用于Scrollview中嵌套的Recyclerview
 */
//inline fun setSimpleLinearNoScroll(context: Context, recyclerView: RecyclerView) {
//    val layoutManager: LinearLayoutManager
//    layoutManager = object : LinearLayoutManager(context) {
//        override fun canScrollVertically(): Boolean {
//            return false
//        }
//    }
//    layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//}
//
///**
// * 可滚动的Recyclerview
// */
//inline fun setSimpleLinearRecyclerView(context: Context, recyclerView: RecyclerView) {
//    val layoutManager = LinearLayoutManager(context)
//    layoutManager.orientation = LinearLayoutManager.VERTICAL
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//}
//
///**
// * 九宫格布局的Recyclerview
// * @param size 九宫格，一行的个数
// */
//inline fun setSimpleGridRecyclerView(context: Context, recyclerView: RecyclerView, size: Int) {
//    val layoutManager = GridLayoutManager(context, size)
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//}
//
///**
// * 不可滚动的SuperRecyclerview，用于Scrollview中嵌套的Recyclerview
// */
//inline fun setSuperLinearNoScoll(context: Context, recyclerView: LRecyclerView) {
//    val layoutManager: LinearLayoutManager
//    layoutManager = object : LinearLayoutManager(context) {
//        override fun canScrollVertically(): Boolean {
//            return false
//        }
//    }
//    layoutManager.setOrientation(LinearLayoutManager.VERTICAL)
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//    recyclerView.setLoadMoreEnabled(false)
//    recyclerView.setPullRefreshEnabled(false)
//}
//
///**
// * 可滚动的SuperRecyclerview，一般SuperRecyclerview的基础属性设置
// */
//inline fun setLinearRecyclerView(context: Context, recyclerView: LRecyclerView) {
//    val layoutManager = LinearLayoutManager(context)
//    layoutManager.orientation = LinearLayoutManager.VERTICAL
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//    recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setArrowImageView(R.drawable.ic_downgrey)
//}
//
///**
// * 九宫格布局的SuperRecyclerview
// * @param size 九宫格，一行的个数
// */
//inline fun setGridRecyclerView(context: Context, recyclerView: LRecyclerView, size: Int) {
//    val layoutManager = GridLayoutManager(context, size)
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//    recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setArrowImageView(R.drawable.ic_downgrey)
//}
//
///**
// * 九宫格布局的SuperRecyclerview不可滚动
// * @param size 九宫格，一行的个数
// */
//inline fun setGridNoScroll(context: Context, recyclerView: LRecyclerView, size: Int) {
//    val layoutManager = object : GridLayoutManager(context, size) {
//        override fun canScrollVertically(): Boolean {
//            return false
//        }
//    }
//    recyclerView.layoutManager = layoutManager
//    recyclerView.itemAnimator = DefaultItemAnimator()
//    recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader)
//    recyclerView.setArrowImageView(R.drawable.ic_downgrey)
//}


class RecyclerViewTool {

    /**
     *  Recyclerview 多布局数据源设置
     * */
    fun setMultiple(num: Int): MutableList<MultipleItem> {
        val mList: MutableList<MultipleItem> = ArrayList()
        if (num > 0) {
            for (i in 1..num) {
                mList.add(MultipleItem(i))
            }
        }
        return mList
    }

}