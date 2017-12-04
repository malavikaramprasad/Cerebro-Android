package com.hci.project.cerebro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class TutorProfilePage extends AppCompatActivity {
    Button request, slot1, slot2, slot3;
    RatingBar rating;
    TextView skill_tv, tutor_name;
    ListView skill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorprofilepage);
        int position=getIntent().getIntExtra("key_position",0);
        ArrayList<User> userList = LearnerFragment.userList;
        System.out.println(userList.get(position).email);
        User user = userList.get(position);


        tutor_name = findViewById(R.id.tutor_name);
        rating = findViewById(R.id.rating);
        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);
        request = findViewById(R.id.request);
        skill_tv = findViewById(R.id.skill_tv);

        tutor_name.setText(user.first_name);
        rating.setRating(user.rating);
        skill_tv.setText("I can help you with your question on " + LearnerFragment.asked_topic + " during one of the following time slots");

        //retrieve the data of the specific tutor at that position
        //and populate the tutorprofilepage
//        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
//        cal.set(user.booked_slots.get(0).getStart_time().get);
//        slot1.setText(String.valueOf(user.start_time));




    }
}
