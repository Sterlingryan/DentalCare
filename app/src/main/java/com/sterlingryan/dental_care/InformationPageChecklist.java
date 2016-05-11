package com.sterlingryan.dental_care;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class InformationPageChecklist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page_checklist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();
        String title = myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_CHECKTITLE);
        String desc = myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_CHECKDESC);
        ChecklistItem[] checklistItems = new ChecklistItem[3];
        checklistItems[0] = new ChecklistItem(myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_CHECKSTEP1));
        checklistItems[1] = new ChecklistItem(myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_CHECKSTEP2));
        checklistItems[2] = new ChecklistItem(myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_CHECKSTEP3));



        TextView checklistTitle = (TextView)findViewById(R.id.checklistTitle);
        checklistTitle.setText(title);

        ListView checklistView = (ListView)findViewById(R.id.checklist);
        ChecklistAdapter myAdapter = new ChecklistAdapter(this, R.layout.checklistitem, checklistItems);
        checklistView.setAdapter(myAdapter);
    }

}
