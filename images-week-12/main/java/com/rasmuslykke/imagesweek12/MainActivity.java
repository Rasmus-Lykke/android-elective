package com.rasmuslykke.imagesweek12;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.rasmuslykke.imagesweek12.Controller.ImageController;

public class MainActivity extends AppCompatActivity {

    public ImageView imageView;
    private ImageController imageController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        imageController = new ImageController(this);

        if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    public void photoRollBtnPressed(View view) {
        Log.i("all", "Photo roll button pressed");
        // Start activity (which will make Android system launch one activity which CAN handle this "request"
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0); // 0 means photo roll, 1 means camera

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (resultCode != -1) return; // -1 indicates OK
        imageController.handleImageReturn(requestCode, intent);
    }

    public void cameraBtnPressed(View view) {
        Log.i("all", "Camera button pressed");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 1);
    }


    public void saveImageToGallery(View view) {
        imageView.setDrawingCacheEnabled(true);
        Bitmap bitmap = imageView.getDrawingCache();
        Bitmap resized = Bitmap.createScaledBitmap(bitmap, 400, 400, true);
        MediaStore.Images.Media.insertImage(getContentResolver(), resized, "Hello", "Test");
    }

}
