package io.github.golok.biodata.main;

import android.os.Bundle;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import io.github.golok.biodata.onboarding.OnBoardingActivity;
import io.github.golok.biodata.utils.SharedPreferencesUtil;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!SharedPreferencesUtil.hasLogin(this)) {
            showOnBoarding();
            return;
        }

        setContentView(R.layout.activity_main);
    }

    private void showOnBoarding() {
        show(OnBoardingActivity.class);
        finish();
    }
}
