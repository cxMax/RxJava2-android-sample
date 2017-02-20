package com.cxmax.rxjava2_android_sample.ui.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cxmax.rxjava2_android_sample.R;

/**
 * Created by cxmax on 2017/2/15.
 */

public abstract class BaseOperatorActivity extends AppCompatActivity {

    protected Button btn;
    protected TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        btn = (Button) findViewById(R.id.btn);
        textView = (TextView) findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operatorTest();
            }
        });
    }

    protected abstract void operatorTest();

}
