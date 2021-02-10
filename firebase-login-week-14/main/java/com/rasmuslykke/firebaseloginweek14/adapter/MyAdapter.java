package com.rasmuslykke.firebaseloginweek14.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasmuslykke.firebaseloginweek14.R;
import com.rasmuslykke.firebaseloginweek14.storage.Storage;
import com.rasmuslykke.firebaseloginweek14.view.MyViewHolder;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private Storage storage;

    public MyAdapter(Storage storage) {
        this.storage = storage;
    }

    @NonNull
    @Override   // Parent is "this" of main activity
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(
                parent.getContext()).inflate(R.layout.mylayout, parent, false);
        return new MyViewHolder(linearLayout); // Pass the linearLayout as a constructor arg. to MyViewHolder
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setData(storage.noteList.get(position), storage.imageList.get(position)); // Start with dummy data
    }

    @Override
    public int getItemCount() {
        return storage.noteList.size(); // Start with dummy number of items
    }


}
