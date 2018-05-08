package com.hrw.loainganimviewlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * @author:MtBaby
 * @date:2017/11/14 20:48
 * @desc:
 */

public class AnimImageView extends LinearLayout {
    BaseAnimator animatorView;

    public AnimImageView(Context context) {
        this(context, null);
    }

    public AnimImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.AnimImageView);
        int animType = typedArray.getInt(R.styleable.AnimImageView_anim_type, 0);
        animatorView = AnimType.values()[animType].newInstance();
        addView(animatorView);
    }

    public void startAnimator() {
        animatorView.startAnimator();
    }

    public void stopAnimator() {
        animatorView.stopAnimator();
    }
}
