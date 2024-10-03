package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendaciones;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        // constructor generico de Object, reserva espacio en la memoria. Usa miPelicula.setNombre()
        // Se crea nuevo constructor en Pelicula y ahora el nombre va en el argumento
        // Pelicula miPelicula = new Pelicula();
        Pelicula miPelicula = new Pelicula("Encanto", 2011);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(9);
        System.out.println(miPelicula.getTotalEvaluaciones()); // metodo que ve el usuario, no atributo
        System.out.println(miPelicula.calculaMedia());

        // simulacion de saboteo de nota, usuario podria modificar atributos
        // miPelicula.sumaDeEvaluaciones = 2;
        // miPelicula.totalEvaluaciones = 1;
        // System.out.println(miPelicula.calculaMedia());

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.setDuracionEnMinutos(100);

        Serie casaDragon = new Serie("Casa del Dragon", 2022);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("Casa Targayren");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);
        filtroRecomendaciones.filtra(episodio);

        var peliculaBruno = new Pelicula("El senior de los anillos", 2001); // var puede inferir tipo de dato, evita redundancia
        peliculaBruno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        listaPeliculas.add(miPelicula);
        listaPeliculas.add(otraPelicula);
        listaPeliculas.add(peliculaBruno);

        System.out.println("Tamanio de lista: " + listaPeliculas.size());
        System.out.println("Primera pelicula: "+ listaPeliculas.get(0).getNombre());

        System.out.println(listaPeliculas);

        System.out.println("toString sobreescrito: " + listaPeliculas.get(0).toString());




    }
}
