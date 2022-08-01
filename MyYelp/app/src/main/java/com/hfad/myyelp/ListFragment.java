package com.hfad.myyelp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.loader.content.Loader;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ListFragment extends Fragment {

    Context context;
    ListView ben_listview;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ben_listview = v.findViewById(R.id.ben_listview);

        context = inflater.getContext();
        RestaurantListAdapter adapter = new RestaurantListAdapter(inflater.getContext(), MainActivity.businessList);
        ben_listview.setAdapter(adapter);

        ben_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(getContext(), data.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    public void updateListData(ArrayList<YelpResponse.Business> data) {
        RestaurantListAdapter adapter = new RestaurantListAdapter(context, data);
        ben_listview.setAdapter(adapter);
    }
}