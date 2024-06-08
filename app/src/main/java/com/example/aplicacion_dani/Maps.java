package com.example.aplicacion_dani;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Maps extends Fragment implements OnMapReadyCallback {
    private NavController navController;
    private GoogleMap mMap;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }

        // Configuración de botones y otras vistas
        Button listadeaviones = view.findViewById(R.id.listadeaviones);
        Button button = view.findViewById(R.id.button);
        Button button2 = view.findViewById(R.id.button2);
        Button button3 = view.findViewById(R.id.button3);
        Button button4 = view.findViewById(R.id.nuevaopcion);
        ImageView botonsalir = view.findViewById(R.id.botonsalir);
        Button camaralogo = view.findViewById(R.id.camaralogo);

        listadeaviones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_aviones_list);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_inicioSesionFragment);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_aeropuertos_list);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_noticiasFragment);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.videoFragment);
            }
        });
        botonsalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_loginFragment);
            }
        });
        camaralogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_maps_to_camaraFragment);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Añadir marcadores en las ciudades especificadas
        LatLng barcelona = new LatLng(41.3851, 2.1734);
        LatLng casablanca = new LatLng(33.5731, -7.5898);
        LatLng berlin = new LatLng(52.5200, 13.4050);
        LatLng londres = new LatLng(51.5074, -0.1278);
        LatLng paris = new LatLng(48.8566, 2.3522);
        LatLng praga = new LatLng(50.0755, 14.4378);
        LatLng roma = new LatLng(41.9028, 12.4964);

        Marker markerBarcelona = mMap.addMarker(new MarkerOptions().position(barcelona).title("Barcelona"));
        Marker markerCasablanca = mMap.addMarker(new MarkerOptions().position(casablanca).title("Casablanca"));
        Marker markerBerlin = mMap.addMarker(new MarkerOptions().position(berlin).title("Berlín"));
        Marker markerLondres = mMap.addMarker(new MarkerOptions().position(londres).title("Londres"));
        Marker markerParis = mMap.addMarker(new MarkerOptions().position(paris).title("París"));
        Marker markerPraga = mMap.addMarker(new MarkerOptions().position(praga).title("Praga"));
        Marker markerRoma = mMap.addMarker(new MarkerOptions().position(roma).title("Roma"));

        // Crear LatLngBounds.Builder para incluir todas las ubicaciones
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(barcelona);
        builder.include(casablanca);
        builder.include(berlin);
        builder.include(londres);
        builder.include(paris);
        builder.include(praga);
        builder.include(roma);

        // Obtener los límites y mover la cámara para ajustar todas las ubicaciones en el mapa
        LatLngBounds bounds = builder.build();
        int padding = 100; // Padding alrededor de los marcadores en el mapa
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, padding));

        // Configurar el InfoWindowAdapter personalizado
        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Nullable
            @Override
            public View getInfoWindow(@NonNull Marker marker) {
                // Usar el diseño predeterminado para el InfoWindow
                return null;
            }

            @Override
            public View getInfoContents(@NonNull Marker marker) {
                View infoWindow = getLayoutInflater().inflate(R.layout.custom_info_window, null);

                ImageView imageView = infoWindow.findViewById(R.id.imageView);
                TextView textView = infoWindow.findViewById(R.id.textView);

                textView.setText(marker.getTitle());

                // Asigna la imagen correcta a cada marcador
                if (marker.equals(markerBarcelona)) {
                    imageView.setImageResource(R.drawable.bcn_air);
                } else if (marker.equals(markerCasablanca)) {
                    imageView.setImageResource(R.drawable.casablanca_air);
                } else if (marker.equals(markerBerlin)) {
                    imageView.setImageResource(R.drawable.london_air);
                } else if (marker.equals(markerLondres)) {
                    imageView.setImageResource(R.drawable.london_air);
                } else if (marker.equals(markerParis)) {
                    imageView.setImageResource(R.drawable.paris_air);
                } else if (marker.equals(markerPraga)) {
                    imageView.setImageResource(R.drawable.prague_air);
                } else if (marker.equals(markerRoma)) {
                    imageView.setImageResource(R.drawable.rome_air);
                }

                return infoWindow;
            }
        });
    }
}
