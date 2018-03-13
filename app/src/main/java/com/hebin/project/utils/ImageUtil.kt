package com.hebin.utils


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

        /**
         * 读取图片属性：旋转的角度
         * @param path 图片绝对路径
         * *
         * @return degree旋转的角度
         */
        fun readPictureDegree(path: String): Int {
            var degree = 0
            try {
                val exifInterface = ExifInterface(path)
                val orientation = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL)
                when (orientation) {
                    ExifInterface.ORIENTATION_ROTATE_90 -> degree = 90
                    ExifInterface.ORIENTATION_ROTATE_180 -> degree = 180
                    ExifInterface.ORIENTATION_ROTATE_270 -> degree = 270
                }
            } catch (e: IOException) {
                e.printStackTrace()
                return degree
            }

            return degree
        }

        /**
         * 旋转图片，使图片保持正确的方向。
         * @param bitmap 原始图片
         * *
         * @param degrees 原始图片的角度
         * *
         * @return Bitmap 旋转后的图片
         */
        fun rotateBitmap(bitmap: Bitmap?, degrees: Int): Bitmap {
            if (degrees == 0 || null == bitmap) {
                return bitmap!!
            }
            val matrix = Matrix()
            matrix.setRotate(degrees.toFloat(), (bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat())
            val bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.width, bitmap.height, matrix, true)
            bitmap.recycle()
            return bmp
        }
    }

}
