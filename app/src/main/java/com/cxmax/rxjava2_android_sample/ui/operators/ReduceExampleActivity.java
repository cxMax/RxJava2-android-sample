package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;

/**
 * Created by cxmax on 2017/2/21.
 */

public class ReduceExampleActivity extends BaseOperatorActivity {
    private static final String TAG = ReduceExampleActivity.class.getSimpleName();

    /**
     * Reduce按顺序对Observable发射的每项数据应用一个函数并发射最终的值
     */
    @Override
    protected void operatorTest() {
        getObservable()
                .reduce(new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer t1, Integer t2) {
                        return t1 + t2;
                    }
                })
                .subscribe(getObserver());
    }

    private Observable<Integer> getObservable() {
        return Observable.just(1, 2, 3, 4);
    }

    private MaybeObserver<Integer> getObserver() {
        return new MaybeObserver<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onSuccess(Integer value) {
                textView.append(" onSuccess : value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onSuccess : value : " + value);
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
