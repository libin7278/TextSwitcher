package com.mvp.libin.textswitch;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mvp.libin.textswitch.view.TextSwitchView;

public class Switch4Activity extends Activity {
    private TextSwitchView ts;

    private boolean isRuning = true;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            if (msg.what == 199) {

                ts.setText(Math.random()+"=======");

            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch4);

        ts = (TextSwitchView) findViewById(R.id.ts);

        ts.setText(Math.random()+"=======");
        new Thread(){
            @Override
            public void run() {
                while (isRuning){
                    SystemClock.sleep(3000);
                    handler.sendEmptyMessage(199);
                }
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isRuning = false;
    }
}
