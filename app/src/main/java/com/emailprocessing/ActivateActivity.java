package com.emailprocessing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zubair.myapplication.R;


public class ActivateActivity extends AppCompatActivity {
    private  Button activateButton;
    private Button  viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activate);

        activateButton = (Button) findViewById(R.id.activate_activateButton);
        viewButton = (Button) findViewById(R.id.viewButton);


        activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(getApplicationContext(), CreateEmail.class);
                startActivity(i);

            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(), SentMail.class);
            startActivity(i);
        }});




    }
}
