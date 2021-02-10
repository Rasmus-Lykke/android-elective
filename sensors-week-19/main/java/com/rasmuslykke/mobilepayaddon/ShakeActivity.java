package com.rasmuslykke.mobilepayaddon;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class ShakeActivity extends AppCompatActivity implements SensorEventListener {

    private TextView shakeTextView;
    private SensorManager sensorManager;
    private Sensor accSensor;

    private static final int SHAKE_THRESHOLD = 500;

    private long lastUpdate = 0; // To keep track of amount of time between sensor data

    private float lastX, lastY, lastZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shake);

        shakeTextView = findViewById(R.id.shakeTextView);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x = event.values[0];

        long currentTime = System.currentTimeMillis();
        long deltaTime = currentTime - lastUpdate;

        if (deltaTime > 500) {
            float speed = Math.abs(x - lastX) / deltaTime * 100000;
            System.out.println("Speed: " + speed);
            if (speed > SHAKE_THRESHOLD) {
                shakeTextView.setText("You made it!");
            }
            lastUpdate = currentTime;
            lastX = x;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
