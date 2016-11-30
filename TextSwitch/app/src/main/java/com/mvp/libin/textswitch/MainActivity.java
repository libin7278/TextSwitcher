package com.mvp.libin.textswitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);

        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btn_1) {
            startActivity(new Intent(this, Switch1Activity.class));
        }
        if (v == btn_2) {
            startActivity(new Intent(this, Switch2Activity.class));
        }
        if (v == btn_3) {
            startActivity(new Intent(this, BackgroundActivity.class));
        }
        if (v == btn_4) {
            startActivity(new Intent(this, Switch3Activity.class));
        }
        if (v == btn_5) {
            startActivity(new Intent(this, MACActivity.class));
        }
        if (v == btn_6) {
            startActivity(new Intent(this, Switch4Activity.class));
        }
    }
}
