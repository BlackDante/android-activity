package com.example.dante.movies;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

class Movie {
    public String title;
    public String description;

    public Movie(String title, String description) {
        this.title = title;
        this.description = description;
    }
}

public class SecondActivity extends AppCompatActivity {

    private TextView movieTitle;
    private TextView movieDescription;
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Resources resources = getResources();

        TypedArray moviesNames = resources.obtainTypedArray(R.array.movies_names);
        TypedArray moviesDescriptions = resources.obtainTypedArray(R.array.movies_descriptions);

        Intent intent = getIntent();
        int id = intent.getIntExtra("movie_id", 0);

        movie = new Movie(moviesNames.getString(id), moviesDescriptions.getString(id));

        movieTitle = (TextView) findViewById(R.id.textView);
        movieTitle.setText(movie.title);

        movieDescription = (TextView) findViewById(R.id.textView2);
        movieDescription.setText(movie.description);
    }
}
