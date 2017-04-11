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

public class Business extends AppCompatActivity {

    EditText name,desig,contact,offTele,bussNature,YearCompany,noEmployee;
    String sname,sdesig,scontact,soffTele,sbussNature,sYearCompany,snoEmployee;
    Spinner typeCompany;
    String filestr,agenti;
    String stypeCompany;
    ArrayAdapter<CharSequence> typecompadapter;
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
    }

    public void onClickNextb1(View view) {

        filestr = getIntent().getExtras().getString("file");
        sname = name.getText().toString().trim();
        sdesig = desig.getText().toString().trim();
        scontact = contact.getText().toString().trim();
        soffTele = offTele.getText().toString().trim();
        sbussNature = bussNature.getText().toString().trim();
        sYearCompany = YearCompany.getText().toString().trim();

    }
}
