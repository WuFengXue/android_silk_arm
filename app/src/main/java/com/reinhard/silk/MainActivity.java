package com.reinhard.silk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private static final String TEST_DIR = "/sdcard/reinhard/";

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
            case R.id.btn_pcm_to_amr:
                testPcmToAmr();
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
        String amrPath = TEST_DIR + "amr2mp3/in.amr";
        String pcmPath = TEST_DIR + "amr2mp3/out.pcm";
        String mp3Path = TEST_DIR + "amr2mp3/out.mp3";
        if (AudioCodec.decode(amrPath, pcmPath, mp3Path) == 0) {
            Toast.makeText(this, "testAmrToMp3 success", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private void testPcmToAmr() {
        Log.d(TAG, "testPcmToAmr");
        String pcmPath = TEST_DIR + "pcm2amr/in.pcm";
        String mp3Path = TEST_DIR + "pcm2amr/out.amr";
        if (AudioCodec.encode(pcmPath, mp3Path) == 0) {
            Toast.makeText(this, "testPcmToAmr success", Toast.LENGTH_SHORT)
                    .show();
        }
    }

    private void testMp3ToAmr() {
        Log.d(TAG, "testMp3ToAmr");
        String amrPath = TEST_DIR + "mp32amr/in.mp3";
        String pcmPath = TEST_DIR + "mp32amr/out.pcm";
        String mp3Path = TEST_DIR + "mp32amr/out.amr";
        if (AudioCodec.encode2(amrPath, pcmPath, mp3Path) == 0) {
            Toast.makeText(this, "testMp3ToAmr success", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
