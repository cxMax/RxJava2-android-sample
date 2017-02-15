package com.cxmax.rxjava2_android_sample.utils;

import android.util.Log;

import com.androidnetworking.error.ANError;
import com.cxmax.rxjava2_android_sample.bean.ApiUser;
import com.cxmax.rxjava2_android_sample.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cxmax on 2017/2/15.
 */

public class Utils {

    private Utils() {
        // This class in not publicly instantiable.
    }

    public static List<User> getUserList() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.firstName = "Amit";
        userOne.lastName = "Shekhar";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.firstName = "Manish";
        userTwo.lastName = "Kumar";
        userList.add(userTwo);

        User userThree = new User();
        userThree.firstName = "Sumit";
        userThree.lastName = "Kumar";
        userList.add(userThree);

        return userList;
    }

    public static List<ApiUser> getApiUserList() {

        List<ApiUser> apiUserList = new ArrayList<>();

        ApiUser apiUserOne = new ApiUser();
        apiUserOne.firstname = "Amit";
        apiUserOne.lastname = "Shekhar";
        apiUserList.add(apiUserOne);

        ApiUser apiUserTwo = new ApiUser();
        apiUserTwo.firstname = "Manish";
        apiUserTwo.lastname = "Kumar";
        apiUserList.add(apiUserTwo);

        ApiUser apiUserThree = new ApiUser();
        apiUserThree.firstname = "Sumit";
        apiUserThree.lastname = "Kumar";
        apiUserList.add(apiUserThree);

        return apiUserList;
    }

    public static List<User> convertApiUserListToUserList(List<ApiUser> apiUserList) {
        List<User> userList = new ArrayList<>();
        if (apiUserList != null && apiUserList.size() > 0){
            for (ApiUser apiUser : apiUserList) {
                User user = new User();
                user.firstName = apiUser.firstname;
                user.lastName = apiUser.lastname;
                userList.add(user);
            }
        }
        return userList;
    }

    public static List<User> getUserListWhoLovesCricket() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstName = "Amit";
        userOne.lastName = "Shekhar";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 2;
        userTwo.firstName = "Manish";
        userTwo.lastName = "Kumar";
        userList.add(userTwo);

        return userList;
    }


    public static List<User> getUserListWhoLovesFootball() {

        List<User> userList = new ArrayList<>();

        User userOne = new User();
        userOne.id = 1;
        userOne.firstName = "Amit";
        userOne.lastName = "Shekhar";
        userList.add(userOne);

        User userTwo = new User();
        userTwo.id = 3;
        userTwo.firstName = "Sumit";
        userTwo.lastName = "Kumar";
        userList.add(userTwo);

        return userList;
    }


    public static List<User> filterUserWhoLovesBoth(List<User> cricketFans, List<User> footballFans) {
        List<User> userWhoLovesBoth = new ArrayList<User>();
        if (cricketFans != null && cricketFans.size() > 0){
            for (User cricketFan : cricketFans) {
                if (footballFans != null && cricketFans.size() > 0){
                    for (User footballFan : footballFans) {
                        if (cricketFan.id == footballFan.id) {
                            userWhoLovesBoth.add(cricketFan);
                        }
                    }
                }
            }
        }
        return userWhoLovesBoth;
    }

    public static void logError(String TAG, Throwable e) {
        if (e == null) return;
        if (e instanceof ANError) {
            ANError anError = (ANError) e;
            if (anError.getErrorCode() != 0) {
                // received ANError from server
                // error.getErrorCode() - the ANError code from server
                // error.getErrorBody() - the ANError body from server
                // error.getErrorDetail() - just a ANError detail
                Log.d(TAG, "onError errorCode : " + anError.getErrorCode());
                Log.d(TAG, "onError errorBody : " + anError.getErrorBody());
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            } else {
                // error.getErrorDetail() : connectionError, parseError, requestCancelledError
                Log.d(TAG, "onError errorDetail : " + anError.getErrorDetail());
            }
        } else {
            Log.d(TAG, "onError errorMessage : " + e.getMessage());
        }
    }
}
