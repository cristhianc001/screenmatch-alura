package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion { // extends para heredar atributos de titulo
    private String director;

    // constructor de Pelicula antes de haber creado uno en titulo
//    public Pelicula(String nombre){
//        this.setNombre(nombre);
//    }

    // super llama al constructor de la clase madre Titulo
    public Pelicula(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClasificacion() {
        return (int) calculaMedia() / 2; // para pasar la nota a numero de estrellas
    }

    @Override
    public String toString() {
        return "Pelicula " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";
    }
}
