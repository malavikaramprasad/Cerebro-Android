package com.hci.project.cerebro;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

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

        Button sendRequest = (Button) findViewById(R.id.request);
        sendRequest.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView) {
                SharedPreferences sp = getApplication().getSharedPreferences("", 0);
                String deviceToken = sp.getString("", "");

                Gson gson = new GsonBuilder()
                        .setLenient()
                        .create();
                final String BASE_URL = "http://cerebro-api.herokuapp.com/api/";
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .build();

                SharedPreferences settings = getApplication().getApplicationContext().getSharedPreferences("MyPref",0);
                String usertoken = settings.getString("Current_User", "defaultvalue");
                int userId = 2; // Need to fetch later
                Time st = new Time(503000);
                Time et = new Time(2333000);

                Map<String, String> map = new HashMap<>();
                map.put("X-Authorization", usertoken);

                RequestTutorAPI reqtutor_api = retrofit.create(RequestTutorAPI.class);
                RequestTutor requestTutor = new RequestTutor(userId,st,et);
                reqtutor_api.reqTutor(map,userId,requestTutor).enqueue(new Callback<SubmitQuestion>()
                {
                    @Override
                    public void onResponse(Call<SubmitQuestion> call, Response<SubmitQuestion> response) {
                        if (response.isSuccessful()) {
                            System.out.println("Request Submitted :: " + response.body());
                        }
                    }
                    @Override
                    public void onFailure(Call<SubmitQuestion> call, Throwable t){
                        t.printStackTrace();}
                });



            }
        });

        }
}
