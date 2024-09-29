import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendaciones;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
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

//        Pelicula otraPelicula = new Pelicula();
//        otraPelicula.nombre = "Matrix";
//        otraPelicula.fechaDeLanzamiento = 1998;
//        otraPelicula.duracionEnMinutos = 100;


        Serie casaDragon = new Serie();
        casaDragon.setNombre("Casa del Dragon");
        casaDragon.setFechaDeLanzamiento(2022);
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




    }
}
