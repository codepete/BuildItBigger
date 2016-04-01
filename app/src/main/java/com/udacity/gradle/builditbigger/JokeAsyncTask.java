package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class JokeAsyncTask extends AsyncTask<Void, Void, String>{
    MyApi mApi;
    AsyncTaskCallback mCallback;

    public JokeAsyncTask(MyApi api, AsyncTaskCallback callback) {
        mApi = api;
        mCallback = callback;
    }

    @Override
    protected String doInBackground(Void... params) {
        String result = null;
        try {
            result = mApi.getJoke().execute().getData();
        } catch (IOException e) {
            e.printStackTrace();
            mCallback.onError();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        mCallback.onSuccess(s);
    }
}
