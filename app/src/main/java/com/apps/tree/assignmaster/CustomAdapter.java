package com.apps.tree.assignmaster;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.apps.tree.assignmaster.task.Task;

import java.util.List;

/**
 * Created by zabie on 4/6/2016.
 */
public class CustomAdapter extends BaseAdapter {

    private List<Task> tasks;

    public CustomAdapter(List<Task> tasks)
    {
        this.tasks = tasks;
    }
    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Task getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = new ViewHolder();


        if(convertView == null)
        {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
            viewHolder.textViewName = (TextView)convertView.findViewById(R.id.textViewName);
            viewHolder.textViewDate = (TextView)convertView.findViewById(R.id.textViewDate);
            viewHolder.textViewDesc = (TextView)convertView.findViewById(R.id.textViewDesc);


            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Task task = getItem(position);
        viewHolder.textViewName.setText(task.getName());
        viewHolder.textViewDate.setText(task.getDate().toString().substring(0,19));
        viewHolder.textViewDesc.setText(task.getSummary());
        return convertView;
    }

    private static class ViewHolder{
        TextView  textViewName;
        TextView  textViewDate;
        TextView  textViewDesc;

    }
}
