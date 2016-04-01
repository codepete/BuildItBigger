package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.util.concurrent.CountDownLatch;

public class ApiTest extends AndroidTestCase {
    private CountDownLatch mSignal;

    public void testAsyncCall() throws InterruptedException {
        mSignal = new CountDownLatch(1);
        AsyncTaskCallback callback = new AsyncTaskCallback() {
            @Override
            public void onSuccess(String result) {
                assertNotNull(result);
                mSignal.countDown();
            }

            @Override
            public void onError() {
                fail();
                mSignal.countDown();
            }
        };

        MyApi myApi = Utility.createApiService();
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(myApi, callback);
        jokeAsyncTask.execute();
        mSignal.await();
    }
}
