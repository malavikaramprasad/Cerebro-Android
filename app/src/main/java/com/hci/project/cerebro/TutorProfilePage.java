package com.hci.project.cerebro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

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
        System.out.println(userList.get(0).email);

        tutor_name = findViewById(R.id.tutor_name);
        tutor_name.setText(userList.get(0).first_name);
;

        //retrieve the data of the specific tutor at that position
        //and populate the tutorprofilepage




    }
}
