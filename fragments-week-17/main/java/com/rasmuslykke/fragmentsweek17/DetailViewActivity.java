package com.rasmuslykke.fragmentsweek17;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailViewActivity extends Fragment {

    private ListViewActivity listViewActivity = new ListViewActivity();
    private MainActivity mainActivity = new MainActivity();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_detailview, container, false);

        TextView textViewNoteTitle = view.findViewById(R.id.textViewNoteTitle);
        EditText editTextNoteBody = view.findViewById(R.id.editTextNoteBody);

        textViewNoteTitle.setText(mainActivity.getNotesList().get(listViewActivity.getPosition()).getTitle());
        editTextNoteBody.setText(mainActivity.getNotesList().get(listViewActivity.getPosition()).getBody());

        return view;
    }
}
