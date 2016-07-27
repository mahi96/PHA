package com.se.personalhealthassistant;

import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class Doctips extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctips);

        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("A Month of Yoga: The Bridge Pose");
        listDataHeader.add("6 Reasons to Drink More Water");
        listDataHeader.add("4 Frozen Foods for a Budget");

        // Adding child data
        List<String> tips = new ArrayList<String>();
        tips.add("The Bridge Pose is a powerful tonic for body and mind. It provides an invigorating stretch for the chest, neck and spine.\n"+
                "Traditionally, its benefits are said to also include:\n1.Rejuvenating tired legs\n" +
                "2.Improving digestion\n" +
                "3.Relieving the symptoms of menopause \n" +
                "4.Reducing anxiety, fatigue, backache, headache and insomnia");
        List<String> tips1 = new ArrayList<String>();
        tips1.add("1. Healthy blood and bones. Your blood is over 80 percent water and your bones are over 50 percent water. Proper hydration is required to optimize creation of new blood and bone cells.\n" +

                "2. Toxin elimination. Skip the fancy (and costly) detox plans. Plain water naturally helps remove toxins through the lymphatic system, intestines and kidneys.\n" +

                "3. Lubricated joints. Water helps protect against wear and tear and can even help reduce joint pain.\n" +

                "4. Proper digestion. Water helps prevent constipation by adding bulk to stools and fluid to the colon. \n" +

                "5. Alertness. Even minor dehydration can lead to headaches, irritability, impaired concentration and fatigue.\n" +

                "6. Healthy skin. Water hydrates from the inside out, helping to maintain elasticity of the skin.");

        List<String> tips2 = new ArrayList<String>();
        tips2.add("1. Berries: frozen berries such as raspberries, blackberries and blueberries are perfect for adding to smoothies, while offering up antioxidants and fiber.\n"+
                "2. Edamame: a good source of isoflavones, frozen edamame is often easier to find than fresh.\n"+
        "3. Seafood: wild Alaskan salmon and black cod are sustainable seafood options that may be more cost-effective frozen than fresh.\n"+
                "4. Vegetables: look for frozen spinach, kale and other dark, leafy greens that have no added ingredients.");


        listDataChild.put(listDataHeader.get(0),tips); // Header, Child data
        listDataChild.put(listDataHeader.get(1), tips1);
        listDataChild.put(listDataHeader.get(2), tips2);
    }
}


