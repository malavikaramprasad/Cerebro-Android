package com.hci.project.cerebro;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


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
