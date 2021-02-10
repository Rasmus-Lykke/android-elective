package com.rasmuslykke.customrecyclerviewweek13.view;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rasmuslykke.customrecyclerviewweek13.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;
    public ImageView imageView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

        LinearLayout linearLayout = (LinearLayout) itemView;

        textView = linearLayout.findViewById(R.id.textView);
        imageView = linearLayout.findViewById(R.id.imageView);

    }

    public void setData(String data, int image) {
        textView.setText(data);
        imageView.setImageResource(image);
    }
}
