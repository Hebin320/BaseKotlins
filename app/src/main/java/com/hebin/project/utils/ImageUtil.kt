package com.hebin.utils


import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ExifInterface
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.hebin.project.R
import com.hebin.project.tools.glide.GlideCircleTransform
import com.hebin.project.tools.glide.GlideRoundTransform
import me.nereo.multi_image_selector.MultiImageSelector
import java.io.IOException


@Suppress("DEPRECATION")
/**
 * Glide工具加载图片的快捷入口
 */

class ImageUtil  {


    companion object {

        /**
         * 将本地图片转为Bitmap并且进行压缩图片
         */
        fun getBitmap(file: String, inSampleSize: Int): Bitmap {
            System.gc()
            val options = BitmapFactory.Options()
            options.inPurgeable = true
            options.inSampleSize = inSampleSize
            return BitmapFactory.decodeFile(file, options)
        }


        fun selectImage(activity: Activity, size: Int, REQUEST_CODE: Int) {
            MultiImageSelector.create()
                    .showCamera(true) // 是否显示相机. 默认为显示
                    .count(size) // 最大选择图片数量, 默认为9. 只有在选择模式为多选时有效
                    .start(activity, REQUEST_CODE)
        }

        /**
         * 将图片加载到ImageView中，显示为圆角图片
         * @param url       图片地址
         * *
         * @param roundSize 圆角大小
         * *
         * @param imageView 需要显示图片的控件
         */
        fun glideRoundImage(context: Context, url: Any, roundSize: Int, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .transform(GlideRoundTransform(context, roundSize))
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

        /**
         * 将图片加载到ImageView中，显示为圆形图片
         * *
         * @param url       图片的地址
         * *
         * @param imageView 需要显示图片的控件
         */
        fun glideCircleImage(context: Context, url: Any, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .transform(GlideCircleTransform(context))
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

        /**
         * 将图片加载到ImageView中，显示为普通的图片
         * *
         * @param url       图片的地址
         * *
         * @param imageView 需要显示图片的控件
         */
        fun glideNormalImage(context: Context, url: Any, imageView: ImageView) {
            if (Util.isOnMainThread()) {
                Glide.with(context)
                        .load(url)
                        .asBitmap()
                        .dontAnimate()
                        .error(R.drawable.ic_img_default)
                        .placeholder(R.drawable.ic_img_default)
                        .into(imageView)
            }
        }

    }

}
