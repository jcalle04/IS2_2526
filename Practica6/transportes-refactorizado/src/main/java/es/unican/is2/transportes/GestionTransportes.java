package es.unican.is2.transportes;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Servicio de aplicacion para gestionar conductores y transportes.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 7
 *   - buscarConductorPorDni(...) = 1
 *   - registrarConductor(...) = 2 = 1 (base) + 1 (if)
 *   - registrarTransporte(...) = 2 = 1 (base) + 1 (if)
 *   - obtenerConductores() = 1
 *   - obtenerMejoresConductores() = 1
 * - WMCn = 7 / 5 = 1.4
 * - CCog = 2
 *   - registrarConductor(...) = 1 = 1 (if)
 *   - registrarTransporte(...) = 1 = 1 (if)
 *   - resto de metodos = 0
 * - CCogn = 2 / 5 = 0.4
 */
public class GestionTransportes {

    private final Map<String, Conductor> conductoresPorDni = new LinkedHashMap<>();

    public Conductor buscarConductorPorDni(String dni) {
        return conductoresPorDni.get(dni);
    }

    public boolean registrarConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
        if (conductoresPorDni.containsKey(dni)) {
            return false;
        }
        conductoresPorDni.put(dni, new Conductor(dni, nombre, apellido1, apellido2, direccion));
        return true;
    }

    public void registrarTransporte(String dni, Transporte transporte) {
        Conductor conductor = conductoresPorDni.get(dni);
        if (conductor == null) {
            throw new IllegalArgumentException("No existe un conductor con DNI " + dni);
        }
        conductor.anhadirTransporte(transporte);
    }

    public List<Conductor> obtenerConductores() {
        return List.copyOf(conductoresPorDni.values());
    }

    public List<Conductor> obtenerMejoresConductores() {
        double sueldoMaximo = conductoresPorDni.values()
                .stream()
                .mapToDouble(Conductor::calcularSueldo)
                .max()
                .orElse(-1.0);

        return conductoresPorDni.values()
                .stream()
                .filter(conductor -> conductor.calcularSueldo() == sueldoMaximo)
                .toList();
    }
}
