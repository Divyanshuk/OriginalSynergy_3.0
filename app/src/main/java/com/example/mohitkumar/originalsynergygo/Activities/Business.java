package com.example.mohitkumar.originalsynergygo.Activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mohitkumar.originalsynergygo.Adapters.MySingleton;
import com.example.mohitkumar.originalsynergygo.R;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Business extends AppCompatActivity {

    EditText name,desig,contact,offTele,bussNature,YearCompany,noEmployee,appnamever,namebusiness,pdesig,remarks,noBranches,empsighted;
    String sname,sdesig,scontact,soffTele,sbussNature,sYearCompany,snoEmployee,sverified,svcard,sremarks;
    Spinner typeCompany,vcard,nameboard,ambience,exterior,bact,locate,polaffl,recomm;
    String filestr,agenti,applorcoappl;
    ProgressDialog dialog;
    Button refresh;
    private double latitude = 0;
    private double longitude = 0;
    TextView lat,lng;
    public static final int LOCATION_REQ_CODE = 100;
    public static final int EXTERNAL_STORAGE_CODE = 101;
    LocationManager locationManager;
    String stypeCompany,snameboard,sambience,sexterior,sbact,slocate,sempsighted,spolaffl;
    ArrayAdapter<CharSequence> typecompadapter,nameBoardadapter,ambienceadapter,exterioradapter,bactadapter
            ,locateadapter,empsightedadapter,polaffladapter,vcardadapter,recommadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business);

        applorcoappl = getIntent().getStringExtra("appl_coappl");
        filestr = getIntent().getExtras().getString("uniid");

        Log.d("TAG",applorcoappl);
        Log.d("TAG56",filestr);

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
        empsighted = (EditText) findViewById(R.id.no_emp_in_prem);
        bact = (Spinner) findViewById(R.id.business_activity);
        typeCompany= (Spinner) findViewById(R.id.spinnecompanytyper);
        vcard = (Spinner) findViewById(R.id.vcardspinner);
        appnamever = (EditText) findViewById(R.id.app_verifired_whom);
        recomm = (Spinner)findViewById(R.id.recomm);

        typecompadapter = ArrayAdapter.createFromResource(this, R.array.company, R.layout.support_simple_spinner_dropdown_item);
        typecompadapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        typeCompany.setAdapter(typecompadapter);

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
        locate.setAdapter(locateadapter);

        locate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                             @Override
                                             public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                                                 switch (i) {
                                                     case 0:
                                                         slocate = "YES";
                                                         break;
                                                     case 1:
                                                         slocate = "NO";
                                                         break;
                                                 }


                                             }

                                             @Override
                                             public void onNothingSelected(AdapterView<?> parent) {

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
        recomm.setAdapter(recommadapter);

        lat = (TextView) findViewById(R.id.lat);
        lng = (TextView) findViewById(R.id.lng);
        refresh = (Button) findViewById(R.id.refresh);

        boolean permissionCheck = LocationPhoto.Utility.checkPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isLocationServicesAvailable(Business.this)) {

                    Log.d("THIS","HERE");
                    dialog = new ProgressDialog(Business.this);
                    dialog.setMessage("Getting Your location....");
                    dialog.show();
                    if (ActivityCompat.checkSelfPermission(Business.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Business.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 100, locationListener);
                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 100, locationListener);
                    dialog.dismiss();
                } else {
                    Log.d("THIS","HERE 2");
                    if (ActivityCompat.checkSelfPermission(Business.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(Business.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    AlertDialog.Builder builder =
                            new AlertDialog.Builder(Business.this);
                    final String action = Settings.ACTION_LOCATION_SOURCE_SETTINGS;
                    final String message = "Enable either GPS or any other location"
                            + " service to find current location.  Click OK to go to"
                            + " location services settings to let you do so.";
                    builder.setTitle("Enable Location");

                    builder.setMessage(message)
                            .setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface d, int id) {
                                            startActivity(new Intent(action));
                                            d.dismiss();
                                        }
                                    })
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface d, int id) {
                                            d.cancel();
                                        }
                                    }).show();
                }

            }
        });

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
        sempsighted = empsighted.getText().toString();
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
        final String latt = lat.getText().toString();
        final String longi = lng.getText().toString();
        Log.d("LONGITUDE",longi);
        Calendar c = Calendar.getInstance();

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        final String time = hour+":"+minutes+":"+seconds;


        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH)+1;
        int year = c.get(Calendar.YEAR);
        final String date = year+"/"+month+"/"+day;
        Log.d("DATE",date);

        String server_url = "http://aztek.in/repignite/android/addtotable.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, server_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("RESPONSE",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // progressDialog.dismiss();
                error.printStackTrace();
                Toast.makeText(getApplicationContext(),"No connection",Toast.LENGTH_LONG).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();

                if(applorcoappl.equals("APPLICANT")) {
                    params.put("tablename","appl_business");
                } else if(applorcoappl.equals("COAPPLICANT")){
                    params.put("tablename","coappl_business");
                }

                Log.d("IN HERE","Reached");

                Log.d("REFNO",filestr);

                params.put("REFNO",filestr);
                params.put("DATEVISIT",date);
                params.put("TIMEVISIT",time);
                params.put("PERSONMET",sname);
                params.put("DESIGNAPPL",spdesig);
                params.put("PERSONDESIGN",sdesig);
                params.put("PERSONPHONE",scontact);
                params.put("NOOFYEARS",sYearCompany);
                params.put("VISITCARD",svcard);
                params.put("ORGNAME",namebus);
                params.put("ORGNATURE",sbussNature);
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
                Log.d("LONG",longi);
                params.put("LATITUDE",latt);
                params.put("LONGITUDE",longi);
                return params;
            }
        };

        MySingleton.getInstance(Business.this).addToRequestQueue(stringRequest);

        progressDialog.dismiss();

        Log.d("REFNO",filestr);
        Intent intent = new Intent(Business.this,LocationPhoto.class);
        intent.putExtra("REFNO",filestr);
        intent.putExtra("ADDRESS","BUSINESS");
        intent.putExtra("APPL",applorcoappl);
        startActivity(intent);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.getDefault());

            try {
                List<Address> addresses=geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                Address address=addresses.get(0);
                String useradd="";
                for(int i=0;i<address.getMaxAddressLineIndex();i++)
                    useradd=useradd+address.getAddressLine(i).toString()+"\n";
                useradd=useradd+(address.getCountryName().toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

            dialog.dismiss();
            latitude = location.getLatitude();
            longitude =location.getLongitude();
            if (latitude != 0 && longitude != 0){

                lat.setText(""+location.getLatitude());
                lng.setText(""+location.getLongitude());

                dialog.dismiss();
            }

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            dialog.dismiss();
        }

        @Override
        public void onProviderDisabled(String provider) {
            dialog.dismiss();
        }
    };

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == LOCATION_REQ_CODE){
            if(permissions[0] == Manifest.permission.ACCESS_FINE_LOCATION)  {
                if(grantResults[0] == PackageManager.PERMISSION_GRANTED)  {
                    dialog.setMessage("Getting Coordinates");
                    dialog.show();
                    //noinspection MissingPermission
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0,locationListener);
                    dialog = new ProgressDialog(Business.this);
                }
            }
        }
    }

    public static boolean isLocationServicesAvailable(Context context) {
        int locationMode = 0;
        String locationProviders;
        boolean isAvailable = false;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(context.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }

            isAvailable = (locationMode != Settings.Secure.LOCATION_MODE_OFF);
        } else {
            locationProviders = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            isAvailable = !TextUtils.isEmpty(locationProviders);
        }

        boolean coarsePermissionCheck = (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED);
        boolean finePermissionCheck = (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED);

        return isAvailable && (coarsePermissionCheck || finePermissionCheck);
    }
}
