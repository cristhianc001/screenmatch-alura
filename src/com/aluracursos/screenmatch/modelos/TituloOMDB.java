package com.aluracursos.screenmatch.modelos;
// record es una clase inmutable
// aqui sera usado como un intermedio para almacenar valores que extraiga de la API
// y hacer la conversion mas facil
public record TituloOMDB(String title, String year, String runtime) {
}
