package com.hci.project.cerebro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListOfTutors extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ArrayList<String> names = new ArrayList<>();
            ArrayList<String> ratings = new ArrayList<>();
            for (int i = 0; i<userList.size(); i++){
                names.add(userList.get(i).first_name);
                ratings.add(String.valueOf(userList.get(i).rating));
            }

            String[] names_list = names.toArray(new String[userList.size()]);
            String[] rating_list = ratings.toArray(new String[userList.size()]);
            switch (item.getItemId()) {
                case R.id.distance:
                    //sort tutor list based on distance and store it in tutor array
                    ListView lv=(ListView)findViewById(R.id.listview);
//                    ArrayAdapter adapter= new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_list_of_tutors,R.id.listview,  getResources().getStringArray(R.array.Tutors));
                    adapter1 = new TutorListViewAdapter(ListOfTutors.this, names_list, rating_list);
                    lv.setAdapter(adapter1);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent= new Intent(getApplicationContext(), TutorProfilePage.class);
                            //sending the position of the tutor selected
                            //to the tutor profile activity
                            intent.putExtra("key_position",i );
                            intent.putExtra("value", userList);

                            startActivity(intent);
                        }
                    });
                    return true;
                case R.id.rating:
                    //sort tutor list based on rating and store it in tutor array

                     lv=(ListView)findViewById(R.id.listview);
//                    ArrayAdapter adapter2= new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_list_of_tutors,R.id.listview,  getResources().getStringArray(R.array.Tutors));
                    adapter2 = new TutorListViewAdapter(ListOfTutors.this, names_list, rating_list);
                    lv.setAdapter(adapter2);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent= new Intent(getApplicationContext(), TutorProfileActivity.class);

                            //sending the position of the tutor selected
                            //to the tutor profile activity
                            intent.putExtra("key_position",i );
                            intent.putExtra("value", userList);
                            startActivity(intent);
                        }
                    });
                    return true;
                case R.id.availability:
                    //sort tutor list based on availability and display it in the listview

                    lv=(ListView)findViewById(R.id.listview);
//                    ArrayAdapter adapter3= new ArrayAdapter<String>(getApplicationContext(),R.layout.activity_list_of_tutors,R.id.listview, getResources().getStringArray(R.array.Tutors));
                    adapter3 = new TutorListViewAdapter(ListOfTutors.this, names_list, rating_list);
                    lv.setAdapter(adapter3);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            Intent intent= new Intent(getApplicationContext(), TutorProfileActivity.class);
                            //sending the position of the tutor selected
                            //to the tutor profile activity
                            intent.putExtra("key_position",i );
                            intent.putExtra("value", userList);
                            startActivity(intent);
                        }
                    });

                    return true;
            }
            return false;
        }
    };

    ArrayList<User> userList = LearnerFragment.userList;
    TutorListViewAdapter adapter, adapter1, adapter2, adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_tutors);

        ListView lv= (ListView) findViewById(R.id.listview);
        String [] tutors = getResources().getStringArray(R.array.Tutors);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> ratings = new ArrayList<>();
        for (int i = 0; i<userList.size(); i++){
            names.add(userList.get(i).first_name);
            ratings.add(String.valueOf(userList.get(i).rating));
        }

        String[] names_list = names.toArray(new String[userList.size()]);
        String[] rating_list = ratings.toArray(new String[userList.size()]);
//        ArrayAdapter adapter= new ArrayAdapter<String>(this, R.layout.list_item, R.id.row_element_name, getResources().getStringArray(R.array.Tutors));
//        ArrayAdapter adapter= new ArrayAdapter<User>(this, R.layout.activity_list_of_tutors, R.id.listview, userList);
         adapter = new TutorListViewAdapter(this, names_list, rating_list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent= new Intent(getApplicationContext(), TutorProfilePage.class);
                //sending the position of the tutor selected
                //to the tutor profile activity
                intent.putExtra("key_position",i );
                startActivity(intent);
            }
        });

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}