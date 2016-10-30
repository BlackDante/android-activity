package com.example.dante.movies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> movies;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private String[] values = new String[] { "bociany", "bociany vol 2" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.movies_list);

        movies = new ArrayList<>();
        Collections.addAll(movies, values);

        adapter = new ArrayAdapter<>(this, R.layout.movie_item, R.id.movie_item, movies);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("movie_id", position);
                MainActivity.this.startActivity(i);
            }
        });
    }
}
