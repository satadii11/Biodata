package io.github.golok.biodata.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Satria Adi Putra
 * 10116167
 * IF-4
 * Kamis, 15 Agustus 2019
 */
public class SharedPreferencesUtil {
    private static final String SHARED_PREFERENCES_NAME = "biodata_preferences";
    private static final String HAS_LOGIN = "pref::has_login";
    private static final String NAME = "pref::name";

    public static boolean hasLogin(Context context) {
        return getSharedPreferences(context).getBoolean(HAS_LOGIN, false);
    }

    public static void setLogin(Context context, boolean value) {
        getSharedPreferencesEditor(context)
                .putBoolean(HAS_LOGIN, value)
                .apply();
    }

    public static String getName(Context context) {
        return getSharedPreferences(context).getString(NAME, "");
    }

    public static void setName(Context context, String name) {
        getSharedPreferencesEditor(context)
                .putString(NAME, name)
                .apply();
    }

    public static void clear(Context context) {
        getSharedPreferences(context).edit().clear().apply();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getSharedPreferencesEditor(Context context) {
        return getSharedPreferences(context).edit();
    }
}
