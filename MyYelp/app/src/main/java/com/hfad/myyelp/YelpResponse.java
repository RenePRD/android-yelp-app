package com.hfad.myyelp;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Locale;

public class YelpResponse {

    @SerializedName("businesses")
    public ArrayList<Business> businesses;

    class Business {

        @SerializedName("name")
        public String name;

        @SerializedName("rating")
        public float rating;

        @SerializedName("price")
        public String price;

        @SerializedName("phone")
        public String phone;

        @SerializedName("image_url")
        public String url;

        @SerializedName("categories")
        public ArrayList<YelpCategory> categories;

        class YelpCategory {
            @SerializedName("title")
            public String title;
        }

        @SerializedName("location")
        public YelpLocation yelpLocation;

        class YelpLocation {

            @SerializedName("city")
            public String city;

            @SerializedName("state")
            public String state;

            @SerializedName("address1")
            public String address1;

        }

    }

}
