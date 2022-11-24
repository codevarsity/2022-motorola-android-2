package com.example.countryapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CountryAdapter extends BaseAdapter {

    Context context;
    private ArrayList<String> countryNames = new ArrayList<>();

    CountryAdapter(Context context) {
        this.context = context;
        initialize();;
    }

    static class ViewHolder {
        TextView countryNameTextView;
        ImageView countryFlagImageView;
    }

    private void initialize() {
        countryNames.add("India");
        countryNames.add("Japan");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("Malaysia");
        countryNames.add("China");
        countryNames.add("Germany");

        countryNames.add("India");
        countryNames.add("Japan");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("Malaysia");
        countryNames.add("China");
        countryNames.add("Germany");

        countryNames.add("India");
        countryNames.add("Japan");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("Malaysia");
        countryNames.add("China");
        countryNames.add("Germany");

        countryNames.add("India");
        countryNames.add("Japan");
        countryNames.add("France");
        countryNames.add("Italy");
        countryNames.add("Malaysia");
        countryNames.add("China");
        countryNames.add("Germany");
    }

    @Override
    public int getCount() {
        return countryNames.size();
    }

    @Override
    public Object getItem(int i) {
        return countryNames.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View mainView = null;
        if(view == null) {
                Log.i("CountryAdapter", "Inflate View for index (" + i + ")");

                LayoutInflater inflater = LayoutInflater.from(context);
                mainView = inflater.inflate(R.layout.country_cell, null);

                ViewHolder vh = new ViewHolder();
                vh.countryNameTextView = mainView.findViewById(R.id.countryNameTextView);
                vh.countryFlagImageView = mainView.findViewById(R.id.countryFlagImageView);

                mainView.setTag(vh);
        } else {
            mainView = view;
        }

        ViewHolder vh = (ViewHolder) mainView.getTag();

        String countryName = countryNames.get(i);
        vh.countryNameTextView.setText(countryName);

        return mainView;
    }
}
