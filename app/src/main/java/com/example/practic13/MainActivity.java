package com.example.practic13;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText edtSeconds;
    Button btnStartTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtSeconds = findViewById(R.id.edtSeconds);
        btnStartTimer = findViewById(R.id.btnStartTimer);
        btnStartTimer.setOnClickListener(view -> {
            int seconds = Integer.parseInt(edtSeconds.getText().toString());
            Intent intent = new Intent(MainActivity.this, Alarm.class);
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + seconds * 1000L, PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0));
        });
    }
}