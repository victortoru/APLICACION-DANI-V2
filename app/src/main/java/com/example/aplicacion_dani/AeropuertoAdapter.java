package com.example.aplicacion_dani;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AeropuertoAdapter extends RecyclerView.Adapter<AeropuertoAdapter.AeropuertoViewHolder> {
    private List<AeropuertoItem> aeropuertoItemList;
    private NavController navController;

    public AeropuertoAdapter( List<AeropuertoItem> aeropuertoItemList, NavController navController) {
        this.navController = navController;
        this.aeropuertoItemList = aeropuertoItemList;
    }

    @NonNull
    @Override
    public AeropuertoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_aeropuertos, parent, false);
        return new AeropuertoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AeropuertoViewHolder holder, int position) {
        AeropuertoItem aeropuertoItem = aeropuertoItemList.get(position);

        holder.nombreAeropuerto.setText(aeropuertoItem.getNombreAeropuerto());
        holder.imagenAeropuerto.setImageResource(aeropuertoItem.getImagenAeropuerto());
        holder.textAeropuerto.setText(aeropuertoItem.getInfoAeropuerto());
    }

    @Override
    public int getItemCount() {
        return aeropuertoItemList.size();
    }

    public static class AeropuertoViewHolder extends RecyclerView.ViewHolder {
        TextView nombreAeropuerto;
        ImageView imagenAeropuerto;
        TextView textAeropuerto;

        public AeropuertoViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreAeropuerto = itemView.findViewById(R.id.tituloAeropuerto);
            imagenAeropuerto = itemView.findViewById(R.id.imagenaeropuerto);
            textAeropuerto = itemView.findViewById(R.id.textAeropuerto);

        }
    }
}

