package uni1a;

import un1a.Investigador;

public class PodcastEducativo extends ContenidoAudiovisual {

    private String presentador;
    private String plataforma;
    private Investigador asesor;

    public PodcastEducativo(String titulo, int duracionEnMinutos,
            String genero, String presentador, String plataforma) {
        super(titulo, duracionEnMinutos, genero);
        setPresentador(presentador);
        setPlataforma(plataforma);
    }

    public String getPresentador() {
        return presentador;
    }

    public void setPresentador(String presentador) {
        if (presentador == null || presentador.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El presentador no puede estar vacio.");
        }
        this.presentador = presentador.trim();
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if (plataforma == null || plataforma.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La plataforma no puede estar vacia.");
        }
        this.plataforma = plataforma.trim();
    }

    public Investigador getAsesor() {
        return asesor;
    }

    public void asignarAsesor(Investigador asesor) {
        if (asesor == null) {
            throw new IllegalArgumentException(
                    "El asesor no puede ser nulo.");
        }
        this.asesor = asesor;
    }

    public void desvincularAsesor() {
        asesor = null;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del podcast educativo:");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Minutos: " + getDuracionEnMinutos());
        System.out.println("Genero: " + getGenero());
        System.out.println("Presentador: " + presentador);
        System.out.println("Plataforma: " + plataforma);

        if (asesor == null) {
            System.out.println("Sin asesor asignado.");
        } else {
            asesor.mostrarDetalles();
        }
        System.out.println();
    }
}