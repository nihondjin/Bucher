package com.example.books.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.books.databinding.ItemLocationBinding;
import com.example.books.models.RickAndMortyLocation;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationViewHolder> {

    ArrayList<RickAndMortyLocation> list = new ArrayList<>();

    public void addList(List<RickAndMortyLocation> getList){
        list.addAll(getList);
        notifyDataSetChanged();
    }

    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder {
        ItemLocationBinding binding;

        public LocationViewHolder(@NonNull @NotNull ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(RickAndMortyLocation rickAndMortyLocation) {
            binding.txtNameLocation.setText(rickAndMortyLocation.name);
            binding.typeLocationTxt.setText(rickAndMortyLocation.type);
            binding.txtDimensionLocation.setText(rickAndMortyLocation.dimension);
            binding.txtCreatedLocation.setText(rickAndMortyLocation.created);
        }
    }
}
