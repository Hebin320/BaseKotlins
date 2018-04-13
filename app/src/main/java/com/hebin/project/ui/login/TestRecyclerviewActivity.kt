@file:Suppress("DEPRECATION")

package com.hebin.project.ui.login

import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.hebin.entity.DataEntity
import com.hebin.entity.TestEntity
import com.hebin.hxbr.allEmpty
import com.hebin.hxbr.setVerticalLinear
import com.hebin.hxbr.showToast
import com.hebin.project.R
import com.hebin.project.anko.*
import com.hebin.project.base.BaseActivity
import com.hebin.project.presenter.LoginPresenter
import com.hebin.project.widget.refresh.HebinBaseAdapter
import com.zerom.management.mInterface.base.UniversalView
import kotlinx.android.synthetic.main.activity_test_recyclerview.*

class TestRecyclerviewActivity : BaseActivity(), HebinBaseAdapter.OnRefreshListener, UniversalView,
        BaseQuickAdapter.OnItemChildClickListener {


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
        arrayListOf("", "", "", "").allEmpty({ showToast("全部为空") }, { showToast("部分不为空") })
        rvTest.setVerticalLinear(context)
        val typeAdapter = TestTypeAdapter(setMultiple(10))
        rvTest.adapter = typeAdapter
        typeAdapter.onItemChildClickListener = this
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


    override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>?, view: View, position: Int) {
        when (view.id) {
            R.id.tvTitle -> LoginPresenter(context, this).login(true)
            R.id.tvRight -> {
                LoginPresenter(context, this).time(false)
                showToast("我被点击了")
            }
        }

    }


    override fun getData(): Any {
        val entity = DataEntity()
        return entity
    }

    override fun getSuccess(type: Any, T: Any) {
    }


}

