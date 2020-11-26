package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CallLog;
import android.view.View;
import android.widget.Button;

import com.example.scamsmart.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnReport = findViewById(R.id.btnReport);
        Button btnInfo = findViewById(R.id.btnInfo);
        Button btnBlock = findViewById(R.id.btnBlock);
        Button btnRecent = findViewById(R.id.btnRecent);



        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), report_activity.class);
                startActivity(startIntent);
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), infomenu_activity.class);
                startActivity(startIntent);
            }
        });

        btnBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), block_activity.class);
                startActivity(startIntent);


            }
        });

        btnRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), recent_activity.class);
                startActivity(startIntent);
            }
        });

    }
}