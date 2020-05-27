package com.example.sqlitedatabasee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, password, email, dob;
    Button register, cancel;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username= findViewById(R.id.username);
        password= findViewById(R.id.password);
        email= findViewById(R.id.email);
        dob= findViewById(R.id.dob);
        register= findViewById(R.id.register);
        cancel= findViewById(R.id.cancel);

        final DatabaseHelper databaseHelper = new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();
                String emailValue = email.getText().toString();
                String dobValue = dob.getText().toString();

                if (usernameValue.length()>1){
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username",usernameValue);
                    contentValues.put("password",passwordValue);
                    contentValues.put("email",emailValue);
                    contentValues.put("dob",dobValue);

                    databaseHelper.insertUser(contentValues);
                    Toast.makeText(RegisterActivity.this,"User registered successfully",Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(RegisterActivity.this,"Enter the values",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}
