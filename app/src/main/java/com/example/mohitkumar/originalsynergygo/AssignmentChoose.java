package com.example.mohitkumar.originalsynergygo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.Map;

public class AssignmentChoose extends AppCompatActivity {


    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    RecyclerView recyclerView;
    ArrayList<String> fi = new ArrayList<String>();
    ArrayList<CardDetails> list = new ArrayList<CardDetails>();
    public static final int EXTERNAL_STORAGE_CODE = 101;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_choose);


        final String AgentID = getIntent().getStringExtra("Agent");
        getSupportActionBar().setTitle("Agent ID : " + AgentID);
        recyclerView = (RecyclerView)findViewById(R.id.recyc_view);

        if(isNetworkAvailable(getApplicationContext())) {

            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("Wait...");
            progressDialog.show();
            progressDialog.setCancelable(true);


            layoutManager = new LinearLayoutManager(AssignmentChoose.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setHasFixedSize(true);
            BackgroundTask backGroundTask = new BackgroundTask(AssignmentChoose.this);
            list = backGroundTask.getList();
            adapter = new RecyclerCardAdapter(AssignmentChoose.this,list);
            recyclerView.setAdapter(adapter);


            progressDialog.dismiss();
        } else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setTitle("No Internet Connection...")
                    .setMessage("Click Here to set Active connection")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                        }
                    })
                    .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .setIcon(R.drawable.error)
                    .show();
        }
    }

    public boolean isNetworkAvailable(final Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
