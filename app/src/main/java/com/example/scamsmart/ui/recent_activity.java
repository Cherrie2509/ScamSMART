package com.example.scamsmart.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.scamsmart.R;
import com.example.scamsmart.services.PostAdapter;
import com.example.scamsmart.services.PostService;

import java.util.ArrayList;

public class recent_activity extends AppCompatActivity {

    String[] users, numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_activity);

        ListView lvRecent = findViewById(R.id.lvMyListView);

        PostService postservice = new PostService();

       numbers = postservice.getallPosts();
       users = postservice.getUsers();


        PostAdapter postadapter = new PostAdapter(this, numbers, users);
        lvRecent.setAdapter(postadapter);

        //Gets number from listview https://stackoverflow.com/questions/14839121/how-to-get-textview-values-from-a-listview-items
        // then, pass to number blocker activity
        lvRecent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selected = ((TextView) view.findViewById(R.id.tvNumber)).getText().toString();
                Intent startIntent = new Intent(getApplicationContext(), block_activity.class);
                startIntent.putExtra("Number", selected);
                startActivity(startIntent);
            }
        });



    }
}