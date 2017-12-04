package com.hci.project.cerebro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
//        slot1.setText(String.valueOf(user.start_time))
        }
}
