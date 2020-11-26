package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.scamsmart.R;

public class report_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_activity);

        Button btnReportNumber = findViewById(R.id.btnReportNumber);

        btnReportNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(report_activity.this, "Number reported, thank you!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}