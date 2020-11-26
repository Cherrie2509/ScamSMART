package com.example.scamsmart.services;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.scamsmart.R;

//This class enables my listview to be populated, it is adapted from an example Michael Gleeson showed us in IS4448

public class PostAdapter extends BaseAdapter {

    String[] numbers, users;
    LayoutInflater mInflater;

    // public constructor
     public PostAdapter(Context c, String[] n, String[] u){
        numbers = n;
        users = u;


       //inflates data onto the listview
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return numbers.length;
    } //return the total numbers from the list

    @Override
    public Object getItem(int i) {
        return numbers[i];
    } //returns list item at the specified position

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View v = mInflater.inflate(R.layout.listview_detail, null);
        TextView tvNumber = (TextView) v.findViewById(R.id.tvNumber);
        TextView tvUser = (TextView) v.findViewById(R.id.tvUser);


        String postNumber = numbers[i];
        String postUser = users[i];


        tvNumber.setText(postNumber);
        tvUser.setText(postUser);


        return v; //returns the View for the current row
    }
}
