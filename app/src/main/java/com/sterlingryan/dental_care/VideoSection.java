package com.sterlingryan.dental_care;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.microsoft.windowsazure.mobileservices.MobileServiceClient;

import java.net.MalformedURLException;
import java.util.List;

public class VideoSection extends AppCompatActivity {

    private MobileServiceClient mClient;
    private Context myContext;
    private ListView myList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_section);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       /* myContext = this;
        myList = (ListView)findViewById(R.id.listView);

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
                    final List<InformationPage> informationPages = mClient.getTable(InformationPage.class).where().execute().get();

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int _c = 0;
                            VideoItem[] _myVids = new VideoItem[informationPages.size()];
                            for (InformationPage page : informationPages){
                                _myVids[_c] = new VideoItem(page.Title);
                                _c++;
                            }

                            VideoAdapter myAdapter = new VideoAdapter(myContext, R.layout.video_item, _myVids);
                            myList.setAdapter(myAdapter);

                        }
                    });
                } catch (Exception exception) {
                }
                return null;
            }
        }.execute();






*/
    }

}


