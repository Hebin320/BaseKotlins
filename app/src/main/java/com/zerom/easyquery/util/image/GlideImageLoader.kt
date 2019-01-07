package com.zerom.easyquery.util.image

import android.app.Activity
import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.huburt.library.loader.ImageLoader
import com.zerom.easyquery.R
import java.io.File

/**
 * Author Hebin
 * <p>
 * created at 2018/11/30
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class GlideImageLoader : ImageLoader {

    override fun displayImage(activity: Activity, path: String, imageView: ImageView, width: Int, height: Int) {
        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .error(R.drawable.ic_default_image)           //设置错误图片
                .placeholder(R.drawable.ic_default_image)     //设置占位图片
                .into(imageView)
    }

    override fun displayImagePreview(activity: Activity, path: String, imageView: ImageView, width: Int, height: Int) {
        Glide.with(activity)                             //配置上下文
                .load(Uri.fromFile(File(path)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                .into(imageView)
    }

    override fun clearMemoryCache() {

    }
}
