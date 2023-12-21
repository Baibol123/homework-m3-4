//package com.example.homework_m3_4;
//
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.bumptech.glide.Glide;
//import com.example.homework_m3_4.databinding.FragmentBundleBinding;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//public class BundleFragment extends Fragment {
//
//    private FragmentBundleBinding binding;
//    private Continent continent;
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        binding = FragmentBundleBinding.inflate(getLayoutInflater());
//
//        return binding.getRoot();
//    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        loadContinentData();
//    }
//    private void loadContinentData() {
//        Bundle arguments = getArguments();
//        if (arguments != null && arguments.getSerializable(MainActivity.KEY_CONTINENT) instanceof Continent) {
//            continent = (Continent) arguments.getSerializable(MainActivity.KEY_CONTINENT);
//            displayContinentInfo();
//        }
//    }
//
//    private void displayContinentInfo() {
//        loadContinentImage();
//        binding.continentName.setText(continent.getContinentName());
//        displayCountries();
//    }
//    private void loadContinentImage() {
//        Glide.with(binding.continentImage).load(continent.getContinentImage()).into(binding.continentImage);
//    }
//    private void displayCountries() {
//        StringBuilder countriesText = new StringBuilder();
//        for (String continentCountry : continent.getContinentCountries()) {
//            countriesText.append("\n").append(continentCountry);
//        }
//        binding.countries.setText(countriesText.toString());
//    }
//}
package com.example.homework_m3_4;
import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.homework_m3_4.databinding.FragmentBundleBinding;

public class BundleFragment extends Fragment {
    private FragmentBundleBinding binding;
    private Continent continent;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBundleBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadContinentData();
    }
    private void loadContinentData() {
        Bundle arguments = getArguments();
        if (arguments != null && arguments.getSerializable(MainActivity.KEY_CONTINENT) instanceof Continent) {
            continent = (Continent) arguments.getSerializable(MainActivity.KEY_CONTINENT);
            displayContinentInfo();
        }
    }

    private void displayContinentInfo() {
        loadContinentImage();
        binding.continentName.setText(continent.getContinentName());
        displayCountries();
    }

    private void loadContinentImage() {
        Glide.with(binding.continentImage).load(continent.getContinentImage()).into(binding.continentImage);
    }
    private void displayCountries() {
        StringBuilder countriesText = new StringBuilder();
        for (String continentCountry : continent.getContinentCountries()) {
            countriesText.append("\n").append(continentCountry);
        }
        binding.countries.setText(countriesText.toString());
    }
}


