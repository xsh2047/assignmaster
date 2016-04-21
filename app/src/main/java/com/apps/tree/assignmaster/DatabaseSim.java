package com.apps.tree.assignmaster;

import com.apps.tree.assignmaster.login.User;
import com.apps.tree.assignmaster.task.Task;

import java.util.Date;

/**
 * Created by zabie on 4/20/2016.
 */
public class DatabaseSim {

    public static void populateTasks(){
        deleteAllTasks();
        Task task1 = new Task();
        Task task2 = new Task();
        task1.setName("Assignment 1");
        task1.setDate(new Date(System.currentTimeMillis()));
        task1.setSummary("Sample Summary");
        task1.setType("Assignment");
        task1.setFile("/Assignment.docx");
        task2.setName("Exam 1");
        task2.setDate(new Date(System.currentTimeMillis() + 50000000));
        task2.setSummary("Exam for COMP1161");
        task2.setType("Exam");
        task2.setFile("/Exam.pdf");
        task1.save();
        task2.save();
    }

    public static void populateUsers(){
        deleteAllUsers();
        User user1 = new User((long) 620084236);
        user1.setName("Xavier Bryson");
        user1.setPassword("1234");
        user1.save();
    }

    public static void deleteAllTasks(){
        if(Task.listAll(Task.class) != null){
            Task.deleteAll(Task.class);
        }
    }

    public static void deleteAllUsers(){
        if(User.listAll(User.class) != null){
            User.deleteAll(User.class);
        }
    }
}
