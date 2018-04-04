package com.hebin.project.ui.login

import com.chad.library.adapter.base.BaseViewHolder
import com.hebin.entity.TestEntity
import com.hebin.project.R
import com.hebin.project.utils.ResultDealUtil
import com.hebin.project.utils.setOnRefreshListener
import com.hebin.project.utils.zeroOrNot
import com.hebin.project.widget.refresh.HebinBaseAdapter
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout

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
class TestAdapter(layout: Int, var list: MutableList<TestEntity.ListEntity>) : HebinBaseAdapter<TestEntity.ListEntity, BaseViewHolder>(layout, list) {


    fun refresh(list: MutableList<TestEntity.ListEntity>) {
        this.list = list
        this.notifyDataSetChanged()
    }

    override fun convert(helper: BaseViewHolder, item: TestEntity.ListEntity) {
        helper.adapterPosition.zeroOrNot(
                { helper.setText(R.id.tvTitle, item.title) },
                { helper.setText(R.id.tvTitle, "${item.title}Hebin") })




    }


}

