package com.aluracursos.screenmatch.modelos;

public class Titulo {
    private String nombre;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeEvaluaciones; // modificadores de acceso, usuario no debe saber como se calcula esto
    private int totalEvaluaciones; //

    // Generate Getter/Setter para crear metodos publicos que usan atributos privados
    // Getter para un metodo que retorne un valor, setter para uno que introduzca
    public String getNombre() {
        return nombre;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre; // this indica que nombre se refiere al atributo de clase pelicula, el otro "nombre" es el valor que se introduce
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public int getTotalEvaluaciones(){ // encapsular para que el usuario no vea como se calcula
        return totalEvaluaciones;
    }

    public void muestraFichaTecnica(){ // Public para que Principal.java pueda acceder a atributos y metodos
        System.out.println("El nombre de la pelicula es " + nombre);
        System.out.println("La fecha de lanzamiento es " + fechaDeLanzamiento);
        System.out.println("La duracion en minutos " + getDuracionEnMinutos());
    }

    public void evalua(double nota){
        sumaDeEvaluaciones += nota;
        totalEvaluaciones ++;
    }

    public double calculaMedia(){
        return sumaDeEvaluaciones/totalEvaluaciones;
    }
}
