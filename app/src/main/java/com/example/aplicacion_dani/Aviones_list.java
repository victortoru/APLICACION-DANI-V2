package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Aviones_list extends Fragment {
    NavController navController;
    private RecyclerView recyclerViewAvionesLista;
    private List<AvionItem> avionItemList;
    private AvionesAdapter avionesAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        ImageView volver = view.findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.maps);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aviones_list, container, false);

        // Inicializa tu lista de datos (avionItemList)
        avionItemList = new ArrayList<>();
        avionItemList.add(new AvionItem("PRG - JFK", "11,800m", "660 KM/h", "BOEING 777-FFG", R.drawable.americanavion));
        avionItemList.add(new AvionItem("LHR - HKG", "11,800m", "660 KM/h", "BOEING 777-FFG", R.drawable.britshavion));
        avionItemList.add(new AvionItem("FCO - CMN", "11,800m", "660 KM/h", "BOEING 777-FFG", R.drawable.alitaliaavion));
        avionItemList.add(new AvionItem("CMN - LHR", "11,800m", "660 KM/h", "BOEING 777-FFG", R.drawable.iberiaavion));
        avionItemList.add(new AvionItem("BCN - CDG", "11,800m", "660 KM/h", "BOEING 777-FFG", R.drawable.vuelingavion));

        // Configura el RecyclerView
        recyclerViewAvionesLista = view.findViewById(R.id.recyclerViewListAviones);
        recyclerViewAvionesLista.setLayoutManager(new LinearLayoutManager(getContext()));
        avionesAdapter = new AvionesAdapter(avionItemList, navController);
        recyclerViewAvionesLista.setAdapter(avionesAdapter);

        return view;
    }
}