package es.unican.is2.transportes;

/**
 * Clase base para los transportes realizados por la empresa.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados con cuerpo en el codigo fuente):
 * - WMC = 5
 *   - Transporte(...) = 2 = 1 (base) + 1 (if)
 *   - getHoras() = 1
 *   - calcularPago() = 1
 *   - calcularPagoBase() = 1
 * - WMCn = 5 / 4 = 1.25
 * - CCog = 1
 *   - Transporte(...) = 1 = 1 (if)
 *   - resto de metodos = 0
 * - CCogn = 1 / 4 = 0.25
 */
public abstract class Transporte {

    private static final double PAGO_BASE_POR_HORA = 5.0;

    private final double horas;

    protected Transporte(double horas) {
        if (horas <= 0) {
            throw new IllegalArgumentException("Las horas deben ser mayores que cero.");
        }
        this.horas = horas;
    }

    public double getHoras() {
        return horas;
    }

    public final double calcularPago() {
        return calcularPagoBase() + calcularExtra();
    }

    protected double calcularPagoBase() {
        return horas * PAGO_BASE_POR_HORA;
    }

    protected abstract double calcularExtra();
}
