package un1a;

public class Actor {

    private String nombre;
    private String especialidad;

    public Actor(String nombre, String especialidad) {
        setNombre(nombre);
        setEspecialidad(especialidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        if (especialidad == null
                || especialidad.trim().isEmpty()) {

            throw new IllegalArgumentException(
                "La especialidad no puede estar vacía."
            );
        }

        this.especialidad = especialidad.trim();
    }

    @Override
    public String toString() {
        return nombre + " (" + especialidad + ")";
    }
}