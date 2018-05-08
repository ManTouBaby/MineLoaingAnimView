package com.hrw.loainganimviewlibrary.ball;

import android.animation.TypeEvaluator;

/**
 * @author:ccf008
 * @date:2017/11/09 10:56
 * @desc:
 */

public class BallEvaluator implements TypeEvaluator<BallPointF> {
    @Override
    public BallPointF evaluate(float fraction, BallPointF startValue, BallPointF endValue) {
        BallPointF pointF = new BallPointF();
        if (endValue.x > startValue.x) {
            if (fraction < (1f / 6f) || fraction >= (5f / 6f))
                pointF.color = BallColor.RED;

            if (fraction >= (1f / 6f) && fraction < (3f / 6f))
                pointF.color = BallColor.YELLOW;

            if (fraction >= (3f / 6f) && fraction < (5f / 6f))
                pointF.color = BallColor.BLUE;
            double period = (Math.sin(6 * Math.PI * fraction + Math.PI * 3 / 2));
            pointF.x = (float) (((endValue.x - startValue.x) / 4) * period + (endValue.x + 3 * startValue.x) / 4);

        } else if (endValue.x < startValue.x) {

            if (fraction < (1f / 6f) || fraction >= (5f / 6f))
                pointF.color = BallColor.BLUE;

            if (fraction >= (1f / 6f) && fraction < (3f / 6f))
                pointF.color = BallColor.RED;

            if (fraction >= (3f / 6f) && fraction < (5f / 6f))
                pointF.color = BallColor.YELLOW;
            double period = (Math.sin(6 * Math.PI * fraction + Math.PI / 2));
            pointF.x = (float) (((startValue.x - endValue.x) / 4) * period + (endValue.x + 3 * startValue.x) / 4);

        } else if (endValue.x == startValue.x) {
            if (fraction < (1f / 6f) || fraction >= (5f / 6f)) {
                pointF.color = BallColor.YELLOW;
            }
            if (fraction >= (1f / 6f) && fraction < (3f / 6f)) {
                pointF.color = BallColor.BLUE;
            }
            if (fraction >= (3f / 6f) && fraction < (5f / 6f)) {
                pointF.color = BallColor.RED;
            }
            pointF.x = endValue.x;
        }
        pointF.y = startValue.y;
        return pointF;
    }
}
