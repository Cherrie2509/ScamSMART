package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scamsmart.R;

public class infomenu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infomenu_activity);

        Button btnPhoneinfo = findViewById(R.id.btnPhoneinfo);
        Button btnTextinfo = findViewById(R.id.btnTextInfo);
        Button btnReportinfo = findViewById(R.id.btnReportInfo);
        Button btnNumberinfo = findViewById(R.id.btnNumberInfo);

        btnPhoneinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), callinfo_activity.class);
                startActivity(startIntent);
            }
        });

        btnTextinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(infomenu_activity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

        btnReportinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(infomenu_activity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });

        btnNumberinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(infomenu_activity.this, "Coming Soon!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}