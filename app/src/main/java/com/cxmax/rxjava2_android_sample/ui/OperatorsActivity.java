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
import com.cxmax.rxjava2_android_sample.ui.operators.DeferExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.DisposableExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.DistinctExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.FilterExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.FlowableExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.IntervalExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.LastOperatorExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.MapExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.MergeExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.PublishSubjectExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ReduceExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ReplayExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ReplaySubjectExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ScanExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.SimpleExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.SingleObserverExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.SkipExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.TakeExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ThrottleFirstExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ThrottleLastExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.TimerExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.WindowExampleActivity;
import com.cxmax.rxjava2_android_sample.ui.operators.ZipExampleActivity;

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

    public void startDeferActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, DeferExampleActivity.class));
    }

    public void startDisposableActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, DisposableExampleActivity.class));
    }

    public void startDistinctActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, DistinctExampleActivity.class));
    }

    public void startFilterActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, FilterExampleActivity.class));
    }

    public void startFlowableActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, FlowableExampleActivity.class));
    }

    public void startIntervalActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, IntervalExampleActivity.class));
    }

    public void startLastOperatorActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, LastOperatorExampleActivity.class));
    }

    public void startMapActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, MapExampleActivity.class));
    }

    public void startMergeActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, MergeExampleActivity.class));
    }

    public void startPublishSubjectActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, PublishSubjectExampleActivity.class));
    }

    public void startReduceActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ReduceExampleActivity.class));
    }

    public void startReplayActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ReplayExampleActivity.class));
    }

    public void startReplaySubjectActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ReplaySubjectExampleActivity.class));
    }

    public void startScanActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ScanExampleActivity.class));
    }

    public void startSimpleActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, SimpleExampleActivity.class));
    }

    public void startSingleObserverActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, SingleObserverExampleActivity.class));
    }

    public void startSkipActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, SkipExampleActivity.class));
    }

    public void startTakeActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, TakeExampleActivity.class));
    }

    public void startThrottleFirstActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this,ThrottleFirstExampleActivity.class));
    }

    public void startThrottleLastActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ThrottleLastExampleActivity.class));
    }

    public void startTimerActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, TimerExampleActivity.class));
    }

    public void startWindowActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this,WindowExampleActivity.class));
    }

    public void startZipActivity(View view) {
        startActivity(new Intent(OperatorsActivity.this, ZipExampleActivity.class));
    }
}
