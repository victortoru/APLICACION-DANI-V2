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


public class Aeropuertos_list extends Fragment {
    ImageView volver;
    private NavController navController;
    private List<AeropuertoItem> AeropuertoItem;
    private AeropuertoAdapter AeropuertosAdapter;
    private RecyclerView recyclerViewAeropuertos;

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_aviones_list, container, false);

        AeropuertoItem = new ArrayList<>();
        AeropuertoItem.add(new AeropuertoItem("1.Aeropuerto de Barcelona El Prat - Josep Tarradelles", "Temp. 15ºC\n" +
                "3 Pistas\n" +
                "Servicio con 157 Aeropuertos", R.drawable.bcn_air));
        AeropuertoItem.add(new AeropuertoItem("2. Paris Charles de Gaulle Airport", "Temp. 14ºC\n" +
                "4 Pistas\n" +
                "Servicio con 233 Aeropuertos", R.drawable.paris_air));
        AeropuertoItem.add(new AeropuertoItem("3. Casablanca Mohammed V International Airport", "Temp. 20ºC\n" +
                "2 Pistas\n" +
                "Servicio con 91 Aeropuertos", R.drawable.casablanca_air));
        AeropuertoItem.add(new AeropuertoItem("4. Prague Vaclav Havel Airport", "Temp. 8ºC\n" +
                "2 Pistas\n" +
                "Servicio con 97 Aeropuertos", R.drawable.prague_air));
        AeropuertoItem.add(new AeropuertoItem("5. London Heathrow Airport", "Temp. 14ºC\n" +
                "2 Pistas\n" +
                "Servicio con 182 Aeropuertos", R.drawable.london_air));
        AeropuertoItem.add(new AeropuertoItem("6. Rome Leonardo da Vinci Fiumicino Airport", "Temp. 16ºC\n" +
                "3 Pistas\n" +
                "Servicio con 156 Aeropuertos", R.drawable.rome_air ));

        recyclerViewAeropuertos = view.findViewById(R.id.recyclerViewListAviones);
        // Asegúrate de pasar el contexto al crear la instancia del adaptador
        recyclerViewAeropuertos.setLayoutManager(new LinearLayoutManager(getContext()));
        AeropuertosAdapter = new AeropuertoAdapter(AeropuertoItem, navController);
        recyclerViewAeropuertos.setAdapter(AeropuertosAdapter);

        return view;
    }
}
