package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepcion.ErrorEnConversionDuracionExcepcion;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOMDB;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        // convertir json a una clase
        Gson gson = new GsonBuilder() // decirle a Gson que las claves del json vienen en Mayus
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escriba el nombre de la pelicula");
            var busqueda = lectura.nextLine();

            if(busqueda.equalsIgnoreCase("salir") ){
                break;
            }

            // replace necesario para peliculas con espacio
            String direccion = "https://www.omdbapi.com/?t=" +
                    busqueda.replace(" ", "+") + "&apikey=829ddf0f" ;

            try{
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                TituloOMDB miTituloOMDB = gson.fromJson(json, TituloOMDB.class);

                // usar toString en Titulo para arreglar el output
                // tambien se podria usar miTitulo.getNombre si no se quiere adicionar toString
                System.out.println(miTituloOMDB);

                // si el resultado es null, puede ser porque hay diferencias entre los atributos
                // de la clase Titulo y los atributos que recoge gson

                // puede haber error porque Runtime siempre es String por tener "min" al final de la cifra
                // mientras que definimos duracion en clase Titulo como int


                Titulo miTitulo = new Titulo(miTituloOMDB);
                System.out.println(miTitulo);

                titulos.add(miTitulo);

                // ejemplo de uso, crea un archivo txt con los datos de la pelicula
//                FileWriter escritura = new FileWriter("peliculas.txt");
//                escritura.write(miTitulo.toString());
//                escritura.close();



            } catch (NumberFormatException e) {
                System.out.println("Ocurrio error: ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println("Error en URI");
            } catch (ErrorEnConversionDuracionExcepcion e){ // no recomendado usar la clase madre Exception
                System.out.println(e.getMessage());
            }

        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();


        System.out.println("Finalizo ejecucion");

    }
}
