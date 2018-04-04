@file:Suppress("DEPRECATION")

package com.hebin.project.ui.login

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import com.hebin.entity.TestEntity
import com.hebin.project.R
import com.hebin.project.base.BaseActivity
import com.hebin.project.utils.setMultiple
import com.hebin.project.widget.refresh.HebinBaseAdapter
import kotlinx.android.synthetic.main.activity_test_recyclerview.*

class TestRecyclerviewActivity : BaseActivity(), HebinBaseAdapter.OnRefreshListener {

    var count = 1
    var adapter: TestAdapter? = null
    var mList: MutableList<TestEntity.ListEntity> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recyclerview)
//        setList()
        setTypeList()
    }

    private fun setTypeList() {
        rvTest.layoutManager = LinearLayoutManager(context)
        val typeAdapter = TestTypeAdapter(setMultiple(10))
        rvTest.adapter = typeAdapter
    }

    private fun setList() {
        val title = arrayOf("loo", "周四", "伤口", "小程序", "热啊", "电饭锅", "loo", "周四", "伤口", "小程序", "热啊", "电饭锅")
        for (s in title) {
            val entity = TestEntity.ListEntity()
            entity.title = s
            mList.add(entity)
        }
        rvTest.layoutManager = LinearLayoutManager(context)
        adapter = TestAdapter(R.layout.public_simple_title, mList)
        rvTest.adapter = adapter
        adapter?.setRefreshListener(hrlTest, this)
        adapter?.disableLoadMoreIfNotFullPage(rvTest)
    }

    override fun onRefresh() {
        mList.clear()
        val title = arrayOf("loo", "周四", "伤口", "小程序", "热啊", "loo", "周四", "伤口", "小程序", "热啊")
        for (s in title) {
            val entity = TestEntity.ListEntity()
            entity.title = s
            mList.add(entity)
        }
        adapter?.refresh(mList)
        hrlTest.finishRefreshing()
        adapter?.disableLoadMoreIfNotFullPage(rvTest)
    }

    override fun onLoadMore() {
        when (count) {
            1 -> Handler().postDelayed({
                mList.addAll(mList)
                adapter?.refresh(mList)
                adapter?.loadMoreComplete()
                count += 1
            }, 2000)
            2 -> {
                Handler().postDelayed({
                    adapter?.loadMoreFail()
                    count += 1
                }, 2000)
            }
            else ->
                Handler().postDelayed({
                    adapter?.loadMoreEnd()
                }, 2000)
        }
    }


}

