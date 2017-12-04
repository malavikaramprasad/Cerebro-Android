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

/**
 * Created by niharika on 12/1/17.
 */

public class TutorProfilePage extends AppCompatActivity {
    Button Request, slot1, slot2, slot3;
    TextView skill_tv, tutor_name;
    ListView skill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorprofilepage);
        int position=getIntent().getIntExtra("key_position",0);
        ArrayList<User> userList = LearnerFragment.userList;
        System.out.println(userList.get(position).email);

        tutor_name = findViewById(R.id.tutor_name);
        tutor_name.setText(userList.get(position).first_name);
;

        //retrieve the data of the specific tutor at that position
        //and populate the tutorprofilepage

        Button sendRequest = (Button) findViewById(R.id.Request);
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
