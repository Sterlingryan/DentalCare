package com.sterlingryan.dental_care;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Gabriel on 25/04/2016.
 */
public class InformationSectionExpandableAdaptor extends BaseExpandableListAdapter {private Context _context;
    private List<Section> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<Section, List<InformationPage>> _listDataChild;
    public final static String PAGE_TITLE = "com.example.gabriel.gaptdentist.PAGE_TITLE";
    public final static String PAGE_IMAGETOP = "com.example.gabriel.gaptdentist.PAGE_IMAGETOP";
    public final static String PAGE_FIRSTTEXT = "com.example.gabriel.gaptdentist.PAGE_FIRSTTEXT";

    public InformationSectionExpandableAdaptor(Context context, List<Section> listDataHeader,
                                 HashMap<Section, List<InformationPage>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    public void SetLists(List<Section> listDataHeader, HashMap<Section, List<InformationPage>> listChildData){
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public InformationPage getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = getChild(groupPosition, childPosition).Title;

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.information_section_button, null);
        }

        Button txtListChild = (Button) convertView
                .findViewById(R.id.information_section_button_widget);

        txtListChild.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InformationPage myPage = getChild(groupPosition, childPosition);
                NextPage(v, myPage.Title, myPage.ImageTop, myPage.FirstText);
            }
        });
        txtListChild.setText(childText);
        return convertView;
    }

    public void NextPage(View view, String title, String imageTop, String firstText){
        Intent informationPageIntent = new Intent(_context, InformationPageActivity.class);
        informationPageIntent.putExtra(PAGE_TITLE, title);
        informationPageIntent.putExtra(PAGE_IMAGETOP, imageTop);
        informationPageIntent.putExtra(PAGE_FIRSTTEXT, firstText);
        _context.startActivity(informationPageIntent);
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Section getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = getGroup(groupPosition).Name;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.information_section, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.sectionTitle);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        ExpandableListView lView = (ExpandableListView) parent;
        lView.expandGroup(groupPosition);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}