package com.example.finalprojectbucci;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class RestauranteursTab extends Fragment {
    //this java class creates the tab view for the given employee and calls the xml layout specific to that employee. When each tab is selected, the selections pager adapter calls each java class

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.restauranteurs, container, false); //creates a view object and calls the tab layout for restaurateurs when this class is used
        return view;
    }
}
