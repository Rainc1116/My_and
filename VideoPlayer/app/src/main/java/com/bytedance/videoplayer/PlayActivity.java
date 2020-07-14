package com.bytedance.videoplayer;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bytedance.player.VideoPlayerIJK;
import com.bytedance.player.VideoPlayerListener;

import tv.danmaku.ijk.media.player.IjkMediaPlayer;


public class PlayActivity extends AppCompatActivity {
    private VideoPlayerIJK ijkPlayer;
    private SeekBar seekBar;
    private TextView text;
    private Handler handler = new Handler();
    int min,sec;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        setTitle("ijkPlayer");
        ijkPlayer = findViewById(R.id.ijkPlayer);
        seekBar = findViewById(R.id.seekBar3);
        text = findViewById(R.id.textView4);
        //seekBar.setOnSeekBarChangeListener(onSeekBarChangeListener);
        try {
            IjkMediaPlayer.loadLibrariesOnce(null);
            IjkMediaPlayer.native_profileBegin("libijkplayer.so");
        } catch (Exception e) {
            this.finish();
        }
        ijkPlayer.setListener(new VideoPlayerListener());
        //ijkPlayer.setVideoResource(R.raw.bytedance);
        ijkPlayer.setVideoPath(getVideoPath());

        findViewById(R.id.buttonPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("1234", "long "+ijkPlayer.getDuration());
                ijkPlayer.start();
            }
        });

        findViewById(R.id.buttonPause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ijkPlayer.pause();
            }
        });

        findViewById(R.id.buttonSeek).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ijkPlayer.seekTo(20 * 1000);
            }
        });
        handler.post(runnable);
    }

    private Runnable runnable = new Runnable() {
        public void run() {
            Log.i("1234", "run: ");
            if (ijkPlayer.isPlaying()) {
                long current = ijkPlayer.getCurrentPosition();
                Log.i("1234", "run: "+(int)(((float)current/ijkPlayer.getDuration())*100));
                seekBar.setProgress((int)(((float)current/ijkPlayer.getDuration())*100));
                min = (int)current/60000;
                sec = (int)(current - min*1000)/1000;
                text.setText(" "+min+" : "+sec);
            }
            handler.postDelayed(runnable, 500);
        }
    };



    private String getVideoPath() {
        return "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";
//        return "android.resource://" + this.getPackageName() + "/" + resId;
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (ijkPlayer.isPlaying()) {
            ijkPlayer.stop();
        }

        IjkMediaPlayer.native_profileEnd();
    }
}

