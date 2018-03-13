package com.zerom.management.mInterface.base

/**
 * Author Hebin
 * <p>
 * created at 2017/6/28
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */
interface BaseView {

    // 显示加载对话框
    fun showLoading()
    // 隐藏加载对话框
    fun hideLoading()
    // 显示空数据布局
    fun showNullLayout()
    // 隐藏空数据布局
    fun hideNullLayout()
    // 显示请求失败布局
    fun showErroLayout()
    // 隐藏请求失败布局
    fun hideErroLayout()
    // 请求失败后，将得到的结果通过接口，从P层传到V层
    fun getFailed(type: Any, T: Any)
}