package com.hebin.project.widget.refresh

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.hebin.project.R

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
class NomoreView : LoadMoreView() {

    override fun getLayoutId(): Int {
        return R.layout.view_nomore
    }

    override fun getLoadingViewId(): Int {
        return R.id.load_more_loading_view
    }

    override fun getLoadFailViewId(): Int {
        return R.id.load_more_load_fail_view
    }

    override fun getLoadEndViewId(): Int {
        return R.id.load_more_load_end_view
    }

}