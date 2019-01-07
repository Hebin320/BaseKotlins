package com.zerom.easyquery.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import com.huburt.library.ImagePicker
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.cookie.store.MemoryCookieStore
import com.lzy.okgo.model.HttpParams
import com.zerom.easyquery.util.image.GlideImageLoader


@SuppressLint("Registered")
@Suppress("DEPRECATION")
/**
 * Author Hebin
 * <p>
 * created at 2017/6/8
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * 说明：
 */


open class MyApplication : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        var mContext: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this.applicationContext
        setOkgo()
        setImagePicker()

    }


    // 配置选图片插件
    private fun setImagePicker() {
        ImagePicker.init(GlideImageLoader())
        ImagePicker
                .limit(9)//选择图片数量限制，默认9张
                .isCrop(true)//拍照后是否裁剪，默认false
                .showCamera(true)//列表是否显示拍照，默认true
                .multiMode(true)//false单选/true多选，默认true
                .saveAsDefault()//保存为自定义
    }

    // 配置网络请求插件
    private fun setOkgo() {
        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        val params = HttpParams()
        //-----------------------------------------------------------------------------------//

        //必须调用初始化
        OkGo.init(this)

        //以下设置的所有参数是全局参数,同样的参数可以在请求的时候再设置一遍,那么对于该请求来讲,请求中的参数会覆盖全局参数
        //好处是全局参数统一,特定请求可以特别定制参数
        try {
            //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
            OkGo.getInstance()
                    //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                    .debug("OkGo")
                    //如果使用默认的 60秒,以下三行也不需要传
                    .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS.toLong())  //全局的连接超时时间
                    .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS.toLong())     //全局的读取超时时间
                    .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS.toLong())    //全局的写入超时时间
                    .setRetryCount(3)
                    //可以全局统一设置缓存模式,默认是不使用缓存,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy/
                    .setCacheMode(CacheMode.FIRST_CACHE_THEN_REQUEST)
                    //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                    .setCacheTime((1000 * 60 * 60 * 24 * 7).toLong())
                    //如果不想让框架管理cookie,以下不需要
                    .setCookieStore(MemoryCookieStore())                //cookie使用内存缓存（app退出后，cookie消失）
                    //.setCookieStore(PersistentCookieStore())          //cookie持久化存储，如果cookie不过期，则一直有效
                    //            可以设置https的证书, 以下几种方案根据需要自己设置, 不需要不用设置
                    .setCertificates()                                  //方法一：信任所有证书
                    .addCommonParams(params)                                          //设置全局公共参数
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun getResources(): Resources {
        val res = super.getResources()
        val config = Configuration()
        config.setToDefaults()
        res.updateConfiguration(config, res.displayMetrics)
        return res
    }

}