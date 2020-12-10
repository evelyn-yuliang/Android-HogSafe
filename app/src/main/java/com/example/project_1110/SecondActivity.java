package com.example.project_1110;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";

//    private ArrayList<String> restName = new ArrayList<>();
//    private ArrayList<String> restType = new ArrayList<>();
//    private ArrayList<String> restAdd = new ArrayList<>();
    //private int[] foodImage;

    ArrayList<String> restaurantName = new ArrayList<>();
    ArrayList<String> restaurantCuisine = new ArrayList<>();
    ArrayList<String> restaurantPhotoUrl = new ArrayList<>();
    ArrayList<String> restaurantAddress = new ArrayList<>();

    private String mResponse;
    private JSONObject jsonObject;
    private JSONArray jsonArray;
    private boolean dineIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        mResponse = intent.getStringExtra("RestaurantsList");
        dineIn = intent.getBooleanExtra("DineIn",true);

        Log.d(TAG, "onCreate: " + mResponse);
        if (mResponse != null) {
            try {
                jsonObject = new JSONObject(mResponse);
                jsonArray = jsonObject.getJSONArray("restaurants");

                Log.d("debug", "onResponse: " + jsonArray.length());

                for (int i = 0; i < jsonArray.length(); i++) {

                    //limit:20, and takeaway can not filter
                    JSONObject item = (JSONObject) jsonArray.getJSONObject(i).get("restaurant");

                    String name = (String) item.get("name");
                    String cuisine = (String) item.get("cuisines");
                    String photoUrl = (String) item.get("featured_image");

                    JSONObject location = (JSONObject) item.get("location");
                    String address = (String) location.get("address");


                    Log.i("check", "run:restaurant " + name + " " + cuisine + " " + photoUrl);
                    Log.i("check", "onResponse: " + address);

                    restaurantName.add(name);
                    restaurantCuisine.add(cuisine);
                    restaurantPhotoUrl.add(photoUrl);
                    restaurantAddress.add(address);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        initRecyclerView();
    }


    private void initImage() {
        //    Log.d(TAG, "initImage: preparing images");
//        foodImage = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5};
//        restName.add("HOYA SHSUI");
//        restName.add("PIZZA PIZZA");
//        restName.add("TANDOORI time");
//        restName.add("McDonald's");
//        restName.add("Harvey's");
//        restType.add("sushi,sashimi,soup");
//        restType.add("pizza,fried chicken");
//        restType.add("taco,roasted chicken");
//        restType.add("hamberger,fries,nugget");
//        restType.add("burger,chicken,omelet");
//        restAdd.add("Humber college,Etobicoke,ON");
//        restAdd.add("1701 Martin Grove Rd,Etobicoke,ON");
//        restAdd.add("1727 Albion Rd,Etobicoke,ON");
//        restAdd.add("1750 Albion Rd,Etobicoke,ON");
//        restAdd.add("6620 Finch Ave W, Etobicoke,ON");


    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, restaurantName, restaurantCuisine, restaurantAddress, restaurantPhotoUrl,dineIn);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }



}