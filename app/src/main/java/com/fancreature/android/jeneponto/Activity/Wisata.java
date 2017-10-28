package com.fancreature.android.jeneponto.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.KontenWisata.WisataDelapan;
import com.fancreature.android.jeneponto.KontenWisata.WisataDua;
import com.fancreature.android.jeneponto.KontenWisata.WisataEmpat;
import com.fancreature.android.jeneponto.KontenWisata.WisataEnam;
import com.fancreature.android.jeneponto.KontenWisata.WisataLima;
import com.fancreature.android.jeneponto.KontenWisata.WisataSatu;
import com.fancreature.android.jeneponto.KontenWisata.WisataSembilan;
import com.fancreature.android.jeneponto.KontenWisata.WisataSepuluh;
import com.fancreature.android.jeneponto.KontenWisata.WisataTiga;
import com.fancreature.android.jeneponto.KontenWisata.WisataTujuh;
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
    @Bind(R.id.w6) ImageView w6;
    @Bind(R.id.w7) ImageView w7;
    @Bind(R.id.w8) ImageView w8;
    @Bind(R.id.w9) ImageView w9;
    @Bind(R.id.w10) ImageView w10;
    private Class fragmentClass;
    Fragment fragment = null;
    Pembantu pembantu = new Pembantu();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.wisatakonten, container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {

                if(getFragmentManager().getBackStackEntryCount() == 0){
                    Log.i("hai: ", "sudah pindah");
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
        //this code using for bundling the data
        Bundle bundle = new Bundle();
        switch (v.getId()){
            case R.id.w1:
                pembantu.setId(R.drawable.w1);
                fragmentClass = WisataSatu.class;
//                Log.d(TAG, "onClick() returned: " + " drawable terclick");
//                Log.d(TAG, "onClick: fragment terubah");
                break;
            case R.id.w2:
                pembantu.setId(R.drawable.w2);
                fragmentClass = WisataDua.class;
                break;
            case R.id.w3:
                pembantu.setId(R.drawable.w3);
                fragmentClass = WisataTiga.class;
                break;
            case R.id.w4:
                pembantu.setId(R.drawable.w4);
                fragmentClass = WisataEmpat.class;
                break;
            case R.id.w5:
                pembantu.setId(R.drawable.w5);
                fragmentClass = WisataLima.class;
                break;
            case R.id.w6:
                pembantu.setId(R.drawable.w6);
                fragmentClass = WisataEnam.class;
                break;
            case R.id.w7:
                pembantu.setId(R.drawable.w7);
                fragmentClass = WisataTujuh.class;
                break;
            case R.id.w8:
                pembantu.setId(R.drawable.w8);
                fragmentClass = WisataDelapan.class;
                break;
            case R.id.w9:
                pembantu.setId(R.drawable.w9);
                fragmentClass = WisataSembilan.class;
                break;
            case R.id.w10:
                pembantu.setId(R.drawable.w10);
                fragmentClass = WisataSepuluh.class;
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
        w6.setOnClickListener(this);
        w7.setOnClickListener(this);
        w8.setOnClickListener(this);
        w9.setOnClickListener(this);

    }
}

