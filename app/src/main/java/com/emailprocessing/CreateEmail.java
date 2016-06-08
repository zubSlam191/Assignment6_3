package com.emailprocessing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.zubair.myapplication.R;

import java.util.ArrayList;


public class CreateEmail extends AppCompatActivity {
    private  Button activateButton;
    private Spinner spinner;
    private TextView editText2;
    private TextView editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_email);
        activateButton = (Button) findViewById(R.id.viewButton);
        spinner = (Spinner) findViewById(R.id.spinner);
        editText2 = (TextView) findViewById(R.id.editText2);
        editText = (TextView) findViewById(R.id.editText);
        ArrayList<String> spinArray = new ArrayList();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.emails_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


         activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click
                Intent i = new Intent(getApplicationContext(), PreviewSend.class);
                i.putExtra("emailType", spinner.getSelectedItem().toString());
                i.putExtra("address", editText2.getText().toString());
                i.putExtra("text", editText.getText().toString());
                startActivity(i);

            }
        });




    }
}
