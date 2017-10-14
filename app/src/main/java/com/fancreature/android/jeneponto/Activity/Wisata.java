package com.fancreature.android.jeneponto.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.KontenWisata.WisataFull;
import com.fancreature.android.jeneponto.Pembantu;
import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Irfan Assidiq on 7/26/2017.
 */

public class Wisata extends Fragment implements View.OnClickListener{

    @Bind(R.id.w1) ImageView w1;
    @Bind(R.id.w2) ImageView w2;
    @Bind(R.id.w3) ImageView w3;
    @Bind(R.id.w4) ImageView w4;
    @Bind(R.id.w5) ImageView w5;
    private Class fragmentClass;
    Fragment fragment = null;
    Pembantu pembantu = new Pembantu();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wisatakonten, container, false);
//
//        ImageView w1 = (ImageView) rootView.findViewById(R.id.w1);
//        ImageView w2 = (ImageView) rootView.findViewById(R.id.w2);
//        ImageView w3 = (ImageView) rootView.findViewById(R.id.w3);
//        ImageView w4 = (ImageView) rootView.findViewById(R.id.w4);
//        ImageView w5 = (ImageView) rootView.findViewById(R.id.w5);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View v) {
        //this code using for bundling the data
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.w1:
                pembantu.setId(R.drawable.w1);
                fragmentClass = WisataFull.class;
//                Log.d(TAG, "onClick() returned: " + " drawable terclick");
//                Log.d(TAG, "onClick: fragment terubah");
                break;
            case R.id.w2:
                pembantu.setId(R.drawable.w2);
                fragmentClass = WisataFull.class;
//                Log.d(TAG, "onClick() returned: " + " drawable terclick");
//                Log.d(TAG, "onClick: fragment terubah");
                break;
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
//            e.printStackTrace();
            String x ="tidak tereksekusi";
            Log.d(TAG, x);
        }
        bundle.putParcelable("Pembantu",pembantu);
        FragmentManager fr = getFragmentManager();
        fragment.setArguments(bundle);
        fr.beginTransaction().replace(R.id.fContent, fragment,"uh yeah").commit();

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        w1.setOnClickListener(this);
        w2.setOnClickListener(this);
        w3.setOnClickListener(this);
        w4.setOnClickListener(this);
        w5.setOnClickListener(this);
    }

//    private View.OnClickListener newOnclickCeritanya = new View.OnClickListener() {
//        @Override
//        public void onClick(View v) {
//            Intent baru;
//            switch (v.getId()){
//                case R.drawable.w1 :
////                    pembantu.setId(R.drawable.w1);
//                    fragmentClass = WisataFull.class;
//                    baru = new Intent(getActivity(),WisataFull.class);
//                    startActivity(baru);
//                    break;
//                case R.drawable.w2 :
//                    pembantu.setId(R.drawable.w2);
//                    fragmentClass = WisataFull.class;
//                    break;
//                default:
//                    fragmentClass = this.getClass();
//            }
//        }
//    };
}

