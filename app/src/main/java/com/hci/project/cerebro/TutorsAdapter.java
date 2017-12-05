package com.hci.project.cerebro;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Malavika Ramprasad on 12/5/2017.
 */

public class TutorsAdapter extends BaseAdapter {
    Activity context;
    List<SubmitQuestion> questions;

    public TutorsAdapter(Activity context, List<SubmitQuestion> questions) {
        super();
        this.context = context;
        this.questions = questions;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public Object getItem(int i) {
        return questions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder {
        TextView txtViewTitle;
        TextView txtViewDescription;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TutorListViewAdapter.ViewHolder holder;
        LayoutInflater inflater = context.getLayoutInflater();

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null);
            holder = new TutorListViewAdapter.ViewHolder();
            holder.txtViewTitle = (TextView) convertView.findViewById(R.id.row_element_name);
            holder.txtViewDescription = (TextView) convertView.findViewById(R.id.row_element_rating);
            convertView.setTag(holder);
        } else {
            holder = (TutorListViewAdapter.ViewHolder) convertView.getTag();
        }

//        holder.txtViewTitle.setText(title[position]);
        holder.txtViewDescription.setText(questions.get(position).getDescription());

        return convertView;
    }
}
