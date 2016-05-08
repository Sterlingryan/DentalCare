package com.sterlingryan.dental_care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Sterling Ryan on 5/1/2016.
 */
public class WizardCarerActivity extends AppCompatActivity{

    private Button btnNext;
    private Button btnPrev;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wizard_carer);

        btnNext = (Button) findViewById(R.id.carerNextbutton);
        btnNext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardCarerActivity.this, WizardBrushingActivity.class);
                startActivity(intent);
            }
        });

        btnPrev = (Button) findViewById(R.id.carerPrevbutton);
        btnPrev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(WizardCarerActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
