package un1a;

public class Temporada {

    private final int numero;
    private int cantidadEpisodios;
    private String nombre;

    public Temporada(int numero, int cantidadEpisodios,
                     String nombre) {

        if (numero <= 0) {
            throw new IllegalArgumentException(
                "El número de temporada debe ser mayor que cero."
            );
        }

        this.numero = numero;
        setCantidadEpisodios(cantidadEpisodios);
        setNombre(nombre);
    }

    public int getNumero() {
        return numero;
    }

    public int getCantidadEpisodios() {
        return cantidadEpisodios;
    }

    public void setCantidadEpisodios(int cantidadEpisodios) {
        if (cantidadEpisodios <= 0) {
            throw new IllegalArgumentException(
                "La cantidad de episodios debe ser mayor que cero."
            );
        }

        this.cantidadEpisodios = cantidadEpisodios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                "El nombre de la temporada no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    public void mostrarDetalles() {
        System.out.println("Temporada: " + numero);
        System.out.println("Nombre: " + nombre);
        System.out.println(
            "Cantidad de episodios: " + cantidadEpisodios
        );
    }

    @Override
    public String toString() {
        return nombre;
    }
}