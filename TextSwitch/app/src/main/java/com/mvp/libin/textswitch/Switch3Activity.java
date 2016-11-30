package com.mvp.libin.textswitch;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * 图片切换
 */
public class Switch3Activity extends Activity implements ViewSwitcher.ViewFactory {
    private ImageSwitcher ImageSwitcher;

    private int number =0;
    private boolean isRuning = true;

    private int[] images = {R.drawable.stone_b1,R.drawable.stone_w2};

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 200) {

                number++;
                ImageSwitcher.setImageResource(images[number%images.length]);

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch3);

        ImageSwitcher = (android.widget.ImageSwitcher) findViewById(R.id.ImageSwitcher);

        ImageSwitcher.setFactory(this);

        ImageSwitcher.setImageResource(R.drawable.stone_b1);
        new Thread(){
            @Override
            public void run() {
                while (isRuning){
                    SystemClock.sleep(3000);
                    handler.sendEmptyMessage(200);
                }
            }
        }.start();
    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        return imageView;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isRuning = false;
    }
}
