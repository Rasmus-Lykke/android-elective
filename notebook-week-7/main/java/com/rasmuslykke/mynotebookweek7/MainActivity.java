package com.rasmuslykke.mynotebookweek7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    final ArrayList<String> notesList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    EditText editText;
    Button updateNotesButton;
    int updateIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.notesTextView);
        ListView mainListView = findViewById(R.id.notesListView);
        updateNotesButton = findViewById(R.id.updateNotesButton);

        arrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, notesList);
        mainListView.setAdapter(arrayAdapter);

        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                updateNotesButton.setVisibility(View.VISIBLE);
                editText.setText(notesList.get(position));
                updateIndex = position;

            }
        });

        mainListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("Long click", "A long click");
                return false;
            }
        });
    }

    public void saveNotes(View view){

        notesList.add(editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.getText().clear();

    }

    public void updateNotes(View view) {

        updateNotesButton.setVisibility(View.INVISIBLE);
        notesList.set(updateIndex, editText.getText().toString());
        arrayAdapter.notifyDataSetChanged();
        editText.getText().clear();

    }
}
