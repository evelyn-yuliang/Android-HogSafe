package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class JoinTable extends AppCompatActivity {
    EditText theCode ;
    String matchCode = "1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.code_join_table);

        theCode = (EditText) findViewById(R.id.enterCode);

    }

    public void join_Proceed(View view) {

        if((theCode.getText().toString()).equals(matchCode)){
            Intent viewMenu = new Intent(this, MenuView.class);
            startActivity(viewMenu);
            Toast.makeText(getBaseContext(), "Valid code !", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getBaseContext(), "Invalid code, Try again !", Toast.LENGTH_LONG).show();
        }
    }
}