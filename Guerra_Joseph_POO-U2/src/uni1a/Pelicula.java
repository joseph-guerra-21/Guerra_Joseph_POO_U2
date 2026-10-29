package uni1a;

import un1a.Actor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {

    private String estudio;
    private final List<Actor> actores = new ArrayList<>();

    public Pelicula(String titulo, int duracionEnMinutos,
                    String genero, String estudio) {

        super(titulo, duracionEnMinutos, genero);
        setEstudio(estudio);
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        if (estudio == null || estudio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El estudio no puede estar vacío."
            );
        }

        this.estudio = estudio.trim();
    }

    // Agregación: los actores existen independientemente
    // y pueden participar en varias películas.
    public void agregarActor(Actor actor) {
        if (actor == null) {
            throw new IllegalArgumentException(
                "El actor no puede ser nulo."
            );
        }

        if (!actores.contains(actor)) {
            actores.add(actor);
        }
    }

    public boolean quitarActor(Actor actor) {
        return actores.remove(actor);
    }

    public List<Actor> getActores() {
        return Collections.unmodifiableList(
            new ArrayList<>(actores)
        );
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println(
            "Duración en minutos: " + getDuracionEnMinutos()
        );
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);

        if (actores.isEmpty()) {
            System.out.println("Sin actores registrados.");
        } else {
            System.out.println("Actores:");

            for (Actor actor : actores) {
                System.out.println("- " + actor);
            }
        }

        System.out.println();
    }
}