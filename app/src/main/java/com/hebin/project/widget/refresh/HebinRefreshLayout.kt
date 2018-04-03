package com.hebin.project.widget.refresh

import android.content.Context
import android.util.AttributeSet
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

/**
 * Author Hebin
 * <p>
 * created at 2018/4/3
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
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
        })
        this.setHeaderHeight(60f)
        this.setEnableLoadmore(false)
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
    }


}