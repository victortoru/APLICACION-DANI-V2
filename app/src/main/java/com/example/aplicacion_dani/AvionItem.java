package com.example.aplicacion_dani;

public class AvionItem {
    private String ruta;
    private String altura;
    private String velocidad;
    private String nombreAvion;
    private int imagenResId;  // Identificador del recurso de imagen

    public AvionItem(String ruta, String altura, String velocidad, String nombreAvion, int imagenResId) {
        this.ruta = ruta;
        this.altura = altura;
        this.velocidad = velocidad;
        this.nombreAvion = nombreAvion;
        this.imagenResId = imagenResId;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public int getImagenResId() {
        return imagenResId;
    }

    public void setImagenResId(int imagenResId) {
        this.imagenResId = imagenResId;
    }
}

