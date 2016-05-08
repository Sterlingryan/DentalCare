package com.sterlingryan.dental_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

/**
 * Created by Gabriel on 04/05/2016.
 */
public class VideoAdapter extends ArrayAdapter<VideoItem> {

    public final static String PAGE_VIDEOITEM = "com.example.gabriel.gaptdentist.PAGE_VIDEOITEM";

    private Context _myContext;
    private int _myResource;
    private VideoItem[] _myVideoItems;
    public VideoAdapter(Context context, int resource, VideoItem[] objects) {
        super(context, resource, objects);
        _myContext = context;
        _myResource = resource;
        _myVideoItems = objects;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) _myContext).getLayoutInflater();
        View row = inflater.inflate(_myResource, parent, false);

        Button videoItemButton = (Button)row.findViewById(R.id.videoItemButton);
        videoItemButton.setText("Watch " + _myVideoItems[position].Name);

        videoItemButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                VideoItem myVideoItem = _myVideoItems[position];
                NextPage(v, myVideoItem);
            }
        });

        return row;
    }

    public void NextPage(View view, VideoItem myVideoItem){
        Intent videoPageIntent = new Intent(_myContext, VideoPage.class);
        videoPageIntent.putExtra(PAGE_VIDEOITEM, myVideoItem.Name);
        _myContext.startActivity(videoPageIntent);
    }
}
