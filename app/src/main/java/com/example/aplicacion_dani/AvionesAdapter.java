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

public class AvionesAdapter extends RecyclerView.Adapter<AvionesAdapter.AvionViewHolder> {

    private List<AvionItem> avionItemList;
    private NavController navController;

    public AvionesAdapter(List<AvionItem> avionItemList, NavController navController) {
        this.avionItemList = avionItemList;
        this.navController = navController;

    }

    @NonNull
    @Override
    public AvionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_avion, parent, false);
        return new AvionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvionViewHolder holder, int position) {
        AvionItem avionItem = avionItemList.get(position);
        holder.textView.setText(avionItem.getRuta());
        holder.altura.setText(avionItem.getAltura());
        holder.velocidad.setText(avionItem.getVelocidad());
        holder.nombreavion.setText(avionItem.getNombreAvion());
        holder.imagenaviones.setImageResource(avionItem.getImagenResId());
    }

    @Override
    public int getItemCount() {
        return avionItemList.size();
    }

    public static class AvionViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        TextView altura;
        TextView velocidad;
        TextView nombreavion;
        ImageView imagenaviones;

        public AvionViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textRuta);
            altura = itemView.findViewById(R.id.altura);
            velocidad = itemView.findViewById(R.id.velocidad);
            nombreavion = itemView.findViewById(R.id.nombreavion);
            imagenaviones = itemView.findViewById(R.id.imagenaviones);
        }
    }
}
