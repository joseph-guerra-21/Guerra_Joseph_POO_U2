package uni1a;

import un1a.Investigador;

public class ClaseVirtual extends ContenidoAudiovisual {

    private String materia;
    private String nivel;
    private Investigador instructor;

    public ClaseVirtual(String titulo, int duracionEnMinutos,
            String genero, String materia, String nivel) {
        super(titulo, duracionEnMinutos, genero);
        setMateria(materia);
        setNivel(nivel);
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        if (materia == null || materia.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La materia no puede estar vacia.");
        }
        this.materia = materia.trim();
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        if (nivel == null || nivel.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nivel no puede estar vacio.");
        }
        this.nivel = nivel.trim();
    }

    public Investigador getInstructor() {
        return instructor;
    }

    public void asignarInstructor(Investigador instructor) {
        if (instructor == null) {
            throw new IllegalArgumentException(
                    "El instructor no puede ser nulo.");
        }
        this.instructor = instructor;
    }

    public void desvincularInstructor() {
        instructor = null;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la clase virtual:");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Minutos: " + getDuracionEnMinutos());
        System.out.println("Genero: " + getGenero());
        System.out.println("Materia: " + materia);
        System.out.println("Nivel: " + nivel);

        if (instructor == null) {
            System.out.println("Sin instructor asignado.");
        } else {
            instructor.mostrarDetalles();
        }
        System.out.println();
    }
}