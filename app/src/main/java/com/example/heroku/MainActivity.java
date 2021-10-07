package com.example.heroku;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.heroku.retrofit.Films;
import com.example.heroku.retrofit.NetworkService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycler();

        NetworkService.getmInstance().getGhibliapi()
                .getFilms()
                .enqueue(new Callback<List<Films>>() {
                    @Override
                    public void onResponse(Call<List<Films>> call, Response<List<Films>> response) {
                        ArrayList<Films> list = (ArrayList<Films>) response.body();
                        adapter.setList(list);
                    }

                    @Override
                    public void onFailure(Call<List<Films>> call, Throwable t) {

                    }
                });




    }


    public void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }
}