package com.myapplicationdev.android.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare all the variables that I have labelled as ID
    RadioGroup rg1, rg2, rg3;
    RadioButton rb1, rb2, rb3;
    EditText et;
    TextView tv1, tv2, tv3;
    int selected1, selected2, selected3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get the button and set the OnClickListener
        Button btnDone = findViewById(R.id.button);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
              public void onClick(View v) {
                RadioGroup rg1 = findViewById(R.id.rg1);
                RadioGroup rg2 = findViewById(R.id.rg2);
                RadioGroup rg3 = findViewById(R.id.rg3);
                selected1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = findViewById(selected1);
                selected2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = findViewById(selected2);
                selected3 = rg3.getCheckedRadioButtonId();
                RadioButton rb3 = findViewById(selected3);
                EditText et = findViewById(R.id.editText);
                TextView tv1 = findViewById(R.id.textView);
                TextView tv2 = findViewById(R.id.textView3);
                TextView tv3 = findViewById(R.id.textView5);
                //Put the TextView, which is the questions and the radio buttons that is chosen into an array
                String[] info = {tv1.getText().toString(), rb1.getText().toString(), tv2.getText().toString(), rb2.getText().toString(), tv3.getText().toString(), rb3.getText().toString(), et.getText().toString()};
                //Create an intent to start another activity called MainActivity2(which we would create later)
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                //Pass the String array holding the question and the selected radio buttons to new activity
                i.putExtra("info", info);
                //Start new activity
                startActivity(i);
                //mutiple shared preference files identified by name that specify the first parameter which is MainActivity
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefedit = prefs.edit();
                prefedit.putInt("read", selected1);
                prefedit.putInt("arrive", selected2);
                prefedit.putInt("attempt", selected3);
                prefedit.putString("reflect", et.getText().toString());
                prefedit.commit();
}
        });

    }

     @Override
     protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        int read = prefs.getInt("read", 0);
        int arrive = prefs.getInt("arrive", 0);
        int attempt = prefs.getInt("attempt", 0);
        String reflect = prefs.getString("reflect", "");
        EditText et = findViewById(R.id.editText);
        et.setText(reflect);
        if (read!=0 && arrive!=0 && attempt!=0){
            RadioButton rb1 = findViewById(read);
            rb1.setChecked(true);
            RadioButton rb2 = findViewById(arrive);
            rb2.setChecked(true);
            RadioButton rb3 = findViewById(attempt);
            rb3.setChecked(true);
        }

    }
}
