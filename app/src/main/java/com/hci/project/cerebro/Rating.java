package com.hci.project.cerebro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Rating extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        TextView tutorName = (TextView) findViewById(R.id.tutor);
        TextView req_question = (TextView) findViewById(R.id.req_question);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                System.out.println("Rating Selected :: " + String.valueOf(rating));
                //txtRatingValue.setText(String.valueOf(rating));

            }
        });

        Button submitbutton = (Button) findViewById(R.id.submitbttn);

        submitbutton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

    }
}
