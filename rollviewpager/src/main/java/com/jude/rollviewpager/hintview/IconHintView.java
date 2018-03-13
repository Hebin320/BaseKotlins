package com.jude.rollviewpager.hintview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import com.jude.rollviewpager.Util;

public class IconHintView extends ShapeHintView {
    private int focusResId;
    private int normalResId;
    private int size;
    private int circleMargin;



    public IconHintView(Context context, int focusResId, int normalResId, int size, int circleMargin) {
        super(context);
        this.focusResId = focusResId;
        this.normalResId = normalResId;
        this.size = size;
        this.circleMargin = Util.dip2px(getContext(), circleMargin);
    }

    @Override
    public Drawable makeFocusDrawable() {
        Drawable drawable = getContext().getResources().getDrawable(focusResId);
        if (size > 0) {
            drawable = zoomDrawable(drawable, size, size);
        }
        return drawable;
    }

    @Override
    public Drawable makeNormalDrawable() {
        Drawable drawable = getContext().getResources().getDrawable(normalResId);
        if (size > 0) {
            drawable = zoomDrawable(drawable, size, size);
        }
        return drawable;
    }

    @Override
    public int setMargin() {
        return circleMargin;
    }

    private Drawable zoomDrawable(Drawable drawable, int w, int h) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap oldbmp = drawableToBitmap(drawable);
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) w / width);
        float scaleHeight = ((float) h / height);
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height,
                matrix, true);
        return new BitmapDrawable(null, newbmp);
    }

    private Bitmap drawableToBitmap(Drawable drawable) {
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
                : Bitmap.Config.RGB_565;
        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }
}
