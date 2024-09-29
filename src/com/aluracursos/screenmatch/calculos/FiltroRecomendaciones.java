package com.aluracursos.screenmatch.calculos;

public class FiltroRecomendaciones {
    public void filtra(Clasificacion clasificacion){
        if (clasificacion.getClasificacion() >=4){
            System.out.println("Bien evaluado");
        } else if (clasificacion.getClasificacion() >=2){
            System.out.println("Popular");
        } else {
            System.out.println("Anadelo a la lista");
        }
    }
}
