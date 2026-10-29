package uni1a;

import un1a.Temporada;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {

    private final List<Temporada> temporadas = new ArrayList<>();

    public SerieDeTV(String titulo, int duracionEnMinutos,
                     String genero, int cantidadTemporadas) {

        super(titulo, duracionEnMinutos, genero);
        setTemporadas(cantidadTemporadas);
    }

    public int getTemporadas() {
        return temporadas.size();
    }

    public List<Temporada> getListaTemporadas() {
        return Collections.unmodifiableList(
            new ArrayList<>(temporadas)
        );
    }

    public void setTemporadas(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(
                "La cantidad de temporadas no puede ser negativa."
            );
        }

        while (temporadas.size() > cantidad) {
            temporadas.remove(temporadas.size() - 1);
        }

        while (temporadas.size() < cantidad) {
            int numero = siguienteNumero();

            agregarTemporada(
                "Temporada " + numero,
                1
            );
        }
    }

    private int siguienteNumero() {
        int mayor = 0;

        for (Temporada temporada : temporadas) {
            if (temporada.getNumero() > mayor) {
                mayor = temporada.getNumero();
            }
        }

        return mayor + 1;
    }

    // Composición: la serie crea sus propias temporadas.
    // No se reciben temporadas creadas fuera de la serie.
    public void agregarTemporada(String nombre,
                                int cantidadEpisodios) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre de la temporada no puede estar vacío."
            );
        }

        if (cantidadEpisodios <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de episodios debe ser mayor que cero."
            );
        }

        Temporada nueva = new Temporada(
            siguienteNumero(),
            cantidadEpisodios,
            nombre.trim()
        );

        temporadas.add(nueva);
    }

    public boolean quitarTemporada(int numero) {
        for (int i = 0; i < temporadas.size(); i++) {
            if (temporadas.get(i).getNumero() == numero) {
                temporadas.remove(i);
                return true;
            }
        }

        return false;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println(
            "Duración por episodio en minutos: "
            + getDuracionEnMinutos()
        );
        System.out.println("Género: " + getGenero());
        System.out.println(
            "Cantidad de temporadas: " + getTemporadas()
        );

        for (Temporada temporada : temporadas) {
            temporada.mostrarDetalles();
        }

        System.out.println();
    }
}