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
interface UniversalView : BaseView {

    // view层设置数据，Presenter层通过接口得到数据，用于网络请求等参数的动态改变
    fun getData(): Any
    // 请求成功后，将得到的结果通过接口，从P层传到V层
    fun getSuccess(type: Any, T: Any)

}