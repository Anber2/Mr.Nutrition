package com.mawaqaa.mrnutrition.activity;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ProgressBar;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.fragments.MrNutritionBaseFragment;
import com.mawaqaa.mrnutrition.utilities.DrawerUtilities;
import com.mawaqaa.mrnutrition.volley.MrNutritionResponse;
import com.mawaqaa.mrnutrition.volley.VolleyUtils;

import org.json.JSONObject;

import static com.mawaqaa.mrnutrition.fragments.MrNutritionBaseFragment.SPINWHEEL_LIFE_TIME;

/**
 * Created by anson on 1/23/2017.
 */

public class MrNutritionBaseActivity extends AppCompatActivity {
    protected static MrNutritionBaseActivity BaseActivity;
    public MrNutritionBaseFragment BaseFragment;
    private static final String TAG = "MrNutritionBaseActivity";
    private Dialog spinWheelDialog;
    Handler spinWheelTimer = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //WindowUtils.setFullScreenWithAction(this);
        BaseActivity = this;
        VolleyUtils.init(this);
    }

    public static MrNutritionBaseActivity getMrNutritionBaseActivity() {
        return BaseActivity;
    }

    public void serviceResponseSuccess(MrNutritionResponse response) {
        if (response != null) {
            String reqUrl = response.mReqUrl;
            Log.d(TAG, "serviceResponseSuccess" + reqUrl);
            switch (reqUrl) {
                default:
                    break;
            }
        }
    }

    public void serviceResponseError(MrNutritionResponse response) {
        if (response != null) {
            String reqUrl = response.mReqUrl;
            Log.d(TAG, "serviceResponseError!!!" + reqUrl);
            switch (reqUrl) {
                default:
                    break;
            }
        }
    }

    public void onSplashCountryLoadedSuccessfully(JSONObject jsonObject) {}
    public void onSplashCountryLoadedFailed(JSONObject jsonObject) {}


    public String getCurrentFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        String fragmentTag = fragmentManager.getBackStackEntryAt(fragmentManager.getBackStackEntryCount() - 1).getName();
        Fragment currentFragment = fragmentManager.findFragmentByTag(fragmentTag);
        String fragmentName = currentFragment.getClass().getName();
        return fragmentName;
    }


    public void pushFragments(Fragment fragment, boolean shouldAnimate,
                              boolean shouldAdd) {
        FragmentManager manager = getSupportFragmentManager();
        String backStateName = fragment.getClass().getName();

        if (isNeedTransaction(backStateName)) {
            boolean fragmentPopped = manager.popBackStackImmediate(
                    backStateName, 0);

            if (!fragmentPopped) { // fragment not in back stack, create it.
                FragmentTransaction ft = manager.beginTransaction();
                if (shouldAnimate)
                    ft.setCustomAnimations(R.anim.slide_in_right,
                            R.anim.slide_out_left);
                ft.replace(R.id.content_main, fragment, backStateName);
                if (shouldAdd)
                    ft.addToBackStack(backStateName);
                ft.commit();
                manager.executePendingTransactions();
            }
        }
    }

    private boolean isNeedTransaction(String backStateName) {
        boolean needTransaction = true;
        if (BaseFragment != null) {
            String baseFrag = BaseFragment.getClass().getName();
            if (baseFrag.equals(backStateName)) {

                needTransaction = false;
            } else
                needTransaction = true;
        }
        return needTransaction;
    }


    public void clearAllBackStackEntries() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(0, FragmentManager.POP_BACK_STACK_INCLUSIVE);

    }

    public void popFragments(Fragment frag) {
        Log.e("Enterd here", "Inside pop fragment");
        try {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction ft = manager.beginTransaction();
            String fragName = frag.getClass().getName();
            manager.popBackStack(fragName,
                    FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ft.remove(frag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) BaseActivity
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onBackPressed() {


        if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            if (MrNutritionMainActivity.mDrawerLayout.isDrawerVisible(MrNutritionMainActivity.mNavigationView)) {
                DrawerUtilities.closeDrawerVeiw(getApplicationContext(), MrNutritionMainActivity.mDrawerLayout);
            } else {
                this.finish();
                super.onBackPressed();
            }


        } else {
            if (MrNutritionMainActivity.mDrawerLayout.isDrawerVisible(MrNutritionMainActivity.mNavigationView)) {
                DrawerUtilities.closeDrawerVeiw(getApplicationContext(), MrNutritionMainActivity.mDrawerLayout);
            } else
                super.onBackPressed();
        }
    }


    public void startSpinwheel(boolean setDefaultLifetime, boolean isCancelable) {
        // Log.d(TAG, "startSpinwheel"+getCurrentActivity().getClass() );
        // If already showing no need to create.
        if (spinWheelDialog != null && spinWheelDialog.isShowing())
            return;
        spinWheelDialog = new Dialog(BaseActivity, R.style.wait_spinner_style);
        ProgressBar progressBar = new ProgressBar(BaseActivity);
        ActionBar.LayoutParams layoutParams = new ActionBar.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        spinWheelDialog.addContentView(progressBar, layoutParams);
        spinWheelDialog.setCancelable(isCancelable);
        spinWheelDialog.show();
        // start timer for SPINWHEEL_LIFE_TIME
        spinWheelTimer.removeCallbacks(dismissSpinner);
        if (setDefaultLifetime) // If requested for default dismiss time.
            spinWheelTimer.postAtTime(dismissSpinner, SystemClock.uptimeMillis() + SPINWHEEL_LIFE_TIME);

        spinWheelDialog.setCanceledOnTouchOutside(false);
    }

    public void startSpinwheel(boolean isCancelable, int layoutid, int timeOutSec) {
        startSpinwheel(true, isCancelable);
        spinWheelTimer.removeCallbacks(dismissSpinner);
        spinWheelTimer.postAtTime(dismissSpinner, SystemClock.uptimeMillis() + timeOutSec);
        spinWheelDialog.setContentView(layoutid);
    }

    /**
     * Closes the spin wheel dialog
     */

    public void stopSpinWheel() {
        // Log.d(TAG, "stopSpinWheel"+getCurrentActivity().getClass());
        if (spinWheelDialog != null)
            try {
                spinWheelDialog.dismiss();
            } catch (IllegalArgumentException e) {
                Log.e(TAG, "Parent is died while tryingto dismiss spin wheel dialog ");
                e.printStackTrace();
            }
        spinWheelDialog = null;
    }

    /**
     * Dismiss the spinwheel
     */
    Runnable dismissSpinner = new Runnable() {

        @Override
        public void run() {
            stopSpinWheel();
        }

    };

    // Callback for spin wheel dismissal
    protected void onSpinWheelDismissed() {
        Log.d(TAG, "Spin wheel disconnected");
    }
}


