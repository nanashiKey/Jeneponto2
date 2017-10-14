package com.fancreature.android.jeneponto.FragmentPerizinan;

import android.app.Application;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.Html;
import android.text.Html.TagHandler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.fancreature.android.jeneponto.Activity.Perizinan;
import com.fancreature.android.jeneponto.HttpHandler;
import com.fancreature.android.jeneponto.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.XMLReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.JarEntry;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by pranadana on 8/15/2017.
 */

public class IzinDaerah extends Fragment implements TagHandler, View.OnClickListener {
    private String TAG = IzinDaerah.class.getSimpleName();

    private ProgressDialog pDialog;

    @Bind(R.id.list)
    ListView lv;
    //
//    @Bind(R.id.llay)
//    LinearLayout llay;
    // URL to get contacts JSON
    private static String urlList = "http://visitjeneponto.id/connection/getListIzinApps.php/";
    private static String urlKonten = "http://visitjeneponto.id/connection/getKontenIzinApps.php/id=?";
//    private Uri urix = Uri.parse("http://www.visitjeneponto.id"); // missing 'http://' will cause crashed

    ArrayList<HashMap<String, String>> contactList;
    ArrayList<HashMap<String, String>> contactKonten;


    //    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.httpsample, container, false);
//
////        getActivity();
//
//        return rootView;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.listview_perizinan_daerah, container, false);

//    rootView.findViewById(R.id.l)
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contactList = new ArrayList<>();
        new GetContacts().execute();


//        setContentView(R.layout.httpsample);
//        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.FContent); //Remember this is the FrameLayout area within your activity_main.xml
//        getLayoutInflater().inflate(R.layout.httpsample, contentFrameLayout);
    }

    @Override
    public void handleTag(boolean opening, String tag, Editable output, XMLReader xmlReader) {
        if (tag.equals("ul") && !opening) output.append("\n");
        if (tag.equals("li") && opening) output.append("\n\tâ€¢ ");
    }


    /**
     * Async task class to get json by making HTTP call
     */


    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(IzinDaerah.super.getContext());
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStrList = sh.makeServiceCall(urlList);
            String jsonStrKonten = sh.makeServiceCall(urlKonten);

            Log.e(TAG, "Response from url: " + jsonStrList);
            Log.e(TAG, "Response from url: " + jsonStrKonten);

            if (jsonStrList != null) {
                try {
                    JSONObject jsonObjList = new JSONObject(jsonStrList);
                    JSONObject jsonObjKonten = new JSONObject(jsonStrKonten);

                    // Getting JSON Array node
                    JSONArray contactsList = jsonObjList.getJSONArray("kategori");
                    JSONArray contactsKonten = jsonObjKonten.getJSONArray("page_konten");

                    // looping through All Contacts
                    for (int i = 0; i < contactsList.length(); i++) {
                        JSONObject a = contactsKonten.getJSONObject(i);
                        JSONObject c = contactsList.getJSONObject(i);

//                        String kategoriId = c.getString("kategori_id");
                        String namaKategori = c.getString("nm_kategori");
                        String kategoriReffId = a.getString("kategori_reff_id");
                        String konten = String.valueOf(Html.fromHtml(a.getString("page_konten"), null, new IzinDaerah()));
//                        String kategoriReffId = a.getString("kategori_reff_id");
//                        String persyaratan = String.valueOf(Html.fromHtml(c.getString("persyaratan")));

                        // Phone node is JSON Object
//                        JSONObject phone = c.getJSONObject("phone");
//                        String mobile = phone.getString("mobile");
//                        String home = phone.getString("home");
//                        String office = phone.getString("office");

                        // tmp hash map for single contact
                        HashMap<String, String> contact = new HashMap<>();

                        // adding each child node to HashMap key => value

//                        contact.put("kategori_id", kategoriId);
                        contact.put("nm_kategori", namaKategori);
                        contact.put("kategori_reff_id", kategoriReffId);
                        contact.put("page_konten", konten);
//                        contact.put("kategori_reff_id", kategoriReffId);

                        // adding contact to contact list
                        contactList.add(contact);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
//                    runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            Toast.makeText(getContext(),
//                                    "Json parsing error: " + e.getMessage(),
//                                    Toast.LENGTH_LONG)
//                                    .show();
//                        }
//                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Toast.makeText(getContext(),
//                                "Couldn't get json from server. Check LogCat for possible errors!",
//                                Toast.LENGTH_LONG)
//                                .show();
//                    }
//                });

            }
            return null;

        }

        @RequiresApi(api = Build.VERSION_CODES.M)
        @Override
        protected void onPostExecute(final Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

//            final String kategoriReff = new String("kategori_reff_id");

//            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                    HttpHandler sh = new HttpHandler();
//
//                    // Making a request to url and getting response
//
//                    String linkKonten = urlKonten + kategoriReff;
//
//                    Log.e(TAG, "Response from url: " + linkKonten);
//
//                    if (linkKonten != null) {
//                        try {
//                            JSONObject jsonObjKonten = new JSONObject(linkKonten);
//
//                            // Getting JSON Array node
//                            JSONArray contactsKonten = jsonObjKonten.getJSONArray(String.valueOf(kategoriReff));
//
//                            JSONObject ambilId = contactsKonten.getJSONObject(0);
//                            String konten = String.valueOf(Html.fromHtml(ambilId.getString("page_konten"), null, new IzinDaerah()));
////                        String kategoriReffId = a.getString("kategori_reff_id");
////                        String persyaratan = String.valueOf(Html.fromHtml(c.getString("persyaratan")));
//
//                            // Phone node is JSON Object
////                        JSONObject phone = c.getJSONObject("phone");
////                        String mobile = phone.getString("mobile");
////                        String home = phone.getString("home");
////                        String office = phone.getString("office");
//
//                            // tmp hash map for single contact
//                            HashMap<String, String> contact = new HashMap<>();
//
//                            // adding each child node to HashMap key => value
//
//                            contact.put("kategori_reff_id", String.valueOf(ambilId));
//                            contact.put("page_konten", konten);
////                        contact.put("kategori_reff_id", kategoriReffId);
//
//                            // adding contact to contact list
//                            contactList.add(contact);
//                        } catch (final JSONException e) {
//                            Log.e(TAG, "Json parsing error: " + e.getMessage());
//                        }
//                    } else {
//                        Log.e(TAG, "Couldn't get json from server.");
//                    }

            ListAdapter adapterList = new SimpleAdapter(
                    IzinDaerah.super.getContext(), contactList,
                    R.layout.list_izin_daerah, new String[]{"nm_kategori", "page_konten"}, new int[]{R.id.nama_izin, R.id.keteranganIzinDaerah});
            lv.setAdapter(adapterList);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onClick(View v){
    }

}
