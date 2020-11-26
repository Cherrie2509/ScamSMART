package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scamsmart.R;

public class block_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_activity);

        Button btnViewRecent = findViewById(R.id.btnViewRecent);
        Button btnLaunchBlock = findViewById(R.id.btnLaunchBlock);
        Button btnInstructions = findViewById(R.id.btnInstructions);
        EditText etNumber = findViewById(R.id.etNumber);

        //receiving a number from recent activity
        if(getIntent().hasExtra("Number")){
            String text = getIntent().getExtras().getString("Number");
            etNumber.setText(text);
        }

        //button for view recent calls
        btnViewRecent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), callLog_activity.class);
                startActivity(startIntent);
            }
        });

        //button to launch built in blocker
        btnLaunchBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strNumber = String.valueOf(etNumber.getText());

                setClipboard(block_activity.this, strNumber);



                TelecomManager telecomManager = (TelecomManager) getSystemService(Context.TELECOM_SERVICE);
                startActivity(telecomManager.createManageBlockedNumbersIntent(), null);

            }
        });

        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), instruction_activity.class);
                startActivity(startIntent);
            }
        });

    }

    //adapted from https://stackoverflow.com/questions/19253786/how-to-copy-text-to-clip-board-in-android
    private void setClipboard(Context context, String text) {

        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied Text", text);
        clipboard.setPrimaryClip(clip);

    }
}