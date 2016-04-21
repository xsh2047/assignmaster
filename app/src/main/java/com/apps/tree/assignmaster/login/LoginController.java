package com.apps.tree.assignmaster.login;

/**
 * Created by zabie on 4/5/2016.
 */
public class LoginController {

    private static User testuser;

    public static String authenticate(Long id, String password){
        if(id >= 620000000 && id < 620100000){
            testuser = User.findById(User.class, id);
            if(testuser == null){
                return "No Such User Exists.";
            }else if(testuser.getPassword().equals(password)){
                return "Success";
            }else{
                return "Invalid Password";
            }
        }
        return "Invalid ID.";
    }

}
