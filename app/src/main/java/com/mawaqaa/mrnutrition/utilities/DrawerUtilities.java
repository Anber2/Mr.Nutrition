package com.mawaqaa.mrnutrition.utilities;

import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;

import com.mawaqaa.mrnutrition.constants.AppConstants;

/**
 * Created by anson on 1/25/2017.
 */

public class DrawerUtilities {
    protected final static String TAG = "DrawerUtils";

    public static final void closeDrawerVeiw(Context context,
                                             DrawerLayout mDrawerLayout) {
        try {
            if (PreferenceUtil.getLanguage(context).equals(
                    AppConstants.MRNUTRITION_ENGLISH)) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            } else {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        } catch (Exception e) {
            Log.e(TAG, "Exception in closeDrawer Method");
            e.printStackTrace();
        }
    }

}
