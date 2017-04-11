package com.example.mohitkumar.originalsynergygo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Residence extends AppCompatActivity {

    EditText name,noFamilyMem,workingMem,dependMem,children,spouseEmp,registration,carpetArea,politicalInflu,otherRemarks,relapp,mob,noyears,doba,eduqual;
    String sname,snoFamilyMem,sworkingMem,sdependMem,schildren,sspouseEmp,sresidence,smaritalStatus,slocality;
    Spinner residence,maritalStatus,locality,resambience,ncheck,clientcoop;
    ArrayAdapter<CharSequence> residenceadapter;
    ArrayAdapter<CharSequence> maritaladapter;
    ArrayAdapter<CharSequence> localityadapter;

    String sregistration,scarpetArea,spoliticalInflu,sotherRemarks,svehicle;
    Spinner vehicle;
    String filestr,agentid;
    ArrayAdapter<CharSequence> vehicleadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residence);

        getSupportActionBar().setTitle("Fill the Details");

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
        politicalInflu= (EditText)findViewById(R.id.PoliticaleditText);
        otherRemarks= (EditText)findViewById(R.id.OtherRemarkseditText);
        vehicle=(Spinner) findViewById(R.id.Vehiclespinner);
        resambience = (Spinner) findViewById(R.id.res_ambience);
        relapp = (EditText) findViewById(R.id.relationmet);
        mob = (EditText) findViewById(R.id.mobno);
        noyears = (EditText) findViewById(R.id.noyears);
        doba = (EditText) findViewById(R.id.dobapp);
        eduqual = (EditText) findViewById(R.id.eduqual);
        ncheck = (Spinner) findViewById(R.id.neighbour_check);
        clientcoop = (Spinner) findViewById(R.id.coopspinner);

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

        vehicleadapter=ArrayAdapter.createFromResource(this,R.array.vehicle,R.layout.support_simple_spinner_dropdown_item);
        vehicleadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        vehicle.setAdapter(vehicleadapter);

        vehicle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i)
                {
                    case 0:
                        svehicle="Two Wheeler";
                        break;
                    case 1:
                        svehicle="Car";
                        break;
                    case 2:
                        svehicle="other";

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
}
