package io.github.golok.biodata.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Senin, 20 Mei 2019
 */
public class SharedPreferencesUtil {
    private static final String SHARED_PREFERENCES_NAME = "biodata_preferences";
    private static final String HAS_LOGIN = "pref::has_login";

    public static boolean hasLogin(Context context) {
        return getSharedPreferences(context).getBoolean(HAS_LOGIN, false);
    }

    public static void setLogin(Context context, boolean value) {
        getSharedPreferencesEditor(context)
                .putBoolean(HAS_LOGIN, value)
                .apply();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getSharedPreferencesEditor(Context context) {
        return getSharedPreferences(context).edit();
    }
}
