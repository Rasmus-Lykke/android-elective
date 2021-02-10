package com.rasmuslykke.firebaseloginweek14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.rasmuslykke.firebaseloginweek14.auth.FirebaseManager;
import com.rasmuslykke.firebaseloginweek14.storage.Storage;
import com.rasmuslykke.firebaseloginweek14.adapter.MyAdapter;

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

    public void signOut(View view){
        FirebaseManager.getInstance().signOut();
        finish();
    }
}
