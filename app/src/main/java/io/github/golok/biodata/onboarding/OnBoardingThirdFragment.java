package io.github.golok.biodata.onboarding;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import io.github.golok.biodata.R;
import io.github.golok.biodata.main.MainActivity;
import io.github.golok.biodata.utils.SharedPreferencesUtil;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Selasa, 21 Mei 2019
 */
public class OnBoardingThirdFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_on_boarding_third, container, false);
        Button btnNext = view.findViewById(R.id.btn_on_board_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getContext();
                if (context != null) {
                    SharedPreferencesUtil.setLogin(context, true);
                    context.startActivity(new Intent(context, MainActivity.class));
                    Activity activity = getActivity();
                    if (activity != null) activity.finish();
                }
            }
        });
        return view;
    }
}
