package com.cxmax.rxjava2_android_sample.ui.operators;

import android.util.Log;

import com.cxmax.rxjava2_android_sample.bean.ApiUser;
import com.cxmax.rxjava2_android_sample.bean.User;
import com.cxmax.rxjava2_android_sample.ui.Base.BaseOperatorActivity;
import com.cxmax.rxjava2_android_sample.utils.AppConstant;
import com.cxmax.rxjava2_android_sample.utils.Utils;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cxmax on 2017/2/21.
 */

public class MapExampleActivity extends BaseOperatorActivity {
    private static final String TAG = MapExampleActivity.class.getSimpleName();

    @Override
    protected void operatorTest() {
        getObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<List<ApiUser>,  List<User>>() {
                    @Override
                    public List<User> apply(List<ApiUser> apiUsers) throws Exception {
                        return Utils.convertApiUserListToUserList(apiUsers);
                    }
                }).subscribe(getObserver());
    }

    private Observable<List<ApiUser>> getObservable() {
        return Observable.create(new ObservableOnSubscribe<List<ApiUser>>() {
            @Override
            public void subscribe(ObservableEmitter<List<ApiUser>> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(Utils.getApiUserList());
                    e.onComplete();
                }
            }
        });
    }

    private Observer<List<User>> getObserver() {
        return new Observer<List<User>>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(List<User> userList) {
                textView.append(" onNext");
                textView.append(AppConstant.LINE_SEPARATOR);
                for (User user : userList) {
                    textView.append(" firstName : " + user.firstName);
                    textView.append(AppConstant.LINE_SEPARATOR);
                }
                Log.d(TAG, " onNext : " + userList.size());
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
