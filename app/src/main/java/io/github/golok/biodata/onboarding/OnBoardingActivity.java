package io.github.golok.biodata.onboarding;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import io.github.golok.biodata.R;
import io.github.golok.biodata.common.BaseActivity;
import me.relex.circleindicator.CircleIndicator;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 21 Mei 2019
 */
public class OnBoardingActivity extends BaseActivity {

    private ViewPager vpOnBoard;
    private CircleIndicator ciOnBoard;

    private OnBoardingAdapter onBoardingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);

        vpOnBoard = findViewById(R.id.vp_on_board);
        ciOnBoard = findViewById(R.id.ci_on_board);

        onBoardingAdapter = new OnBoardingAdapter(getSupportFragmentManager());
        vpOnBoard.setAdapter(onBoardingAdapter);
        ciOnBoard.setViewPager(vpOnBoard);
    }
}
