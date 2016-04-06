package com.apps.tree.assignmaster.task;

import java.util.ArrayList;

/**
 * Created by zabie on 4/5/2016.
 */
public class TasksController {

    public boolean defaultView;
    public Schedule schedule;

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

}
