package com.mawaqaa.mrnutrition.data;

/**
 * Created by anson on 1/31/2017.
 */

public class CountriesSpinnerData {
    private String countryName;
    private String imgUrl;

    public  CountriesSpinnerData(){}

    public CountriesSpinnerData(String countryName, String imgUrl) {
        this.countryName = countryName;
        this.imgUrl = imgUrl;
    }

    public String getCountryName() {
        return this.countryName;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }
}
