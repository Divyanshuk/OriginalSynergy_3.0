package com.example.mohitkumar.originalsynergygo;

import android.app.ProgressDialog;
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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Business extends AppCompatActivity {

    EditText name,desig,contact,offTele,bussNature,YearCompany,noEmployee,appnamever,namebusiness,pdesig,remarks,noBranches;
    String sname,sdesig,scontact,soffTele,sbussNature,sYearCompany,snoEmployee,sverified,svcard,sremarks;
    Spinner typeCompany,vcard,nameboard,ambience,exterior,bact,locate,empsighted,polaffl,recomm;
    String filestr,agenti,applorcoappl;
    String stypeCompany,snameboard,sambience,sexterior,sbact,slocate,sempsighted,spolaffl;
    ArrayAdapter<CharSequence> typecompadapter,nameBoardadapter,ambienceadapter,exterioradapter,bactadapter
            ,locateadapter,empsightedadapter,polaffladapter,vcardadapter,recommadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        applorcoappl = getIntent().getStringExtra("appl_coappl");
        filestr = getIntent().getExtras().getString("uniid");


        name= (EditText)findViewById(R.id.nameeditText);
        nameboard = (Spinner)findViewById(R.id.nameboard);
        ambience = (Spinner) findViewById(R.id.amb_office);
        desig= (EditText)findViewById(R.id.designationeditText);
        contact= (EditText)findViewById(R.id.phoneeditText);
        offTele= (EditText)findViewById(R.id.offteleditText);
        bussNature= (EditText)findViewById(R.id.busnatureeditText);
        YearCompany= (EditText)findViewById(R.id.yearseditText);
        namebusiness = (EditText)findViewById(R.id.namebusiness);
        noEmployee= (EditText)findViewById(R.id.EmpeditText);
        exterior = (Spinner) findViewById(R.id.exterior);
        noBranches = (EditText) findViewById(R.id.noOfbranches);
        pdesig = (EditText) findViewById(R.id.persondesignation);
        locate = (Spinner) findViewById(R.id.easy_locate);
        polaffl = (Spinner) findViewById(R.id.disp_aff_party);
        remarks = (EditText) findViewById(R.id.OtherRemarkseditText);
        empsighted = (Spinner) findViewById(R.id.no_of_in_prem);
        bact = (Spinner) findViewById(R.id.business_activity);
        typeCompany= (Spinner) findViewById(R.id.spinnecompanytyper);
        vcard = (Spinner) findViewById(R.id.vcardspinner);
        appnamever = (EditText) findViewById(R.id.app_verifired_whom);
        recomm = (Spinner)findViewById(R.id.recomm);

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

        exterior.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        recommadapter = ArrayAdapter.createFromResource(this, R.array.recom_or_not, R.layout.support_simple_spinner_dropdown_item);
        recommadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        recomm.setAdapter(polaffladapter);
    }

    public void onClickNextb1(View view) {

        ProgressDialog progressDialog = new ProgressDialog(Business.this);
        progressDialog.setTitle("Uploadng");
        progressDialog.setMessage("Pushing your details....");
        progressDialog.setCancelable(false);
        progressDialog.show();

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
        sremarks = remarks.getText().toString();
        final String spdesig = pdesig.getText().toString();
        final String namebus = namebusiness.getText().toString();
        final String sbranches = noBranches.getText().toString();
        final String srecomm = recomm.getSelectedItem().toString();

        Date date = new Date();
        long hours = date.getHours();
        long minutes = date.getMinutes();
        final String time = String.valueOf(hours) + String.valueOf(minutes);

        long dt = date.getDate();
        final String date1 = String.valueOf(dt);

        String server_url = "http://139.59.5.200/repignite/android/addtotable.php";

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

                if(applorcoappl.equals("APPLICANT")) {
                    params.put("tablename","appl_business");
                } else {
                    params.put("tablename","coappl_business");
                }

                params.put("REFNO",filestr);
                params.put("DATE",date1);
                params.put("TIME",time);
                params.put("PERSONMET",sname);
                params.put("DESIGNAPPL",sdesig);
                params.put("PERSONDESIGN",spdesig);
                params.put("PERSONPHONE",scontact);
                params.put("NOOFYEARS",sYearCompany);
                params.put("VISITCARD",svcard);
                params.put("ORGNAME",namebus);
                params.put("ORGNAME",sbussNature);
                params.put("ORGTYPE", stypeCompany);
                params.put("NOOFEMPL",snoEmployee);
                params.put("NOOFBRANCH",sbranches);
                params.put("BOOLBOARD",snameboard);
                params.put("AMBIENCE",sambience);
                params.put("EXTERIOR",sexterior);
                params.put("VERIFFROM",sverified);
                params.put("EASELOCATE",slocate);
                params.put("ORGACTIVITY",sbact);
                params.put("POLPARTYAFFL",spolaffl);
                params.put("RECOMM",srecomm);
                params.put("SEENNOOFEMPL",sempsighted);
                params.put("REMARKS",sremarks);

                return params;
            }
        };

        MySingleton.getInstance(Business.this).addToRequestQueue(stringRequest);

        progressDialog.dismiss();
    }
}
