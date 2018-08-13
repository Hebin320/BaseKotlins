package com.hebin.project.ui.adapter

import android.content.Context
import com.hebin.project.R
import com.hebin.recyclerview.adapter.BaseViewHolder
import com.hebin.recyclerview.adapter.HxbBaseAdapter

/**
 * Author Hebin
 * <p>
 * created at 2018/8/13
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class HxbAdapter(val context: Context, val list: ArrayList<String>) : HxbBaseAdapter<String>(context, list) {

    override fun convert(holder: BaseViewHolder, item: String, position: Int) {
        holder.setOnClickListener(R.id.activity_chooser_view_content,OnItemChildClickListener())
    }

    override fun getItemViewLayoutId(position: Int, item: String?): Int {
        return R.layout.activity_main
    }
}