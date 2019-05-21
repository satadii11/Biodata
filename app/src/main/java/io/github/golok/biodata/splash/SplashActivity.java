package io.github.golok.biodata.splash;

import android.os.Bundle;
import android.os.Handler;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.main.MainActivity;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Selasa, 21 Mei 2019
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                show(MainActivity.class);
                finish();
            }
        }, 1000L);
    }
}
