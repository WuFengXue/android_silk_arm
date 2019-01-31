package com.reinhard.silk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_amr_to_mp3:
                testAmrToMp3();
                break;
            case R.id.btn_mp3_to_amr:
                testMp3ToAmr();
                break;
            default:
                break;
        }
    }

    private void testAmrToMp3() {
        Log.d(TAG, "testAmrToMp3");
        String amrPath = "/sdcard/reinhard/amr2mp3/in.amr";
        String pcmPath = "/sdcard/reinhard/amr2mp3/out.pcm";
        String mp3Path = "/sdcard/reinhard/amr2mp3/out.mp3";
        AudioCodec.amrToMp3(amrPath, pcmPath, mp3Path);
    }

    private void testMp3ToAmr() {
        Log.d(TAG, "testMp3ToAmr");
        String amrPath = "/sdcard/reinhard/mp32amr/in.mp3";
        String pcmPath = "/sdcard/reinhard/mp32amr/out.pcm";
        String mp3Path = "/sdcard/reinhard/mp32amr/out.amr";
        AudioCodec.mp3ToAmr(amrPath, pcmPath, mp3Path);
    }
}
