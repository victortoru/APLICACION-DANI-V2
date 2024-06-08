package com.example.aplicacion_dani;

public class Noticias_list {
    private String tituloNoticia;
    private String textoNoticia;
    private int imagenResource; // Puedes cambiar el tipo dependiendo de cómo manejes las imágenes

    public Noticias_list(String tituloNoticia, String textoNoticia, int imagenResource) {
        this.tituloNoticia = tituloNoticia;
        this.textoNoticia = textoNoticia;
        this.imagenResource = imagenResource;
    }

    public String getTituloNoticia() {
        return tituloNoticia;
    }

    public void setTituloNoticia(String tituloNoticia) {
        this.tituloNoticia = tituloNoticia;
    }

    public String getTextoNoticia() {
        return textoNoticia;
    }

    public void setTextoNoticia(String textoNoticia) {
        this.textoNoticia = textoNoticia;
    }

    public int getImagenResource() {
        return imagenResource;
    }

    public void setImagenResource(int imagenResource) {
        this.imagenResource = imagenResource;
    }
}