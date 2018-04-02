package com.hebin.project.widget.refresh

import android.content.Context
import android.util.AttributeSet
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

/**
 * Author Hebin
 *
 *
 * created at 2018/4/2
 *
 *
 * blog: http://blog.csdn.net/hebin320320
 *
 *
 * GitHub: https://github.com/Hebin320
 *
 *
 * describe：
 */
class HebinRefreshLayout @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : TwinklingRefreshLayout(context, attrs, defStyleAttr) {


    init {
        init()
    }

    private var headView: HebinRefreshView? = null
    private var listener: OnRefreshListener? = null


    private fun init() {
        headView = HebinRefreshView(context)
        this.setHeaderView(headView)
        this.setOnRefreshListener(object : RefreshListenerAdapter() {
            override fun onRefresh(refreshLayout: TwinklingRefreshLayout?) {
                super.onRefresh(refreshLayout)
                listener?.onRefresh()
            }

            override fun onLoadMore(refreshLayout: TwinklingRefreshLayout?) {
                super.onLoadMore(refreshLayout)
                listener?.onLoadMore()
            }
        })
        this.setHeaderHeight(60f)
    }

    fun setIndicatorColor(color: Int) {
        headView?.setIndicatorColor(color)
    }

    fun setIndicatorId(indicator: Int) {
        headView?.setIndicatorId(indicator)
    }

    fun setRefreshListener(listener: OnRefreshListener) {
        this.listener = listener
    }

    interface OnRefreshListener {
        fun onRefresh()
        fun onLoadMore()
    }


}
