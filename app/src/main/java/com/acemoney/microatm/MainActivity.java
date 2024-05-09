package com.acemoney.microatm;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.acemoney.mylibrary.utils.AceMatm;
import com.google.gson.JsonObject;


public class MainActivity extends AppCompatActivity implements AceMatm.ResponseListener {
    private AceMatm aceMatm;
    private String Agent_email;
    private Activity activity=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Agent_email="sruthys240@gmail.com";
        AceMatm aceMatm= AceMatm.getInstance(activity, Agent_email);
        aceMatm.setUI(true);
        aceMatm.setResponseListener(this);
    }

    @Override
    public void onResult(JsonObject jsonData) {

    }
}