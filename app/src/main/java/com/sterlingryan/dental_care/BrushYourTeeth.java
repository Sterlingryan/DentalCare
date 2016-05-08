package com.sterlingryan.dental_care;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BrushYourTeeth extends AppCompatActivity {
    int buttonClick = 0;
    int currentHour, currentMinute, currentYear, currentMonth, currentDay;
    boolean deleteButton2Flag = false;
    boolean deleteButton3Flag = false;
    boolean deleteButton4Flag = false;

    Calendar currentTime;
    TimePickerDialog timePicker;

    //AlarmManager alarmManager;
    //private PendingIntent pendingIntent;

    int selectHour;
    int selectMinute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brush_your_teeth);

        Intent i = getIntent();

        final TextView time1 = (TextView)findViewById(R.id.Time1);
        final TextView alert2 = (TextView)findViewById(R.id.Alert2);
        final TextView time2 = (TextView)findViewById(R.id.Time2);
        final TextView alert3 = (TextView)findViewById(R.id.Alert3);
        final TextView time3 = (TextView)findViewById(R.id.Time3);
        final TextView alert4 = (TextView)findViewById(R.id.Alert4);
        final TextView time4 = (TextView)findViewById(R.id.Time4);
        final TextView text = (TextView)findViewById(R.id.messageText);

        final Button deleteButton2 = (Button)findViewById(R.id.time2DeleteButton);
        final Button deleteButton3 = (Button)findViewById(R.id.time3DeleteButton);
        final Button deleteButton4 = (Button)findViewById(R.id.time4DeleteButton);
        final Button addAlertButton = (Button)findViewById(R.id.AddAlert);

        time1.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                currentTime = Calendar.getInstance();

                //NOWWW
                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);
                currentYear = currentTime.get(Calendar.YEAR);
                currentMonth = currentTime.get(Calendar.MONTH);
                currentDay = currentTime.get(Calendar.DAY_OF_MONTH);

                timePicker = new TimePickerDialog(BrushYourTeeth.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        selectHour = selectedHour;
                        selectMinute = selectedMinute;

                        if(selectedHour < 10 && selectedMinute < 10)
                            time1.setText("0" + selectedHour + ":" + "0" + selectedMinute);
                        else if(selectedHour < 10)
                            time1.setText("0" + selectedHour + ":" + selectedMinute);
                        else if(selectedMinute < 10)
                            time1.setText(selectedHour + ":" + "0" + selectedMinute);
                        else
                            time1.setText(selectedHour + ":" + selectedMinute);
                    }
                }, currentHour, currentMinute, true);//Yes 24 hour time

                timePicker.setTitle("Select Time");
                timePicker.show();

                //DEBUG CODE
                //text.setText("Hour: " + currentHour + "\nMinute: " + currentMinute);

                Calendar cal = Calendar.getInstance();
                cal.set(currentYear, currentMonth, currentDay, selectHour, selectMinute, 00);

                setAlarm(cal);
            }
        });

        time2.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                currentTime = Calendar.getInstance();

                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                timePicker = new TimePickerDialog(BrushYourTeeth.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if(selectedHour < 10 && selectedMinute < 10)
                            time2.setText("0" + selectedHour + ":" + "0" + selectedMinute);
                        else if(selectedHour < 10)
                            time2.setText("0" + selectedHour + ":" + selectedMinute);
                        else if(selectedMinute < 10)
                            time2.setText(selectedHour + ":" + "0" + selectedMinute);
                        else
                            time2.setText(selectedHour + ":" + selectedMinute);
                    }
                }, currentHour, currentMinute, true);//Yes 24 hour time

                timePicker.setTitle("Select Time");
                timePicker.show();
            }
        });

        addAlertButton.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                buttonClick++;

                /*if((deleteButton2Flag && deleteButton4Flag)){
                    alert2.setVisibility(View.VISIBLE);
                    time2.setVisibility(View.VISIBLE);
                    deleteButton2.setVisibility(View.VISIBLE);
                }*/

                if(deleteButton2Flag){
                    alert2.setVisibility(View.VISIBLE);
                    time2.setVisibility(View.VISIBLE);
                    deleteButton2.setVisibility(View.VISIBLE);
                }

                if(deleteButton3Flag){
                    alert3.setVisibility(View.VISIBLE);
                    time3.setVisibility(View.VISIBLE);
                    deleteButton3.setVisibility(View.VISIBLE);
                }

                if(deleteButton4Flag){
                    alert4.setVisibility(View.VISIBLE);
                    time4.setVisibility(View.VISIBLE);
                    deleteButton4.setVisibility(View.VISIBLE);
                }

                if(buttonClick == 1){
                    alert3.setVisibility(View.VISIBLE);
                    time3.setVisibility(View.VISIBLE);
                    deleteButton3.setVisibility(View.VISIBLE);

                }
                else if(buttonClick == 2){
                    alert4.setVisibility(View.VISIBLE);
                    time4.setVisibility(View.VISIBLE);
                    deleteButton4.setVisibility(View.VISIBLE);

                    addAlertButton.setEnabled(false);
                }
            }
        });

        time3.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                currentTime = Calendar.getInstance();

                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                timePicker = new TimePickerDialog(BrushYourTeeth.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if(selectedHour < 10 && selectedMinute < 10)
                            time3.setText("0" + selectedHour + ":" + "0" + selectedMinute);
                        else if(selectedHour < 10)
                            time3.setText("0" + selectedHour + ":" + selectedMinute);
                        else if(selectedMinute < 10)
                            time3.setText(selectedHour + ":" + "0" + selectedMinute);
                        else
                            time3.setText(selectedHour + ":" + selectedMinute);
                    }
                }, currentHour, currentMinute, true);//Yes 24 hour time

                timePicker.setTitle("Select Time");
                timePicker.show();
            }
        });

        time4.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v){
                currentTime = Calendar.getInstance();

                currentHour = currentTime.get(Calendar.HOUR_OF_DAY);
                currentMinute = currentTime.get(Calendar.MINUTE);

                timePicker = new TimePickerDialog(BrushYourTeeth.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        if(selectedHour < 10 && selectedMinute < 10)
                            time4.setText("0" + selectedHour + ":" + "0" + selectedMinute);
                        else if(selectedHour < 10)
                            time4.setText("0" + selectedHour + ":" + selectedMinute);
                        else if(selectedMinute < 10)
                            time4.setText(selectedHour + ":" + "0" + selectedMinute);
                        else
                            time4.setText(selectedHour + ":" + selectedMinute);
                    }
                }, currentHour, currentMinute, true);//Yes 24 hour time

                timePicker.setTitle("Select Time");
                timePicker.show();
            }
        });

        deleteButton2.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                alert2.setVisibility(View.GONE);
                time2.setVisibility(View.GONE);
                deleteButton2.setVisibility(View.GONE);
                addAlertButton.setEnabled(true);

                buttonClick--;
                deleteButton2Flag = true;
            }
        });

        deleteButton3.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                alert3.setVisibility(View.GONE);
                time3.setVisibility(View.GONE);
                deleteButton3.setVisibility(View.GONE);
                addAlertButton.setEnabled(true);

                buttonClick--;
                deleteButton3Flag = true;
            }
        });

        deleteButton4.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v){
                alert4.setVisibility(View.GONE);
                time4.setVisibility(View.GONE);
                deleteButton4.setVisibility(View.GONE);
                addAlertButton.setEnabled(true);

                buttonClick--;
                deleteButton4Flag = true;
            }
        });
    }

    private void setAlarm(Calendar targetCal){

        Toast.makeText(getBaseContext(), "setAlarm Method", Toast.LENGTH_LONG).show();

        /*Intent intent = new Intent(getBaseContext(), AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getBaseContext(), RQS_1, intent, 0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);*/

        /*tent myIntent = new Intent(BrushYourTeeth.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(BrushYourTeeth.this, 0, myIntent, 0);
        alarmManager.set(AlarmManager.RTC, budda.getTimeInMillis(), pendingIntent);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /*----When an option is selected----
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return true;
    }*/


}
