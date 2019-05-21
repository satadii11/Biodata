package io.github.golok.biodata.onboarding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import io.github.golok.biodata.R;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 21 Mei 2019
 */
public class OnBoardingFirstFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_on_boarding_first, container, false);
    }
}
