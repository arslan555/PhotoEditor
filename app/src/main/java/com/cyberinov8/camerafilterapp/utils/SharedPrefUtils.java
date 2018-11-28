package com.cyberinov8.camerafilterapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefUtils {
    static String PREFS_NAME = "pref";

    public String getSharedPrefValue(Context mContext, String sharedPrefTitle) {
        SharedPreferences settings = mContext.getSharedPreferences(PREFS_NAME,
                0);
        return settings.getString(sharedPrefTitle, null);
    }

    public void saveSharedPrefValue(Context mContext, String sharedPrefTitle,
                                    String sharedPrefValue) {
        try {
            SharedPreferences settings = mContext.getSharedPreferences(PREFS_NAME, 0);
            final SharedPreferences.Editor editor = settings.edit();
            editor.putString(sharedPrefTitle, sharedPrefValue);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeSharedPrefValue(Context mContext, String sharedPrefTitle) {
        try {
            SharedPreferences settings = mContext.getSharedPreferences(
                    PREFS_NAME, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.remove(sharedPrefTitle);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
