package com.example.admin.registrationpage;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by User on 1/18/2018.
 */


public class Second extends AppCompatActivity  {

    private AppCompatActivity activity = Second.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private HolderClass holderClassAdapter;
    private SailajaDB databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
//        getSupportActionBar().setTitle("");



    }


}