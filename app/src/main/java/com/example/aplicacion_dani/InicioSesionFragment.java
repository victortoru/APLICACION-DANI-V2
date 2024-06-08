package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class InicioSesionFragment extends Fragment {
    private NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_inicio_sesion, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savesInstanceState){
        super.onViewCreated(view, savesInstanceState);

        navController = Navigation.findNavController(view);

        Button btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);
        TextView btnMenuPrincipal = view.findViewById(R.id.btnMenuPrincipal);
        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_inicioSesionFragment_to_loginFragment);
            }
        });
        btnMenuPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_inicioSesionFragment_to_maps);
            }
        });
    }
}