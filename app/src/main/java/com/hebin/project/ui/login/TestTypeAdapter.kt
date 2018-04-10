package com.hebin.project.ui.login

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.hebin.entity.MultipleItem
import com.hebin.project.R

/**
 * Author Hebin
 * <p>
 * created at 2018/4/2 14:32
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class TestTypeAdapter(var list: MutableList<MultipleItem>) : BaseMultiItemQuickAdapter<MultipleItem, BaseViewHolder>(list) {

    init {
        addItemType(MultipleItem.ONE, R.layout.public_simple_title)
        addItemType(MultipleItem.TWO, R.layout.public_simple_title_right)
        addItemType(MultipleItem.THREE, R.layout.test_swpie_menu)
        addItemType(MultipleItem.FOUR, R.layout.public_simple_title_right)
        addItemType(MultipleItem.FIVE, R.layout.test_swpie_menu)
        addItemType(MultipleItem.SIX, R.layout.public_simple_title_right)
        addItemType(MultipleItem.SEVEN, R.layout.test_swpie_menu)
        addItemType(MultipleItem.EIGHT, R.layout.public_simple_title_right)
        addItemType(MultipleItem.NINE, R.layout.test_swpie_menu)
        addItemType(MultipleItem.TEN, R.layout.public_simple_title_right)
    }

    override fun convert(helper: BaseViewHolder, item: MultipleItem) {
        when (item.type) {
            MultipleItem.ONE ->
                helper.setText(R.id.tvTitle, item.type.toString())
                        .addOnClickListener(R.id.tvTitle)
            MultipleItem.TWO -> helper.setText(R.id.tvRight, item.type.toString()).addOnClickListener(R.id.tvRight)
        }
    }




}
