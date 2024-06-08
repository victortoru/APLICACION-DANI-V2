package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NoticiasFragment extends Fragment {
    private List<Noticias_list> noticiasList;
    private NoticiaAdapter noticiaAdapter;
    private RecyclerView recyclerViewNoticias;
    private NavController navController;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        TextView btnMenuPrincipal = view.findViewById(R.id.btnMenuPrincipal);

        /*
        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_noticiasFragment_to_maps);
            }
        });
         */

        ImageView imageView = view.findViewById(R.id.imageView3);
        ImageView volver = view.findViewById(R.id.volver);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.maps);
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_noticiasFragment_to_noticia_grande_1);
            }
        });
        ImageView imageView1 = view.findViewById(R.id.iamgen2);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_noticiasFragment_to_noticia_grande_2);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_noticias, container, false);

        noticiasList = new ArrayList<>();
        noticiasList.add(new Noticias_list("Air Belgium, ¿al borde de la quiebra?", "Los principales accionistas de la empresa el grupo Hongyuan (49%), el gobierno valón (39%) y el gobierno belga (10%) aún no se han pronunciado sobre el tema", R.drawable.airbelgium));
        noticiasList.add(new Noticias_list("La Maestranza de Albacete tendrá un nuevo hangar para los Botijos", "El Consejo de Ministros ha autorizado el gasto para la construcción de un nuevo hangar de mantenimiento para los aviones Canadair CL-215T/ Bombardier CL-415", R.drawable.maestranza));
        noticiasList.add(new Noticias_list("Emirates y su beneficio récord en el primer semestre del año fiscal", "La aerolínea Emirates obtuvo un beneficio récord de 4.200 millones de dirhams (1.200 millones de dólares) en el primer semestre de su año fiscal 2022/2023", R.drawable.emirates));
        noticiasList.add(new Noticias_list("LATAM reanudará sus vuelos entre Brasilia y Lima en 2023", "LATAM Airlines anunció este miércoles que reanudará vuelos diarios y directos entre Brasilia y Lima (Perú) a partir de marzo de 2023.", R.drawable.latam));
        noticiasList.add(new Noticias_list("Icelandair anuncia vuelos a Praga y Barcelona para el verano de 2023", "Icelandair anunció este miércoles que volará a Praga y Barcelona desde Reikiavik para el verano de 2023. Ambas ciudades conectarán con la amplia red norteamericana de la aerolínea.", R.drawable.icelandair));
        noticiasList.add(new Noticias_list("Silk Way Airlines anuncia pedido de hasta cuatro Boeing 777-8 Freighter", "La empresa de carga de Azerbaiyán, que sirve a 40 destinos en todo el mundo, es el primer cliente de la región de Eurasia que encarga el nuevo bimotor de carga.", R.drawable.silkway));


        //recyclerViewNoticias = view.findViewById(R.id.recyclerViewListAeropuertos);
        noticiaAdapter = new NoticiaAdapter(noticiasList, navController);
        //recyclerViewNoticias.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerViewNoticias.setAdapter(noticiaAdapter);

        return view;
    }
}
