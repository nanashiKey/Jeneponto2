package com.fancreature.android.jeneponto.KontenWisata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.Pembantu;
import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by Irfan Assidiq on 9/16/2017.
 */

public class WisataFull extends Fragment {

    @Bind(R.id.ivWisata)
    ImageView ivWisata;
    Pembantu pembantu;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_kontenwisata_, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null){
            pembantu = bundle.getParcelable("Pembantu");
        }

        int x = pembantu.getId();

        if (x == R.id.w1){
            ivWisata.setImageDrawable(getResources().getDrawable(R.drawable.w1));
        }
        else if(x == R.id.w2){
            ivWisata.setImageDrawable(getResources().getDrawable(R.drawable.w2));
        }
        else{
            Log.d(TAG,"tidak terjadi apa-apa");

            // do nothing;
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
            }
}
