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
    private ArrayList<Films> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<>();
        initRecycler();

        createObject("2baf70d1-42bb-4437-b551-e5fed5a87abe");
        createObject("12cfb892-aac0-4c5b-94af-521852e46d6a");
        createObject("58611129-2dbc-4a81-a72f-77ddfc1b1b49");
        createObject("4e236f34-b981-41c3-8c65-f8c9000b94e7");
        createObject("ea660b10-85c4-4ae3-8a5f-41cea3648e3e");
        createObject("ebbb6b7c-945c-41ee-a792-de0e43191bd8");
        createObject("1b67aa9a-2e4a-45af-ac98-64d6ad15b16c");
        createObject("ff24da26-a969-4f0e-ba1e-a122ead6c6e3");
        createObject("0440483e-ca0e-4120-8c50-4c8cd9b965d6");
        createObject("45204234-adfd-45cb-a505-a8e7a676b114");
        createObject("dc2e6bd1-8156-4886-adff-b39e6043af0c");
        createObject("90b72513-afd4-4570-84de-a56c312fdf81");
        createObject("cd3d059c-09f4-4ff3-8d63-bc765a5184fa");
        createObject("112c1e67-726f-40b1-ac17-6974127bb9b9");
        createObject("758bf02e-3122-46e0-884e-67cf83df1786");
        createObject("2de9426b-914a-4a06-a3a0-5e6d9d3886f6");
        createObject("45db04e4-304a-4933-9823-33f389e8d74d");
        createObject("67405111-37a5-438f-81cc-4666af60c800");





    }

    private void createObject(String id) {
        NetworkService.getmInstance().getGhibliapi()
                .getFilms(id)
                .enqueue(new Callback<Films>() {
                    @Override
                    public void onResponse(Call<Films> call, Response<Films> response) {
                        Films films = response.body();
                        list.add(films);
                        adapter.setList(list);

                    }

                    @Override
                    public void onFailure(Call<Films> call, Throwable t) {

                    }
                });

    }


    public void initRecycler() {
        recyclerView = findViewById(R.id.recycler);
        adapter = new Adapter();
        recyclerView.setAdapter(adapter);
    }
}