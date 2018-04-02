@file:Suppress("DEPRECATION")

package com.hebin.project.ui.login

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.hebin.entity.TestEntity
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.hebin.project.utils.showToast
import com.hebin.project.widget.refresh.HebinRefreshLayout
import kotlinx.android.synthetic.main.activity_test_recyclerview.*

class TestRecyclerviewActivity : BaseActivity(), HebinRefreshLayout.OnRefreshListener,
        BaseQuickAdapter.OnItemChildClickListener {

    var adapter: TestAdapter? = null
    var mList: MutableList<TestEntity.ListEntity> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recyclerview)
        init()
        setList()
    }

    private fun init() {
    }

    private fun setList() {
        val title = arrayOf("loo", "周四", "伤口", "小程序", "热啊", "电饭锅", "现在", "驱蚊器", "郭德纲")
        for (s in title) {
            val entity = TestEntity.ListEntity()
            entity.title = s
            mList.add(entity)
        }
        rvTest.layoutManager = LinearLayoutManager(this)
        adapter = TestAdapter(R.layout.test_item, mList)
        rvTest.adapter = adapter
        adapter?.onItemChildClickListener = this
        erlTest.setRefreshListener(this)
    }


    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View?, position: Int) {
        showToast(context, "${position}项")
    }

    override fun onRefresh() {
        Handler().postDelayed({
            mList.addAll(mList)
            adapter?.refresh(mList)
            erlTest.finishRefreshing()
        }, 2000)
    }

    override fun onLoadMore() {
        Handler().postDelayed({
            mList.removeAt(0)
            adapter?.refresh(mList)
            erlTest.finishLoadmore()
        }, 2000)
    }

}
