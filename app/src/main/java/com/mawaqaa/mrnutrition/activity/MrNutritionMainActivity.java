package com.mawaqaa.mrnutrition.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.fragments.HomeFragment;
import com.mawaqaa.mrnutrition.listeners.DrawerClickListeners;
import com.mawaqaa.mrnutrition.utilities.DrawerUtilities;

/**
 * Created by anson on 1/23/2017.
 */


public class MrNutritionMainActivity extends MrNutritionBaseActivity implements View.OnClickListener {

    public static final String TAG = "MrNutritionMainActivity";

    public Boolean isBackBtnNeed = false;
    ImageButton mImgBtnActnBarDrawer, mImgBtnActnBarSearch, mImgBtnActnBarLanguage, mImgBtnActnBarAccount;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    /*Objects for Drawer Layout*/
    public static DrawerLayout mDrawerLayout;
    TextView tvHomeDrawer, tvProductCatDrawer, tvBrandsDrawer, tvSupplementsDrawer, tvShakersAndAccessDrawer, tvOthersDrawer, tvSpecialOffersDrawer, tvBestSellersDrawer, tvHotDealsDrawer, tvMyAccountDrawer, tvMyCartDrawer, tvWishListDrawer, tvInformationDrawer, tvSettingsDrawer, tvContactUsDrawer, tvPayementMethodsDrawer;
    public static NavigationView mNavigationView;
    public static TextView tvLastSelected, tvDealsDrawer;
    public static LinearLayout llDeals;
//    LinearLayout headerView;
    View headerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setActionBar();
        setDrawer();
        Fragment mHomFragment = new HomeFragment();

        pushFragments(mHomFragment, false, true);

    }


    private void setDrawer() {

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);

        /**Adding drawer layout to navigation view*/
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = mNavigationView.inflateHeaderView(R.layout.drawer_layout);

//        headerView = (LinearLayout) findViewById(R.id.ll_drawer_main);

        getDrawerItemId(); /**Initialising Drawer Items drawer items */
        tvHomeDrawer.setSelected(true);
        tvLastSelected = tvHomeDrawer;
        setOnCLickListenerToDrawerItems(); /**Setting OnClickListeners to Drawer Items*/

    }

    private void setOnCLickListenerToDrawerItems() {
        tvHomeDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvHomeDrawer));
        tvProductCatDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvProductCatDrawer));
        tvBrandsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvBrandsDrawer));
        tvSupplementsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvSupplementsDrawer));
        tvShakersAndAccessDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvShakersAndAccessDrawer));
        tvOthersDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvOthersDrawer));
        tvDealsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, llDeals, tvDealsDrawer));
        tvSpecialOffersDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvSpecialOffersDrawer, tvDealsDrawer));
        tvBestSellersDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvBestSellersDrawer, tvDealsDrawer));
        tvHotDealsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvHotDealsDrawer, tvDealsDrawer));
        tvMyAccountDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvMyAccountDrawer));
        tvMyCartDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvMyCartDrawer));
        tvWishListDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvWishListDrawer));
        tvInformationDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvInformationDrawer));
        tvSettingsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvSettingsDrawer));
        tvContactUsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvContactUsDrawer));
        tvPayementMethodsDrawer.setOnClickListener(new DrawerClickListeners(getApplicationContext(), mDrawerLayout, tvPayementMethodsDrawer));
    }

    private void getDrawerItemId() {
        tvHomeDrawer = (TextView) headerView.findViewById(R.id.tv_home_drawer);
        tvProductCatDrawer = (TextView) headerView.findViewById(R.id.tv_product_cat_drawer);
        tvBrandsDrawer = (TextView) headerView.findViewById(R.id.tv_brands_drawer);
        tvSupplementsDrawer = (TextView) headerView.findViewById(R.id.tv_supplements_drawer);
        tvShakersAndAccessDrawer = (TextView) headerView.findViewById(R.id.tv_shakers_and_acces_drawer);
        tvOthersDrawer = (TextView) headerView.findViewById(R.id.tv_others_drawer);
        tvDealsDrawer = (TextView) headerView.findViewById(R.id.tv_deals_drawer);
        tvSpecialOffersDrawer = (TextView) headerView.findViewById(R.id.tv_special_offers_drawer);
        tvBestSellersDrawer = (TextView) headerView.findViewById(R.id.tv_best_sellers_drawer);
        tvHotDealsDrawer = (TextView) headerView.findViewById(R.id.tv_hot_deals_drawer);
        tvMyAccountDrawer = (TextView) headerView.findViewById(R.id.tv_my_account_drawer);
        tvMyCartDrawer = (TextView) headerView.findViewById(R.id.tv_my_cart_drawer);
        tvWishListDrawer = (TextView) headerView.findViewById(R.id.tv_wish_list_drawer);
        tvInformationDrawer = (TextView) headerView.findViewById(R.id.tv_information_drawer);
        tvSettingsDrawer = (TextView) headerView.findViewById(R.id.tv_settings_drawer);
        tvContactUsDrawer = (TextView) headerView.findViewById(R.id.tv_contact_us_drawer);
        tvPayementMethodsDrawer = (TextView) headerView.findViewById(R.id.tv_payment_methods_drawer);

        llDeals = (LinearLayout) headerView.findViewById(R.id.ll_deals_drawer);
    }

    private void setActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mImgBtnActnBarDrawer = (ImageButton) findViewById(R.id.img_btn_appbar_drawer);
        mImgBtnActnBarAccount = (ImageButton) findViewById(R.id.img_btn_appbar_profile);
        mImgBtnActnBarLanguage = (ImageButton) findViewById(R.id.img_btn_appbar_language);
        mImgBtnActnBarSearch = (ImageButton) findViewById(R.id.img_btn_appbar_search);

        mImgBtnActnBarDrawer.setOnClickListener(this);
        mImgBtnActnBarAccount.setOnClickListener(this);
        mImgBtnActnBarLanguage.setOnClickListener(this);
        mImgBtnActnBarSearch.setOnClickListener(this);

        /**Checking Drawer Button Status*/
        if (isBackBtnNeed == true) {
            mImgBtnActnBarDrawer.setBackgroundResource(R.drawable.ic_keyboard_arrow_left);
        } else {
            mImgBtnActnBarDrawer.setBackgroundResource(R.drawable.ic_menu);

        }

    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.img_btn_appbar_drawer:
                Log.e(TAG, "Appbar>> Drawer Icon Clicked");
                if (isBackBtnNeed == true) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.LEFT);
                    isBackBtnNeed = false;
                }
                break;
            case R.id.img_btn_appbar_profile:
                Log.e(TAG, "Appbar>> Account Icon Clicked");
                break;
            case R.id.img_btn_appbar_language:
                Log.e(TAG, "Appbar>> Language Icon Clicked");
                break;
            case R.id.img_btn_appbar_search:
                Log.e(TAG, "Appbar>> Search Icon Clicked");
                break;
            case R.id.tv_home_drawer:
                Log.e(TAG, "Drawe>> Home clicked");
                break;
            default:
                break;
        }

    }
}
