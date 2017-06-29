package com.vinctor.vcharts;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.SeekBar;

import com.vinctor.vchartviews.progress.ProgressBarView;

public class ProgressBarViewActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        Intent starter = new Intent(context, ProgressBarViewActivity.class);
        context.startActivity(starter);
    }

    ProgressBarView progressBarView;
    AppCompatSeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar_view);

        progressBarView = (ProgressBarView) findViewById(R.id.progress);
        seekBar = (AppCompatSeekBar) findViewById(R.id.seekbar);

        progressBarView
                .setProgressBarHeight(30)
                .setIndicatorCircleRadius(50)
                .setBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pic))
                .commit();

        seekBar.setMax(100);
        seekBar.setProgress(progressBarView.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBarView
                        .setProgress(progress)
                        .commit();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
