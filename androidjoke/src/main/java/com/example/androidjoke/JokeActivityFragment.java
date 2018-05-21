package com.example.androidjoke;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        String joke = intent.getStringExtra(JokeActivity.JOKE_KEY);
        TextView jokeTextView = view.findViewById(R.id.joke);
        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return view;
    }
}
