package com.example.mohitkumar.originalsynergygo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Residence extends AppCompatActivity {

    EditText name,noFamilyMem,workingMem,dependMem,children,twowheeler,fourwheeler,spouseEmp,registration,carpetArea,otherRemarks,mob,noyears,doba,eduqual;
    String sname,snoFamilyMem,sworkingMem,sdependMem,schildren,sspouseEmp,sresidence,smaritalStatus,slocality,sspousework;
    Spinner residence,maritalStatus,locality,resambience,ncheck,clientcoop,spousework,addlock,relapp;
    ArrayAdapter<CharSequence> residenceadapter,ambienceadapter;
    ArrayAdapter<CharSequence> maritaladapter;
    ArrayAdapter<CharSequence> localityadapter,spouseworkadapter,clientcoopadapter,addlockadapter;
    LinearLayout linearLayout;

    String sregistration,scarpetArea,spoliticalInflu,sotherRemarks,saddlock,srelapp,smob,snoyears,sdoba,seduqual;
    String filestr,agentid,applorcoappl;
    ArrayAdapter<CharSequence> vehicleadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);

        getSupportActionBar().setTitle("Fill the Details");

        applorcoappl = getIntent().getStringExtra("appl_coappl");
        filestr = getIntent().getStringExtra("uniid");

        linearLayout = (LinearLayout) findViewById(R.id.lin_s_emp);
        name= (EditText)findViewById(R.id.Personnameet);
        noFamilyMem=(EditText)findViewById(R.id.FamilymemeditText);
        workingMem=(EditText)findViewById(R.id.workingmemeditText);
        dependMem=(EditText)findViewById(R.id.dependenteditText);
        children=(EditText)findViewById(R.id.ChildreneditText);
        spouseEmp=(EditText)findViewById(R.id.SpouseeditText);
        residence =(Spinner) findViewById(R.id.ResStatusSpinner);
        maritalStatus=(Spinner) findViewById(R.id.MaritalStatusSpinner);
        locality=(Spinner) findViewById(R.id.Localityspinner);
        registration= (EditText)findViewById(R.id.RegNoeditText);
        carpetArea= (EditText)findViewById(R.id.CarpetAreaeditText);
        //politicalInflu= (EditText)findViewById(R.id.PoliticaleditText);
        otherRemarks= (EditText)findViewById(R.id.OtherRemarkseditText);
        twowheeler=(EditText) findViewById(R.id.two_wheeler);
        fourwheeler = (EditText) findViewById(R.id.fourwheelerseen);
        resambience = (Spinner) findViewById(R.id.res_ambience);
        relapp = (Spinner) findViewById(R.id.rel_Appl);
        mob = (EditText) findViewById(R.id.mobno);
        noyears = (EditText) findViewById(R.id.noyears);
        doba = (EditText) findViewById(R.id.dobapp);
        addlock = (Spinner) findViewById(R.id.add_check);
        eduqual = (EditText) findViewById(R.id.eduqual);
        ncheck = (Spinner) findViewById(R.id.neighbour_check);
        clientcoop = (Spinner) findViewById(R.id.coopspinner);
        spousework = (Spinner)findViewById(R.id.SpouseWorkSpinner);

        residenceadapter=ArrayAdapter.createFromResource(this,R.array.resstatus,R.layout.support_simple_spinner_dropdown_item);
        residenceadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        residence.setAdapter(residenceadapter);

        residence.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:
                        sresidence="Self Owned";
                        break;
                    case 1:
                        sresidence="Owned By Relatives";
                        break;
                    case 2:
                        sresidence=" Rented";
                        break;
                    case 3:
                        sresidence="Paying Guest";
                        break;
                    case 4:
                        sresidence="Owned by Parents";
                        break;
                    case 5:
                        sresidence=" Owned by Friends";
                        break;
                    case 6:
                        sresidence="Company Accommodation";
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        maritaladapter=ArrayAdapter.createFromResource(this,R.array.marital,R.layout.support_simple_spinner_dropdown_item);
        maritaladapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        maritalStatus.setAdapter(maritaladapter);

        maritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        smaritalStatus = "Single";
                        break;
                    case 1:
                        smaritalStatus = "Married";
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        clientcoopadapter=ArrayAdapter.createFromResource(this,R.array.transfer,R.layout.support_simple_spinner_dropdown_item);
        clientcoopadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        clientcoop.setAdapter(clientcoopadapter);

        addlockadapter=ArrayAdapter.createFromResource(this,R.array.transfer,R.layout.support_simple_spinner_dropdown_item);
        addlockadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        addlock.setAdapter(addlockadapter);

        spouseworkadapter = ArrayAdapter.createFromResource(this,R.array.transfer,R.layout.support_simple_spinner_dropdown_item);
        spouseworkadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spousework.setAdapter(spouseworkadapter);

        spousework.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {
                    case 0:
                        sspousework = "YES";

                        break;
                    case 1:
                        sspousework = "NO";
                        linearLayout.setVisibility(View.GONE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        ambienceadapter = ArrayAdapter.createFromResource(this,R.array.ambience,R.layout.support_simple_spinner_dropdown_item);
        ambienceadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        resambience.setAdapter(ambienceadapter);


        localityadapter=ArrayAdapter.createFromResource(this,R.array.locality,R.layout.support_simple_spinner_dropdown_item);
        localityadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        locality.setAdapter(localityadapter);

        locality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {

                    case 0:
                        slocality="Posh Locality";
                        break;
                    case 1:
                        slocality="Village Area";
                        break;
                    case 2:
                        slocality="Lodging";
                        break;
                    case 3:
                        slocality="Upper Middle Class";
                        break;
                    case 4:
                        slocality="Lower Middle Class";
                        break;
                    case 5:
                        slocality="Slum Locality";
                        break;
                    case 6:
                        slocality="Middle Class";
                        break;
                    case 7:
                        slocality="Residential Complex";
                        break;
                    case 8:
                        slocality="Others";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void onClicknextsr1(View view) {

        sname = name.getText().toString();
        snoFamilyMem = noFamilyMem.getText().toString();
        sworkingMem = workingMem.getText().toString();
        sdependMem = dependMem.getText().toString();
        schildren = children.getText().toString();
        sspouseEmp = spouseEmp.getText().toString();
        sresidence = residence.getSelectedItem().toString();
        smaritalStatus = maritalStatus.getSelectedItem().toString();
        slocality = locality.getSelectedItem().toString();
        sregistration = registration.getText().toString();
        scarpetArea = carpetArea.getText().toString();
        //spoliticalInflu = politicalInflu.getText().toString();
        sotherRemarks = otherRemarks.getText().toString();
        srelapp = relapp.getSelectedItem().toString();
        smob = mob.getText().toString();
        snoyears = noyears.getText().toString();
        sdoba = doba.getText().toString();
        seduqual = eduqual.getText().toString();
        saddlock = addlock.getSelectedItem().toString();
        final String sclientcoop = clientcoop.getSelectedItem().toString();
        final String stwo = twowheeler.getText().toString();
        final String sfour = fourwheeler.getText().toString();
        sspousework = spousework.getSelectedItem().toString();
        final String sambience = resambience.getSelectedItem().toString();

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
                    params.put("tablename","appl_residence");
                } else {
                    params.put("tablename","coappl_residence");
                }


                params.put("REFNO",filestr);
                params.put("PERSONMET",sname);
                params.put("RELATIOAPPL",srelapp);
                params.put("PERSONPHONE",smob);
                params.put("NOOFYEARS",snoyears);
                params.put("DOBAPPL",sdoba);
                params.put("EDUQUAL",seduqual);
                params.put("RESISTATUS",sresidence);
                params.put("MARITALSTATUS",smaritalStatus);
                params.put("NOOFFAMILY",snoFamilyMem);
                params.put("WORKING",sworkingMem);
                params.put("ADULTSDEP",sdependMem);
                params.put("CHILDDEP",schildren);
                params.put("SPOUSEWORK",sspousework);
                params.put("SPOUSEEMP",sspouseEmp);
                params.put("COOPERATIVE",sclientcoop);
                params.put("NEIGHBOURHOOD",saddlock);
                params.put("LOCALITY",slocality);
                params.put("AMBIENCE",sambience);
                params.put("CARPETAREA",scarpetArea);
                params.put("NAPPLSTAY","");
                params.put("NNOOFFAMILY","");
                params.put("WHEELER2",stwo);
                params.put("WHEELER4",sfour);
                params.put("REMARKS",sotherRemarks);

                return params;
            }
        };

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }
}