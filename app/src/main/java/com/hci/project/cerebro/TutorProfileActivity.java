package com.hci.project.cerebro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TutorProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorprofilepage);
        Intent intent= getIntent();
        intent.getIntExtra("key", 0);
        intent.getParcelableExtra("key1");


    }
}
