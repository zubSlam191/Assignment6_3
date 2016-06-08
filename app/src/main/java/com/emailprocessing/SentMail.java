package com.emailprocessing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.domain.GMail;
import com.emailprocessing.email.respository.settings.Impl.BusinessRespositoryImpl;
import com.emailprocessing.email.respository.settings.Impl.EmailsRespositoryImpl;
import com.emailprocessing.email.respository.settings.Impl.GmailRespositoryImpl;
import com.example.zubair.myapplication.R;

import java.util.Set;


public class SentMail extends AppCompatActivity {
    private  EditText emailAddress;
    private  EditText password;
    private  EditText orgcode;
    private  Button activateButton;
    private  TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sent_mail);
        txtView = (TextView) findViewById(R.id.textView4);
        activateButton = (Button) findViewById(R.id.activate_activateButton);
        GmailRespositoryImpl gmailRepo = new GmailRespositoryImpl(getApplicationContext());
        BusinessRespositoryImpl busiRepo = new BusinessRespositoryImpl(getApplicationContext());
        Set<Email> allBusiEmails = busiRepo.findAll();

        Set<Email> allGMail = gmailRepo.findAll();
        txtView.setText("Business: \n");

        for(Email mail:allBusiEmails)
        {
            txtView.append("ID: "+mail.getId()+
                    "\n Address: " + mail.getAddress()+
                    "\n Text: " + mail.getDescription()+"\n\n");
        }

        txtView.append("GMail: \n");
        for(Email mail:allGMail)
        {
            txtView.append("ID: "+mail.getId()+
                    "\n Address: " + mail.getAddress()+
                    "\n Text: " + mail.getDescription()+"\n\n");
        }


        activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Do something in response to button click

                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

    }
}
