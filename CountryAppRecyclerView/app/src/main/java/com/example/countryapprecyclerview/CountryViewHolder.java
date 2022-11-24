package com.example.countryapprecyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountryViewHolder extends RecyclerView.ViewHolder {

    TextView countryNameTextView;
    ImageView countryFlagImageView;

    public CountryViewHolder(@NonNull View itemView) {
        super(itemView);
        countryNameTextView = itemView.findViewById(R.id.countryNameTextView);
        countryFlagImageView = itemView.findViewById(R.id.countryFlagImageView);


    }
}
