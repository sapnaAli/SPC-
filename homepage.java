package com.example.spc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class homepage extends AppCompatActivity {

    Button profile,company,skills,test,interview,vaccancy,complaint,reviewrating,mocktest,mockinterview,resultscapabilities,intershipscourses,networks,notifications;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        profile=findViewById(R.id.button18);
        company=findViewById(R.id.button29);
        skills=findViewById(R.id.button20);
        test=findViewById(R.id.button19);
        interview=findViewById(R.id.button22);
        vaccancy=findViewById(R.id.button24);
        complaint=findViewById(R.id.button23);
        reviewrating=findViewById(R.id.button30);
        mocktest=findViewById(R.id.button31);
        mockinterview=findViewById(R.id.button32);
        resultscapabilities=findViewById(R.id.button21);
        intershipscourses=findViewById(R.id.button33);
        networks=findViewById(R.id.button34);
        notifications=findViewById(R.id.button35);
        

    }
}