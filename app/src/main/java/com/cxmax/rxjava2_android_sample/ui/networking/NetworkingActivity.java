package com.cxmax.rxjava2_android_sample.ui.networking;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.Pair;
import android.view.View;

import com.cxmax.rxjava2_android_sample.R;
import com.cxmax.rxjava2_android_sample.bean.ApiUser;
import com.cxmax.rxjava2_android_sample.bean.User;
import com.cxmax.rxjava2_android_sample.bean.UserDetail;
import com.cxmax.rxjava2_android_sample.utils.Utils;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cxmax on 2017/2/21.
 */

public class NetworkingActivity extends AppCompatActivity {

    public static final String TAG = NetworkingActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networking);
    }

    public void map(View view) {
        Rx2AndroidNetworking
                .get("https://fierce-cove-29863.herokuapp.com/getAnUser/{userId}")
                .addPathParameter("userId", "1")
                .build()
                .getObjectObservable(ApiUser.class)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<ApiUser, User>() {
                    @Override
                    public User apply(ApiUser apiUser) throws Exception {
                        User user = new User(apiUser);
                        return user;
                    }
                })
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void zip(View view) {
        Observable.zip(getCricketFansObservable(), getFootballFansObservable(),
                new BiFunction<List<User>, List<User>, List<User>>() {
                    @Override
                    public List<User> apply(List<User> cricketFans, List<User> footballFans) throws Exception {
                        List<User> userWhoLovesBoth =
                                filterUserWhoLovesBoth(cricketFans, footballFans);
                        return userWhoLovesBoth;
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<User>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<User> users) {
                        // do anything with user who loves both
                        Log.d(TAG, "userList size : " + users.size());
                        for (User user : users) {
                            Log.d(TAG, "user : " + user.toString());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    private Observable<List<User>> getCricketFansObservable() {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllCricketFans")
                .build()
                .getObjectListObservable(User.class);
    }

    private Observable<List<User>> getFootballFansObservable() {
        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllFootballFans")
                .build()
                .getObjectListObservable(User.class);
    }

    private List<User> filterUserWhoLovesBoth(List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<>();
        for (User cricketFan : cricketFans) {
            for (User footballFan : footballFans) {
                if (cricketFan.id == footballFan.id) {
                    userWhoLovesBoth.add(cricketFan);
                }
            }
        }
        return userWhoLovesBoth;
    }

    public void flatMapAndFilter(View view) {
        Rx2AndroidNetworking
                .get("https://fierce-cove-29863.herokuapp.com/getAllFriends/{userId}")
                .addPathParameter("userId", "1")
                .build()
                .getObjectListObservable(User.class)
                .flatMap(new Function<List<User>, ObservableSource<User>>() {
                    @Override
                    public ObservableSource<User> apply(List<User> users) throws Exception {
                        return Observable.fromIterable(users);
                    }
                })
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User user) throws Exception {
                        return user.isFollowing;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        Log.d(TAG, "user : " + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void take(View view) {
        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "10")
                .build()
                .getObjectListObservable(User.class)
                .flatMap(new Function<List<User>, ObservableSource<User>>() { // flatMap - to return users one by one
                    @Override
                    public ObservableSource<User> apply(List<User> usersList) throws Exception {
                        return Observable.fromIterable(usersList); // returning user one by one from usersList.
                    }
                })
                .take(4)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        // // only four user comes here one by one
                        Log.d(TAG, "user : " + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void flatMap(View view) {
        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "10")
                .build()
                .getObjectListObservable(User.class)
                .flatMap(new Function<List<User>, ObservableSource<User>>() { // flatMap - to return users one by one
                    @Override
                    public ObservableSource<User> apply(List<User> usersList) throws Exception {
                        return Observable.fromIterable(usersList); // returning user one by one from usersList.
                    }
                })
                .flatMap(new Function<User, ObservableSource<UserDetail>>() {
                    @Override
                    public ObservableSource<UserDetail> apply(User user) throws Exception {
                        return Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/{userId}")
                                .addPathParameter("userId", String.valueOf(user.id))
                                .build()
                                .getObjectObservable(UserDetail.class);
                    }
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onNext(UserDetail userDetail) {
                        // do anything with userDetail
                        Log.d(TAG, "userDetail : " + userDetail.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.d(TAG, "onComplete");
                    }
                });
    }

    public void flatMapWithZip(View view) {
        Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
                .addPathParameter("pageNumber", "0")
                .addQueryParameter("limit", "10")
                .build()
                .getObjectListObservable(User.class)
                .flatMap(new Function<List<User>, ObservableSource<User>>() { // flatMap - to return users one by one
                    @Override
                    public ObservableSource<User> apply(List<User> usersList) throws Exception {
                        return Observable.fromIterable(usersList);
                    }
                }).flatMap(new Function<User, ObservableSource<Pair<UserDetail, User>>>() {
            @Override
            public ObservableSource<Pair<UserDetail, User>> apply(User user) throws Exception {
                return Observable.zip(Rx2AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAnUserDetail/{userId}")
                                .addPathParameter("userId", String.valueOf(user.id))
                                .build()
                                .getObjectObservable(UserDetail.class),
                        Observable.just(user),
                        new BiFunction<UserDetail, User, Pair<UserDetail, User>>() {
                            @Override
                            public Pair<UserDetail, User> apply(UserDetail userDetail, User user) throws Exception {
                                return new Pair<>(userDetail, user); // returning the pair(userDetail, user)
                            }
                        });
            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Pair<UserDetail, User>>() {
                    @Override
                    public void onComplete() {
                        // do something onCompleted
                        Log.d(TAG, "onComplete");
                    }

                    @Override
                    public void onError(Throwable e) {
                        // handle error
                        Utils.logError(TAG, e);
                    }

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Pair<UserDetail, User> pair) {
                        // here we are getting the userDetail for the corresponding user one by one
                        UserDetail userDetail = pair.first;
                        User user = pair.second;
                        Log.d(TAG, "user : " + user.toString());
                        Log.d(TAG, "userDetail : " + userDetail.toString());
                    }
                });
    }
}
