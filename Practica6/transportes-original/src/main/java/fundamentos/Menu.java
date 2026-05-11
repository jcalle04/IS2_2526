package fundamentos;

/**
 * Sustituto minimo de la biblioteca original fundamentos.
 * Solo se incluye para que el proyecto heredado compile en Maven.
 */
public class Menu {

    public Menu(String titulo) {
    }

    public void insertaOpcion(String texto, int opcion) {
    }

    public int leeOpcion() {
        throw new UnsupportedOperationException("La biblioteca fundamentos original no esta disponible.");
    }
}
