package glide

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.util.Util
import com.hebin.universalelib.R

/**
 * Author Hebin
 * <p>
 * created at 2018/8/13
 * <p>
 * blog: http://blog.csdn.net/hebin320320
 * <p>
 * GitHub: https://github.com/Hebin320
 * <p>
 * describe：
 */
class ImageUtil {


    companion object {

        fun getBitmap(file: String, inSampleSize: Int): Bitmap {
            System.gc()
            val options = BitmapFactory.Options()
            options.inPurgeable = true
            options.inSampleSize = inSampleSize
            return BitmapFactory.decodeFile(file, options)
        }

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

}
