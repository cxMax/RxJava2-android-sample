package com.cxmax.rxjava2_android_sample.bean;

/**
 * Created by cxmax on 2017/2/15.
 */

public class UserDetail {

    public long id;
    public String firstname;
    public String lastname;

    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
