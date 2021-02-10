package com.rasmuslykke.mynotebookwithstorage.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasmuslykke.mynotebookwithstorage.DetailActivity;
import com.rasmuslykke.mynotebookwithstorage.MainActivity;
import com.rasmuslykke.mynotebookwithstorage.R;
import com.rasmuslykke.mynotebookwithstorage.storage.FirebaseRepo;

public class ViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;
    private int rowNumber = 0;

    public ViewHolder(@NonNull final View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewInList);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create new intent. Get the context from the view passed as a param
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                // Add the row number to the intent, so we can get it back
                // "on the other side" in DetailActivity
                intent.putExtra(MainActivity.INDEX_KEY, rowNumber);
                // Again use the view to get the context in order to start activity
                itemView.getContext().startActivity(intent);
            }
        });

        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                FirebaseRepo.deleteNote(rowNumber);
                Log.i("Deleted note", "Deleted a note");
                return true;
            }
        });
    }

    public void setPosition(int position) {
        rowNumber = position;
        textView.setText(FirebaseRepo.notes.get(position).getHeadline());
    }
}
