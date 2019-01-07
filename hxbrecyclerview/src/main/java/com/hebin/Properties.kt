package com.hebin

import android.support.v7.widget.RecyclerView
import android.view.View
import com.hebin.adapter.BaseMultiItemQuickAdapter
import com.hebin.adapter.BaseQuickAdapter
import com.lcodecore.tkrefreshlayout.IBottomView
import com.lcodecore.tkrefreshlayout.IHeaderView
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Author Hebin
 * <p>
 * created at 2018/4/26
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */


var HxbRecyclerview.emptyView: View?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setEmptyView(v!!)

var HxbRecyclerview.nomoreView: View?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setNomoreView(v!!)

var HxbRecyclerview.failView: View?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setFailView(v!!)

var HxbRecyclerview.indicatorColor: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setIndicatorColor(v!!)

var HxbRecyclerview.indicatorId: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setIndicatorId(v!!)

var HxbRecyclerview.headHeight: Float?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHeadHeight(v!!)

var HxbRecyclerview.arrowResource: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setArrowResource(v!!)

var HxbRecyclerview.textColor: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setTextColor(v!!)

var HxbRecyclerview.pullDownStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setPullDownStr(v!!)

var HxbRecyclerview.releaseRefreshStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setReleaseRefreshStr(v!!)

var HxbRecyclerview.refreshingStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setRefreshingStr(v!!)

var HxbRecyclerview.headView: IHeaderView?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setHeadView(v!!)

var HxbRecyclerview.maxHeadHeight: Float?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMaxHeadHeight(v!!)

var HxbRecyclerview.bottomIndicatorColor: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomIndicatorColor(v!!)

var HxbRecyclerview.bottomIndicatorId: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomIndicatorId(v!!)

var HxbRecyclerview.bottomHeight: Float?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomHeight(v!!)

var HxbRecyclerview.bottomArrowResource: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomArrowResource(v!!)

var HxbRecyclerview.bttomTextColor: Int?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomTextColor(v!!)

var HxbRecyclerview.bottomPullDownStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomPullDownStr(v!!)

var HxbRecyclerview.bottomReleaseRefreshStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomReleaseRefreshStr(v!!)

var HxbRecyclerview.bottomRefreshingStr: String?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomRefreshingStr(v!!)

var HxbRecyclerview.maxBottomHeight: Float?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setMaxBottomHeight(v!!)

var HxbRecyclerview.bottomView: IBottomView?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setBottomView(v!!)

var HxbRecyclerview.floatRefresh: Boolean?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setFloatRefresh(v!!)

var HxbRecyclerview.layoutManager: RecyclerView.LayoutManager?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setLayoutManager(v!!)

var HxbRecyclerview.adapter: BaseQuickAdapter<*, *>?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setAdapter(v!!)

var HxbRecyclerview.multiItemAdapter: BaseMultiItemQuickAdapter<*, *>?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setAdapter(v!!)

var HxbRecyclerview.listener: HxbRecyclerview.Listener?
    @Deprecated(AnkoInternals.NO_GETTER, level = DeprecationLevel.ERROR) get() = AnkoInternals.noGetter()
    set(v) = setListener(v!!)

