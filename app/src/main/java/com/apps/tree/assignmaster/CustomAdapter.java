package com.apps.tree.assignmaster;

import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, View convertView, ViewGroup parent) {

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

        final Task task = getItem(position);
        viewHolder.textViewName.setText(task.getName());
        viewHolder.textViewDate.setText(task.getDate().toString().substring(0, 19));
        viewHolder.textViewDesc.setText(task.getSummary());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(v.getContext());
                dialog.setContentView(R.layout.item_info);
                TextView nameText = (TextView) dialog.findViewById(R.id.nameView);
                TextView dateText = (TextView) dialog.findViewById(R.id.dateView);
                TextView descText = (TextView) dialog.findViewById(R.id.descView);
                nameText.setText(task.getName());
                dateText.setText(task.getDate().toString().substring(0, 19));
                descText.setText(task.getSummary());
                dialog.setTitle(task.getType());
                Button openFile = (Button) dialog.findViewById(R.id.openButton);
                openFile.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(v.getContext(), task.getFile(), Toast.LENGTH_SHORT).show();
                    }
                });

                Button dialogButton = (Button) dialog.findViewById(R.id.close_button);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        return convertView;
    }



    private static class ViewHolder{
        TextView  textViewName;
        TextView  textViewDate;
        TextView  textViewDesc;

    }
}
