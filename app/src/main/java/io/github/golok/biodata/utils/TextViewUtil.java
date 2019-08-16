package io.github.golok.biodata.utils;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

import io.github.golok.biodata.R;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class TextViewUtil {
    public static void underline(TextView tv) {
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

    public static void colorSpannable(TextView tvToSpan, @StringRes int stringId, String textToSpan) {
        Context context = tvToSpan.getContext();
        String rawString = context.getString(stringId);
        int spannableIndex = rawString.indexOf(textToSpan);
        int textToSpanLength = textToSpan.length();
        int colorPrimary = ContextCompat.getColor(context, R.color.colorPrimary);

        SpannableString spannableString = new SpannableString(rawString);
        spannableString.setSpan(
                new ForegroundColorSpan(colorPrimary),
                spannableIndex,
                spannableIndex + textToSpanLength,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        );
        tvToSpan.setText(spannableString);
    }
}
