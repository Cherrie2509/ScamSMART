package com.example.scamsmart.services;

import android.graphics.Movie;

import com.example.scamsmart.models.Post;
import com.example.scamsmart.models.User;

import java.util.ArrayList;

//This code is based off my java project last year. I will be replacing this class with proper database functionality
// for now, I have baked in some posts as to get a
// proof of concept as to how the application will work.
// Attempted to use objects because it will better represent the database, I've used string arrays for now

public class PostService {


    public String[] getallPosts(){

        String[] postlist = {"0860000000", "0870000000"};

        //Post post = new Post();
       // post.setPostcontent("0860000000");

        //Post post2 = new Post();
       // post2.setPostcontent("0870000000");


       // postlist.add(post.getPostcontent());
       // postlist.add(post2.getPostcontent());

        return postlist;

    }

   // public ArrayList<String> getUsers() {
      //  ArrayList<String> userlist = null;
       // User user1 = new User();
       // user1.setName("Fred");
      //  User user2 = new User();
       // user1.setName("Bethany");

       // userlist.add(user1.getName());
       // userlist.add(user2.getName());

        //return userlist;

   //}

    public String[] getUsers() {

        //  ArrayList<String> userlist = null;
        // User user1 = new User();
        // user1.setName("Fred");
        //  User user2 = new User();
        // user1.setName("Bethany");

        // userlist.add(user1.getName());
        // userlist.add(user2.getName());

        String[] userlist = {"Fred", "Bethany"};

        return userlist;

    }

}
