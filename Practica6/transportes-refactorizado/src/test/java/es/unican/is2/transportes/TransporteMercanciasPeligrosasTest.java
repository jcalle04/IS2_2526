package es.unican.is2.transportes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TransporteMercanciasPeligrosasTest {

    @Test
    void calcularPagoIncluyeSuplementoFijo() {
        TransporteMercanciasPeligrosas transporte = new TransporteMercanciasPeligrosas(10, 1000);

        assertEquals(10, transporte.getHoras());
        assertEquals(1000, transporte.getToneladas());
        assertEquals(2100.0, transporte.calcularPago());
    }
}
