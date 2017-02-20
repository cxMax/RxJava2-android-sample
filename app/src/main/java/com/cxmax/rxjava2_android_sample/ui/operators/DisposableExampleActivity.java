package com.cxmax.rxjava2_android_sample.ui.operators;

import android.os.SystemClock;
import android.util.Log;

import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import static android.R.attr.value;

/**
 * Created by cxmax on 2017/2/20.
 */

public class DisposableExampleActivity extends BaseOperatorActivity {

    private static final String TAG = DisposableExampleActivity.class.getSimpleName();
    private final CompositeDisposable disposables = new CompositeDisposable();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposables.clear();
    }

    /**
     * 使用CompositeSubscription来收集Subscription，来统一取消订阅
     */
    @Override
    protected void operatorTest() {
        disposables.add(sampleObservable()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableObserver<String>(){
            @Override
            public void onComplete() {
                textView.append(" onComplete");
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onComplete");
            }

            @Override
            public void onError(Throwable e) {
                textView.append(" onError : " + e.getMessage());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onError : " + e.getMessage());
            }

            @Override
            public void onNext(String value) {
                textView.append(" onNext : value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext value : " + value);
            }
        }));
    }

    private Observable<String> sampleObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                // Do some long running operation
                SystemClock.sleep(2000);
                return Observable.just("one", "two", "three", "four", "five");
            }
        });
    }
}
