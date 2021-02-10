package com.rasmuslykke.mynotebookwithstorage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.rasmuslykke.mynotebookwithstorage.adapter.MyRecycleViewAdapter;
import com.rasmuslykke.mynotebookwithstorage.storage.FirebaseRepo;

public class MainActivity extends AppCompatActivity {

    MyRecycleViewAdapter adapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    public static final String INDEX_KEY = "INDEX_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyRecycleViewAdapter();
        recyclerView.setAdapter(adapter);
        FirebaseRepo.adapter = adapter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("all", "onResume()...");
    }

    public void toActivityCreate(View v){
        // Create new intent. Get the context from the view passed as a param
        Intent intent = new Intent(v.getContext(), CreateActivity.class);
        // Again use the view to get the context in order to start activity
        v.getContext().startActivity(intent);
    }
}
