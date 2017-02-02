package com.mawaqaa.mrnutrition.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.constants.AppConstants;
import com.mawaqaa.mrnutrition.data.CountriesSpinnerData;
import com.mawaqaa.mrnutrition.volley.CommandFactory;
import com.mawaqaa.mrnutrition.volley.VolleyUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 * Created by anson on 1/25/2017.
 */

public class CountryPickerActivity extends MrNutritionBaseActivity implements View.OnClickListener {

    private static final String TAG = "CountryPickerActivity";
    public MrNutritionBaseActivity Activity;
    Button mButtonContinue;
    ToggleButton mToggleLanguage;
    TextView tvEnglishLanguage, tvArabicLanguage;
    Spinner spinnerCountryList;
    ImageView imageViewSpinnerDown;
    Locale mLocale = Locale.ENGLISH;
    RelativeLayout rlSpinner, rlContinueBtn;
    ArrayList<CountriesSpinnerData> countriesSpinnerDatas;
    JSONObject demoJsonObject = new JSONObject("{ \"country\": [\"Kuwait\", \"Algeria\", \"Bahrain\", \"Egypt\", \"Iran\"]}");
    ArrayList<String> countryFlag = new ArrayList<>(Arrays.asList("http://shop.flagshop.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/f/l/flag-world-kuwait.gif",
            "http://shop.flagshop.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/f/l/flag-world-algeria.gif",
            "http://shop.flagshop.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/f/l/flag-world-bahrain.gif",
            "http://shop.flagshop.com/media/catalog/product/cache/1/thumbnail/128x128/9df78eab33525d08d6e5fb8d27136e95/f/l/flag-world-egypt.gif",
            "http://shop.flagshop.com/media/catalog/product/cache/1/image/9df78eab33525d08d6e5fb8d27136e95/f/l/flag-world-iran.gif"));

    public CountryPickerActivity() throws JSONException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.HONEYCOMB) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        }
        setContentView(R.layout.activity_country_pick);
        Activity = this.getMrNutritionBaseActivity();

        try {
            setLayoutValues(); /**--Setting Layout Ids and click listeners*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setLayoutValues() throws Exception {
        mToggleLanguage = (ToggleButton) findViewById(R.id.switch_language_select);
        tvEnglishLanguage = (TextView) findViewById(R.id.tv_language_english);
        tvArabicLanguage = (TextView) findViewById(R.id.tv_language_arabic);
        spinnerCountryList = (Spinner) findViewById(R.id.spinner_country_list);
        imageViewSpinnerDown = (ImageView) findViewById(R.id.img_spinner_dwn_arrow);

        mButtonContinue = (Button) findViewById(R.id.btn_splash_continue);
        mButtonContinue.setOnClickListener(this);
        imageViewSpinnerDown.setOnClickListener(this);

        try {
            parseJsonCountryListResponse(demoJsonObject);
        } catch (Exception e) {
        }
//        if (Activity.isNetworkAvailable()) {
//            createJsonForCountryList();
//        }
    }

    private void createJsonForCountryList() {
        JSONObject jsonObject = new JSONObject();
        try {
            startSpinwheel(false, true);
            if (VolleyUtils.volleyEnabled) {

                CommandFactory commandFactory = new CommandFactory();
                Log.e(TAG, "service URL :"
                        + AppConstants.MRNUTRITION_SPLASH_URL);
                Log.e(TAG, " Data :" + jsonObject.toString());

                commandFactory.sendPostCommand(
                        AppConstants.MRNUTRITION_SPLASH_URL, jsonObject);

            }
        } catch (Exception e) {
            Log.e(TAG, "Execption while Putting Json");
            e.printStackTrace();
        }
    }

    @Override
    public void onSplashCountryLoadedSuccessfully(JSONObject jsonObject) {
        super.onSplashCountryLoadedSuccessfully(jsonObject);
        stopSpinWheel();
        try {
            parseJsonCountryListResponse(jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void parseJsonCountryListResponse(JSONObject jsonObject) throws Exception {
        try {
            countriesSpinnerDatas = new ArrayList<CountriesSpinnerData>();

            JSONArray jsonArray = jsonObject.getJSONArray(AppConstants.MRNUTRITION_COUNTRY);
            for (int i = 0; i < jsonArray.length(); i++) {
                Log.e(TAG, "In parsing loop>>>>");
                CountriesSpinnerData spinnerData = new CountriesSpinnerData(jsonArray.getString(i), countryFlag.get(i));
                Log.e(TAG, "Contryname>>" + jsonArray.getString(i) + ", COuntry Flag" + countryFlag.get(i));
                countriesSpinnerDatas.add(spinnerData);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSplashCountryLoadedFailed(JSONObject jsonObject) {
        super.onSplashCountryLoadedFailed(jsonObject);
        Toast.makeText(getMrNutritionBaseActivity(), getResources().getString(R.string.server_error),
                Toast.LENGTH_LONG).show();
        stopSpinWheel();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_splash_continue:
                Log.e(TAG, "Contiue Button clicked>>");

                /**--Starting MainActivity--**/
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(), MrNutritionMainActivity.class);
                startActivity(intent);

                /**--Closing CountryPickerActivity--**/
                finish();
                break;
            case R.id.switch_language_select:
                Log.e(TAG, "Language clicked");
                if (mToggleLanguage.isChecked()) {
                    Log.e(TAG, "Language Arabic selected");
                    mLocale = new Locale("ar");
                } else {
                    Log.e(TAG, "Language English selected");
                }
                break;
            case R.id.img_spinner_dwn_arrow:
                Log.e(TAG, "Spinner clicked");
                break;
            default:
                break;
        }
    }
}
