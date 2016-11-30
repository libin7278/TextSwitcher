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
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

/**
 * TextSwitcher 简单使用
 * 文字切换
 */
public class Switch1Activity extends Activity implements ViewSwitcher.ViewFactory {
    private boolean isRuning = true;

    private TextSwitcher ts;

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
        setContentView(R.layout.activity_switch1);

        ts = (TextSwitcher) findViewById(R.id.ts);

        ts.setFactory(this);

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

        ActivityManager activityManager=(ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);

        String runningActivity=activityManager.getRunningTasks(1).get(0).topActivity.getClassName();
        Log.e("TAG","============"+runningActivity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        isRuning = false;
    }

    @Override
    public View makeView() {
        TextView textView = new TextView(this);
        textView.setTextSize(36);
        return textView;
    }
}

//==============================================>
/**
 *三部曲:
 * 1:布局并初始化
 * <TextSwitcher
 *android:id="@+id/ts"
 *android:layout_width="wrap_content"
 *android:layout_height="wrap_content"/>
 *
 * 2:设置工厂模式
 * ts.setFactory(this);
 * implements ViewSwitcher.ViewFactory
 * 实现makeView()方法
 *
 * @Override
 *public View makeView() {
 *TextView textView = new TextView(this);
 *textView.setTextSize(36);
 *return textView;
 *}
 *
 *3.使用
 * 每调一setText()方法会实现自动切换,比如倒计时之类的效果不错
 *
 *
 */