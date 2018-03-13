package com.taorouw.utils

/**
 * Author Hebin
 * <p>
 * created at 2018/3/13 14:22
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：泛型单例模式
 */
abstract class SingletonUtil<T> {

    private var instance: T? = null

    protected abstract fun newInstance(): T

    fun getInstance(): T? {
        if (instance == null) {
            synchronized(SingletonUtil::class) {
                if (instance == null) {
                    instance = newInstance()
                }
            }
        }
        return instance
    }
}
