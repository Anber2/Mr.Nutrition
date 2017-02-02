package com.mawaqaa.mrnutrition.utilities;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.mawaqaa.mrnutrition.activity.MrNutritionBaseActivity;

public class WindowUtils {
    private static final String TAG = "TabDeal::WindowUtils";

    public static final void setFullScreenNoAction(MrNutritionBaseActivity act) {
        if (act != null) {
            if (Build.VERSION.SDK_INT < 16) {
                Log.e(TAG, "Below Build Version 16");
                act.getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
                act.getSupportActionBar().hide();
            } else {
                Log.e(TAG, "Above Build Version 16");
                act.getWindow().getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
                act.getSupportActionBar().hide();
            }
        }
    }

    public static final void setFullScreenWithAction(MrNutritionBaseActivity act) {
        if (act != null) {
            if (Build.VERSION.SDK_INT < 16) {
                Log.e(TAG, "Below Build Version 16");
                act.getWindow().setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
            } else {
                Log.e(TAG, "Above Build Version 16");
                act.getWindow().getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
            }
        }
    }

    public static final int getScreenWidth(MrNutritionBaseActivity act) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        Log.e(TAG, "Screen Width :" + displaymetrics.widthPixels);
        return (displaymetrics.widthPixels);
    }

    public static final int getScreenHeight(MrNutritionBaseActivity act) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        act.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        Log.e(TAG, "Screen Width :" + displaymetrics.heightPixels);
        return (displaymetrics.heightPixels);
    }

    public static final int getLinearLayoutWidth(final LinearLayout linearLayout) {
        return linearLayout.getWidth();
    }

    //...........................About Us Fragment ...................................................//

    public static int convertDip2Pixels(Context context, float dip) {
        Log.d(TAG, "convertDip2Pixels");
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dip, context.getResources().getDisplayMetrics());
    }

    public static String getHtmlData(Context context, String data) {
        String head = "<head><style>@font-face {font-family: 'Raleway-Regular';src: url('file://"
                + context.getFilesDir().getAbsolutePath()
                + "/Raleway-Regular.otf');}body {font-family: 'Raleway-Regular';}</style></head>";

        String htmlData = "<html>" + head + "<body>" + data + "</body></html>";
        return htmlData;
    }

    //...........................About Us Fragment ...................................................//

}
