package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThankYou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
    }

    public void onConfirmCheckoutClick(View view) {
        Intent cartSuccessActivity = new Intent(getApplicationContext(),HomeActivity.class);
        startActivity(cartSuccessActivity);
    }
}