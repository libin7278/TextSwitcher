package com.mvp.libin.textswitch;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;

import com.mvp.libin.textswitch.view.AutoVerticalScrollTextView;

/**
 * 实现广告竖直滚动切换
 */
public class Switch2Activity extends Activity {
    private LinearLayout ll_first_sound_toast;
    private LinearLayout ll_second_sound_toast;
    private AutoVerticalScrollTextView toast_content;

    private int number =0;
    private boolean isRunning=true;

    private String[] contents = {"“撒大声地”\n“撒打算”\n“按时打算”\n“啊实打实的”","按时打算”\n“是倒萨大”\n“发送到发送到”\n“撒打算”"};

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 199) {

                number++;

                toast_content.setText(contents[number%contents.length]);

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch2);

        findView();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //PresentActivity.getInstance().getCurrentActivity().finish();
                ll_first_sound_toast.setVisibility(View.INVISIBLE);
                showAutoVerticalText();
                ll_second_sound_toast.setVisibility(View.VISIBLE);
            }
        },3000);
    }

    private void showAutoVerticalText() {
        toast_content.setText(contents[0]);

        new Thread(){
            @Override
            public void run() {
                while (isRunning){
                    SystemClock.sleep(4000);
                    handler.sendEmptyMessage(199);
                }
            }
        }.start();
    }

    private void findView() {
        toast_content = (AutoVerticalScrollTextView) findViewById(R.id.toast_content);
        ll_first_sound_toast = (LinearLayout) findViewById(R.id.ll_first_sound_toast);
        ll_second_sound_toast = (LinearLayout) findViewById(R.id.ll_second_sound_toast);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isRunning = false;
    }

    public AnimationSet showTextAnimation(){
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,200);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(1000);

        return animationSet;
    }

    public AnimationSet dismessTextAnimation(){
        AnimationSet animationSet = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1,0);
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,0,Animation.RELATIVE_TO_SELF,200,Animation.RELATIVE_TO_SELF,0);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(translateAnimation);
        animationSet.setDuration(1000);

        return animationSet;
    }
}
