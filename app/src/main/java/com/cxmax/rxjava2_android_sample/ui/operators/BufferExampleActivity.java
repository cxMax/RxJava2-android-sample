package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;
import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by cxmax on 2017/2/15.
 */

public class BufferExampleActivity extends BaseOperatorActivity {

    private static final String TAG = BufferExampleActivity.class.getSimpleName();

    /*
     * simple example using buffer operator - bundles all emitted values into a list
     */
    @Override
    protected void operatorTest() {
        Observable<List<String>> buffered = getObservable().buffer(3, 1);

        // 3 means,  it takes max of three from its start index and create list
        // 1 means, it jumps one step every time
        // so the it gives the following list
        // 1 - one, two, three
        // 2 - two, three, four
        // 3 - three, four, five
        // 4 - four, five
        // 5 - five

        buffered.subscribe(getObserver());
    }

    private Observable<String> getObservable() {
        return Observable.just("one", "two", "three", "four", "five");
    }

    private Observer<List<String>> getObserver() {
        return new Observer<List<String>>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<String> stringList) {
                textView.append(" onNext size : " + stringList.size());
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext : size :" + stringList.size());
                for (String value : stringList) {
                    textView.append(" value : " + value);
                    textView.append(AppConstant.LINE_SEPARATOR);
                    Log.d(TAG, " : value :" + value);
                }

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
