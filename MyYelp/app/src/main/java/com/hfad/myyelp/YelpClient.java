package com.hfad.myyelp;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YelpClient {

    public YelpAPI build(){

        OkHttpClient httpClient = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {

                    @NonNull
                    @Override
                    public Response intercept(@NonNull Chain chain) throws IOException {
                        return chain.proceed(chain.request()
                                .newBuilder().
                                        addHeader("Authorization", "Bearer HnZuR6Vl-FsVZjPXOEeGIBatYDqOZckvtGUJO-4HJd7REVmxGgAshaCJ_XdB_XoopmEXcqhp-TJ0NeyqBK2rO9Wwp-ZgwEH15PeB0gG3a56zv4JPQhxsG-Nm73yvYnYx")
                                .build());
                    }
                }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.yelp.com/v3/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        return retrofit.create(YelpAPI.class);
    }
}
