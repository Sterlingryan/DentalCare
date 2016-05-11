package com.sterlingryan.dental_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Gabriel on 11/05/2016.
 */
public class ChecklistAdapter extends ArrayAdapter<ChecklistItem> {

    private Context _myContext;
    private int _myResource;
    private ChecklistItem[] _myChecklistItems;
    public ChecklistAdapter(Context context, int resource, ChecklistItem[] objects) {
        super(context, resource, objects);
        _myContext = context;
        _myResource = resource;
        _myChecklistItems = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) _myContext).getLayoutInflater();
        View row = inflater.inflate(_myResource, parent, false);

        TextView checklistText = (TextView)row.findViewById(R.id.checklistText);
        checklistText.setText(_myChecklistItems[position].Text);

        return row;
    }
}
