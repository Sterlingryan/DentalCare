package com.sterlingryan.dental_care;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    private NumberPicker pckrAgeGroup;
    private Button btnNext;
    private String[] ageGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources rcs = getResources();

        //set picker to the main_activity picker
        pckrAgeGroup = (NumberPicker) findViewById(R.id.numberPicker);
        ageGroups = rcs.getStringArray(R.array.ageGroups);

        pckrAgeGroup.setMinValue(0);
        //Sets the number of values in the picker.
        pckrAgeGroup.setMaxValue(ageGroups.length-1);

        //Specify the NumberPicker data source as array elements
        pckrAgeGroup.setDisplayedValues(ageGroups);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        //pckrAgeGroup.setWrapSelectorWheel(true);

        //Prevents keyboard from popping up.
        pckrAgeGroup.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        btnNext = (Button) findViewById(R.id.nextbutton);

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WizardCarerActivity.class);
                startActivity(intent);
            }
        });
    }

}
