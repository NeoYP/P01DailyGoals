package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tv = findViewById(R.id.textView8);
        Button btn = findViewById(R.id.button2);
        //Get the intent so as to get the "things" inside the intent
        Intent i = getIntent();
        //Get the String array named "info" we passed in
        String[] info = i.getStringArrayExtra("info");
        //Display the question and the selected radio button on the TextView
        tv.setText(info[0] + " : " + info[1] + "\n" + info[2] + " : " + info[3] + "\n" + info[4] + " : " + info[5] + "\n Reflection:" + info[6] + ".");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                //to return to the previous page
                finish();
            }
         });

    }
}
