package com.hci.project.cerebro;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TutorProfileActivity extends AppCompatActivity {

    //SKILLS Variables
    EditText skill1, skill2, skill3, skill4, skill5, skill6;
    List<String> skills;
    Button from_time, till_time;
    Button go_location, skip;
    private int mHour, mMinute;

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
        from_time = findViewById(R.id.from_time);
        till_time = findViewById(R.id.till_time);

        //Go to choose location
        go_location = findViewById(R.id.go_location);
        go_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TutorProfileActivity.this, TutoringLocationActivity.class);
                startActivity(intent);
            }
        });

        //SKIP to dashboard
        skip = findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TutorProfileActivity.this, DrawerActivity.class);
                startActivity(intent);
            }
        });

    }

    public void onClick(View v) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
        if (v==from_time) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            from_time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v==till_time) {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            till_time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
    }
}