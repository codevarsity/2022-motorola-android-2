package com.example.countryapprecyclerview;

import android.animation.LayoutTransition;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<CountryViewHolder> {

    Context context;
    ArrayList<String> countryNames = new ArrayList<>();

    void initialize() {
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("India");
        countryNames.add("Malaysia");
        countryNames.add("Japan");
        countryNames.add("China");
        countryNames.add("France");
        countryNames.add("Italy");

    }
    CountryAdapter(Context context) {
        this.context = context;
        initialize();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater  = LayoutInflater.from(context);;

        View mainView = inflater.inflate(R.layout.country_row_cell, null);
        CountryViewHolder vh = new CountryViewHolder(mainView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        String countryName = countryNames.get(position);
        holder.countryNameTextView.setText( countryName);
    }

    @Override
    public int getItemCount() {
        return countryNames.size();
    }

    public void addCountryName(String name) {
        countryNames.add(name);
        notifyDataSetChanged();
    }


}