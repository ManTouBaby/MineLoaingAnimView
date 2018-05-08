package com.hrw.loainganimviewlibrary.ball;

/**
 * @author:ccf008
 * @date:2017/11/10 15:37
 * @desc:
 */

public class BallPointF {
    public float x;
    public float y;
    public int color;

    public BallPointF() {
    }

    public BallPointF(float x, float y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public String toString() {
        return "BallPointF{" +
                "x=" + x +
                ", y=" + y +
                ", color=" + color +
                '}';
    }
}
