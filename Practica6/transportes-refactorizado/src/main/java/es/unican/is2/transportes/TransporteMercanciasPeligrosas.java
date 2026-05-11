package es.unican.is2.transportes;

/**
 * Variante de transporte de mercancias con un suplemento fijo.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 2
 *   - TransporteMercanciasPeligrosas(...) = 1
 *   - calcularExtra() = 1
 * - WMCn = 2 / 2 = 1.0
 * - CCog = 0
 * - CCogn = 0 / 2 = 0
 */
public class TransporteMercanciasPeligrosas extends TransporteMercancias {

    private static final double SUPLEMENTO_PELIGROSIDAD = 50.0;

    public TransporteMercanciasPeligrosas(double horas, int toneladas) {
        super(horas, toneladas);
    }

    @Override
    protected double calcularExtra() {
        return super.calcularExtra() + SUPLEMENTO_PELIGROSIDAD;
    }
}
