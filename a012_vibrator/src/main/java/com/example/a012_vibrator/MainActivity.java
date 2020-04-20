package com.example.a012_vibrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
// 진동
// 1. 진동 권한을 획득해야한다. AndroidManifest.xml
// 2. Vibrator 객체를 얻어서 진동시킨다

public class MainActivity extends AppCompatActivity {

    Button btnVib1, btnVib2, btnVib3, btnVib4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVib1 = findViewById(R.id.btnVib1);
        btnVib2 = findViewById(R.id.btnVib2);
        btnVib3 = findViewById(R.id.btnVib3);
        btnVib4 = findViewById(R.id.btnVib4);

        final Vibrator vibrator
        = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        btnVib1.setText("5초 진동");
        btnVib1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrator.vibrate(5000); //지정시간동안 진동
            }
        });



    }
}
