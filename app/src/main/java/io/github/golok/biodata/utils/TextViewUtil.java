package io.github.golok.biodata.utils;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class TextViewUtil {
    public static void underline(TextView tv) {
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }
}
