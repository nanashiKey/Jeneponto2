package com.fancreature.android.jeneponto.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fancreature.android.jeneponto.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Hubungi extends Fragment implements View.OnClickListener{

    static String url = "https://www.google.co.id/maps/place/Kantor+Pelayanan+Terpadu+Jeneponto/@-5.6845144,119.7534452,19.21z/data=!4m13!1m7!3m6!1s0x2db937ab2ca46a5b:0xef67d976f809c21a!2sJalan+Lingkar,+Binamu,+Kabupaten+Jeneponto,+Sulawesi+Selatan+92311!3b1!8m2!3d-5.6818362!4d119.7621392!3m4!1s0x0:0xc493b9daec275f7!8m2!3d-5.6845897!4d119.7536809?hl=en";
    @Bind(R.id.imview2)
    ImageView imview2;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View rootview = inflater.inflate(R.layout.layout_contact, container, false);
        ButterKnife.bind(this, rootview);
        return rootview;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        imview2.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imview2 :
//                AlertDialog mDialog = new AlertDialog.Builder(getContext())
//                        .setTitle(R.string.app_name)
//                        .setMessage("hiji dua hiju dua tilu eta terangkanlah")
//                        .setPositiveButton("OK",
//                                new DialogInterface.OnClickListener() {
//
//                                    @Override
//                                    public void onClick(DialogInterface dialog, int which) {
//                                        Log.i("MyTag", "Click YES");
//                                    }
//                                })
//                        .create();
//
//                mDialog.show();

                Intent x = new Intent();
                x.setData(Uri.parse(url));
                startActivity(x);

                break;
        }
    }
}

