package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fancreature.android.jeneponto.R;

/**
 * Created by Irfan Assidiq on 10/14/2017.
 */

public class RealEnergi extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static RealEnergi newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RealEnergi fragment = new RealEnergi();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_energi, container, false);
        TextView tvTitle = (TextView) view.findViewById(R.id.tvTitlex);
        tvTitle.setText(R.string.lorem);
        return view;
    }
}
