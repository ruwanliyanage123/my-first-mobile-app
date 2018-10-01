package com.ruwan.myfirstmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    private Firebase usernameRef;
    private Firebase passwordRef;
    Button btn;
    String name;
    String pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btn      = (Button)findViewById(R.id.btn);

        Firebase.setAndroidContext(this);
        usernameRef = new Firebase("https://myfirstmobileapp-38fbf.firebaseio.com/username");
        passwordRef = new Firebase("https://myfirstmobileapp-38fbf.firebaseio.com/password");


        name = username.getText().toString();
        pass = password.getText().toString();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usernameRef.setValue(username.getText().toString());
                passwordRef.setValue(password.getText().toString());
            }
        });
    }
}
