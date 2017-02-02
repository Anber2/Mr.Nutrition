package com.mawaqaa.mrnutrition.listeners;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mawaqaa.mrnutrition.R;
import com.mawaqaa.mrnutrition.activity.MrNutritionBaseActivity;
import com.mawaqaa.mrnutrition.activity.MrNutritionMainActivity;
import com.mawaqaa.mrnutrition.fragments.BestSellersFragment;
import com.mawaqaa.mrnutrition.fragments.BrandsFragment;
import com.mawaqaa.mrnutrition.fragments.ContactUsFragment;
import com.mawaqaa.mrnutrition.fragments.HomeFragment;
import com.mawaqaa.mrnutrition.fragments.HotDealsFragment;
import com.mawaqaa.mrnutrition.fragments.InformationFragment;
import com.mawaqaa.mrnutrition.fragments.MyAccountFragment;
import com.mawaqaa.mrnutrition.fragments.MyCartFragment;
import com.mawaqaa.mrnutrition.fragments.OthersFragment;
import com.mawaqaa.mrnutrition.fragments.PaymentMethodsFragments;
import com.mawaqaa.mrnutrition.fragments.ProductCatFragment;
import com.mawaqaa.mrnutrition.fragments.SettingsFragment;
import com.mawaqaa.mrnutrition.fragments.ShakersandAccessFragment;
import com.mawaqaa.mrnutrition.fragments.SpecialOffersFragment;
import com.mawaqaa.mrnutrition.fragments.SupplementsFragment;
import com.mawaqaa.mrnutrition.fragments.WishListFragment;
import com.mawaqaa.mrnutrition.utilities.DrawerUtilities;

/**
 * Created by anson on 1/24/2017.
 */

public class DrawerClickListeners implements View.OnClickListener {

    public static String TAG = "DrawerClickListeners";
    Context mcontext;
    DrawerLayout mDrawerLayout;
    LinearLayout linearLayout;
    boolean isDealsClosed = true, isDealsSelected = false;
    TextView textView, tvDeals;


    public DrawerClickListeners(Context context, DrawerLayout drawerLayout, TextView textView) {
        this.mcontext = context;
        this.textView = textView;
        this.mDrawerLayout = drawerLayout;

    }

    public DrawerClickListeners(Context context, DrawerLayout drawerLayout, TextView textView, TextView tvDeals) {
        this.mcontext = context;
        this.textView = textView;
        this.mDrawerLayout = drawerLayout;
        this.tvDeals = tvDeals;

    }

    public DrawerClickListeners(Context context, DrawerLayout drawerLayout, LinearLayout linearLayout, TextView textView) {
        this.mcontext = context;
        this.mDrawerLayout = drawerLayout;
        this.linearLayout = linearLayout;
        this.textView = textView;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_home_drawer:
                Log.e(TAG, ">>>> drawer home clicked.");

                /**Checking is it in HomeFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new HomeFragment().getClass().getName()) {

                    /**In same HomeFragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mHomFragment = new HomeFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mHomFragment, false, true);
                    setTextviewSelected(textView);

                }
                break;

            case R.id.tv_product_cat_drawer:
                Log.e(TAG, ">>>> drawer product categories clicked.");

                /**Checking is it in ProductCatFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new ProductCatFragment().getClass().getName()) {

                    /**In same ProductCatFragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mProductCat = new ProductCatFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mProductCat, false, true);
                    setTextviewSelected(textView);

                }
                break;

            case R.id.tv_brands_drawer:
                Log.e(TAG, ">>>> drawer brands clicked.");

                /**Checking is it in ProductCatFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new BrandsFragment().getClass().getName()) {

                    /**In same BrandsFragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mBrands = new BrandsFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mBrands, false, true);
                    setTextviewSelected(textView);

                }
                break;

            case R.id.tv_supplements_drawer:
                Log.e(TAG, ">>>> drawer supplements clicked.");

                /**Checking is it in SupplementsFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new SupplementsFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new SupplementsFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_shakers_and_acces_drawer:
                Log.e(TAG, "drawer supplements clicked.>>>>");

                /**Checking is it in ShakersandAccessFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new ShakersandAccessFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new ShakersandAccessFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_others_drawer:
                Log.e(TAG, ">>>> drawer others clicked.");

                /**Checking is it in OthersFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new OthersFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new OthersFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_deals_drawer:
                /**Handling Visiblity of inner layout*/

                if (isDealsClosed) {

                    isDealsSelected = true;
                    linearLayout.setVisibility(View.VISIBLE);
                    MrNutritionMainActivity.tvDealsDrawer.setSelected(true);
                    isDealsClosed = false;

                } else {

                    isDealsSelected = false;
                    linearLayout.setVisibility(View.GONE);
                    MrNutritionMainActivity.tvDealsDrawer.setSelected(false);
                    isDealsClosed = true;

                }

                break;
            case R.id.tv_special_offers_drawer:
                Log.e(TAG, ">>>> drawer special offers clicked.");

                /**Checking is it in SpecialOffersFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new SpecialOffersFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);

                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new SpecialOffersFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);
                    tvDeals.setSelected(true);

                }

                break;
            case R.id.tv_best_sellers_drawer:
                Log.e(TAG, ">>>> drawer best sellers clicked.");

                /**Checking is it in BestSellersFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new BestSellersFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new BestSellersFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);
                    tvDeals.setSelected(true);
                }

                break;
            case R.id.tv_hot_deals_drawer:
                Log.e(TAG, ">>>> drawer hot deals clicked.");

                /**Checking is it in HotDealsFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new HotDealsFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new HotDealsFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);
                    tvDeals.setSelected(true);

                }

                break;
            case R.id.tv_my_account_drawer:
                Log.e(TAG, ">>>> drawer supplements clicked.");

                /**Checking is it in MyAccountFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new MyAccountFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new MyAccountFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_my_cart_drawer:
                Log.e(TAG, ">>>>> drawer my cart clicked.");

                /**Checking is it in ShakersandAccessFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new MyCartFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new MyCartFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_wish_list_drawer:
                Log.e(TAG, ">>>> drawer wishlist clicked.");

                /**Checking is it in WishListFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new WishListFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new WishListFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_information_drawer:
                Log.e(TAG, ">>>>>>> drawer information clicked.");

                /**Checking is it in InformationFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new InformationFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new InformationFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_settings_drawer:
                Log.e(TAG, ">>>>> drawer settings clicked.");

                /**Checking is it in SettingsFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new SettingsFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new SettingsFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_contact_us_drawer:
                Log.e(TAG, ">>> drawer contact us clicked.");

                /**Checking is it in ContactUsFragment */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new ContactUsFragment().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new ContactUsFragment();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);

                }

                break;
            case R.id.tv_payment_methods_drawer:
                Log.e(TAG, ">>>>drawer payment methods clicked.");

                /**Checking is it in PaymentMethodsFragments */
                if (MrNutritionMainActivity.getMrNutritionBaseActivity().getCurrentFragment() == new PaymentMethodsFragments().getClass().getName()) {

                    /**In same Fragment>> closing drawer*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Log.e(TAG, "Same Fragment");

                } else {

                    /**Starting fragment transaction*/
                    DrawerUtilities.closeDrawerVeiw(mcontext, mDrawerLayout);
                    Fragment mfFragment = new PaymentMethodsFragments();
                    MrNutritionBaseActivity.getMrNutritionBaseActivity().pushFragments(mfFragment, false, true);
                    setTextviewSelected(textView);
                }

                break;

            default:
                break;
        }
    }

    public void setTextviewSelected(TextView textView) {
        Log.e(TAG, "TextView Selection>>>");

        if (!textView.isSelected()) {

            textView.setSelected(true);
            Log.e(TAG, "TextView Selection>>> IF case" + MrNutritionMainActivity.tvLastSelected);
            MrNutritionMainActivity.tvLastSelected.setSelected(false);
            MrNutritionMainActivity.tvLastSelected = textView;

            if (!(textView.getId() == R.id.tv_special_offers_drawer || textView.getId() == R.id.tv_best_sellers_drawer ||
                    textView.getId() == R.id.tv_hot_deals_drawer)) {

                MrNutritionMainActivity.llDeals.setVisibility(View.GONE);
                isDealsClosed = true;

            }

        }
        if (isDealsSelected) {
            MrNutritionMainActivity.tvDealsDrawer.setSelected(true);
        } else {
            MrNutritionMainActivity.tvDealsDrawer.setSelected(false);
        }
        /*else {
            Log.e(TAG, "TextView Selection>>> IF case");
            tvLastSelected.setSelected(false);
        }
*/
    }
}
