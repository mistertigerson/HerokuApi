package com.example.heroku;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.heroku.retrofit.Films;
import com.example.heroku.retrofit.NetworkService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);

        NetworkService.getmInstance().
                getGhibliapi().
                getFilms("58611129-2dbc-4a81-a72f-77ddfc1b1b49").
                enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                Films films = response.body();
                Log.d(TAG, "onResponse: " + response);
                textView.append(films.getId() + "\n");
                textView.append(films.getDirector() + "\n");
                textView.append(films.getOriginalTitle() + "\n");
                textView.append(films.getProducer() + "\n");
                textView.append(films.getReleaseDate() + "\n");
                textView.append(films.getRtScore() + "\n");
            }

            @Override
            public void onFailure(Call<Films> call, Throwable t) {
                textView.append("Error occurred while getting request!");
                t.printStackTrace();
            }
        });

    }
}