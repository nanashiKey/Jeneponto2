package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Something extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.newenergi, container, false);
        return rootView;
    }
}
