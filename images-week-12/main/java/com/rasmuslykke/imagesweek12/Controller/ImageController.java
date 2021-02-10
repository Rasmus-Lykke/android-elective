package com.rasmuslykke.imagesweek12.Controller;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import androidx.annotation.Nullable;

import com.rasmuslykke.imagesweek12.MainActivity;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class ImageController {

    private MainActivity mainActivity;

    public ImageController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public void handleImageReturn(int requestCode, @Nullable Intent intent) {
        if(requestCode == 0) {
            Uri uri = intent.getData();
            try {
                // Content resolver knows how to find path, other is content provider.
                InputStream inputStream = mainActivity.getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                mainActivity.imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        if(requestCode == 1) { // It's the camera
            Bitmap bitmap = (Bitmap) intent.getExtras().get("data"); // Here the intent itself was
            // provided with the intent
            mainActivity.imageView.setImageBitmap(bitmap);
        }
    }
}
