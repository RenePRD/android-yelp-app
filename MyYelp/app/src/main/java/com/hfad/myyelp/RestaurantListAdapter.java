package com.hfad.myyelp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class RestaurantListAdapter extends BaseAdapter {

    List<YelpResponse.Business> restaurantList;
    Context m_context;

    public RestaurantListAdapter(Context context, List<YelpResponse.Business> restaurantList) {
        this.restaurantList = restaurantList;
        m_context = context;
    }

    @Override
    public int getCount() {
        return restaurantList.size();
    }

    @Override
    public Object getItem(int position) {
        return restaurantList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(m_context,R.layout.list_item, null);

        ImageView tvItemImage = v.findViewById(R.id.list_item_poster);
        TextView tvItemName = v.findViewById(R.id.list_item_name);
        RatingBar tvItemRating = v.findViewById(R.id.list_item_rating);
        TextView tvItemPrice = v.findViewById(R.id.list_item_price);
        TextView tvItemKeyword = v.findViewById(R.id.list_item_keyword);
        TextView tvNumber = v.findViewById(R.id.list_item_number);
        TextView tvAddress = v.findViewById(R.id.list_item_address);

        String restaurantPoster = restaurantList.get(position).url;
        String restaurantName = restaurantList.get(position).name;
        float restaurantRating = restaurantList.get(position).rating;
        String restaurantPrice = restaurantList.get(position).price;
        ArrayList<YelpResponse.Business.YelpCategory> restaurantCategory = restaurantList.get(position).categories;

        StringBuilder Categories = new StringBuilder();
        for (YelpResponse.Business.YelpCategory c : restaurantCategory) {
            Categories.append(c.title);
            if (restaurantCategory.indexOf(c) < (restaurantCategory.size() - 1)) {
                Categories.append(", ");
            }
        }
        String restaurantCategories = Categories.toString();

        String restaurantNumber = restaurantList.get(position).phone;
        String restaurantAddress = restaurantList.get(position).yelpLocation.address1;
        String restaurantCity = restaurantList.get(position).yelpLocation.city;
        String restaurantState = restaurantList.get(position).yelpLocation.state;

        Glide.with(m_context).load(restaurantPoster).into(tvItemImage);
        tvItemName.setText(restaurantName);
        tvItemRating.setRating(restaurantRating);
        tvItemPrice.setText(restaurantPrice);
        tvItemKeyword.setText(restaurantCategories);
        tvNumber.setText(restaurantNumber);
        tvAddress.setText(restaurantAddress + " " + restaurantCity + " " + restaurantState);

        return v;
    }
}
