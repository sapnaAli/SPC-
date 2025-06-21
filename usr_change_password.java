package com.example.spc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class usr_change_password extends AppCompatActivity implements View.OnClickListener {
    EditText crrntpss,newpss,cnfrmpss;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usr_change_password);
        crrntpss=findViewById(R.id.editTextTextPassword4);
        newpss=findViewById(R.id.editTextTextPassword5);
        cnfrmpss=findViewById(R.id.editTextTextPassword3);
        change=findViewById(R.id.button4);
        change.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String crpsd = crrntpss.getText().toString();
        String npsd = newpss.getText().toString();
        String cpsd = cnfrmpss.getText().toString();


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

                params.put("crrntpss", crpsd);
                params.put("newpss",npsd );
                params.put("cnfrmpss",cpsd );


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
