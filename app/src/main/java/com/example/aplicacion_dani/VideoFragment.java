package com.example.aplicacion_dani;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
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
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends Fragment {
    private NavController navController;
    private ViewPager2 videoViewPager;
    private VideoSliderAdapter videoSliderAdapter;
    private List<String> videoIds;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        ImageView volver = view.findViewById(R.id.volver2);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.maps);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video, container, false);

        GradientDrawable borderDrawable = new GradientDrawable();
        borderDrawable.setStroke(10, Color.CYAN);
        borderDrawable.setShape(GradientDrawable.RECTANGLE); // Establece la forma del borde como un rectángulo

        ImageView imagen1 = view.findViewById(R.id.imagen1);
        ImageView imagen2 = view.findViewById(R.id.imagen2);
        ImageView imagen3 = view.findViewById(R.id.imagen3);
        ImageView imagen4 = view.findViewById(R.id.imagen4);

        imagen1.setPadding(10, 10, 10, 10); // Ajusta el relleno de imagen1 para dar espacio al borde
        imagen1.setBackground(borderDrawable);

        imagen2.setPadding(10, 10, 10, 10); // Ajusta el relleno de imagen2 para dar espacio al borde
        imagen2.setAlpha(0.5f); // Establece la transparencia a la mitad (0.5)

        imagen3.setPadding(10, 10, 10, 10);
        imagen3.setAlpha(0.5f);

        imagen4.setPadding(10, 10, 10, 10);
        imagen4.setAlpha(0.5f);

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen1.setBackground(borderDrawable); // Aplica el borde a imagen1
                imagen2.setBackground(null); // Quita cualquier borde de imagen2
                imagen3.setBackground(null); // Quita cualquier borde de imagen3
                imagen4.setBackground(null); // Quita cualquier borde de imagen4

                imagen1.setAlpha(1.0f); // Restaura la opacidad completa en imagen1
                imagen2.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen2
                imagen3.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen3
                imagen4.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen4
                videoViewPager.setCurrentItem(0); // Mostrar el primer video
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen2.setBackground(borderDrawable); // Aplica el borde a imagen2
                imagen1.setBackground(null); // Quita cualquier borde de imagen1
                imagen3.setBackground(null); // Quita cualquier borde de imagen3
                imagen4.setBackground(null); // Quita cualquier borde de imagen4

                imagen2.setAlpha(1.0f); // Restaura la opacidad completa en imagen2
                imagen1.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen1
                imagen3.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen3
                imagen4.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen4

                videoViewPager.setCurrentItem(1); // Mostrar el segundo video
            }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen3.setBackground(borderDrawable); // Aplica el borde a imagen3
                imagen1.setBackground(null); // Quita cualquier borde de imagen1
                imagen2.setBackground(null); // Quita cualquier borde de imagen2
                imagen4.setBackground(null); // Quita cualquier borde de imagen4

                imagen3.setAlpha(1.0f); // Restaura la opacidad completa en imagen3
                imagen1.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen1
                imagen2.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen2
                imagen4.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen4

                videoViewPager.setCurrentItem(2); // Mostrar el tercer video
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagen4.setBackground(borderDrawable);
                imagen1.setBackground(null); // Quita cualquier borde de imagen1
                imagen2.setBackground(null); // Quita cualquier borde de imagen2
                imagen3.setBackground(null); // Quita cualquier borde de imagen3

                imagen4.setAlpha(1.0f); // Restaura la opacidad completa en imagen4
                imagen1.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen1
                imagen2.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen2
                imagen3.setAlpha(0.5f); // Establece la transparencia a la mitad en imagen3

                videoViewPager.setCurrentItem(3); // Mostrar el cuarto video
            }
        });


        videoViewPager = view.findViewById(R.id.videoViewPager);

        videoIds = new ArrayList<>();
        videoIds.add("tq6cNEpbN_o");
        videoIds.add("AK_-jvMgCNM");
        videoIds.add("gONtw18mgcU");
        videoIds.add("0jUGiYZKAMg");

        videoSliderAdapter = new VideoSliderAdapter(videoIds, getLifecycle(), videoViewPager);
        videoViewPager.setAdapter(videoSliderAdapter);

        videoViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // Selecciona la imagen correspondiente y aplica el borde y el color sólido
                switch (position) {
                    case 0:
                        imagen1.setBackground(borderDrawable);
                        imagen2.setBackground(null);
                        imagen3.setBackground(null);
                        imagen4.setBackground(null);
                        imagen1.setAlpha(1.0f);
                        imagen2.setAlpha(0.5f);
                        imagen3.setAlpha(0.5f);
                        imagen4.setAlpha(0.5f);
                        break;
                    case 1:
                        imagen2.setBackground(borderDrawable);
                        imagen1.setBackground(null);
                        imagen3.setBackground(null);
                        imagen4.setBackground(null);
                        imagen2.setAlpha(1.0f);
                        imagen1.setAlpha(0.5f);
                        imagen3.setAlpha(0.5f);
                        imagen4.setAlpha(0.5f);
                        break;
                    case 2:
                        imagen3.setBackground(borderDrawable);
                        imagen1.setBackground(null);
                        imagen2.setBackground(null);
                        imagen4.setBackground(null);
                        imagen3.setAlpha(1.0f);
                        imagen1.setAlpha(0.5f);
                        imagen2.setAlpha(0.5f);
                        imagen4.setAlpha(0.5f);
                        break;
                    case 3:
                        imagen4.setBackground(borderDrawable);
                        imagen1.setBackground(null);
                        imagen2.setBackground(null);
                        imagen3.setBackground(null);
                        imagen4.setAlpha(1.0f);
                        imagen1.setAlpha(0.5f);
                        imagen2.setAlpha(0.5f);
                        imagen3.setAlpha(0.5f);
                        break;
                }
            }
        });

        return view;
    }
}