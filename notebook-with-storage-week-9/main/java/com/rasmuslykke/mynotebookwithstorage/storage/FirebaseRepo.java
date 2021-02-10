package com.rasmuslykke.mynotebookwithstorage.storage;

import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;
import com.rasmuslykke.mynotebookwithstorage.MainActivity;
import com.rasmuslykke.mynotebookwithstorage.model.Note;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirebaseRepo {

    public static List<Note> notes = new ArrayList<>();

    private final static String notesPath = "notes";
    private static FirebaseFirestore db = FirebaseFirestore.getInstance();
    public static RecyclerView.Adapter adapter;

    static { // Make sure the listener starts as soon as possible
        startNoteListener();
    }

    private static void startNoteListener() {
        FirebaseRepo.db.collection(notesPath).addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots,
                                @Nullable FirebaseFirestoreException e) {
                FirebaseRepo.notes.clear();
                for (DocumentSnapshot snap: queryDocumentSnapshots.getDocuments()){
                    FirebaseRepo.notes.add(new Note(
                            snap.get("headline").toString(),
                            snap.get("body").toString(),
                            snap.getId()));
                    System.out.println("--> Notes size: " + FirebaseRepo.notes.size());
                }
                adapter.notifyDataSetChanged();
            }
        });
    }

    public static Note getNote(int index){
        if(index >= notes.size()) return new Note("", "empty", "");
        return notes.get(index);
    }

    public static void deleteNote(int index) {
        String key = notes.get(index).getId();
        DocumentReference documentReference = FirebaseRepo.db.collection(notesPath).document(key);
        documentReference.delete();
        adapter.notifyDataSetChanged();
    }

    public static void editNote(int index, String title, String body) {
        String id = notes.get(index).getId();
        // Get a Firebase ref. to the current note object.
        DocumentReference documentReference = FirebaseRepo.db.collection(notesPath).document(id);
        Map<String, String> map = new HashMap<>();

        map.put("headline", title);
        map.put("body", body);

        documentReference.set(map);
    }

    public static void saveNewNote(View v, String title, String body) {
        DocumentReference documentReference = FirebaseRepo.db.collection(notesPath).document();

        Map<String, String> map = new HashMap<>();
        map.put("headline", title);
        map.put("body", body);
        documentReference.set(map);

        // Create new intent. Get the context from the view passed as a param
        Intent intent = new Intent(v.getContext(), MainActivity.class);
        // Again use the view to get the context in order to start activity
        v.getContext().startActivity(intent);
    }

}
