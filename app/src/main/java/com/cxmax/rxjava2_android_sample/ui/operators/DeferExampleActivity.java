package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.bean.Car;
import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by cxmax on 2017/2/20.
 */

public class DeferExampleActivity extends BaseOperatorActivity{

    private static final String TAG = DeferExampleActivity.class.getSimpleName();

    /**
     * Defer直到有观察者订阅时才创建Observable，并且为每个观察者创建一个新的Observable
     */
    @Override
    protected void operatorTest() {
        Car car = new Car();
        Observable<String> brandDeferObservable = car.brandDeferObservable();
        car.setBrand("BMW");
        brandDeferObservable
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
