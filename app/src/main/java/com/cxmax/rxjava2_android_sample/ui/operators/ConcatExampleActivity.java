package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by cxmax on 2017/2/20.
 */

public class ConcatExampleActivity extends BaseOperatorActivity{
    private static final String TAG = ConcatExampleActivity.class.getSimpleName();

    /**
     * Concat操作符持有多个Observable对象，并将它们按顺序串联成队列
     */
    @Override
    protected void operatorTest() {
        String[] aStrings = {"A1", "A2", "A3", "A4"};
        String[] bStrings = {"B1", "B2", "B3"};

        Observable aObservable = Observable.fromArray(aStrings);
        Observable bObservable = Observable.fromArray(bStrings);

        Observable.concat(aObservable , bObservable)
                .subscribe(getObserver());
    }

    private Observer<String> getObserver() {
        return new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {
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
