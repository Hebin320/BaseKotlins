package com.hebin.project.presenter

import android.content.Context
import com.google.gson.Gson
import com.hebin.project.base.douyu
import com.hebin.project.base.look
import com.hebin.project.base.time
import com.hebin.project.base.okgo.BaseOkgoGet
import com.hebin.project.entity.DataEntity
import com.hebin.project.entity.DouyuEntity
import com.hebin.project.mInterface.SuccessListener
import com.hebin.project.mInterface.UniversalView
import com.hebin.project.utils.ResultDealUtil

/**
 * Author Hebin
 * <p>
 * created at 2018/4/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class DouyuPresenter(val context: Context, val view: UniversalView) : SuccessListener {

    companion object {
        const val SUCCESS_FOR_DOUYU = 1
    }

    private val entity = view.getData() as DataEntity

    fun getPic(isShow: Boolean) {
        BaseOkgoGet()
                .showLoading(isShow)
                .setType(SUCCESS_FOR_DOUYU)
                .setUrl(douyu(entity.page))
                .setView(view)
                .setListener(this)
                .request(context)
    }


    override fun onSuccess(context: Context, type: Any, results: String) {
        when (type) {
            SUCCESS_FOR_DOUYU -> {
                val entity = Gson().fromJson<DouyuEntity>(results, DouyuEntity::class.java)
                view.getSuccess(type, entity)
            }
        }
    }
}