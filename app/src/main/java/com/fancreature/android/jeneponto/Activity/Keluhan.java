package com.fancreature.android.jeneponto.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fancreature.android.jeneponto.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Irfan Assidiq on 7/27/2017.
 */

public class Keluhan extends Fragment {

    @Bind(R.id.ETNama)
    EditText nama;
    @Bind(R.id.ETEmail)
    EditText email;
    @Bind(R.id.ETKeluhan)
    EditText keluhan;
    @Bind(R.id.button3)
    Button masuk;

    //this used for send position
    //visitjeneponto.id/connection/keluhan.php?namalengkap=value&email=value&isikeluhan=value&state=value

    String state = "i";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.keluhan, container, false);

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              CekStatus();
//                clearAja();
                nama.setText("admin test");
            }
        });
    }

    void dialogDia(){
        AlertDialog mDialog = new AlertDialog.Builder(Keluhan.super.getContext())
                .setTitle(R.string.app_name)
                .setMessage("Kolom tidak boleh kosong")
                .setPositiveButton(R.string.yes,
                        new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.i("MyTag", "Click Ya");
                            }

                        })
                .create();

        mDialog.show();
    }

    void CekStatus(){
        String namabaru = nama.getText().toString();
        String emailbaru = email.getText().toString();
        String keluhanbaru = keluhan.getText().toString();
        if (namabaru.matches("") || emailbaru.matches("") || keluhanbaru.matches("")){
            dialogDia();
        }
        else{
            new SendOnPost().execute();
        }

    }

    private void clearAja(){
        nama.getText().clear();
        email.getText().clear();
        keluhan.getText().clear();
    }
    private class SendOnPost extends AsyncTask<String, String, String>{

        @Override
        protected void onPreExecute() {
//            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
         try{
             URL url = new URL("http://visitjeneponto.id/connection/keluhan.php");

             JSONObject postDataParams = new JSONObject();
             postDataParams.put("namalengkap", nama.getText());
             postDataParams.put("email",email.getText());
             postDataParams.put("isikeluhan",keluhan.getText());
             postDataParams.put("state",state);
             Log.e("params", postDataParams.toString());

             HttpURLConnection conn = (HttpURLConnection) url.openConnection();
             conn.setReadTimeout(15000); //milliseconds
             conn.setConnectTimeout(15000);
             conn.setRequestMethod("POST");
             conn.setDoInput(true);
             conn.setDoOutput(true);

             OutputStream os = conn.getOutputStream();
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(os, "UTF-8"));
             writer.write(getPostDataString(postDataParams));
             writer.flush();
             writer.close();
             os.close();

             int responseCode = conn.getResponseCode();
             if(responseCode == HttpURLConnection.HTTP_OK){
                 BufferedReader in = new BufferedReader(
                         new InputStreamReader(conn.getInputStream()));
                 StringBuffer sb = new StringBuffer("Keluhan telah dikirim");
                 String line ="";

                 while ((line = in.readLine()) != null){
                     sb.append(line);
                     break;
                 }
                 in.close();
                 return sb.toString();
             }else{
                 return new String("false: " +responseCode );
             }
         }catch(Exception e){
             return new String("Exception: " + e.getMessage());
         }
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getActivity().getApplicationContext(), s, Toast.LENGTH_LONG).show();
        }
    }
    public String getPostDataString(JSONObject params) throws Exception{
        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();
        while(itr.hasNext()){
            String key = itr.next();
            Object value = params.get(key);

            if(first){
                first = false;
            }
            else{
                result.append("&");
            }

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));
        }
        return result.toString();
    }
}
