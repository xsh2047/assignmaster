package com.apps.tree.assignmaster.task;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by zabie on 4/5/2016.
 */
public class TasksController {

    public boolean defaultView;
    public Schedule schedule = new Schedule();

    public void changeNote(){

    }

    public void changeSettings() {

    }

    public ArrayList<Task> upcommingTasks(){
        return null;
    }

    public ArrayList<Task> tasks(){
        return schedule.fetchTasks();
    }

    public void populate(){
        Task.deleteAll(Task.class);
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setName("Assignment 1");
        task1.setDate(new Date(System.currentTimeMillis()));
        task1.setSummary("Sample Summary");
        task2.setName("Exam 1");
        task2.setDate(new Date(System.currentTimeMillis() * 2));
        task2.setSummary("Exam for COMP1161");
        task1.save();
        task2.save();
    }

}
