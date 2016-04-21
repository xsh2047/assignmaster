package com.apps.tree.assignmaster.task;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by zabie on 4/5/2016.
 */
public class TasksController {

    public static Schedule mainSchedule = new Schedule();
    public static Schedule calSchedule = new Schedule();

    public static void changeNote(){

    }

    public static void changeSettings() {

    }

    public static void upcommingTasks(Date date){
        mainSchedule.setTasks(mainSchedule.getDayTasks(date));
    }

    public static ArrayList<Task> tasks(){
        return mainSchedule.fetchTasks();
    }

    public static HashMap<Date, Drawable> dueDates(){
        //ArrayList<Date> dates = new ArrayList<>();
        HashMap<Date, Drawable> dateMap = new HashMap<>();
        ColorDrawable green = new ColorDrawable(Color.GREEN);
        ColorDrawable yellow = new ColorDrawable(Color.YELLOW);
        ArrayList<Task> tasks = tasks();
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getType().equals("Assignment")){
                dateMap.put(tasks.get(i).getDate(), green);
            }else {
                dateMap.put(tasks.get(i).getDate(), yellow);
            }
        }
        return dateMap;
    }

}
