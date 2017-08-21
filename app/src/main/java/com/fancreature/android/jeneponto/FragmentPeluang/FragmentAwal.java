package com.fancreature.android.jeneponto.FragmentPeluang;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by Irfan Assidiq on 8/21/2017.
 */

public class FragmentAwal extends Fragment {
    private String taitel;
    private int page;

    public static FragmentAwal newInstance(int page, String taitel){

        FragmentAwal fragmentAwal = new FragmentAwal();
        Bundle args = new Bundle();
        args.putInt("someInt",page);
        args.putString("someTitle",taitel);
        fragmentAwal.setArguments(args);
        return fragmentAwal;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        taitel = getArguments().getString("someTitle");
    }
}
