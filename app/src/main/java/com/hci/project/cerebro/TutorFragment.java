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
    ListView lv_new, lv_old;

    public static List<SubmitQuestion> accepted;
    public static List<SubmitQuestion> pending;
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
        map.put("X-Authorization", token);
        TutorRequestsAPI requests_api = retrofit.create(TutorRequestsAPI.class);
        requests_api.getRequests(map).enqueue(new Callback<TutorRequests>()
        {
            @Override
            public void onResponse(Call<TutorRequests> call, Response<TutorRequests> response) {
                if (response.isSuccessful()) {
                    System.out.println("Response Requests :::" + response.body());
                    TutorRequests requests = response.body();
                    accepted = requests.accepted;
                    pending = requests.pending;
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


//        lv_new=getActivity().findViewById(R.id.newRequests);
//        lv_old=getActivity().findViewById(R.id.oldRequests);
//
//        lv_new.setItemChecked(pos, true);
//        lv_old.setItemChecked(pos, true);
//
//        //Accepted Tasks ListView
//        ArrayList<String> ques = new ArrayList<>();
//        ArrayList<String> uid = new ArrayList<>();
//        String[] questions, user_ids;
//        for (int i=0; i<accepted.size();i++){
//            ques.add(accepted.get(i).description);
//            uid.add(String.valueOf(accepted.get(i).id));
//        }
//        questions = ques.toArray(new String[ques.size()]);
//        user_ids = uid.toArray(new String[uid.size()]);

        Intent intent= new Intent(getContext(), MessageFromLearner.class);
        startActivity(intent);


        // Inform the QuoteViewerActivity that the item in position pos has been selected

    }

}
