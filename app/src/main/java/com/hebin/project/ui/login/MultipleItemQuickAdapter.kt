package com.hebin.project.ui.login

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.hebin.entity.MultipleItem
import com.hebin.project.R

/**
 * Author Hebin
 * <p>
 * created at 2018/3/30 17:27
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class MultipleItemQuickAdapter(data: List<MultipleItem>) : BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(data) {

    init {
        addItemType(MultipleItem.ONE, R.layout.public_simple_title)
        addItemType(MultipleItem.TWO, R.layout.public_simple_title_right_img)
    }

    override fun convert(helper: BaseViewHolder, item: MultipleItem) {
        when (helper.itemViewType) {
            MultipleItem.ONE -> {
            }
            MultipleItem.TWO -> {
            }
        }
    }

}
