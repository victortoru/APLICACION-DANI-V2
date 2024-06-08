package com.example.aplicacion_dani;

public class AeropuertoItem {
    private String nombreAeropuerto;
    private String infoAeropuerto;
    private int imagenAeropuerto; // Cambiar el tipo de dato según el tipo de recurso que estés utilizando

    public AeropuertoItem(String nombreAeropuerto, String infoAeropuerto, int imagenAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
        this.infoAeropuerto = infoAeropuerto;
        this.imagenAeropuerto = imagenAeropuerto;
    }

    public String getNombreAeropuerto() {
        return nombreAeropuerto;
    }

    public void setNombreAeropuerto(String nombreAeropuerto) {
        this.nombreAeropuerto = nombreAeropuerto;
    }

    public String getInfoAeropuerto() {
        return infoAeropuerto;
    }

    public void setInfoAeropuerto(String infoAeropuerto) {
        this.infoAeropuerto = infoAeropuerto;
    }

    public int getImagenAeropuerto() {
        return imagenAeropuerto;
    }

    public void setImagenAeropuerto(int imagenAeropuerto) {
        this.imagenAeropuerto = imagenAeropuerto;
    }
}
