package com.example.anish.automatedio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    EditText name,email,details;
    RatingBar rbar;
    RadioGroup rg;
    Button send;
    RadioButton rb;
    String sendTo,sub,n,e,d,rate,body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name=(EditText)findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
        details=(EditText)findViewById(R.id.details);
        rbar=(RatingBar)findViewById(R.id.ratingBar);
        rg=(RadioGroup)findViewById(R.id.rg);
        send=(Button)findViewById(R.id.button);


            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    n=name.getText().toString();
                    e=email.getText().toString();
                    d=details.getText().toString();
                    rate=String.valueOf(rbar.getRating());

                    sendTo="anishkumarrocks11@gmail.com";
                    body=String.format("%s\n%s\n%s%s\n%s",n,e,"Rating=",rate,d);
                    rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                    if (rg.getCheckedRadioButtonId() != -1) {
                        sub = rb.getText().toString();
                    }
                    if(n.equals("") || e.equals("") || d.equals("") ||rate.equals("")){
                        Toast.makeText(getApplicationContext(),"Fill all details",Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                        intent.putExtra(Intent.EXTRA_TEXT, body);
                        intent.setData(Uri.parse("mailto:" + sendTo)); // or just "mailto:" for blank
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                        startActivity(intent);
                    }
                }
            });
    }
}
