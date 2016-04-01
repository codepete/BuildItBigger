package com.example.jokeandroidlibrary;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_lib_activity);

        Bundle data = getIntent().getExtras();
        TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);

        String jokeText;
        if (data != null) {
            jokeText = data.getString("joke", "Sorry, no jokes to show!");
        } else {
            jokeText =  "Sorry, no jokes found.";
        }

        if (jokeTextView != null) {
            jokeTextView.setText(jokeText);
        }
    }



}
