package com.rasmuslykke.mynotebookwithstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.rasmuslykke.mynotebookwithstorage.storage.FirebaseRepo;

public class CreateActivity extends AppCompatActivity {

    EditText detailsTitleEditText;
    EditText detailsNotesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        detailsTitleEditText = findViewById(R.id.editTextTitle);
        detailsNotesEditText = findViewById(R.id.editTextBody);
    }

    public void saveNewNote(View v) {
        FirebaseRepo.saveNewNote(v,
            detailsTitleEditText.getText().toString(),
            detailsNotesEditText.getText().toString());
    }

}
