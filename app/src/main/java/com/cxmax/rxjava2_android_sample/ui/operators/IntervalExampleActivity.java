package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cxmax on 2017/2/21.
 */

public class IntervalExampleActivity extends BaseOperatorActivity{
    private static final String TAG = IntervalExampleActivity.class.getSimpleName();
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear(); // clearing it : do not emit after destroy
    }

    /**
     * interval创建一个按固定时间间隔发射整数序列的Observable
     */
    @Override
    protected void operatorTest() {
        disposables.add(getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));
    }

    private Observable<? extends Long> getObservable() {
        return Observable.interval(0, 2, TimeUnit.SECONDS);
    }

    private DisposableObserver<Long> getObserver() {
        return new DisposableObserver<Long>() {

            @Override
            public void onNext(Long value) {
                textView.append(" onNext : value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext : value : " + value);
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }
        };
    }
}
