package com.hfad.myyelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SearchView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    static ArrayList<YelpResponse.Business> businessList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.searchView);

        YelpAPI yelpAPI = new YelpClient().build();

        yelpAPI.getStarterRestaurants("Montreal").enqueue(new Callback<YelpResponse>() {
            @Override
            public void onResponse(Call<YelpResponse> call, Response<YelpResponse> response) {
                YelpResponse res = response.body();
                for (YelpResponse.Business b : res.businesses) {
                    businessList.add(b);
                }
            }

            @Override
            public void onFailure(Call<YelpResponse> call, Throwable t) {

            }
        });

        ListFragment listFragment = new ListFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.list_container, listFragment).commit();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                yelpAPI.getRestaurants(s,"Montreal").enqueue(new Callback<YelpResponse>() {
                    @Override
                    public void onResponse(Call<YelpResponse> call, Response<YelpResponse> response) {
                        YelpResponse res = response.body();
                        businessList.clear();
                        for (YelpResponse.Business b : res.businesses) {
                            businessList.add(b);
                        }


                    }

                    @Override
                    public void onFailure(Call<YelpResponse> call, Throwable t) {

                    }
                });
                return false;
            }


            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }
}