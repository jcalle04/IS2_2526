package fundamentos;

/**
 * Sustituto minimo de la biblioteca original fundamentos.
 * Solo se incluye para que el proyecto heredado compile en Maven.
 */
public class Lectura {

    public Lectura(String titulo) {
    }

    public void creaEntrada(String etiqueta, String valorPorDefecto) {
    }

    public void creaEntrada(String etiqueta, int valorPorDefecto) {
    }

    public void esperaYCierra() {
    }

    public String leeString(String etiqueta) {
        throw new UnsupportedOperationException("La biblioteca fundamentos original no esta disponible.");
    }

    public int leeInt(String etiqueta) {
        throw new UnsupportedOperationException("La biblioteca fundamentos original no esta disponible.");
    }
}
