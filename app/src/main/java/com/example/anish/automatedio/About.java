package com.example.anish.automatedio;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class About extends AppCompatActivity {

    TextView tv;
    ImageView twitter,fb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tv=(TextView)findViewById(R.id.textView);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(About.this,Help_activity.class);
                startActivity(i);
            }
        });

        twitter=(ImageView)findViewById(R.id.imageView5);
        fb=(ImageView)findViewById(R.id.imageView4);

        twitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent();
                in.setAction(Intent.ACTION_VIEW);
                in.addCategory(Intent.CATEGORY_BROWSABLE);
                in.setData(Uri.parse("https://www.twitter.com/automate.io/"));
                startActivity(in);
                Toast.makeText(getApplicationContext(),"Twitter",Toast.LENGTH_SHORT).show();
            }
        });

        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/automate/"));
                in1.addCategory(Intent.CATEGORY_BROWSABLE);
                startActivity(in1);
                Toast.makeText(getApplicationContext(),"Facebook",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
