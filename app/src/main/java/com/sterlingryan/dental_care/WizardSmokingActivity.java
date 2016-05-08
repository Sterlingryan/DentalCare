package com.sterlingryan.dental_care;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sterling Ryan on 5/1/2016.
 */
public class WizardSmokingActivity extends AppCompatActivity {

    private Button btnFinish;
    private Button btnPrev;
    private Button btnYes;
    private Button btnNo;
    private Boolean isYesButtonClicked;
    private static final String TAG = "WizardSmokingActivity";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_smoking);

        btnFinish = (Button) findViewById(R.id.smokingFinishbutton);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardSmokingActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnPrev = (Button) findViewById(R.id.smokingPrevbutton);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardSmokingActivity.this, WizardBrushingActivity.class);
                startActivity(intent);
            }
        });


        isYesButtonClicked = true;
        btnYes = (Button) findViewById(R.id.yesButton);
        btnNo = (Button) findViewById(R.id.noButton);
        btnYes.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.DARKEN);
        btnNo.getBackground().setColorFilter(Color.parseColor("#00ffffff"), PorterDuff.Mode.DARKEN);


        btnYes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!isYesButtonClicked){
                    btnYes.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.DARKEN);
                    btnNo.getBackground().setColorFilter(Color.parseColor("#00ffffff"), PorterDuff.Mode.DARKEN);
                    isYesButtonClicked = true;
                    Log.v(TAG, "Button Yes pressed, Button Yes is clicked ?" + isYesButtonClicked);
                }
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isYesButtonClicked){
                    btnYes.getBackground().setColorFilter(Color.parseColor("#00ffffff"), PorterDuff.Mode.DARKEN);
                    btnNo.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.DARKEN);
                    isYesButtonClicked = false;
                    Log.v(TAG, "Button No pressed, Button Yes is clicked ?" + isYesButtonClicked);
                }
            }
        });
    }
}
