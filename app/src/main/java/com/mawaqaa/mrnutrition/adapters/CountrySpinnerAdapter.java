package com.mawaqaa.mrnutrition.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.data.CountriesSpinnerData;

import java.util.ArrayList;

/**
 * Created by anson on 1/31/2017.
 */

public class CountrySpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context context;
    private ArrayList<CountriesSpinnerData> countriesSplashSpinnerDatas;

    public CountrySpinnerAdapter(Context context, ArrayList<CountriesSpinnerData> countriesSplashSpinnerDatas) {
        this.context = context;
        this.countriesSplashSpinnerDatas = countriesSplashSpinnerDatas;
    }

    @Override
    public int getCount() {
        return countriesSplashSpinnerDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return countriesSplashSpinnerDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return (long) position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CountriesSpinnerData data=countriesSplashSpinnerDatas.get(position);
        LayoutInflater inflater=((Activity)context).getLayoutInflater();
        ImageView  imageView=(ImageView) convertView.findViewById(R.id.img_country_flag);
        TextView textView=(TextView)convertView.findViewById(R.id.tv_country_name);
inflater.
        return null;
    }
}
