package com.apps.tree.assignmaster.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.apps.tree.assignmaster.DatabaseSim;
import com.apps.tree.assignmaster.R;
import com.apps.tree.assignmaster.login.LoginController;

public class LoginActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        if(sharedpreferences.getString("status", "null").equals("loggedIn")){
            login();
        }

        final EditText uName = (EditText) findViewById(R.id.etUsername);
        final EditText pass = (EditText) findViewById(R.id.etPassword);
        final Button bLogin = (Button) findViewById(R.id.btnLogin);

        DatabaseSim.populateUsers();
        if (bLogin != null) {
            bLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(!uName.getText().toString().matches("") && !pass.getText().toString().matches("") ){
                        Long id = Long.valueOf(uName.getText().toString());
                        String password = pass.getText().toString();
                        String response = LoginController.authenticate(id, password);
                        if(response.equals("Success")){
                            SharedPreferences.Editor editor = sharedpreferences.edit();
                            editor.putLong("id", id);
                            editor.putString("pass", password);
                            editor.putString("status", "loggedIn");
                            editor.apply();
                            login();
                        }else{
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });
        }

    }

    private void login(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}
