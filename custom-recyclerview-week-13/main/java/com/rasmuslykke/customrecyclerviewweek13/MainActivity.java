package com.rasmuslykke.customrecyclerviewweek13;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.rasmuslykke.customrecyclerviewweek13.adapter.MyAdapter;
import com.rasmuslykke.customrecyclerviewweek13.storage.Storage;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdapter = new MyAdapter(new Storage());
        recyclerView.setAdapter(myAdapter); // Assign the adapter to recyclerView
    }
}
