package com.example.spc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

public class view_profile extends AppCompatActivity implements View.OnClickListener {

    TextView tvname,tvdob,tvgender,tvemail,tvplace,tvpost,tvpin,tvdistrict,tvstate,tvcountry;
     Button edit;
     ImageView imgphoto,imgresume;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        tvname=findViewById(R.id.textView38);
        tvdob=findViewById(R.id.textView40);
        tvgender=findViewById(R.id.textView49);
        tvemail=findViewById(R.id.textView50);
        tvplace=findViewById(R.id.textView51);
        tvpost=findViewById(R.id.textView52);
        tvpin=findViewById(R.id.textView69);
        tvdistrict=findViewById(R.id.textView70);
        tvstate=findViewById(R.id.textView71);
        tvcountry=findViewById(R.id.textView72);
        imgphoto=findViewById(R.id.imageView3);
        imgresume=findViewById(R.id.imageView4);
        edit=findViewById(R.id.button17);
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
                                tvname.setText(jsonObj.getString("tvname"));
                                tvdob.setText(jsonObj.getString("tvdob"));
                                tvgender.setText(jsonObj.getString("tvgender"));
                                tvemail.setText(jsonObj.getString("tvemail"));
                                tvplace.setText(jsonObj.getString("tvplace"));
                                tvpost.setText(jsonObj.getString("tvpost"));
                                tvpin.setText(jsonObj.getString("tvpin"));
                                tvdistrict.setText(jsonObj.getString("tvdistrict"));
                                tvstate.setText(jsonObj.getString("tvstate"));
                                tvcountry.setText(jsonObj.getString("tvcountry"));

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



    }
}