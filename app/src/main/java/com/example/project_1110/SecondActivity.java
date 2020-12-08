package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

    private ArrayList<String> restName = new ArrayList<>();
    private ArrayList<String> restType = new ArrayList<>();;
    private ArrayList<String> restAdd = new ArrayList<>();;
    private int[] foodImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "onCreate: started");
        initImage();
    }


    //R.drawable.person1

    private  void initImage(){
        Log.d(TAG, "initImage: preparing images");
        foodImage = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};
        restName.add("HOYA SHSUI");
        restName.add("PIZZA PIZZA");
        restName.add("TANDOORI time");
        restName.add("McDonald's");
        restName.add("Harvey's");
        restType.add("sushi,sashimi,soup");
        restType.add("pizza,fried chicken");
        restType.add("taco,roasted chicken");
        restType.add("hamberger,fries,nugget");
        restType.add("burger,chicken,omelet");
        restAdd.add("Humber college,Etobicoke,ON");
        restAdd.add("1701 Martin Grove Rd,Etobicoke,ON");
        restAdd.add("1727 Albion Rd,Etobicoke,ON");
        restAdd.add("1750 Albion Rd,Etobicoke,ON");
        restAdd.add("6620 Finch Ave W, Etobicoke,ON");

        initRecyclerView();


    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, restName, restType, restAdd, foodImage);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}



