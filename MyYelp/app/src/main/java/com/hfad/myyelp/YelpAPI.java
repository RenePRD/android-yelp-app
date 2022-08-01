package com.hfad.myyelp;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YelpAPI {

    @GET("businesses/search")
    Call<YelpResponse> getStarterRestaurants(@Query("location") String location);

    @GET("businesses/search")
    Call<YelpResponse> getRestaurants(@Query("term") String term,
                                                 @Query("location") String location);
}
