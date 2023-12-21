package com.example.homework_m3_4;

import android.view.ViewGroup;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homework_m3_4.databinding.ItemContinentBinding;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ContinentViewHolder> {
    private ArrayList<Continent> continents;
    private imageClick ContinentImageClick;

    public Adapter(ArrayList<Continent> continents, imageClick ContinentImageClick) {
        this.ContinentImageClick = ContinentImageClick;
        this.continents = continents;
    }

    @NonNull
    @Override
    public ContinentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContinentViewHolder(ItemContinentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContinentViewHolder holder, int position) {
        holder.onBind(continents.get(position));
        holder.itemView.setOnClickListener(v -> {
            ContinentImageClick.onClick(position);
        });
    }

    @Override
    public int getItemCount() {
        return continents.size();
    }
}
class ContinentViewHolder extends RecyclerView.ViewHolder {
    private ItemContinentBinding binding;

    public void onBind(Continent continent) {
        binding.continentName.setText(continent.getContinentName());
        Glide.with(binding.continentImage).load(continent.getContinentImage()).into(binding.continentImage);
    }
    public ContinentViewHolder(@NonNull ItemContinentBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}

interface imageClick{
    void onClick(int position);

}
