package com.udacity.gradle.builditbigger;

public interface AsyncTaskCallback {
    void onSuccess(String result);
    void onError();
}
