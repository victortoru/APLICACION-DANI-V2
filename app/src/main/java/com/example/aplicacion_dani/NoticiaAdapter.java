package com.example.aplicacion_dani;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NoticiaAdapter extends RecyclerView.Adapter<NoticiaAdapter.NoticiaViewHolder> {

    private List<Noticias_list> noticiasList;
    private Context context;
    private NavController navController;

    public NoticiaAdapter(List<Noticias_list> noticiasList, NavController navController) {
        this.navController = navController;
        this.noticiasList = noticiasList;
    }

    @NonNull
    @Override
    public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_noticia, parent, false);
        return new NoticiaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticiaViewHolder holder, int position) {
        Noticias_list noticia = noticiasList.get(position);
        holder.tituloNoticia.setText(noticia.getTituloNoticia());
        holder.textoNoticia.setText(noticia.getTextoNoticia());
        holder.imagenNoticia.setImageResource(noticia.getImagenResource());
    }

    @Override
    public int getItemCount() {
        return noticiasList.size();
    }

    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        TextView tituloNoticia;
        TextView textoNoticia;
        ImageView imagenNoticia;

        public NoticiaViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloNoticia = itemView.findViewById(R.id.tituloNoticia);
            textoNoticia = itemView.findViewById(R.id.textNoticia);
            imagenNoticia = itemView.findViewById(R.id.imagennoticias);
        }
    }
}
