package un1a;

public class Investigador {

    private String nombre;
    private String especialidad;
    private String institucion;

    public Investigador(String nombre, String especialidad, String institucion) {
        setNombre(nombre);
        setEspecialidad(especialidad);
        setInstitucion(institucion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre del investigador no puede estar vacío."
            );
        }
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La especialidad no puede estar vacía."
            );
        }
        this.especialidad = especialidad;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        if (institucion == null || institucion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "La institución no puede estar vacía."
            );
        }
        this.institucion = institucion;
    }

    public void mostrarDetalles() {
        System.out.println("Investigador: " + nombre);
        System.out.println("Especialidad: " + especialidad);
        System.out.println("Institución: " + institucion);
    }
}