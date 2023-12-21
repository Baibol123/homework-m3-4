package com.example.homework_m3_4;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.homework_m3_4.databinding.FragmentContinentsBinding;

import java.util.ArrayList;

public class ContinentsFragment extends Fragment implements imageClick{
    private ArrayList<Continent> continents = new ArrayList<>();
    private FragmentContinentsBinding binding;
    private Adapter continentsAdapter;
    private RecyclerView itemCont;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentContinentsBinding.inflate(getLayoutInflater());
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (continents.isEmpty()) {
            loadData(continents);
        }
        if (continentsAdapter == null) {
            continentsAdapter = new Adapter(continents, this);
        }
        binding.rvContinents.setAdapter(continentsAdapter);
    }

    private ArrayList<Continent> loadData(ArrayList<Continent> continents) {

        ArrayList<String> africa = new ArrayList<>();
        africa.add("Niger");
        africa.add("Nigeria");
        africa.add("Marocco");
        africa.add("Egypt");
        africa.add("Senegal");

        ArrayList<String> northAmerica = new ArrayList<>();
        northAmerica.add("Canada");
        northAmerica.add("Kuba");
        northAmerica.add("Mexico");
        northAmerica.add("USA");
        northAmerica.add("Panama");

        ArrayList<String> southAmerica = new ArrayList<>();
        southAmerica.add("Argentina");
        southAmerica.add("Brazil");
        southAmerica.add("Chili");
        southAmerica.add("Uruguay");
        southAmerica.add("Ecuador");

        ArrayList<String> eurAsia = new ArrayList<>();
        eurAsia.add("Kyrgyzstan");
        eurAsia.add("Kazakhstan");
        eurAsia.add("Tajikistan");
        eurAsia.add("Uzbekistan");
        eurAsia.add("Russian");
        continents.add(new Continent("africa", "https://www.shutterstock.com/image-vector/africa-blank-map-vector-template-600nw-1422395537.jpg", africa));
        continents.add(new Continent("northAmerica","https://mapfsc.com/wp-content/uploads/2021/01/BMW-NORTH-AMERICA-MAP-DATA.jpg",northAmerica));
        continents.add(new Continent("southAmerica", "https://static.vecteezy.com/system/resources/thumbnails/001/198/036/small/south-america-map.png",southAmerica));

        continents.add(new Continent("eurAsia", "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.vecteezy.com%2Fvector-art%2F32047535-vector-illustration-with-simplified-map-of-eurasia-continent-grey-silhouette-white-background&psig=AOvVaw20QOPemNctXcOLSvEB8ZLd&ust=1703178468488000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCMjczsDAnoMDFQAAAAAdAAAAABAE",eurAsia));

        return this.continents;
    }


    public void onClick(int position) {
        Continent selectedContinent = continents.get(position);
        Bundle bundle = new Bundle();
        bundle.putSerializable(MainActivity.KEY_CONTINENT, selectedContinent);

        BundleFragment bundleFragment = new BundleFragment();
        bundleFragment.setArguments(bundle);

        requireActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, bundleFragment)
                .addToBackStack(null)
                .commit();
    }
}
