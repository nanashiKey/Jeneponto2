package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fancreature.android.jeneponto.R;

import butterknife.Bind;

/**
 * Created by Irfan Assidiq on 8/25/2017.
 */

public class PeluangSub extends Fragment {
    public static final String ARG_PAGE ="ARG_PAGE";
    private int mPage;
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    public static PeluangSub newInstance(int page){
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PeluangSub fragment = new PeluangSub();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View voila = inflater.inflate(R.layout.layout_peluang2, container, false);
        return voila;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
