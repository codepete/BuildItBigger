package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jokeandroidlibrary.JokeActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AsyncTaskCallback{

    MyApi mApiService;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mApiService = Utility.createApiService();
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.joke_button)
    public void showJokeActivity() {
        JokeAsyncTask jokeAsyncTask = new JokeAsyncTask(mApiService, this);
        jokeAsyncTask.execute();
    }

    @Override
    public void onSuccess(String joke) {
        Intent intent = new Intent(getContext(), JokeActivity.class);
        intent.putExtra("joke", joke);
        getActivity().startActivity(intent);
    }

    @Override
    public void onError() {
        Toast.makeText(getContext(), "Sorry, unable to retrieve jokes", Toast.LENGTH_SHORT).show();
    }
}