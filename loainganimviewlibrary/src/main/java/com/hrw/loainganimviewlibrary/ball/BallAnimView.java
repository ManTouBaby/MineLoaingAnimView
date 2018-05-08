package com.hrw.loainganimviewlibrary.ball;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

import com.hrw.loainganimviewlibrary.BaseAnimator;
import com.hrw.loainganimviewlibrary.R;


/**
 * @author:ccf008
 * @date:2017/11/06 14:58
 * @desc:
 */

public class BallAnimView extends BaseAnimator {
    Paint paint;
    BallPointF currentLPoint;
    BallPointF currentRPoint;
    BallPointF currentCPoint;

    float mWidth;
    float mHeight;

    private AnimatorSet animatorSet;


    public BallAnimView(Context context) {
        this(context, null);
    }

    public BallAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BallAnimView);
        mWidth = typedArray.getDimension(R.styleable.BallAnimView_Anim_Width, 0);
        mHeight = typedArray.getDimension(R.styleable.BallAnimView_Anim_Height, 0);
    }

    @Override
    protected void initParams() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLView(canvas);
        drawCenterView(canvas);
        drawRView(canvas);
    }

    private void drawLView(Canvas canvas) {
        if (currentLPoint == null) {
            currentLPoint = new BallPointF(mWidth / 10, mWidth / 10, BallColor.RED);
        }
        drawBall(canvas, currentLPoint);
    }

    private void drawCenterView(Canvas canvas) {
        if (currentCPoint == null) {
            currentCPoint = new BallPointF(mWidth / 2, mWidth / 10, BallColor.YELLOW);
        }
        drawBall(canvas, currentCPoint);
    }

    private void drawRView(Canvas canvas) {
        if (currentRPoint == null) {
            currentRPoint = new BallPointF(mWidth * 9 / 10, mWidth / 10, BallColor.BLUE);
        }
        drawBall(canvas, currentRPoint);

    }


    private void drawBall(Canvas canvas, BallPointF pointF) {
        paint.setColor(pointF.color);
        canvas.drawCircle(pointF.x, pointF.y, mWidth / 10, paint);
    }


    @Override
    public void startAnimator() {
        BallPointF stLPointF = new BallPointF(mWidth / 10, mWidth / 10, BallColor.YELLOW);
        BallPointF endLPointF = new BallPointF(mWidth * 9 / 10, mWidth / 10, BallColor.YELLOW);
        ValueAnimator leftAnimator = ValueAnimator.ofObject(new BallEvaluator(), stLPointF, endLPointF);
        leftAnimator.setRepeatCount(-1);
        leftAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentLPoint = (BallPointF) animation.getAnimatedValue();
                invalidate();
            }

        });


        BallPointF stRPointF = new BallPointF(mWidth * 9 / 10, mWidth / 10, BallColor.BLUE);
        BallPointF endRPointF = new BallPointF(mWidth / 10, mWidth / 10, BallColor.BLUE);
        ValueAnimator rightAnimator = ValueAnimator.ofObject(new BallEvaluator(), stRPointF, endRPointF);
        rightAnimator.setRepeatCount(-1);
        rightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentRPoint = (BallPointF) animation.getAnimatedValue();
                invalidate();

            }
        });

        BallPointF stCPointF = new BallPointF(mWidth / 2, mWidth / 10, BallColor.RED);
        BallPointF endCPointF = new BallPointF(mWidth / 2, mWidth / 10, BallColor.RED);
        ValueAnimator cAnimator = ValueAnimator.ofObject(new BallEvaluator(), stCPointF, endCPointF);
        cAnimator.setRepeatCount(-1);
        cAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentCPoint = (BallPointF) animation.getAnimatedValue();
                invalidate();
            }
        });

        animatorSet = new AnimatorSet();
        animatorSet.play(leftAnimator).with(rightAnimator).with(cAnimator);
        animatorSet.setInterpolator(new LinearInterpolator());
        animatorSet.setDuration(3000).start();
    }

    @Override
    public void stopAnimator() {
        if (animatorSet != null)
            animatorSet.end();
    }

}
