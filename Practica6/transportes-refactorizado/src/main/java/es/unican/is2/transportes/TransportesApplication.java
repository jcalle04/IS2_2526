package es.unican.is2.transportes;

/**
 * Punto de entrada ejecutable del proyecto refactorizado.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 7
 *   - main(...) = 1
 *   - crearEmpresaDemo() = 1
 *   - registrarConductoresDemo(...) = 1
 *   - registrarTransportesDemo(...) = 1
 *   - mostrarResumen(...) = 3 = 1 (base) + 1 (for) + 1 (for)
 * - WMCn = 7 / 5 = 1.4
 * - CCog = 2
 *   - mostrarResumen(...) = 2 = 1 (for) + 1 (for)
 *   - resto de metodos = 0
 * - CCogn = 2 / 5 = 0.4
 */
public final class TransportesApplication {

    public static void main(String[] args) {
        GestionTransportes empresa = crearEmpresaDemo();
        mostrarResumen(empresa);
    }

    static GestionTransportes crearEmpresaDemo() {
        GestionTransportes empresa = new GestionTransportes();
        registrarConductoresDemo(empresa);
        registrarTransportesDemo(empresa);
        return empresa;
    }

    private static void registrarConductoresDemo(GestionTransportes empresa) {
        empresa.registrarConductor("123123123X", "Pepe", "Martinez", "Fernandez", "Avda. de los Castros s/n");
        empresa.registrarConductor("987654321Z", "Ana", "Lopez", "Ruiz", "Calle Alta 15");
    }

    private static void registrarTransportesDemo(GestionTransportes empresa) {
        empresa.registrarTransporte("123123123X", new TransportePersonas(1, 1));
        empresa.registrarTransporte("123123123X", new TransporteMercancias(2, 5));
        empresa.registrarTransporte("987654321Z", new TransportePersonas(4, 20));
        empresa.registrarTransporte("987654321Z", new TransporteMercanciasPeligrosas(1, 10));
    }

    private static void mostrarResumen(GestionTransportes empresa) {
        System.out.println("Resumen del proyecto refactorizado");
        for (Conductor conductor : empresa.obtenerConductores()) {
            System.out.printf("- %s (%s): %.2f euros%n",
                    conductor.getNombre(),
                    conductor.getDni(),
                    conductor.calcularSueldo());
        }

        System.out.println("Mejor conductor o mejores conductores:");
        for (Conductor conductor : empresa.obtenerMejoresConductores()) {
            System.out.printf("  * %s %s%n", conductor.getNombre(), conductor.getApellido1());
        }
    }
}
