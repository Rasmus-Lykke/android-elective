package com.rasmuslykke.mobilepayaddon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor gyroSensor;

    private SeekBar seekBar;
    float seekBarMax = 100;
    float currentSeekBar = 0;

    private TextView successTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar =  findViewById(R.id.seekBar);
        seekBar.setMax((int) seekBarMax);

        successTextView = findViewById(R.id.successTextView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GAME_ROTATION_VECTOR); // No magnetic field
    }

    public void startPaymentPressed(View view) {
        startMotionSensor();

    }

    private void startMotionSensor(){
        sensorManager.registerListener(this, gyroSensor, SensorManager.SENSOR_DELAY_NORMAL);

    }

    public void toAccActivity(View view){
        Intent myIntent = new Intent(this, ShakeActivity.class);
        startActivity(myIntent);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float y = sensorEvent.values[1]; // x = 0, y = 1, z = 2
        System.out.println("Data in y-axis: " + y);
        if (y > 0.01) {
            currentSeekBar = seekBarMax * y * 2;
            seekBar.setProgress((int) currentSeekBar);
            if (currentSeekBar >= seekBarMax) {
                sensorManager.unregisterListener(this);
                successTextView.setVisibility(View.VISIBLE);

            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this); // This will stop listening, when the app is paused

    }
}
