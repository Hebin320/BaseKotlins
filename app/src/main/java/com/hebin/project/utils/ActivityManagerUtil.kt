package com.hebin.utils

import android.app.Activity
import java.util.*

/**
 * Author Hebin
 * <p>
 * created at 2018/4/16 15:02
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：Activity管理器
 */
open class ActivityManagerUtil {

    companion object {

        private var activityList: MutableList<Activity>? = ArrayList()

        /**
         * 添加 Activity 到列表

         * @param activity activity
         */
        fun addActivity(activity: Activity) {
            if (activityList == null) {
                activityList = ArrayList()
            }
            activityList!!.add(activity)
        }

        /**
         * 获取界面数量

         * @return activity size
         */
        val activitySize: Int
            get() {
                if (activityList != null) {
                    return activityList!!.size
                }
                return 0
            }

        /**
         * 获取当前 Activity - 堆栈中最后一个压入的

         * @return current Activity
         */
        val currentActivity: Activity?
            get() {
                if (activityList != null && activityList!!.size > 0) {
                    val activity = activityList!![activityList!!.size - 1]
                    return activity
                }
                return null
            }

        /**
         * 获取指定类名的 Activity

         * @param cls 指定的类
         * *
         * @return Activity
         */
        fun getActivity(cls: Class<*>): Activity? {
            if (activityList == null) {
                return null
            }
            for (activity in activityList!!) {
                if (activity.javaClass == cls) {
                    return activity
                }
            }
            return null
        }

        /**
         * 结束指定的 Activity

         * @param activity Activity
         */
        fun removeActivity(activity: Activity?) {
            if (activity != null) {
                activityList!!.remove(activity)
            }
        }

        /**
         * 结束指定类名的Activity
         */
        fun finishActivity(cls: Class<*>?) {
            if (cls != null) {
                getActivity(cls)!!.finish()
            }
        }

        /**
         * 结束指定类名的 Activity

         * @param cls 指定的类
         */
        fun removeActivity(cls: Class<*>) {
            if (activityList == null) {
                return
            }
            for (activity in activityList!!) {
                if (activity.javaClass == cls) {
                    activityList!!.remove(activity)
                }
            }
        }

        /**
         * 结束所有Activity
         */
        fun finishAllActivity() {
            if (activityList == null) {
                return
            }
            val size = activityList!!.size
            if (size > 0) {
                for (i in 0 until size) {
                    activityList!![i].finish()
                }
                activityList!!.clear()
            }
        }

        /**
         * 结束其他所有的Activity

         * @param activity 不需要销毁的Activity
         */
        fun finishOtherAllActivity(activity: Activity) {
            if (activityList == null) {
                return
            }
            var i = 0
            val size = activityList!!.size
            while (i < size) {
                if (activity !== activityList!![i]) {
                    activityList!![i].finish()
                    activityList!!.removeAt(i)
                }
                i++
            }
        }
    }

}
