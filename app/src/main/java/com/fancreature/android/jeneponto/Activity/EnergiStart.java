package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astuetz.PagerSlidingTabStrip;
import com.fancreature.android.jeneponto.FragmentClassAdapt;
import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 10/14/2017.
 */

public class EnergiStart extends Fragment {
    @Bind(R.id.pagerView)
    ViewPager viewPager;
    @Bind(R.id.tabsman)
    PagerSlidingTabStrip tabs;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layoutenergi, container, false);
        ButterKnife.bind(this, v);
        viewPager.setAdapter(new Energi(getFragmentManager()));
        tabs.setViewPager(viewPager);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
