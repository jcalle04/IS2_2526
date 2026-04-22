package es.unican.is2.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

public class SeguroTest {

    @Test
    public void precioDevuelveCeroSiNoHayFechaDeInicio() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 80, null);

        assertEquals(0.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioDevuelveCeroSiNoHayCobertura() {
        Seguro seguro = creaSeguro(null, 80, LocalDate.now().minusYears(2));

        assertEquals(0.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioDevuelveCeroSiElSeguroTodaviaNoHaEntradoEnVigor() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 80, LocalDate.now().plusDays(1));

        assertEquals(0.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioCalculaTercerosSinRecargosNiDescuento() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 80, LocalDate.now().minusYears(2));

        assertEquals(400.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioCalculaTodoRiesgoDuranteElPrimerAnho() {
        Seguro seguro = creaSeguro(Cobertura.TODO_RIESGO, 80, LocalDate.now().minusMonths(6));

        assertEquals(800.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioCalculaTercerosLunasConRecargoEnElLimiteInferiorDelTramoMedio() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS_LUNAS, 90, LocalDate.now().minusYears(2));

        assertEquals(630.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioCalculaTercerosConRecargoEnElLimiteSuperiorDelTramoMedio() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 110, LocalDate.now().minusYears(2));

        assertEquals(420.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioCalculaTercerosConRecargoDelTramoAlto() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 111, LocalDate.now().minusYears(2));

        assertEquals(480.0, seguro.precio(), 0.01);
    }

    @Test
    public void precioNoAplicaDescuentoAlCumplirseUnAnhoExacto() {
        Seguro seguro = creaSeguro(Cobertura.TERCEROS, 80, LocalDate.now().minusYears(1));

        assertEquals(400.0, seguro.precio(), 0.01);
    }

    private Seguro creaSeguro(Cobertura cobertura, int potencia, LocalDate fechaInicio) {
        Seguro seguro = new Seguro();
        seguro.setCobertura(cobertura);
        seguro.setPotencia(potencia);
        seguro.setFechaInicio(fechaInicio);
        return seguro;
    }
}
