package com.hci.project.cerebro;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



/**
 * A simple {@link Fragment} subclass.
 */
public class TutorFragment extends Fragment {
    ListView lv;


    public TutorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Fetch the requests of current user
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        final String BASE_URL = "http://cerebro-api.herokuapp.com/api/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        SharedPreferences settings = getActivity().getApplicationContext().getSharedPreferences("MyPref",0);
        String token = settings.getString("Current_User", "defaultvalue");
        Map<String, String> map = new HashMap<>();
        map.put("X-Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoidnBhbmRpMkB1aWMuZWR1IiwiZXhwIjoxNTEyMjkyODE2fQ.H0-W02QWR9XDHeOl_4IunGuvrDjGUHkGM0ZA_88ELXk");
        TutorRequestsAPI requests_api = retrofit.create(TutorRequestsAPI.class);
        requests_api.getRequests(map).enqueue(new Callback<TutorRequests>()
        {
            @Override
            public void onResponse(Call<TutorRequests> call, Response<TutorRequests> response) {
                if (response.isSuccessful()) {
                    System.out.println("Response Requests :::" + response.body());
                }
            }
            public void onFailure(Call<TutorRequests> call, Throwable t){
                t.printStackTrace();}
        });

        //End
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tutor, container, false);

    }


    public void onListItemClick(ListView l, View v, int pos, long id) {

        // Indicates the selected item has been checked

        lv=getActivity().findViewById(R.id.listview);

        lv.setItemChecked(pos, true);

        Intent intent= new Intent(getContext(), MessageFromLearner.class);
        startActivity(intent);


        // Inform the QuoteViewerActivity that the item in position pos has been selected

    }

}
