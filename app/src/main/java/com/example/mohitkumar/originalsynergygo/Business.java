package com.example.mohitkumar.originalsynergygo;

import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Business extends AppCompatActivity {

    EditText name,desig,contact,offTele,bussNature,YearCompany,noEmployee,appnamever;
    String sname,sdesig,scontact,soffTele,sbussNature,sYearCompany,snoEmployee,sverified,svcard;
    Spinner typeCompany,vcard,nameboard,ambience,exterior,bact,locate,empsighted,polaffl;
    String filestr,agenti;
    String stypeCompany,snameboard,sambience,sexterior,sbact,slocate,sempsighted,spolaffl;
    ArrayAdapter<CharSequence> typecompadapter,nameBoardadapter,ambienceadapter,exterioradapter,bactadapter
            ,locateadapter,empsightedadapter,polaffladapter,vcardadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        name= (EditText)findViewById(R.id.nameeditText);
        desig= (EditText)findViewById(R.id.designationeditText);
        contact= (EditText)findViewById(R.id.phoneeditText);
        offTele= (EditText)findViewById(R.id.offteleditText);
        bussNature= (EditText)findViewById(R.id.busnatureeditText);
        YearCompany= (EditText)findViewById(R.id.yearseditText);
        noEmployee= (EditText)findViewById(R.id.EmpeditText);
        typeCompany= (Spinner) findViewById(R.id.spinnecompanytyper);
        vcard = (Spinner) findViewById(R.id.vcardspinner);
        appnamever = (EditText) findViewById(R.id.app_verifired_whom);



        typecompadapter = ArrayAdapter.createFromResource(this, R.array.company, R.layout.support_simple_spinner_dropdown_item);
        typecompadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        typeCompany.setAdapter(typecompadapter);

        typeCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        stypeCompany = "C1";
                        break;
                    case 1:
                        stypeCompany = "C2";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        nameBoardadapter = ArrayAdapter.createFromResource(this, R.array.name_board, R.layout.support_simple_spinner_dropdown_item);
        nameBoardadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        nameboard.setAdapter(nameBoardadapter);

        nameboard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        snameboard = "YES";
                        break;
                    case 1:
                        snameboard = "NO";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        vcardadapter = ArrayAdapter.createFromResource(this, R.array.name_board, R.layout.support_simple_spinner_dropdown_item);
        vcardadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        vcard.setAdapter(nameBoardadapter);

        vcard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        svcard = "YES";
                        break;
                    case 1:
                        svcard = "NO";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ambienceadapter = ArrayAdapter.createFromResource(this, R.array.ambience, R.layout.support_simple_spinner_dropdown_item);
        ambienceadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        ambience.setAdapter(ambienceadapter);

        ambience.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        sambience = "AVERAGE";
                        break;
                    case 1:
                        sambience = "GOOD";
                        break;
                    case 2:
                        sambience = "POOR";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        exterioradapter = ArrayAdapter.createFromResource(this, R.array.exteriors, R.layout.support_simple_spinner_dropdown_item);
        exterioradapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        exterior.setAdapter(exterioradapter);

        typeCompany.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        sexterior = "C1";
                        break;
                    case 1:
                        sexterior = "C2";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bactadapter = ArrayAdapter.createFromResource(this, R.array.business_Act, R.layout.support_simple_spinner_dropdown_item);
        bactadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        bact.setAdapter(bactadapter);

        bact.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        sbact = "HIGH";
                        break;
                    case 1:
                        sbact = "MEDIUM";
                        break;
                    case 2:
                        sbact = "LOW";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        locateadapter = ArrayAdapter.createFromResource(this, R.array.easy_locate, R.layout.support_simple_spinner_dropdown_item);
        locateadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        locate.setAdapter(bactadapter);

        locate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        slocate = "HIGH";
                        break;
                    case 1:
                        slocate = "MEDIUM";
                        break;
                    case 2:
                        slocate = "LOW";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        empsightedadapter = ArrayAdapter.createFromResource(this, R.array.emp_sighted, R.layout.support_simple_spinner_dropdown_item);
        empsightedadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        empsighted.setAdapter(empsightedadapter);

        empsighted.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        sempsighted = "YES";
                        break;
                    case 1:
                        sempsighted = "NO";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        polaffladapter = ArrayAdapter.createFromResource(this, R.array.aff_pol_party, R.layout.support_simple_spinner_dropdown_item);
        polaffladapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        polaffl.setAdapter(polaffladapter);

        polaffl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        spolaffl = "YES";
                        break;
                    case 1:
                        spolaffl = "NO";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onClickNextb1(View view) {

        filestr = getIntent().getExtras().getString("file");
        sname = name.getText().toString().trim();
        sdesig = desig.getText().toString().trim();
        scontact = contact.getText().toString().trim();
        soffTele = offTele.getText().toString().trim();
        sbussNature = bussNature.getText().toString().trim();
        sYearCompany = YearCompany.getText().toString().trim();
        snoEmployee = noEmployee.getText().toString();
        stypeCompany = typeCompany.getSelectedItem().toString();
        spolaffl = polaffl.getSelectedItem().toString();
        sempsighted = empsighted.getSelectedItem().toString();
        sexterior = exterior.getSelectedItem().toString();
        sambience = ambience.getSelectedItem().toString();
        snameboard = nameboard.getSelectedItem().toString();
        sbact = bact.getSelectedItem().toString();
        slocate = locate.getSelectedItem().toString();
        sverified = appnamever.getText().toString();
        svcard = vcard.getSelectedItem().toString();

        String server_url = "";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // progressDialog.dismiss();
                Toast.makeText(getApplicationContext(),"No connection",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                params.put("REFNO","");
                params.put("PERSONMET",sname);
                params.put("DESIGNAPPL",sdesig);
                params.put("PERSONDESIGN","");
                params.put("PERSONPHONE",scontact);
                params.put("NOOFYEARS",sYearCompany);
                params.put("VISITCARD",svcard);
                params.put("ORGNAME","");
                params.put("ORGNAME",sbussNature);
                params.put("ORGTYPE", stypeCompany);
                params.put("NOOFEMPL",snoEmployee);
                params.put("NOOFBRANCH","");
                params.put("BOOLBOARD",snameboard);
                params.put("AMBIENCE",sambience);
                params.put("EXTERIOR",sexterior);
                params.put("VERIFFROM",sverified);
                params.put("EASELOCATE",slocate);
                params.put("ORGACTIVITY",sbact);
                params.put("POLPARTYAFFL",spolaffl);
                params.put("REMARKS","");
                params.put("SEENNOOFEMPL",sempsighted);
                params.put("REMARKS","");

                return params;
            }
        };

        MySingleton.getInstance(Business.this).addToRequestQueue(stringRequest);
    }
}
