package es.unican.is2.transportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TransporteMercanciasTest {

    @Test
    void constructorValidoYPago() {
        TransporteMercancias transporte = new TransporteMercancias(1, 1);

        assertEquals(1, transporte.getHoras());
        assertEquals(1, transporte.getToneladas());
        assertEquals(7.0, transporte.calcularPago());
    }

    @Test
    void constructorNoValido() {
        assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(1, 0));
    }
}
