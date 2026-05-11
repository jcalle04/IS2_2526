package fundamentos;

/**
 * Sustituto minimo de la biblioteca original fundamentos.
 * Solo se incluye para que el proyecto heredado compile en Maven.
 */
public class Mensaje {

    public Mensaje(String titulo) {
    }

    public void escribe(String texto) {
        System.out.println(texto);
    }
}
