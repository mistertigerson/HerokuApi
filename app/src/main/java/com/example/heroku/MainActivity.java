package com.example.heroku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new FilmsFragment()).commit();



    }


//    public void initRecycler() {
//        recyclerView = findViewById(R.id.recycler);
//        adapter = new Adapter();
//        recyclerView.setAdapter(adapter);
//    }
}