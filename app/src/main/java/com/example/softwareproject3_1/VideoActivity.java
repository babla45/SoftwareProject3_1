package com.example.softwareproject3_1;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    private static final String TAG = "VideoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        VideoView videoView = findViewById(R.id.vv);

        // Use the direct MP4 URL for testing
        String onlineVPath = "https://sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4";
        Uri onlineVideoURI = Uri.parse(onlineVPath);
        videoView.setVideoURI(onlineVideoURI);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        videoView.setOnPreparedListener(mp -> {
            Log.d(TAG, "Video prepared, starting playback.");
            videoView.start();
        });

        videoView.setOnErrorListener((mp, what, extra) -> {
            Log.e(TAG, "Error occurred during video playback. What: " + what + ", Extra: " + extra);
            return true;
        });
    }
}
