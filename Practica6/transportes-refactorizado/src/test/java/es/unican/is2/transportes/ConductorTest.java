package es.unican.is2.transportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ConductorTest {

    @Test
    void constructorValidoYAccesores() {
        Conductor conductor = new Conductor("123123123X", "Pepe", "Martinez", "Fernandez",
                "Avda. de los Castros s/n");

        assertEquals("123123123X", conductor.getDni());
        assertEquals("Pepe", conductor.getNombre());
        assertEquals("Martinez", conductor.getApellido1());
        assertEquals("Fernandez", conductor.getApellido2());
        assertEquals("Avda. de los Castros s/n", conductor.getDireccion());

        conductor = new Conductor("123123123X", "Pepe", "Martinez", null, "Avda. de los Castros s/n");
        assertNull(conductor.getApellido2());
    }

    @Test
    void constructorNoValido() {
        assertThrows(NullPointerException.class,
                () -> new Conductor(null, "Pepe", "Martinez", "Fernandez", "Avda. de los Castros s/n"));
        assertThrows(NullPointerException.class,
                () -> new Conductor("123123123X", null, "Martinez", "Fernandez", "Avda. de los Castros s/n"));
        assertThrows(NullPointerException.class,
                () -> new Conductor("123123123X", "Pepe", null, "Fernandez", "Avda. de los Castros s/n"));
        assertThrows(NullPointerException.class,
                () -> new Conductor("123123123X", "Pepe", "Martinez", "Fernandez", null));
    }

    @Test
    void calcularSueldoYAnhadeTransporte() {
        Conductor conductor = new Conductor("123123123X", "Pepe", "Martinez", "Fernandez",
                "Avda. de los Castros s/n");

        assertEquals(700.0, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransportePersonas(1, 1));
        assertEquals(705.5, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransportePersonas(10, 9));
        assertEquals(760.5, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransportePersonas(1, 10));
        assertEquals(766.5, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransportePersonas(10, 20));
        assertEquals(826.5, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransporteMercancias(1, 1));
        assertEquals(833.5, conductor.calcularSueldo());

        conductor.anhadirTransporte(new TransporteMercanciasPeligrosas(10, 100));
        assertEquals(1133.5, conductor.calcularSueldo());
    }
}
