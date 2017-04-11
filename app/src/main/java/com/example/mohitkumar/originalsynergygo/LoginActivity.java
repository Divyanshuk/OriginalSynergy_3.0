package com.example.mohitkumar.originalsynergygo;

import android.content.Context;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {


    EditText agentId,pass;
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
}
