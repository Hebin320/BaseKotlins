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