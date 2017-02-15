package com.cxmax.rxjava2_android_sample.bean;

/**
 * Created by cxmax on 2017/2/15.
 */

public class ApiUser {
    public long id;
    public String firstname;
    public String lastname;

    @Override
    public String toString() {
        return "ApiUser{" +
                "id=" + id +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                '}';
    }
}
