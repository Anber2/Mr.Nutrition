package com.mawaqaa.mrnutrition.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.utilities.WindowUtils;

public class SplashActivity extends MrNutritionBaseActivity {

    private static final String TAG = "SplashActivity";
    public MrNutritionBaseActivity Activity;
    private ProgressBar customProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        setContentView(R.layout.activity_splash);
//        WindowUtils.setFullScreenNoAction(this);
        Activity =  this.getMrNutritionBaseActivity();
        customProgress = (ProgressBar) findViewById(R.id.progress_splash);
        if(isNetworkAvailable()){

//            GCMHelper gcmHelper = new GCMHelper(Activity);
//            gcmHelper.gcmRegisteration();
            new ShowCustomProgressBarAsyncTask().execute();
        }
        else{
            Toast.makeText(Activity, getResources().getString(R.string.no_internet), Toast.LENGTH_LONG).show();
            this.finish();
        }


    }

    public class ShowCustomProgressBarAsyncTask extends
            AsyncTask<Void, Integer, Void> {

        int myProgress;

        @Override
        protected void onPreExecute() {
            myProgress = 0;
        }

        @Override
        protected Void doInBackground(Void... params) {
            while (myProgress < 100) {
                myProgress++;
                publishProgress(myProgress);
                SystemClock.sleep(35);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            customProgress.setProgress(values[0]);
            customProgress.setSecondaryProgress(values[0] + 1);
            // progressDisplay.setText(String.valueOf(myProgress)+"%");

        }

        @Override
        protected void onPostExecute(Void result) {

            finish();

            // start a new activity
            Intent i = new Intent();
            i.setClass(getApplicationContext(), CountryPickerActivity
                    .class);
            startActivity(i);


        }
    }
}
