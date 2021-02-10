package com.rasmuslykke.helloworldweek5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Create a handeler for the page 2 button
    public void goToPage2(View view){

        Intent intent = new Intent(this, Page2.class);
        startActivity(intent);

    }
}
