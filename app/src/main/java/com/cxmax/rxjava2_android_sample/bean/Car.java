package com.cxmax.rxjava2_android_sample.bean;

import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;

/**
 * Created by cxmax on 2017/2/15.
 */

public class Car {
    private String brand;

    public Car brand(String brand){
        this.brand = brand;
        return this;
    }

    public Observable<String> brandDeferObservable() {
        return Observable.defer(new Callable<ObservableSource<? extends String>>() {
            @Override
            public ObservableSource<? extends String> call() throws Exception {
                return Observable.just(brand);
            }
        });
    }
}
