package com.mine.volume_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SeekBar seek;
    AudioManager audio;
    ImageButton mute,unmute;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seek = findViewById(R.id.seekBar);
        text = findViewById(R.id.text);
        mute = findViewById(R.id.mute);
        unmute=findViewById(R.id.unmute);

        audio = (AudioManager) getApplicationContext().getSystemService(Context.AUDIO_SERVICE);
        //getting max volume
        int max = audio.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        //getting current volume
        int currentvol = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        seek.setMax(max);
        seek.setProgress(currentvol);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int prog, boolean b) {
                text.setVisibility(View.VISIBLE);
                text.setText(prog + "/15");
                audio.setStreamVolume(AudioManager.STREAM_MUSIC, prog, 5);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }
    public void mute(View view) {
        int mute = 0;
        seek.setProgress(mute);
    }

    public void Unnmute(View view) {
        audio.setStreamVolume(AudioManager.STREAM_MUSIC,10,10);
        seek.setProgress(10);
    }

}