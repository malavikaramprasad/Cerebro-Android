package com.hci.project.cerebro;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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
    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_learner, container,false);
        btn = (Button) rootView.findViewById(R.id.submit_question);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View rootView) {
                Log.i("SubmitButton", "Button1 Clicked");
                System.out.println("Button Clicked");
                EditText topic = (EditText) rootView.findViewById(R.id.topic);
                String tag = topic.getText().toString();
                EditText desc = (EditText) rootView.findViewById(R.id.description);
                String description = desc.getText().toString();
               // registerQuestion(tag, description);
            }
        });
        return rootView;
    }

    public void registerQuestion(String tag, String description)
    {

        if(!TextUtils.isEmpty(tag) && !TextUtils.isEmpty(description)) {
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(CreateUser.class, new CustomGsonAdapter.UserAdapter())
                    .setLenient()
                    .create();
            final String BASE_URL = "http://cerebro-api.herokuapp.com/api/";
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            SubmitQuestionAPI submitQn_api = retrofit.create(SubmitQuestionAPI.class);
            SubmitQuestion submitQuestion = new SubmitQuestion(tag,description,"sdsd");
            submitQn_api.addQuestion(submitQuestion).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    if (response.isSuccessful()) {
                        System.out.println("Response Bodyyyyy : :: : " + response.toString());
                        System.out.println("Token : :: : " + response.body());
                        System.out.println("Response  :::" + response.body().toString());
                    }
                }
                @Override
                public void onFailure(Call<User> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        }
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
