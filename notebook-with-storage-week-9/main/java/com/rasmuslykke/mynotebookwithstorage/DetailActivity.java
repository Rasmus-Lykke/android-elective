package com.rasmuslykke.mynotebookwithstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.rasmuslykke.mynotebookwithstorage.storage.FirebaseRepo;

public class DetailActivity extends AppCompatActivity {

    EditText detailsTitleEditText;
    EditText detailsNotesEditText;
    private int row = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailsTitleEditText = findViewById(R.id.detailsTitleEditText);
        detailsNotesEditText = findViewById(R.id.detailsNotesEditText);

        row = getIntent().getIntExtra(MainActivity.INDEX_KEY, 0);
        detailsTitleEditText.setText(FirebaseRepo.getNote(row).getHeadline());
        detailsNotesEditText.setText(FirebaseRepo.getNote(row).getBody());
    }

    @Override
    protected void onPause() {
        super.onPause();
        FirebaseRepo.editNote(row, detailsTitleEditText.getText().toString(), detailsNotesEditText.getText().toString());
    }
}
