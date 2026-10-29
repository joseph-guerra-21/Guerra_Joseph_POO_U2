package poo;

import uni1a.*;
import un1a.*;

public class PruebaRelaciones {

    private static int pruebas = 0;

    private static void verificar(boolean condicion, String mensaje) {
        if (!condicion) {
            throw new AssertionError("FALLO: " + mensaje);
        }
        pruebas++;
        System.out.println("OK: " + mensaje);
    }

    public static void main(String[] args) {

        Actor actor = new Actor("Ana Torres", "Drama");

        Pelicula pelicula = new Pelicula(
                "El descubrimiento", 100, "Drama", "Estudio Norte");
        Pelicula otraPelicula = new Pelicula(
                "Nuevo comienzo", 90, "Drama", "Estudio Sur");

        pelicula.agregarActor(actor);
        otraPelicula.agregarActor(actor);
        verificar(pelicula.getActores().contains(actor),
                "Actor agregado a la pelicula");

        pelicula.agregarActor(actor);
        verificar(pelicula.getActores().size() == 1,
                "No se duplica el mismo actor");

        verificar(pelicula.quitarActor(actor),
                "Actor retirado de una pelicula");
        verificar(otraPelicula.getActores().contains(actor),
                "El actor permanece en la otra pelicula");

        SerieDeTV serie = new SerieDeTV(
                "Aprender ciencia", 40, "Educativo", 0);
        serie.agregarTemporada("Primeros pasos", 6);
        verificar(serie.getTemporadas() == 1,
                "Temporada creada dentro de la serie");

        Temporada temporada = serie.getListaTemporadas().get(0);
        verificar(temporada.getCantidadEpisodios() == 6,
                "Cantidad de episodios correcta");
        verificar(serie.quitarTemporada(temporada.getNumero()),
                "Temporada retirada");
        verificar(serie.getTemporadas() == 0,
                "La serie queda sin temporadas");

        Investigador investigador = new Investigador(
                "Luis Perez", "Fisica", "Universidad");

        Documental documental = new Documental(
                "El universo", 50, "Ciencia", "Astronomia");
        documental.asignarInvestigador(investigador);
        verificar(documental.getInvestigador() == investigador,
                "Investigador asignado al documental");
        documental.desvincularInvestigador();
        verificar(documental.getInvestigador() == null,
                "Investigador desvinculado");

        PodcastEducativo podcast = new PodcastEducativo(
                "Ciencia al dia", 30, "Educativo", "Maria", "Spotify");
        podcast.asignarAsesor(investigador);
        verificar(podcast.getAsesor() == investigador,
                "Asesor asignado al podcast");
        podcast.desvincularAsesor();
        verificar(podcast.getAsesor() == null,
                "Asesor desvinculado");

        ClaseVirtual clase = new ClaseVirtual(
                "Introduccion a Java", 60, "Educativo",
                "Programacion", "Basico");
        clase.asignarInstructor(investigador);
        verificar(clase.getInstructor() == investigador,
                "Instructor asignado a la clase");
        clase.desvincularInstructor();
        verificar(clase.getInstructor() == null,
                "Instructor desvinculado");

        try {
            clase.setMateria(" ");
            throw new AssertionError("Se acepto una materia vacia");
        } catch (IllegalArgumentException esperado) {
            verificar(true, "Se rechaza una materia vacia");
        }

        ContenidoAudiovisual[] contenidos = {
            pelicula, serie, documental, podcast, clase
        };

        System.out.println("\n--- PRUEBA DE POLIMORFISMO ---");
        for (ContenidoAudiovisual contenido : contenidos) {
            contenido.mostrarDetalles();
        }

        System.out.println("PRUEBAS SUPERADAS: " + pruebas);
    }
}