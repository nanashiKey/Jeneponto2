package com.fancreature.android.jeneponto.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.astuetz.PagerSlidingTabStrip;
import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 10/14/2017.
 */

public class Energi extends FragmentPagerAdapter implements PagerSlidingTabStrip.IconTabProvider {
    final int PAGE_COUNT=3;
    private int TabIcons[] = {R.drawable.energi_ikon,
                                R.drawable.energi_ikon,
                                    R.drawable.energi_ikon};

    public Energi(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getPageIconResId(int position) {
        return TabIcons[position];
    }

    @Override
    public Fragment getItem(int position) {
        return RealEnergi.newInstance(position + 1);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
