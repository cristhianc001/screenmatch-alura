package com.aluracursos.screenmatch.modelos;

public class Serie extends Titulo {
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;

    public Serie(String nombre, int fechaDeLanzamiento) {
        super(nombre, fechaDeLanzamiento);
    }

    @Override // sobreescritura del metodo que esta en Titulo, opcional en este caso
    public int getDuracionEnMinutos() {
        return temporadas*episodiosPorTemporada*minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    @Override
    public String toString() {
        return "Serie " + this.getNombre() + " (" + this.getFechaDeLanzamiento() + ")";
    }
}
