package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.example.scamsmart.R;

public class callinfo_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_callinfo_activity);

        //Make content scrollable, adapted from https://stackoverflow.com/questions/1748977/making-textview-scrollable-on-android
        TextView tvContent = findViewById(R.id.tvPhoneinfoContent);
        tvContent.setMovementMethod(new ScrollingMovementMethod());


    }
}