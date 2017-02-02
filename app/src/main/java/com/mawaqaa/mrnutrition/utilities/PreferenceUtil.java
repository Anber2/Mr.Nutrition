package com.mawaqaa.mrnutrition.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.mawaqaa.mrnutrition.constants.AppConstants;

/**
 * Created by anson on 1/25/2017.
 */

public class PreferenceUtil {

    private final static String TAG = "PreferenceUtil";
    public static SharedPreferences mnsp;
    private final static String TABDEAL_LANGUAGE = "language";


    /*Language Preference Part*/
    public final static void setLanguage(Context context, String lang) {
        mnsp = PreferenceManager.getDefaultSharedPreferences(context);
        mnsp.edit().putString(TABDEAL_LANGUAGE, lang).apply();
        ;
    }

    public final static String getLanguage(Context context) {
        mnsp = PreferenceManager.getDefaultSharedPreferences(context);
        return mnsp.getString(TABDEAL_LANGUAGE, AppConstants.MRNUTRITION_ENGLISH);
    }


}
