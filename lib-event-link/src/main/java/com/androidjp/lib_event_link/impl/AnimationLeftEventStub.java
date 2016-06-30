package com.androidjp.lib_event_link.impl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.support.annotation.NonNull;
import android.view.View;

import com.androidjp.lib_event_link.EventStub;
import com.androidjp.lib_event_link.IEvent;

/**
 * 左移动画事件 传递实现类
 *
 * Created by androidjp on 16-6-30.
 */
public class AnimationLeftEventStub extends EventStub<View>{


    private boolean result = true;

    /**
     * @param mEventStub 下一级的事件接收者
     * @param viewStub   下一级被处理的对象
     */
    public AnimationLeftEventStub(IEvent mEventStub, View viewStub) {
        super(mEventStub, viewStub);
    }

    @Override
    protected boolean onEventImpl(@NonNull View obj) {
        if (result){
            ObjectAnimator anim = ObjectAnimator.ofFloat(obj,"x", -400);
            anim.setDuration(2000);
            anim.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {

                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    result = false;
                }

                @Override
                public void onAnimationCancel(Animator animator) {

                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }
            });
            anim.start();
        }
        return result;
    }
}
