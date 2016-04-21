package com.apps.tree.assignmaster.login;

import com.orm.SugarRecord;
import com.orm.dsl.Column;

/**
 * Created by zabie on 4/5/2016.
 */
public class User extends SugarRecord {

    public String name;

    @Column(name = "id", unique = true, notNull = true)
    public Long id;

    private String password;

    public User(Long idNum){
        this.id = idNum;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
