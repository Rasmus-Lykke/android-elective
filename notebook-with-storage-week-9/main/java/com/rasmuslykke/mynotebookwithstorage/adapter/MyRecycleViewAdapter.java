package com.rasmuslykke.mynotebookwithstorage.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasmuslykke.mynotebookwithstorage.storage.FirebaseRepo;
import com.rasmuslykke.mynotebookwithstorage.view.ViewHolder;
import com.rasmuslykke.mynotebookwithstorage.R;

public class MyRecycleViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout ll = (LinearLayout) LayoutInflater.
                from(parent.getContext()).inflate(R.layout.customrow, parent, false);
        return new ViewHolder(ll);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return FirebaseRepo.notes.size();
    }
}
