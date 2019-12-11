package com.example.finalprojectbucci.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.finalprojectbucci.HeadChefTab;
import com.example.finalprojectbucci.HostessTab;
import com.example.finalprojectbucci.ManagerTab;
import com.example.finalprojectbucci.R;
import com.example.finalprojectbucci.RestauranteursTab;
import com.example.finalprojectbucci.ServersTab;
import com.example.finalprojectbucci.SommelierTab;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 *
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    //this creates the titles for the tabs using the strings for each tab in layout->strings
    private static final int[] TAB_TITLES = new int[]{R.string.tab_rest, R.string.tab_headchef, R.string.tab_manager, R.string.tab_hostess, R.string.tab_sommelier, R.string.tab_servers};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.


      /**create a switch function that calls each java class that corresponds to each tab  and creates an object, then returns that object
        (returns the tab)*/

        switch(position)
        {
            case 0:
                RestauranteursTab tabOne = new RestauranteursTab(); //restaurateurs tab
                return tabOne;
            case 1:
                HeadChefTab tabTwo = new HeadChefTab();
                return tabTwo;
            case 2:
                ManagerTab tabThree = new ManagerTab();
                return tabThree;

            case 3:
                HostessTab tabFour = new HostessTab();
                return tabFour;

            case 4:
                SommelierTab tabFive = new SommelierTab();
                return tabFive;

            case 5:
                ServersTab tabSix = new ServersTab();
                return tabSix;

            default:
                return null;
        }

    }

    @Nullable
    @Override
    //this gets the current position and returns the title of the tab
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }
}