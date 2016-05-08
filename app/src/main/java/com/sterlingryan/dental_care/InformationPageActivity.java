package com.sterlingryan.dental_care;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;

public class InformationPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String title = intent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_TITLE);
        String imageTop = intent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_IMAGETOP);
        String firstText = intent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_FIRSTTEXT);

        TextView tv = (TextView) findViewById(R.id.pageTitle);
        tv.setText(title);

        TextView fText = (TextView) findViewById(R.id.firstText);
        fText.setText(firstText);

        ImageView iView = (ImageView) findViewById(R.id.imageTop);
        try{
        new DownloadImageTask(iView) .execute(imageTop);
        }catch (Exception e){

        }
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            if (urldisplay != null) {
                try {
                    InputStream in = new URL(urldisplay).openStream();
                    mIcon11 = BitmapFactory.decodeStream(in);
                } catch (Exception e) {
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null)
                bmImage.setImageBitmap(result);
        }
    }

}
