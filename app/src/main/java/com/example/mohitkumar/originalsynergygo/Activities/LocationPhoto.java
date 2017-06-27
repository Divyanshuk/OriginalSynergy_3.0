package com.example.mohitkumar.originalsynergygo.Activities;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.mohitkumar.originalsynergygo.Adapters.MySingleton;
import com.example.mohitkumar.originalsynergygo.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LocationPhoto extends AppCompatActivity {


    protected LocationManager locationManager;
    private double latitude = 0;
    private double longitude = 0;
    TextView lat, lng, textView;
    Button refresh;
    String refno,address,applcoappl;
    FloatingActionButton photo;
    ProgressDialog dialog;
    private Bitmap bitmap;
    private Uri filepath;
    ProgressDialog progressDialog;
    Button button;
    private int PICK_IMAGE_REQUEST = 1;

    public static final String UPLOAD_URL = "http://139.59.5.200/repignite/android/imageupload.php";
    public static final String UPLOAD_KEY = "image";
    public static final String TAG = "MY MESSAGE";

    public static final int LOCATION_REQ_CODE = 100;
    public static final int EXTERNAL_STORAGE_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_photo);


       // ProgressDialog progressDialog = new ProgressDialog(LocationPhoto.this);

        button = (Button) findViewById(R.id.exit);
        refno = getIntent().getStringExtra("REFNO");
        address = getIntent().getStringExtra("ADDRESS");
        applcoappl = getIntent().getStringExtra("APPL");

        progressDialog = new ProgressDialog(LocationPhoto.this);

    }


    public void exitfunc(View view) {

        StringRequest stringRequest = new StringRequest(Request.Method.POST,"http://139.59.5.200/repignite/android/updateallocations.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

//                progressDialog.show();
                Map<String,String> params = new HashMap<String, String>();

                params.put("REFNO",refno);
                params.put("TYPE",address);
                params.put("APPLORCO",applcoappl);
                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


        Intent intent = new Intent(LocationPhoto.this,AssignmentChoose.class);
        intent.putExtra("Agent",AssignmentChoose.AgentID);
        startActivity(intent);
    }

    public void onc(View view) {
        button.setVisibility(View.VISIBLE);
        Intent cam_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cam_intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filepath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filepath);
                uploadImage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void uploadImage(){
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Uploading Image");
        progressDialog.show();
        Log.d("Entered","ENTER");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

//                progressDialog.show();
                Map<String,String> params = new HashMap<String, String>();

                Log.d("NAME",address + "_" + applcoappl);
                params.put("REFNO",refno);
                params.put("NAME",address + "_" + applcoappl);
                params.put("IMAGE",getStringImage(bitmap));

                return params;
            }
        };
        MySingleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        progressDialog.dismiss();
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Log.d("COMPRESS","COmpressing");
    //    progressDialog.show();
        bmp.compress(Bitmap.CompressFormat.JPEG,20, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    public static class Utility {
        public static boolean checkPermissions(Context context, String... permissions) {
            if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
                for (String permission : permissions) {
                    if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, permission)) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE},EXTERNAL_STORAGE_CODE);
                        } else {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE}, EXTERNAL_STORAGE_CODE);
                        }
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
