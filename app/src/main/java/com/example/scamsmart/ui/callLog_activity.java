package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.CallLog;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scamsmart.R;

import java.text.SimpleDateFormat;
import java.util.Date;

//adapted from https://www.youtube.com/watch?v=wj_I1pwVCq0

public class callLog_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_log_activity);

        if (ContextCompat.checkSelfPermission(callLog_activity.this, Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(callLog_activity.this, Manifest.permission.READ_CALL_LOG)) {

                ActivityCompat.requestPermissions(callLog_activity.this, new String [] {Manifest.permission.READ_CALL_LOG}, 1);
            } else {
                ActivityCompat.requestPermissions(callLog_activity.this, new String [] {Manifest.permission.READ_CALL_LOG}, 1);
            }
        } else {
            TextView textview = findViewById(R.id.tvName);
            textview.setText(getCallDetails());

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,  int[] grantResults) {
        switch (requestCode) {
            case 1: {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if(ContextCompat.checkSelfPermission(callLog_activity.this, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "No permission", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }


    private String getCallDetails() {
        StringBuffer sb = new StringBuffer();
        Cursor managedCursor = getContentResolver().query(CallLog.Calls.CONTENT_URI, null, null, null, android.provider.CallLog.Calls.DATE + " DESC", null);
        int number = managedCursor.getColumnIndex(CallLog.Calls.NUMBER);
        int type = managedCursor.getColumnIndex(CallLog.Calls.TYPE);
        int date = managedCursor.getColumnIndex(CallLog.Calls.DATE);
        int duration = managedCursor.getColumnIndex(CallLog.Calls.DURATION);
        sb.append("Call Details:\n\n");
        while (managedCursor.moveToNext()) {

            String phNumber = managedCursor.getString(number);
            String callType = managedCursor.getString(type);
            String callDate = managedCursor.getString(date);
            Date callDayTime = new Date(Long.valueOf(callDate));
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yy HH:mm");
            String dateString = formatter.format(callDayTime);
            String callDuration = managedCursor.getString(duration);
            String dir = null;
            int dircode = Integer.parseInt(callType);
            switch (dircode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    dir = "OUTGOING";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    dir = "INCOMING";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    dir = "MISSED";
                    break;
            }
            sb.append("\nPhone Number: " + phNumber + " \nCallType " + dir + "\nCall Date: " + dateString + " \nCall Duration: " + callDuration);
            sb.append("\n------------------------------------------");
        }
        managedCursor.close();
        return sb.toString();
    }

}