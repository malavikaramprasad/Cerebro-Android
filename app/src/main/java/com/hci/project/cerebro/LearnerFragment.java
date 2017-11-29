package com.hci.project.cerebro;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LearnerFragment extends Fragment implements View.OnClickListener{


    public LearnerFragment() {
        // Required empty public constructor
    }

    public static interface LearnerListener {
        public void onLoad();
    }

    public LearnerListener listener1;

    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_learner, container,false);
        btn = (Button) rootView.findViewById(R.id.submit_question);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                Log.i("SubmitButton", "Button1 Clicked");

            }
        });
        return inflater.inflate(R.layout.fragment_learner, container, false);
    }

    public void onClick(View v){
        Button submitQuestion = getActivity().findViewById(R.id.submit_question);
        submitQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("SubmitButton", "Button1 Clicked");
            }
        });
    }

    public void onAttach() {
        Button submitQuestion = getActivity().findViewById(R.id.submit_question);
        submitQuestion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.i("SubmitButton", "Button1 Clicked");
            }
        });
    }

}
