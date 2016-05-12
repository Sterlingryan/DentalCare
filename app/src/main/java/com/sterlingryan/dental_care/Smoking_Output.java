package com.sterlingryan.dental_care;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.DecimalFormat;


public class Smoking_Output extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smoking_output);



        Intent intent=getIntent();

        Double amount = Double.parseDouble(intent.getStringExtra("key1"));
        String amountVar = intent.getStringExtra("key2");
        Double message;

        if(amountVar.equals("Packets"))
        {
            message=5.4*amount;

        }
        else
        {
            message=0.27*amount;

        }

        DecimalFormat dF = new DecimalFormat("#.#");
        TextView textView = (TextView)findViewById(R.id.smoking_hint1);
        textView.setText("You have been smoking " +dF.format(amount)+ " "+amountVar + " a day which amounts to:" );

        DecimalFormat df = new DecimalFormat("0.00");
        TextView textView1 = (TextView)findViewById(R.id.smoking_txt1);
        textView1.setText("€" + (df.format(message*365)));

        TextView textView2 = (TextView)findViewById(R.id.smoking_txt2);
        textView2.setText("€" + (df.format(message*1825)));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_smoking__output, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
