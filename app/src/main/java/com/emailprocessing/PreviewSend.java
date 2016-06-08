package com.emailprocessing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.emailprocessing.email.domain.Email;
import com.emailprocessing.email.respository.settings.Impl.BusinessRespositoryImpl;
import com.emailprocessing.email.respository.settings.Impl.GmailRespositoryImpl;
import com.example.zubair.myapplication.R;


public class PreviewSend extends AppCompatActivity {
    private  EditText previewText;
    private  Button activateButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview_and_send);

        activateButton = (Button) findViewById(R.id.viewButton);
        previewText = (EditText) findViewById(R.id.editText3);
        String finalText = "Email Type: "+getIntent().getExtras().getString("emailType")+"\n"+"Address: " + getIntent().getExtras().getString("address")+"\n"+"Message Body: " + getIntent().getExtras().getString("text");
        previewText.setText(finalText);


        activateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                if(getIntent().getExtras().getString("emailType").contains("business")) {
                    BusinessRespositoryImpl bImpl = new BusinessRespositoryImpl(getApplicationContext());
                    Email insertedEntity = bImpl.save(new Email.Builder()
                            .address(getIntent().getExtras().getString("address"))
                            .description(getIntent().getExtras().getString("text"))
                            .build());
                }
                else if (getIntent().getExtras().getString("emailType").contains("GMail")) {
                    GmailRespositoryImpl gImpl = new GmailRespositoryImpl(getApplicationContext());
                    Email insertedEntity = gImpl.save(new Email.Builder()
                            .address(getIntent().getExtras().getString("address"))
                            .description(getIntent().getExtras().getString("text"))
                            .build());
                }

                Intent i = new Intent(getApplicationContext(), SentMail.class);
                i.putExtra("emailType", getIntent().getExtras().getString("emailType"));
                startActivity(i);
            }
        });




    }
}
