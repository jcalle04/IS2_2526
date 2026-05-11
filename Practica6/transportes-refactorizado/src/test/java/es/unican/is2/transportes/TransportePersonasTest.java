package es.unican.is2.transportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TransportePersonasTest {

    @Test
    void constructorValidoYPagoNoColectivo() {
        TransportePersonas transporte = new TransportePersonas(1, 1);

        assertEquals(1, transporte.getHoras());
        assertEquals(1, transporte.getPersonas());
        assertEquals(5.5, transporte.calcularPago());
    }

    @Test
    void pagoColectivo() {
        TransportePersonas transporte = new TransportePersonas(10, 10);

        assertEquals(60.0, transporte.calcularPago());
    }

    @Test
    void constructorNoValido() {
        assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(0, 1));
        assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(1, 0));
    }
}
