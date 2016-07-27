package com.se.personalhealthassistant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText e1;
        e1=(EditText)findViewById(R.id.editText);
        final Button b1 = (Button) findViewById(R.id.getmed);
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myIntent;
                myIntent = new Intent(MainActivity.this, NextActivity.class);
                myIntent.putExtra("symptom",e1.getText().toString());
                MainActivity.this.startActivity(myIntent);

            }
        });

    }
}
