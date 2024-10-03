package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2011);
        miPelicula.evalua(9);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.evalua(6);
        var peliculaBruno = new Pelicula("El senior de los anillos", 2001);
        peliculaBruno.evalua(10);
        Serie casaDragon = new Serie("Casa del Dragon", 2022);

        // ArrayList usa la interfaz List, por lo tanto se puede usar List a la izquierda
        // Es util por si mas adelante se quiere cambiar ArrayList por otra clase de lista que
        // use la interfaz List. List es la interfaz general con unos metodos especificos
        // y ArrayList es una de las tantas clases que toma esos metodos. Otra es LinkedList p.e.
        List<Titulo> lista = new ArrayList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaBruno);
        lista.add(casaDragon);

        for (Titulo item: lista){ // item es el nombre del elemento de tipo Titulo: lista lo que voy a iterar
            System.out.println(item.getNombre());
            // como ni Serie ni Titulo no tiene metodo getClasificacion, se hace casting Titulo -> pelicula
            // forma corta de hacer casting dentro del if, anadiendo pelicula como variable
            if (item instanceof Pelicula pelicula){ // instanceof es type
                // forma convencional de hacer casting
                // Pelicula pelicula = (Pelicula) item;
                System.out.println(pelicula.getClasificacion());
            }
        }

        ArrayList<String> listaArtistas = new ArrayList<>();
        listaArtistas.add("Penelope Cruz");
        listaArtistas.add("Leonardo");
        listaArtistas.add("Ricardo");
        System.out.println(listaArtistas);

        Collections.sort(listaArtistas);
        System.out.println(listaArtistas);

        // despues de implementar la interface en la clase Titulo
        Collections.sort(lista);
        System.out.println(lista);

        // otro criterio de ordenacion. Comparator es una interfaz
        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println(lista);
    }
}
