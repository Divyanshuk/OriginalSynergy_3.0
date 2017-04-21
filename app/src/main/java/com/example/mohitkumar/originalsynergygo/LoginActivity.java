package com.example.mohitkumar.originalsynergygo;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    EditText agentId,pass;
    String id,passw;
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
        String server_url = "";

        if(isNetworkAvailable(getApplicationContext())) {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, server_url, (JSONObject) null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        id = response.getString("USERNAME");
                        passw = response.getString("PASSWORD");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });

            MySingleton.getmInstance(LoginActivity.this).addToRequestQueue(jsonObjectRequest);

            if (pass.equals(PassIn)) {
                Intent intent = new Intent(LoginActivity.this, AssignmentChoose.class);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Wrong Details please try again.", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(),"Check your Network",Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(LoginActivity.this, AssignmentChoose.class);
        intent.putExtra("Agent",AgentIDin);
        startActivity(intent);
    }
}
