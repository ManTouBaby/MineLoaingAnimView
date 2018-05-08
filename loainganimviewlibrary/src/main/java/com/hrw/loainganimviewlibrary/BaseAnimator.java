package com.hrw.loainganimviewlibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author:ccf008
 * @date:2017/11/09 10:33
 * @desc:
 */

public abstract class BaseAnimator extends View {
    protected Context context;

    public BaseAnimator(Context context) {
        this(context, null);
    }

    public BaseAnimator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initParams();
    }

    protected abstract void initParams();

    public abstract void startAnimator();

    public abstract void stopAnimator();

}
