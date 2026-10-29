package uni1a;

import un1a.Investigador;

public class Documental extends ContenidoAudiovisual {

    private String tema;
    private Investigador investigador;

    public Documental(String titulo, int duracionEnMinutos,
                      String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        setTema(tema);
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        if (tema == null || tema.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El tema no puede estar vacío.");
        }
        this.tema = tema.trim();
    }

    public Investigador getInvestigador() {
        return investigador;
    }

    // Asociación: recibe un investigador independiente.
    public void asignarInvestigador(Investigador investigador) {
        if (investigador == null) {
            throw new IllegalArgumentException(
                "El investigador no puede ser nulo.");
        }
        this.investigador = investigador;
    }

    public void desvincularInvestigador() {
        investigador = null;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + tema);

        if (investigador == null) {
            System.out.println("Sin investigador asignado.");
        } else {
            investigador.mostrarDetalles();
        }
        System.out.println();
    }
}