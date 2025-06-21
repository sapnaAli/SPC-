package com.example.spc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class edit_profile extends AppCompatActivity implements View.OnClickListener {
    EditText name,dob,email,place,post,pin,district,state,country,phoneno;
    Button edit;
    ImageView photo,resume;
    RadioButton male,female,other,gender;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        name=findViewById(R.id.editTextText18);
        dob=findViewById(R.id.editTextDate2);
        email=findViewById(R.id.editTextTextEmailAddress3);
        place=findViewById(R.id.editTextText20);
        post=findViewById(R.id.editTextText21);
        pin=findViewById(R.id.editTextNumber2);
        district=findViewById(R.id.editTextText12);
        state=findViewById(R.id.editTextText23);
        country=findViewById(R.id.editTextText24);
        edit=findViewById(R.id.button3);
        photo=findViewById(R.id.imageView5);
        resume=findViewById(R.id.imageView);
        male=findViewById(R.id.radioButton7);
        female=findViewById(R.id.radioButton6);
        gender=findViewById(R.id.radioGroup);
        other=findViewById(R.id.radioButton8);
        phoneno=findViewById(R.id.editTextPhone);
        edit.setOnClickListener(this);
        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String lid = sh.getString("lid", "");
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":8000/and_login";

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equalsIgnoreCase("ok")) {
                                name.setText(jsonObj.getString("name"));
                                dob.setText(jsonObj.getString("dob"));
                                email.setText(jsonObj.getString("email"));
                                place.setText(jsonObj.getString("place"));
                                post.setText(jsonObj.getString("post"));
                                pin.setText(jsonObj.getString("pin"));
                                district.setText(jsonObj.getString("district"));
                                state.setText(jsonObj.getString("state"));
                                country.setText(jsonObj.getString("country"));
                                phoneno.setText(jsonObj.getString("phoneno"));

                            }

                            // }
                            else {
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "eeeee" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Map<String, String> params = new HashMap<String, String>();

                params.put("lid", lid);


                return params;
            }
        };

        int MY_SOCKET_TIMEOUT_MS = 100000;

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);

    }




    @Override
    public void onClick(View view) {

        String nm = name.getText().toString();
        String db = dob.getText().toString();
        String mail = email.getText().toString();
        String plc = place.getText().toString();
        String pst = post.getText().toString();
        String pn = pin.getText().toString();
        String dst = district.getText().toString();
        String st = state.getText().toString();
        String cntry = country.getText().toString();
        String phonenumber = phoneno.getText().toString();

        SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String lid = sh.getString("lid", "");
        String hu = sh.getString("ip", "");
        String url = "http://" + hu + ":8000/and_login";

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();

                        // response
                        try {
                            JSONObject jsonObj = new JSONObject(response);
                            if (jsonObj.getString("status").equalsIgnoreCase("ok")) {


                                SharedPreferences.Editor ed = sh.edit();
                                ed.putString("lid", jsonObj.getString("lid"));
                                ed.commit();

                                if (jsonObj.getString("type").equalsIgnoreCase("staff")) {
//                                    Intent i = new Intent(getApplicationContext(), home.class);
//                                    startActivity(i);
                                }



                            }

                            // }
                            else {
                                Toast.makeText(getApplicationContext(), "Not found", Toast.LENGTH_LONG).show();
                            }

                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(), "Error" + e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Toast.makeText(getApplicationContext(), "eeeee" + error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                SharedPreferences sh = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Map<String, String> params = new HashMap<String, String>();

                params.put("name", nm);
                params.put("dob",db );
                params.put("email",mail );
                params.put("place", plc);
                params.put("post", pst);
                params.put("pin",pn );
                params.put("district",dst );
                params.put("state", st);
                params.put("country",cntry );
                params.put("phoneno",phonenumber );







                return params;
            }
        };

        int MY_SOCKET_TIMEOUT_MS = 100000;

        postRequest.setRetryPolicy(new DefaultRetryPolicy(
                MY_SOCKET_TIMEOUT_MS,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        requestQueue.add(postRequest);

    }
}