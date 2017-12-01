package com.hci.project.cerebro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class TutorProfileActivity extends AppCompatActivity {

    //SKILLS Variables
    LinearLayout add_skills;
    EditText skill1, skill2, skill3, skill4, skill5, skill6;
    List<String> skills;
    Button go_time;

    //TIMES Variables
    LinearLayout add_time;
    Button from_today, till_today, from_tomorrow, till_tomorrow, from_overmorrow, till_overmorrow;
    Button select_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_profile);


        //SKILLS
        skill1 = findViewById(R.id.skill1);
        skill2 = findViewById(R.id.skill2);
        skill3 = findViewById(R.id.skill3);
        skill4 = findViewById(R.id.skill4);
        skill5 = findViewById(R.id.skill5);
        skill6 = findViewById(R.id.skill6);

        //get skills and add to ArrayList
        skills = new ArrayList<>();
        skills.add(skill1.getText().toString());
        skills.add(skill2.getText().toString());
        skills.add(skill3.getText().toString());
        skills.add(skill4.getText().toString());
        skills.add(skill5.getText().toString());
        skills.add(skill6.getText().toString());

        //TIMING PREFERENCES
    }
}
