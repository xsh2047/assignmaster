package com.apps.tree.assignmaster.activities;

import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.Toast;

import com.apps.tree.assignmaster.CustomAdapter;
import com.apps.tree.assignmaster.DatabaseSim;
import com.apps.tree.assignmaster.R;
import com.apps.tree.assignmaster.task.TasksController;
import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class CalendarActivity extends AppCompatActivity {

    CalendarView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Schedule");
       // getActionBar().setDisplayHomeAsUpEnabled(true);
        /*cal = (CalendarView) findViewById(R.id.calendar_view);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                //TODO
            }
        });*/
        final CaldroidListener listener = new CaldroidListener() {
            @Override
            public void onSelectDate(Date date, View view) {
                String text = date.toString();
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
                TasksController.upcommingTasks(date);
            }

            @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
            }
        };
        TasksController tasksController = new TasksController();
        DatabaseSim.populateTasks();
        CaldroidFragment calFragment = new CaldroidFragment();
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
        calFragment.setArguments(args);
        calFragment.setCaldroidListener(listener);
        android.support.v4.app.FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, calFragment);
        t.commit();

        calFragment.setBackgroundDrawableForDates(TasksController.dueDates());
    }
}
