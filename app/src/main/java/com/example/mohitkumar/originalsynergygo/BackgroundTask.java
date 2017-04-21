package com.example.mohitkumar.originalsynergygo;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mohitkumar on 12/04/17.
 */

public class BackgroundTask {

    Context context;
    String name;
    ArrayList<CardDetails> arrayList = new ArrayList<CardDetails>();

    String json_url = "http://139.59.5.200/repignite/android/fetchallocations.php";

    public BackgroundTask(Context context,String name) {
        this.context = context;
        this.name = name;
    }

    public ArrayList<CardDetails> getList() {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Wait..");
        progressDialog.setMessage("Adding you to our network");
        progressDialog.show();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, json_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("TAG",response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // progressDialog.dismiss();
                Toast.makeText(context,"No connection",Toast.LENGTH_LONG).show();
                error.printStackTrace();
            }
        })
//         JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, json_url, (JSONArray) null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                int count = 0;
//                Log.d("NOW HERE","IN HERE");
//                while(count<response.length()) {
//                    try {
//                        JSONObject jsonObject = response.getJSONObject(count);
//                        CardDetails cardDetails = new CardDetails(jsonObject.getString("REFNO"),jsonObject.getString("DOR"),jsonObject.getString("NAME"),jsonObject.getString("ADDRESS"),jsonObject.getString("MOBILE"),jsonObject.getString("FOS"),
//                              jsonObject.getString("APPLORCO"),jsonObject.getString("TYPE"));
//                           arrayList.add(cardDetails);
//                        count++;
//                        Log.d("TAG",jsonObject.getString("REFNO"));
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
//        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                Log.d("FIRST HERE",name);
                params.put("fosname",name);
                return params;
            }

//             @Override
//             protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
//
//                 try {
//                     String jsonString = new String(response.data,
//                             HttpHeaderParser
//                                     .parseCharset(response.headers));
//                     return Response.success(new JSONArray(jsonString),
//                             HttpHeaderParser
//                                     .parseCacheHeaders(response));
//                 } catch (UnsupportedEncodingException e) {
//                     return Response.error(new ParseError(e));
//                 } catch (JSONException je) {
//                     return Response.error(new ParseError(je));
//                 }
//
//             }
         };

        MySingleton.getmInstance(context).addToRequestQueue(stringRequest);
//
        return arrayList;
    }
}
