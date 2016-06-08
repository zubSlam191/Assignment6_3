package com.emailprocessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.zubair.myapplication.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView dBManager = (TextView) findViewById(R.id.openDBEditor);

        TextView cOrV = (TextView ) findViewById(R.id.viewMail);

        cOrV.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), ActivateActivity.class);
                startActivity(i);
            }
        });

        dBManager.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
                startActivity(i);
            }
        });


    }
}