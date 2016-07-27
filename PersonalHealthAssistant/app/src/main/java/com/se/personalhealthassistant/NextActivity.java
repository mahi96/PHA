package com.se.personalhealthassistant;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NextActivity extends AppCompatActivity {

    private final String SAMPLE_DB_NAME = "pha";
    private final String SAMPLE_TABLE_NAME = "meds";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        String n;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                n= null;
            } else {
                n= extras.getString("symptom");
            }
        } else {
            n= (String) savedInstanceState.getSerializable("symptom");
        }
        if (n != null) {
            n=n.trim();
        }
        String j= null;
        if (n != null) {
            j = n.toLowerCase();
        }


        ArrayList<String> results = new ArrayList<String>();
        SQLiteDatabase sampleDB = null;
        try {

            sampleDB =  this.openOrCreateDatabase(SAMPLE_DB_NAME, MODE_PRIVATE, null);

            sampleDB.execSQL("CREATE TABLE IF NOT EXISTS " +
                    SAMPLE_TABLE_NAME +
                    " (medicine VARCHAR, symptom VARCHAR, remedy VARCHAR);");


                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Crocin (500mg)','fever','Lemon Juice, Ginger, Honey');");

                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Zyrtec Tablets','fever','Lemon Juice, Ginger, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Dispar (300mg) ','fever','Lemon Juice, Ginger, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values (' Dispirin ','fever','Lemon Juice, Ginger, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values (' Dolo (300mg) ','fever','Lemon Juice, Ginger, Honey');");

                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Crocin (500mg)','headache','Mint Juice, Basil, Take a Sleep');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Delsym','cough','Fenugreek seeds, Garlic, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Mucinex','cough','Fenugreek seeds, Garlic, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Robitussin','cough','Fenugreek seeds, Garlic, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Tylenol','fever','Lemon Juice, Ginger, Honey');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Crocin Cold & Flu','cold','Drink Hot Liquids, Gargle with Warm Salt Water, Blow your Nose');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Sudafed','cold','Drink Hot Liquids, Gargle with Warm Salt Water, Blow your Nose');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Salanie Nasal Spray','cold','Drink Hot Liquids, Gargle with Warm Salt Water, Blow your Nose');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Ibuprofen Tablets','headache','Mint Juice, Basil, Take a Sleep');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Excedrin Tab','cold','Drink Hot Liquids, Gargle with Warm Salt Water, Blow your Nose');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Painaid','headache','Mint Juice, Basil, Take a Sleep');");
                sampleDB.execSQL("INSERT INTO " +
                        SAMPLE_TABLE_NAME +
                        " Values ('Combiflam','headache','Mint Juice, Basil, Take a Sleep');");



            final TextView t= (TextView) findViewById(R.id.textView3);
            Cursor c = sampleDB.rawQuery("SELECT DISTINCT remedy FROM " +
                    SAMPLE_TABLE_NAME + " where symptom='"+j+"'", null);
            String rem=null;
            if (c != null) {
                if (c.moveToFirst()) {
                    rem = c.getString(c.getColumnIndex("remedy")); }}
                t.setText(rem);

             c = sampleDB.rawQuery("SELECT DISTINCT medicine, remedy FROM " +
                SAMPLE_TABLE_NAME + " where symptom='"+j+"'", null);

            if (c != null) {
                if (c.moveToFirst()) {
                    do {
                        String med = c.getString(c.getColumnIndex("medicine"));

                        results.add("\nMEDICINE : " + med+"\n");
                    } while (c.moveToNext());
                }
            }
          //  Log.d("array",res);
            ListView l=(ListView)findViewById(R.id.listView);
            ArrayAdapter<String> arrayAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results);
            l.setAdapter(arrayAdapter);
             //  this.setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, results));
             // getListView().setTextFilterEnabled(true);
        }
     catch (SQLiteException se ) {
        Log.e(getClass().getSimpleName(), "Could not create or Open the database");
    }
    finally {
        if (sampleDB != null)
            sampleDB.execSQL("DELETE from "+ SAMPLE_TABLE_NAME);
            sampleDB.close();
    }

    }
}
