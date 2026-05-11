package es.unican.is2.transportes;

/**
 * Transporte de mercancias.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 4
 *   - TransporteMercancias(...) = 2 = 1 (base) + 1 (if)
 *   - getToneladas() = 1
 *   - calcularExtra() = 1
 * - WMCn = 4 / 3 = 1.33
 * - CCog = 1
 *   - TransporteMercancias(...) = 1 = 1 (if)
 *   - resto de metodos = 0
 * - CCogn = 1 / 3 = 0.33
 */
public class TransporteMercancias extends Transporte {

    private static final double PAGO_POR_TONELADA = 2.0;

    private final int toneladas;

    public TransporteMercancias(double horas, int toneladas) {
        super(horas);
        if (toneladas <= 0) {
            throw new IllegalArgumentException("Las toneladas deben ser mayores que cero.");
        }
        this.toneladas = toneladas;
    }

    public int getToneladas() {
        return toneladas;
    }

    @Override
    protected double calcularExtra() {
        return toneladas * PAGO_POR_TONELADA;
    }
}
