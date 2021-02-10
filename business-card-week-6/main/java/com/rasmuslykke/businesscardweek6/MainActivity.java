package com.rasmuslykke.businesscardweek6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toContactPage(View view) {
        Log.i("To contact page", "Going to the contact page");
        setContentView(R.layout.activity_contact);
    }

    public void toBeerPage(View view) {
        Log.i("To beer page", "Going to the beer page");
        setContentView(R.layout.activity_beer);
    }

    public void toHomePage(View view) {
        Log.i("To home page", "Going to the home page");
        setContentView(R.layout.activity_main);
    }
}
