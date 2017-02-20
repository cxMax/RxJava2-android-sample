package com.cxmax.rxjava2_android_sample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.cxmax.rxjava2_android_sample.R;
import com.cxmax.rxjava2_android_sample.ui.operators.AsyncSubjectExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.BehaviorSubjectExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.BufferExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.CompletableObserverExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ConcatExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.DebounceExampleActivity;

/**
 * Created by cxmax on 2017/2/20.
 */

public class OperatorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
    }

    public void startConcatActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ConcatExampleActivity.class));
    }

    public void startCompletableObserverActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, CompletableObserverExampleActivity.class));
    }

    public void startBufferActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, BufferExampleActivity.class));
    }

    public void startBehaviorSubjectActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, BehaviorSubjectExampleActivity.class));
    }

    public void startAsyncSubjectActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, AsyncSubjectExampleActivity.class));
    }

    public void startDebounceActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, DebounceExampleActivity.class));
    }
}
