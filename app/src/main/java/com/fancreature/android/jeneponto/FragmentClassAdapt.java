package com.fancreature.android.jeneponto;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fancreature.android.jeneponto.Activity.Peluang;
import com.fancreature.android.jeneponto.Activity.PeluangSub;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentAsal;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentAwal;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentEmpat;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentLima;
import com.fancreature.android.jeneponto.FragmentPeluang.FragmentTiga;

/**
 * Created by Irfan Assidiq on 8/25/2017.
 */

public class FragmentClassAdapt extends FragmentPagerAdapter {

    final int PAGE_COUNT = 5;
    private String tabTitles[]= new String[]{"Peluangku", "Peluangmu", "peluangnya", "peluangKuh", "peluangkitaah"};

    public FragmentClassAdapt(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
//        return PeluangSub.newInstance(position+1);
        switch (position) {
            case 0:
                return FragmentAsal.newInstance(1, "Aset Daerah");
            case 1:
                return FragmentAwal.newInstance(2, "Perikanan dan Kelautan");
            case 2:
                return FragmentTiga.newInstance(3, "Perkebunan");
            case 3:
                return FragmentAsal.newInstance(4, "Pertanian Holtikultura");
            case 4:
                return FragmentEmpat.newInstance(5, "Pertanian Tanaman Pangan");
            case 5:
                return FragmentLima.newInstance(6, "Peternakan");
            default:
                return FragmentAsal.newInstance(1, "Aset Daerah");
        }
    }
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
