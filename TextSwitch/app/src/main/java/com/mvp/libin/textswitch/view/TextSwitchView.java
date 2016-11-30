package com.mvp.libin.textswitch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.mvp.libin.textswitch.R;

/**
 * Created by libin on 16/11/29.
 */

public class TextSwitchView extends TextSwitcher implements ViewSwitcher.ViewFactory {

    private Context mContext;

    public TextSwitchView(Context context) {
        this(context, null);
    }

    public TextSwitchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        init();

    }

    private void init() {
        this.setFactory(this);
        this.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.in_animation));
        this.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.out_animation));
    }

    @Override
    public View makeView() {
        TextView tv =new TextView(mContext);
        return tv;
    }
}
