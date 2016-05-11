package com.sterlingryan.dental_care;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;

public class VideoPage extends AppCompatActivity{

    private static final int RECOVERY_REQUEST = 1;

    private YouTubePlayer youTubePlayer;
    private YouTubePlayerFragment youTubePlayerFragment;

    private static final int RQS_ErrorDialog = 1;

    private Activity myActivity;
    private Context myContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent myIntent = getIntent();
        String title = myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_VIDEOITEM);
        final String videoUrl = myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_VIDEOLINK);
        String desc = myIntent.getStringExtra(InformationSectionExpandableAdaptor.PAGE_VIDEODESC);


        TextView videoTitle = (TextView)findViewById(R.id.videoTitle);
        videoTitle.setText(title);

        TextView videoDesc = (TextView)findViewById(R.id.videoDescription);
        videoDesc.setText(desc);

        myActivity = this;
        myContext = this;

        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment);
        youTubePlayerFragment.initialize(YoutubeConfig.YOUTUBE_API_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {
                if (!wasRestored) {
                    player.cueVideo(videoUrl.split("=")[1]); // Plays https://www.youtube.com/watch?v=fhWaJi1Hsfo
                }
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult errorReason) {
                if (errorReason.isUserRecoverableError()) {
                    errorReason.getErrorDialog(myActivity, RECOVERY_REQUEST).show();
                } else {
                    Toast.makeText(myContext, errorReason.toString(), Toast.LENGTH_LONG).show();
                }
            }



        });
    }

}
