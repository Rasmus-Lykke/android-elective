package com.rasmuslykke.fragmentsweek17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.rasmuslykke.fragmentsweek17.Storage.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final ArrayList<Note> notesList = new ArrayList<>();
    private static final ArrayList<String> titleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 1; i < 20; i++) {
            notesList.add(new Note("Title " + i, "Body " + i));
        };

    }

    public void detailViewButtonPressed(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, new DetailViewActivity());
        fragmentTransaction.commit();
    }
    public void listViewButtonPressed(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayoutId, new ListViewActivity());
        fragmentTransaction.commit();
    }

    public ArrayList<Note> getNotesList(){
        return notesList;
    }

    public ArrayList getTitles(){

        for (Note note : notesList) {
            titleList.add(note.getTitle());
        }
        return titleList;
    }

}
