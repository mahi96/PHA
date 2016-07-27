package com.se.personalhealthassistant;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class Main extends AppCompatActivity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    TextView textAlarmPrompt;
    TimePickerDialog timePickerDialog;

    final static int RQS_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    }
    public void docTips(View view)
    {
        Intent intent = new Intent(Main.this, Doctips.class);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        startActivity(intent);
    }
    public void getPres(View view)
    {
        Intent intent = new Intent(Main.this, MainActivity.class);
        overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
        startActivity(intent);
    }
    public void searchNearby(View view)
    {
        Intent intent = new Intent(Main.this, Nearby.class);
        overridePendingTransition(R.anim.push_down_in,R.anim.push_down_out);
        startActivity(intent);
    }
    public void setAlarm(View view)
    {
        Intent intent = new Intent(Main.this, AlarmActivity.class);
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
        startActivity(intent);
    }
}
