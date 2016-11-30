package com.mvp.libin.textswitch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * 9patch图片
 * 随着文字长度改变,背景图片动态改变
 */

public class BackgroundActivity extends Activity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        tv = (TextView) findViewById(R.id.tv);

        tv.setText("12");

    }
}
