package com.example.mohitkumar.originalsynergygo;

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

public class Office extends AppCompatActivity {



    EditText name,designation,mobile,joinDate,desigApp,noYears,companyNature,remarks,detsalary,orgname;
    String sname,sdesignation,smobile,sjoinDate,sdesigApp,snoYears,scompanyNature,sremarks,sjobType,sworkOrg,sjobTransfer,sdetsalary;
    String filestr,agentid,applorcoappl;
    Spinner jobType,workOrg,jobTransfer,recomm;
    ArrayAdapter<CharSequence> jobtypeadapter;
    ArrayAdapter<CharSequence> workorgadapter;
    ArrayAdapter<CharSequence> jobtransferadapter,recommadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office);

        applorcoappl = getIntent().getStringExtra("appl_coappl");
        filestr = getIntent().getStringExtra("uniid");
        name=(EditText)findViewById(R.id.personconteditText);
        designation=(EditText)findViewById(R.id.desigPCeditText);
        mobile=(EditText)findViewById(R.id.mobPCeditText);
        //joinDate=(EditText)findViewById(R.id.DateAppjoineditText);
        desigApp=(EditText)findViewById(R.id.DesgAppeditText);
        noYears=(EditText)findViewById(R.id.yearseditText);
        companyNature=(EditText)findViewById(R.id.CompanyNatureeditText);
        remarks=(EditText)findViewById(R.id.OtherRemarkseditText);
        jobType=(Spinner)findViewById(R.id.jobtypespinner);
        workOrg=(Spinner)findViewById(R.id.workingAsspinner);
        jobTransfer=(Spinner)findViewById(R.id.transferspinner);
        detsalary = (EditText)findViewById(R.id.det_ver);
        orgname = (EditText) findViewById(R.id.nameoforganisation);
        recomm = (Spinner)findViewById(R.id.recomm);

        jobtypeadapter=ArrayAdapter.createFromResource(this,R.array.jobtype,R.layout.support_simple_spinner_dropdown_item);
        jobtypeadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        jobType.setAdapter(jobtypeadapter);

        jobType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {

                    case 0:
                        sjobType="Permanent";
                        break;
                    case 1:
                        sjobType="Probation";
                        break;
                    case 2:
                        sjobType="Contract Worker";
                        break;
                    case 3:
                        sjobType="Temporary Worker";
                        break;
                    case 4:
                        sjobType="Others";
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        workorgadapter=ArrayAdapter.createFromResource(this,R.array.workorg,R.layout.support_simple_spinner_dropdown_item);
        workorgadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        workOrg.setAdapter(workorgadapter);

        workOrg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        sworkOrg="Typist";
                        break;
                    case 1:
                        sworkOrg="Stenographer";
                        break;
                    case 2:
                        sworkOrg="Supervisor";
                        break;
                    case 3:
                        sworkOrg="Junior Management";
                        break;
                    case 4:
                        sworkOrg="Middle Management";
                        break;
                    case 5:
                        sworkOrg="Senior Management";
                        break;
                    case 6:
                        sworkOrg="Other Management";
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        jobtransferadapter=ArrayAdapter.createFromResource(this,R.array.transfer,R.layout.support_simple_spinner_dropdown_item);
        jobtransferadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        jobTransfer.setAdapter(jobtransferadapter);

        jobTransfer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch(i)
                {
                    case 0:
                        sjobTransfer="Yes";
                        break;
                    case 1:
                        sjobTransfer="No";
                        break;
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        recommadapter=ArrayAdapter.createFromResource(this,R.array.recom_or_not,R.layout.support_simple_spinner_dropdown_item);
        recommadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        recomm.setAdapter(jobtransferadapter);
    }

    public void onClickNextso1(View view) {
        filestr=getIntent().getStringExtra("file");
        sname=name.getText().toString().trim();
        sdesignation=designation.getText().toString().trim();
        smobile=mobile.getText().toString().trim();
        sjoinDate=joinDate.getText().toString().trim();
        sdesigApp=desigApp.getText().toString().trim();
        snoYears=noYears.getText().toString().trim();
        scompanyNature=companyNature.getText().toString().trim();
        sremarks=remarks.getText().toString().trim();
        sdetsalary = detsalary.getText().toString().trim();
        final String sorgname = orgname.getText().toString();
        final String recom = recomm.getSelectedItem().toString();

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
                Map<String,String> params = new HashMap<String, String>();

                if(applorcoappl.equals("APPLICANT")) {
                    params.put("tablename","appl_employment");
                } else {
                    params.put("tablename","coappl_employment");
                }

                params.put("REFNO",filestr);
                params.put("PERSONMET",sname);
                params.put("DESIGNAPPL",sdesigApp);
                params.put("PERSONDESIGN",sdesignation);
                params.put("PERSONPHONE",smobile);
                params.put("NOOFYEARS",snoYears);
                params.put("ORGNAME",sorgname);
                params.put("ORGNATURE",scompanyNature);
                params.put("JOBTYPE",sjobType);
                params.put("WORKINGAS",sworkOrg);
                params.put("TRANSFERABLE",sjobTransfer);
                params.put("SALARYPERSON",sdetsalary);
                params.put("SALARYDESIGN","");
                params.put("RECOMM",recom);
                params.put("REMARKS",sremarks);

                return params;

            }
        };

        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
    }

}
