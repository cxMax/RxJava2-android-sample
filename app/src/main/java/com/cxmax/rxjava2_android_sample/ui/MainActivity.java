package com.cxmax.rxjava2_android_sample.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cxmax.rxjava2_android_sample.R;
import com.cxmax.rxjava2_android_sample.ui.networking.NetworkingActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }

    public void startOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, OperatorsActivity.class));
    }


    public void startNetworkingActivity(View view) {
        startActivity(new Intent(MainActivity.this, NetworkingActivity.class));
    }
}
