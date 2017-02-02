package com.mawaqaa.mrnutrition.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.activity.MrNutritionBaseActivity;

/**
 * Created by anson on 1/25/2017.
 */

public class MyCartFragment extends MrNutritionBaseFragment {
    public MrNutritionBaseActivity Activity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity = (MrNutritionBaseActivity) this.getActivity();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_cart, container,
                false);
        return v;
    }
}
