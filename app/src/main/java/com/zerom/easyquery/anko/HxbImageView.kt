@file:Suppress("NOTHING_TO_INLINE")

package com.zerom.easyquery.anko

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.zerom.easyquery.R
import com.zerom.easyquery.util.image.GlideCircleTransform
import com.zerom.easyquery.util.image.GlideRoundTransform


/**
 *  加载圆形图片
 * */
inline fun Context.glideCircleImage(url: Any, imageView: ImageView) = HxbImageView.glideCircleImage(this, url, imageView)

/**
 *  加载正常图片
 * */
inline fun Context.glideNormalImage(url: Any, imageView: ImageView) = HxbImageView.glideNormalImage(this, url, imageView)

/**
 *  加载圆角图片
 * */
inline fun Context.glideRoundImage(url: Any, roundSize: Int, imageView: ImageView) = HxbImageView.glideRoundImage(this, url, roundSize, imageView)



class HxbImageView {

    companion object {
        /**
         *  加载圆角图片
         * */
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
         *  加载圆形图片
         * */
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
         *  加载正常的图片
         * */
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


    private var mContext: Context? = null
    private var imgUrl: Any? = null
    private var roundSize = 1
    private var imageView: ImageView? = null
    private var errorImage = R.drawable.ic_img_default
    private var placeHolder = R.drawable.ic_img_default

    fun setContext(context: Context): HxbImageView {
        this.mContext = context
        return this
    }

    fun setImgUrl(imgUrl: Any): HxbImageView {
        this.imgUrl = imgUrl
        return this
    }

    fun setRoundSize(roundSize: Int): HxbImageView {
        this.roundSize = roundSize
        return this
    }

    fun setImageView(imageView: ImageView): HxbImageView {
        this.imageView = imageView
        return this
    }

    fun setErrorImage(errorImage: Int): HxbImageView {
        this.errorImage = errorImage
        return this
    }

    fun setPlaceHolder(placeHolder: Int): HxbImageView {
        this.placeHolder = placeHolder
        return this
    }

    /**
     *  加载圆角图片
     * */
    fun glideRoundImage(): HxbImageView {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .transform(GlideRoundTransform(mContext, roundSize))
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }

    /**
     *  加载圆形图片
     * */
    fun glideCircleImage(): HxbImageView {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .transform(GlideCircleTransform(mContext))
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }

    /**
     *  加载圆形图片
     * */
    fun glideNormalImage(): HxbImageView {
        if (Util.isOnMainThread()) {
            Glide.with(mContext)
                    .load(imgUrl)
                    .asBitmap()
                    .dontAnimate()
                    .error(errorImage)
                    .placeholder(placeHolder)
                    .into(imageView)
        }
        return this
    }
}