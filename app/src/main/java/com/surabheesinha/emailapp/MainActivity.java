package com.surabheesinha.emailapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edittextto,edittextSubject,edittextMessage;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edittextto =(EditText)findViewById(R.id.editTextto);
        edittextSubject=(EditText)findViewById(R.id.editTextsubject);
        edittextMessage=(EditText)findViewById(R.id.editTextMessage);
        send= (Button)findViewById(R.id.button1);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to = edittextto.getText().toString();
                String subject = edittextSubject.getText().toString();
                String message = edittextMessage.getText().toString();

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL,to);
                email.putExtra(Intent.EXTRA_SUBJECT,subject);
                email.putExtra(Intent.EXTRA_TEXT,message);

                email.setType("messsage/rfc822");
                startActivity(Intent.createChooser(email,"Choose a Client"));
            }
        });

    }
}
