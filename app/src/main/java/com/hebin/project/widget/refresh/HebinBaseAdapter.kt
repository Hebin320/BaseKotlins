@file:Suppress("DEPRECATION")

package com.hebin.project.widget.refresh

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

/**
 * Author Hebin
 * <p>
 * created at 2018/4/4 16:22
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
abstract class HebinBaseAdapter<T, K : BaseViewHolder> : BaseQuickAdapter<T, K> {

    constructor(layoutResId: Int, data: List<T>?) : super(layoutResId, data) {
        init()
    }

    private fun init() {
        this.setLoadMoreView(NomoreView())
        this.setOnLoadMoreListener { listener?.onLoadMore() }
        this.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM)
    }

    constructor(data: List<T>?) : super(data)

    constructor(layoutResId: Int) : super(layoutResId)

    private var listener: OnRefreshListener? = null
    private var hrl: HebinRefreshLayout? = null

    fun setRefreshListener(hrl: HebinRefreshLayout, listener: OnRefreshListener) {
        this.listener = listener
        hrl.setOnRefreshListener(object : RefreshListenerAdapter() {
            override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
                super.onRefresh(refreshLayout)
                listener.onRefresh()
            }
        })
    }

    interface OnRefreshListener {
        fun onRefresh()
        fun onLoadMore()
    }



}
