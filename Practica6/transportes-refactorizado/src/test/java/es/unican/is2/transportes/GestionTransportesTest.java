package es.unican.is2.transportes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

class GestionTransportesTest {

    @Test
    void registrarYBuscarConductor() {
        GestionTransportes gestion = new GestionTransportes();

        assertTrue(gestion.registrarConductor("123123123X", "Pepe", "Martinez", "Fernandez",
                "Avda. de los Castros s/n"));
        assertFalse(gestion.registrarConductor("123123123X", "Pepe", "Martinez", "Fernandez",
                "Avda. de los Castros s/n"));

        Conductor conductor = gestion.buscarConductorPorDni("123123123X");
        assertEquals("Pepe", conductor.getNombre());
        assertEquals(1, gestion.obtenerConductores().size());
    }

    @Test
    void registrarTransporteExigeConductorExistente() {
        GestionTransportes gestion = new GestionTransportes();
        assertThrows(IllegalArgumentException.class,
                () -> gestion.registrarTransporte("00000000A", new TransporteMercancias(1, 1)));
    }

    @Test
    void obtenerMejoresConductoresGestionaEmpates() {
        GestionTransportes gestion = new GestionTransportes();
        gestion.registrarConductor("1A", "Ana", "Lopez", null, "Dir 1");
        gestion.registrarConductor("2B", "Luis", "Perez", null, "Dir 2");
        gestion.registrarConductor("3C", "Eva", "Ruiz", null, "Dir 3");

        gestion.registrarTransporte("1A", new TransporteMercanciasPeligrosas(1, 10));
        gestion.registrarTransporte("2B", new TransporteMercanciasPeligrosas(1, 10));
        gestion.registrarTransporte("3C", new TransportePersonas(1, 1));

        List<Conductor> mejores = gestion.obtenerMejoresConductores();
        assertEquals(2, mejores.size());
        assertSame(gestion.buscarConductorPorDni("1A"), mejores.get(0));
        assertSame(gestion.buscarConductorPorDni("2B"), mejores.get(1));
    }
}
