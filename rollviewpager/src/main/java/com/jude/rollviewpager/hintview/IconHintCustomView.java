package com.jude.rollviewpager.hintview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.jude.rollviewpager.Util;

public class IconHintCustomView extends ShapeHintView {
    private int focusResId;
    private int normalResId;
    private int circleMargin;


    public IconHintCustomView(Context context, int focusResId, int normalResId, int circleMargin) {
        super(context);
        this.focusResId = focusResId;
        this.normalResId = normalResId;
        this.circleMargin = Util.dip2px(getContext(), circleMargin);
    }

    @Override
    public Drawable makeFocusDrawable() {
        return getContext().getResources().getDrawable(focusResId);
    }

    @Override
    public Drawable makeNormalDrawable() {
        return getContext().getResources().getDrawable(normalResId);
    }

    @Override
    public int setMargin() {
        return circleMargin;
    }


}
