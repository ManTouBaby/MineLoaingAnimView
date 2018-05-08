package com.hrw.loainganimviewlibrary;


import com.hrw.loainganimviewlibrary.ball.BallAnimView;

/**
 * @author:MtBaby
 * @date:2017/11/14 20:49
 * @desc:
 */

public enum AnimType {
    BALL_ANIMVIEW(BallAnimView.class);

    private Class<?> instanceClass;

    AnimType(Class<?> instanceClass) {
        this.instanceClass = instanceClass;
    }

    <T extends BaseAnimator> T newInstance() {
        try {
            return (T) instanceClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
