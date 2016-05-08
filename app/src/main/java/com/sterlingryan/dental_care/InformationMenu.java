package com.sterlingryan.dental_care;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.microsoft.windowsazure.mobileservices.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InformationMenu extends AppCompatActivity {


    public Section[] SectionNames = null;
    //public ArrayList<Section> Sections = new ArrayList<Section>();
    public TextView textview = null;

    public ArrayList<Section> listDataHeader = new ArrayList<Section>();
    public HashMap<Section, List<InformationPage>> listDataChild = new HashMap<Section, List<InformationPage>>();

    private MobileServiceClient mClient;
    private ExpandableListView expListView;
    private InformationSectionExpandableAdaptor listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        expListView = (ExpandableListView) findViewById(R.id.expandableListView);
        listAdapter = new InformationSectionExpandableAdaptor(this, listDataHeader, listDataChild);

        try {
            // Create the Mobile Service Client instance, using the provided

            // Mobile Service URL and key
            mClient = new MobileServiceClient(
                    "https://gaptdentistmobservice.azure-mobile.net/",
                    "zhuwqmjBWeSsTGpIrXtLWSDAoKyQQi17",
                    this);
        } catch (MalformedURLException e) {
        }

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                try {
                    final List<Section> sections = mClient.getTable(Section.class).where().execute().get();
                    final List<InformationPage> informationPages = mClient.getTable(InformationPage.class).where().execute().get();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int _c = 0;
                            for (Section section : sections) {
                                listDataHeader.add(new Section(section.Name));
                                List<InformationPage> myPages = new ArrayList<InformationPage>();

                                for (InformationPage page : informationPages){
                                    if (page.SectionId == section.id){
                                        myPages.add(page);
                                    }


                                }

                                listDataChild.put(listDataHeader.get(_c), myPages);
                                _c++;
                            }

                            listAdapter.SetLists(listDataHeader, listDataChild);
                            expListView.setAdapter(listAdapter);
                        }
                    });
                } catch (Exception exception) {
                }
                return null;
            }
        }.execute();

        // Adding child data
        /*listDataHeader.add(new Section("Dental Care"));
        listDataHeader.add(new Section("Nutrition"));
        listDataHeader.add(new Section("Handling of"));


        // Adding child data
        List<InformationPage> s1 = new ArrayList<InformationPage>();
        s1.add(new InformationPage("How to Brush", "This is content about brushing."));
        s1.add(new InformationPage("How to Floss", "This is content about flossing."));

        List<InformationPage> s2 = new ArrayList<InformationPage>();
        s2.add(new InformationPage("Diet Advice", "This is content about diet advice."));
        s2.add(new InformationPage("Popular Diet Mistakes", "This is content about popular diet mistakes."));

        List<InformationPage> s3 = new ArrayList<InformationPage>();
        s3.add(new InformationPage("Dental Emergencies", "This is content about dental emergencies."));
        s3.add(new InformationPage("Dental Trauma", "This is content about dental trauma."));
        s3.add(new InformationPage("Medical Issues", "This is content about medical issues."));
        s3.add(new InformationPage("Prevention", "This is content about prevention."));

        listDataChild.put(listDataHeader.get(0), s1); // Header, Child data
        listDataChild.put(listDataHeader.get(1), s2);
        listDataChild.put(listDataHeader.get(2), s3);*/


        // setting list adapter


    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information_menu, menu);
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
