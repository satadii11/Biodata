package io.github.golok.biodata.splash;

import android.os.Bundle;

import io.github.golok.biodata.main.MainActivity;
import io.github.golok.biodata.common.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        show(MainActivity.class);
    }
}
