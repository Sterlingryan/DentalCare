package com.sterlingryan.dental_care;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;

/**
 * Created by Sterling Ryan on 5/1/2016.
 */
public class WizardBrushingActivity extends AppCompatActivity{

    private Button btnNext;
    private Button btnPrev;
    private NumberPicker pckrBrushingHealth;
    private String[] brushingState;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_brushing);

        Resources rcs = getResources();

        //set picker to the main_activity picker
        pckrBrushingHealth = (NumberPicker) findViewById(R.id.numberPicker2);
        brushingState = rcs.getStringArray(R.array.wizardBrushingHealthBar);

        pckrBrushingHealth.setMinValue(0);
        //Sets the number of values in the picker.
        pckrBrushingHealth.setMaxValue(brushingState.length-1);

        //Specify the NumberPicker data source as array elements
        pckrBrushingHealth.setDisplayedValues(brushingState);

        //Gets whether the selector wheel wraps when reaching the min/max value.
        pckrBrushingHealth.setWrapSelectorWheel(true);

        //Prevents keyboard from popping up.
        pckrBrushingHealth.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);

        btnNext = (Button) findViewById(R.id.brushingNextbutton);

        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardBrushingActivity.this, WizardSmokingActivity.class);
                startActivity(intent);
            }
        });

        btnPrev = (Button) findViewById(R.id.brushingPrevbutton);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardBrushingActivity.this, WizardCarerActivity.class);
                startActivity(intent);
            }
        });
    }
}
