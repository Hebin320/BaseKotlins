package com.hebin

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.DrawableRes
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.hebin.hxbindicator.AVLoadingIndicatorView
import com.lcodecore.tkrefreshlayout.IHeaderView
import com.lcodecore.tkrefreshlayout.OnAnimEndListener

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
class HxbRefreshView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr), IHeaderView {

    private var refreshArrow: ImageView? = null
    private var loadingView: AVLoadingIndicatorView? = null
    private var refreshTextView: TextView? = null

    private var pullDownStr = "下拉刷新"
    private var releaseRefreshStr = "释放刷新"
    private var refreshingStr = "正在刷新"

    init {
        init()
    }

    private fun init() {
        val rootView = View.inflate(context, R.layout.view_hebin_refresh, null)
        refreshArrow = rootView.findViewById<View>(R.id.iv_arrow) as ImageView
        refreshTextView = rootView.findViewById<View>(R.id.tv) as TextView
        loadingView = rootView.findViewById<View>(R.id.iv_loading) as AVLoadingIndicatorView
        refreshArrow!!.setImageResource(R.drawable.ic_downgrey)
        addView(rootView)
    }

    fun setIndicatorId(indicatorId: Int) {
        loadingView!!.setIndicatorId(indicatorId)
    }

    fun setIndicatorColor(color: Int) {
        loadingView!!.setIndicatorColor(color)
    }

    fun setArrowResource(@DrawableRes resId: Int) {
        refreshArrow!!.setImageResource(resId)
    }

    fun setTextColor(@ColorInt color: Int) {
        refreshTextView!!.setTextColor(color)
    }

    fun setPullDownStr(pullDownStr1: String) {
        pullDownStr = pullDownStr1
    }

    fun setReleaseRefreshStr(releaseRefreshStr1: String) {
        releaseRefreshStr = releaseRefreshStr1
    }

    fun setRefreshingStr(refreshingStr1: String) {
        refreshingStr = refreshingStr1
    }

    override fun getView(): View {
        return this
    }

    override fun onPullingDown(fraction: Float, maxHeadHeight: Float, headHeight: Float) {
        if (fraction < 1f) refreshTextView!!.text = pullDownStr
        if (fraction > 1f) refreshTextView!!.text = releaseRefreshStr
        refreshArrow!!.rotation = fraction * headHeight / maxHeadHeight * 180
    }

    override fun onPullReleasing(fraction: Float, maxHeadHeight: Float, headHeight: Float) {
        if (fraction < 1f) {
            refreshTextView!!.text = pullDownStr
            refreshArrow!!.rotation = fraction * headHeight / maxHeadHeight * 180
            if (refreshArrow!!.visibility == View.GONE) {
                refreshArrow!!.visibility = View.VISIBLE
                loadingView!!.visibility = View.GONE
            }
        }
    }

    override fun startAnim(maxHeadHeight: Float, headHeight: Float) {
        refreshTextView!!.text = refreshingStr
        refreshArrow!!.visibility = View.GONE
        loadingView!!.visibility = View.VISIBLE
    }

    override fun onFinish(listener: OnAnimEndListener) {
        listener.onAnimEnd()
    }

    override fun reset() {
        refreshArrow!!.visibility = View.VISIBLE
        loadingView!!.visibility = View.GONE
        refreshTextView!!.text = pullDownStr
    }
}