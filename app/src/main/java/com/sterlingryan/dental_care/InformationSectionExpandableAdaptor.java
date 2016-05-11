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
    private HashMap<Section, List<InformationPageHolder>> _listDataChild;

    public final static String PAGE_TITLE = "com.example.gabriel.gaptdentist.PAGE_TITLE";
    public final static String PAGE_IMAGETOP = "com.example.gabriel.gaptdentist.PAGE_IMAGETOP";
    public final static String PAGE_FIRSTTEXT = "com.example.gabriel.gaptdentist.PAGE_FIRSTTEXT";

    public final static String PAGE_VIDEOITEM = "com.example.gabriel.gaptdentist.PAGE_VIDEOITEM";
    public final static String PAGE_VIDEOLINK = "com.example.gabriel.gaptdentist.PAGE_VIDEOLINK";
    public final static String PAGE_VIDEODESC = "com.example.gabriel.gaptdentist.PAGE_VIDEODESC";

    public final static String PAGE_CHECKTITLE = "com.example.gabriel.gaptdentist.PAGE_CHECKTITLE";
    public final static String PAGE_CHECKDESC = "com.example.gabriel.gaptdentist.PAGE_CHECKDESC";
    public final static String PAGE_CHECKSTEP1 = "com.example.gabriel.gaptdentist.PAGE_CHECKSTEP1";
    public final static String PAGE_CHECKSTEP2 = "com.example.gabriel.gaptdentist.PAGE_CHECKSTEP2";
    public final static String PAGE_CHECKSTEP3 = "com.example.gabriel.gaptdentist.PAGE_CHECKSTEP3";


    public InformationSectionExpandableAdaptor(Context context, List<Section> listDataHeader,
                                 HashMap<Section, List<InformationPageHolder>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    public void SetLists(List<Section> listDataHeader, HashMap<Section, List<InformationPageHolder>> listChildData){
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public InformationPageHolder getChild(int groupPosition, int childPosititon) {
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

        String myName = "";
        InformationPageHolder holder = getChild(groupPosition, childPosition);

        if (holder.IsNormal){
            myName = holder.N_Title;
        }else if (holder.IsVideo){
            myName = holder.V_Title;
        }else if (holder.IsChecklist){
            myName = holder.C_Title;
        }

        final String childText = myName;


        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.information_section_button, null);
        }

        Button txtListChild = (Button) convertView
                .findViewById(R.id.information_section_button_widget);

        txtListChild.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                InformationPageHolder myPage = getChild(groupPosition, childPosition);
                if (myPage.IsNormal)
                    OpenNormalInformationPage(v, myPage.N_Title, myPage.N_ImageTop, myPage.N_FirstText);
                else if (myPage.IsVideo)
                    OpenVideoInformationPage(v, myPage.V_Title, myPage.V_VideoLink, myPage.V_Description);
                else if (myPage.IsChecklist)
                    OpenChecklistPage(v, myPage.C_Title, myPage.C_Desc, myPage.C_Step1, myPage.C_Step2, myPage.C_Step3);

            }
        });
        txtListChild.setText(childText);
        return convertView;
    }

    public void OpenNormalInformationPage(View view, String title, String imageTop, String firstText){
        Intent informationPageIntent = new Intent(_context, InformationPageActivity.class);
        informationPageIntent.putExtra(PAGE_TITLE, title);
        informationPageIntent.putExtra(PAGE_IMAGETOP, imageTop);
        informationPageIntent.putExtra(PAGE_FIRSTTEXT, firstText);
        _context.startActivity(informationPageIntent);
    }

    public void OpenVideoInformationPage(View view, String title, String videoLink, String description){
        Intent informationVideoPageIntent = new Intent(_context, VideoPage.class);
        informationVideoPageIntent.putExtra(PAGE_VIDEOITEM, title);
        informationVideoPageIntent.putExtra(PAGE_VIDEOLINK, videoLink);
        informationVideoPageIntent.putExtra(PAGE_VIDEODESC, description);
        _context.startActivity(informationVideoPageIntent);
    }

    public void OpenChecklistPage(View view, String title, String desc, String step1, String step2, String step3){
        Intent informationChecklistPageIntent = new Intent(_context, InformationPageChecklist.class);
        informationChecklistPageIntent.putExtra(PAGE_CHECKTITLE, title);
        informationChecklistPageIntent.putExtra(PAGE_CHECKDESC, desc);
        informationChecklistPageIntent.putExtra(PAGE_CHECKSTEP1, step1);
        informationChecklistPageIntent.putExtra(PAGE_CHECKSTEP2, step2);
        informationChecklistPageIntent.putExtra(PAGE_CHECKSTEP3, step3);

        _context.startActivity(informationChecklistPageIntent);
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