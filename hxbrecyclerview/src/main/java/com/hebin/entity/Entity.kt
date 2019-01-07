package com.hebin.entity

import com.hebin.adapter.entity.MultiItemEntity

/**
 * Author Hebin
 * <p>
 * created at 2018/4/12
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */

data class TestEntity(val result: ResultEntity) {
    data class ResultEntity(val title: String)
}


data class MultipleItem(private val type: Int) : MultiItemEntity {
    override fun getItemType(): Int {
        return type
    }

    companion object {
        const val ONE = 1
        const val TWO = 2
        const val THREE = 3
        const val FOUR = 4
        const val FIVE = 5
        const val SIX = 6
        const val SEVEN = 7
        const val EIGHT = 8
        const val NINE = 9
        const val TEN = 10
    }
}