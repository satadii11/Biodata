package io.github.golok.biodata.onboarding;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 21 Mei 2019
 */
public class OnBoardingAdapter extends FragmentStatePagerAdapter {
    private static final int MAX_ITEM = 3;

    OnBoardingAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new OnBoardingFirstFragment();
            case 1:
                return new OnBoardingSecondFragment();
            case 2:
                return new OnBoardingThirdFragment();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCount() {
        return MAX_ITEM;
    }
}
