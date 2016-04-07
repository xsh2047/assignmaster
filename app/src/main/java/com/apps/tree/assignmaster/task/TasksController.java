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

    public Schedule mainSchedule = new Schedule();
    public Schedule calSchedule = new Schedule();

    public void changeNote(){

    }

    public void changeSettings() {

    }

    public ArrayList<Task> upcommingTasks(){
        return null;
    }

    public ArrayList<Task> tasks(){
        return mainSchedule.fetchTasks();
    }

    public HashMap<Date, Drawable> dueDates(){
        //ArrayList<Date> dates = new ArrayList<>();
        HashMap<Date, Drawable> dateMap = new HashMap<>();
        ColorDrawable green = new ColorDrawable(Color.GREEN);
        ColorDrawable yellow = new ColorDrawable(Color.YELLOW);
        ArrayList<Task> tasks = this.tasks();
        for (int i = 0; i < tasks.size(); i++){
            if (tasks.get(i).getType().equals("Assignment")){
                dateMap.put(tasks.get(i).getDate(), green);
            }else {
                dateMap.put(tasks.get(i).getDate(), yellow);
            }
        }
        return dateMap;
    }

    public void populate(){
        Task.deleteAll(Task.class);
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setName("Assignment 1");
        task1.setDate(new Date(System.currentTimeMillis()));
        task1.setSummary("Sample Summary");
        task1.setType("Assignment");
        task2.setName("Exam 1");
        task2.setDate(new Date(System.currentTimeMillis() + 50000000));
        task2.setSummary("Exam for COMP1161");
        task2.setType("Exam");
        task1.save();
        task2.save();
        mainSchedule.getTasks();
    }

}
