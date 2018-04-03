package com.hebin.entity


/**
 * Author Hebin
 * <p>
 * created at 2017/6/14
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：实体类
 */


/**
 *  传参用的实体类
 * */
data class DataEntity(var name: String, var age: Int, var tel: String, var pwd: String) {
    constructor() : this("", 0, "", "")
}

data class TestEntity(var list: MutableList<ListEntity>) {
    data class ListEntity(var title: String) {
        constructor() : this("")
    }
}

class MultipleItem(private val itemType: Int) {

    fun getItemType(): Int {
        return itemType
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
    }
}
