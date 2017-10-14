package com.fancreature.android.jeneponto;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by Irfan Assidiq on 9/16/2017.
 */

public class Pembantu implements Parcelable{
    int id;

    public Pembantu(){
    }

    protected Pembantu(Parcel in)
    {
        id = in.readInt();
    }

    public static final Creator<Pembantu> CREATOR = new Creator<Pembantu>() {
        @Override
        public Pembantu createFromParcel(Parcel in) {
            return new Pembantu(in);
        }

        @Override
        public Pembantu[] newArray(int size) {
            return new Pembantu[size];
        }
    };

    public void setId(int id){
        Log.d(TAG,"data telah masuk");
        this.id = id;
    }

    public int getId(){
        return id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
    }
}
