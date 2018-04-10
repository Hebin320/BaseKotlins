@file:Suppress("NOTHING_TO_INLINE")

package com.hebin.project.anko

import android.os.CountDownTimer
import com.hebin.project.tools.recyclerview.RecyclerViewTool
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout


/**
 *  刷新方法重写
 * */
inline fun TwinklingRefreshLayout.setOnRefreshListener(noinline mRefresh: () -> Unit, noinline mLoadMore: () -> Unit) {
    this.setOnRefreshListener(object : RefreshListenerAdapter() {

        override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
            super.onRefresh(refreshLayout)
            mRefresh()
        }

        override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
            super.onLoadMore(refreshLayout)
            mLoadMore()
        }

    })
}



