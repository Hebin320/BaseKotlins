package com.hebin.base

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.support.multidex.MultiDex
import com.lzy.okgo.OkGo
import com.lzy.okgo.cache.CacheMode
import com.lzy.okgo.cookie.store.PersistentCookieStore
import com.lzy.okgo.model.HttpHeaders
import com.lzy.okgo.model.HttpParams


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
        // 屏幕适配
        resources
        // 设置网络请求的基本属性
        setOkGo()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    private fun setOkGo() {
        //---------这里给出的是示例代码,告诉你可以这么传,实际使用的时候,根据需要传,不需要就不传-------------//
        val headers = HttpHeaders()
        headers.put("commonHeaderKey1", "commonHeaderValue1")    //header不支持中文
        headers.put("commonHeaderKey2", "commonHeaderValue2")
        val params = HttpParams()
        params.put("commonParamsKey1", "commonParamsValue1")     //param支持中文,直接传,不要自己编码
        params.put("commonParamsKey2", "这里支持中文参数")
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
                    //                .setCookieStore(new MemoryCookieStore())                //cookie使用内存缓存（app退出后，cookie消失）
                    .setCookieStore(PersistentCookieStore())          //cookie持久化存储，如果cookie不过期，则一直有效
//            可以设置https的证书, 以下几种方案根据需要自己设置, 不需要不用设置
//                  .setCertificates()                                  //方法一：信任所有证书
//                  .setCertificates(getAssets().open("srca.cer"))      //方法二：也可以自己设置https证书
//                  .setCertificates(getAssets().open("aaaa.bks"), "123456", getAssets().open("srca.cer"))//方法三：传入bks证书,密码,和cer证书,支持双向加密
//            可以添加全局拦截器, 不会用的千万不要传, 错误写法直接导致任何回调不执行
//                  .addInterceptor(new Interceptor () {
//                    @Override
//                   public Response intercept(Chain chain) throws IOException {
//                    return chain.proceed(chain.request());
//                }
//            })
//            这两行同上, 不需要就不要传
//            .addCommonHeaders(headers)                                         //设置全局公共头
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