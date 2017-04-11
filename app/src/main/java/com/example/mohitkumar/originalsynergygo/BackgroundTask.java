package com.example.mohitkumar.originalsynergygo;

import android.app.ProgressDialog;
import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by mohitkumar on 12/04/17.
 */

public class BackgroundTask {

    Context context;
    ArrayList<CardData> arrayList = new ArrayList<CardData>();

    String json_url = "http://139.59.20.254/medex/android/forsale.php";

    public BackgroundTask(Context context) {
        this.context = context;
    }

    public ArrayList<CardData> getList() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Wait..");
        progressDialog.setMessage("Adding you to our network");
        progressDialog.show();
//        final JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, (String) null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                int count = 0;
//                while(count<response.length()) {
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(count);
//                    //    CardData cardData = new CardData(jsonObject.getString("MEDDESC"),jsonObject.getString("MEDNAME"),jsonObject.getString("EXPDATE"),jsonObject.getString("PRICE"),jsonObject.getString("QUANTITY"),jsonObject.getString("USERNAME"));
//                    //    arrayList.add(cardData);
//                        count++;
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        }
//        );
//
//        MySingleton.getInstance(context).addToRequestQueue(jsonArrayRequest);
//
        return arrayList;
    }
}
