package com.hebin

import com.hebin.adapter.BaseQuickAdapter
import com.hebin.adapter.BaseViewHolder

/**
 * Author Hebin
 * <p>
 * created at 2018/4/17
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
abstract class BaseHxbAdapter<T, K : BaseViewHolder>(data: MutableList<T>?) : BaseQuickAdapter<T, K>(data) {

    override fun convert(helper: K, item: T) {
        convert(helper, item, helper.layoutPosition)
    }


    protected abstract fun convert(holder: BaseViewHolder, item: T, position: Int)

}