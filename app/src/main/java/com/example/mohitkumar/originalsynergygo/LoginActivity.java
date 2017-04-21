package com.example.mohitkumar.originalsynergygo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {


    EditText agentId,pass;
    String id,passw,tablename;
    public String AgentIDin,PassIn;
    ArrayList<String> list = new ArrayList<String>();
    public static final int EXTERNAL_STORAGE_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        agentId=(EditText)findViewById(R.id.AgenitIDeditText);
        pass=(EditText)findViewById(R.id.PasseditText);
    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    public void onClickLogin(View view) {
        AgentIDin = agentId.getText().toString();
        PassIn = pass.getText().toString();

        Log.d("PassIn",PassIn);

        if (AgentIDin.equals("") || PassIn.equals("")) {
            Toast.makeText(getApplicationContext(), "Enter the details", Toast.LENGTH_LONG).show();
        } else {
            String server_url = "http://139.59.5.200/repignite/android/fetchtable.php";

            if (isNetworkAvailable(getApplicationContext())) {
                StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("TAG",response);
                            JSONObject jsonObject = new JSONObject(response);
                            id = jsonObject.getString("FOSNAME");
                            passw = jsonObject.getString("FOSPASS");
                            Log.d("passw",passw);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<String, String>();

                        tablename = params.put("tablename","fosdetails");

                        return params;
                    }
                };

                MySingleton.getInstance(LoginActivity.this).addToRequestQueue(stringRequest);

             //   if (passw.equals(PassIn)) {
//                    Intent intent = new Intent(LoginActivity.this, AssignmentChoose.class);
//                    intent.putExtra("Agent",AgentIDin);
//                  //  startActivity(intent);
//                } else {
//                    Toast.makeText(getApplicationContext(), "Wrong Details please try again.", Toast.LENGTH_LONG).show();
//                }
            } else {
                Toast.makeText(getApplicationContext(), "Check your Network", Toast.LENGTH_LONG).show();
            }

//        Intent intent = new Intent(LoginActivity.this, AssignmentChoose.class);
//        startActivity(intent);
        }
    }
}
