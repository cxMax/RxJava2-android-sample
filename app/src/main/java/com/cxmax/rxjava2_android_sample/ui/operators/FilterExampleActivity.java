package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.AppendOnlyLinkedArrayList;

/**
 * Created by cxmax on 2017/2/21.
 */

public class FilterExampleActivity extends BaseOperatorActivity {

    private static final String TAG = FilterExampleActivity.class.getSimpleName();

    /**
     * Filter操作符使用你指定的一个谓词函数测试数据项，只有通过测试的数据才会被发射。
     */
    @Override
    protected void operatorTest() {
        Observable.just(1,2,3,4,5,6)
                .filter(new AppendOnlyLinkedArrayList.NonThrowingPredicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer % 2 == 0;
                    }
                }).subscribe(getObserver());
    }

    private Observer<Integer> getObserver() {
        return new Observer<Integer>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(Integer value) {
                textView.append(" onNext : ");
                textView.append(AppConstant.LINE_SEPARATOR);
                textView.append(" value : " + value);
                textView.append(AppConstant.LINE_SEPARATOR);
                Log.d(TAG, " onNext ");
                Log.d(TAG, " value : " + value);
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
