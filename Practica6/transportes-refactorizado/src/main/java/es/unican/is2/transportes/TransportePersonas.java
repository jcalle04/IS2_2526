package es.unican.is2.transportes;

/**
 * Transporte de personas.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 5
 *   - TransportePersonas(...) = 2 = 1 (base) + 1 (if)
 *   - getPersonas() = 1
 *   - calcularExtra() = 2 = 1 (base) + 1 (operador ternario)
 * - WMCn = 5 / 3 = 1.67
 * - CCog = 2
 *   - TransportePersonas(...) = 1 = 1 (if)
 *   - calcularExtra() = 1 = 1 (operador ternario)
 * - CCogn = 2 / 3 = 0.67
 */
public class TransportePersonas extends Transporte {

    private static final int LIMITE_TRANSPORTE_COLECTIVO = 10;
    private static final double EXTRA_NO_COLECTIVO_POR_HORA = 0.5;
    private static final double EXTRA_COLECTIVO_POR_HORA = 1.0;

    private final int personas;

    public TransportePersonas(double horas, int personas) {
        super(horas);
        if (personas <= 0) {
            throw new IllegalArgumentException("El numero de personas debe ser mayor que cero.");
        }
        this.personas = personas;
    }

    public int getPersonas() {
        return personas;
    }

    @Override
    protected double calcularExtra() {
        return getHoras() * (personas < LIMITE_TRANSPORTE_COLECTIVO
                ? EXTRA_NO_COLECTIVO_POR_HORA
                : EXTRA_COLECTIVO_POR_HORA);
    }
}
