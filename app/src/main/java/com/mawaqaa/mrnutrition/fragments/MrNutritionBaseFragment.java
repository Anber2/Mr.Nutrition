package com.mawaqaa.mrnutrition.fragments;

import android.app.ActionBar;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.ProgressBar;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.activity.MrNutritionBaseActivity;

/**
 * Created by anson on 1/23/2017.
 */

public class MrNutritionBaseFragment extends Fragment {
    private static final String TAG = "MrNutritionBaseFragment";
    public MrNutritionBaseActivity Activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "oncreate>>");
        Activity = (MrNutritionBaseActivity) this.getActivity();
    }

    public void onResume() {
        Log.d(TAG, "onResume" + this.getClass().getName());
        super.onResume();
        ((MrNutritionBaseActivity) getActivity()).BaseFragment = this;
    }

    private Dialog spinWheelDialog;
    Handler spinWheelTimer = new Handler(); // Handler to post a runnable that
    // can dismiss spinweheel afrer a
    // specific time
    public static final int SPINWHEEL_LIFE_TIME = 700; /*
                                                         * Dismiss spin wheel
														 * after 5 seconds
														 */

    public void startSpinwheel(boolean setDefaultLifetime, boolean isCancelable) {
        // Log.d(TAG, "startSpinwheel"+getCurrentActivity().getClass() );
        // If already showing no need to create.
        if (spinWheelDialog != null && spinWheelDialog.isShowing())
            return;
        spinWheelDialog = new Dialog(Activity, R.style.wait_spinner_style);
        ProgressBar progressBar = new ProgressBar(Activity);
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

    Runnable dismissSpinner = new Runnable() {

        @Override
        public void run() {
            stopSpinWheel();
        }

    };

    protected void onSpinWheelDismissed() {
        Log.d(TAG, "Spin wheel disconnected");
    }

}
