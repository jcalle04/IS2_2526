package es.unican.is2.transportes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Entidad de dominio que representa a un conductor.
 */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 9
 *   - Conductor(...) = 1
 *   - getDni() = 1
 *   - getNombre() = 1
 *   - getApellido1() = 1
 *   - getApellido2() = 1
 *   - getDireccion() = 1
 *   - calcularSueldo() = 2 = 1 (base) + 1 (for)
 *   - anhadirTransporte(...) = 1
 * - WMCn = 9 / 8 = 1.13
 * - CCog = 1
 *   - calcularSueldo() = 1 = 1 (for)
 *   - resto de metodos = 0
 * - CCogn = 1 / 8 = 0.13
 */
public class Conductor {

    private static final double SUELDO_BASE = 700.0;

    private final List<Transporte> transportes = new ArrayList<>();
    private final String dni;
    private final String nombre;
    private final String apellido1;
    private final String apellido2;
    private final String direccion;

    public Conductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
        this.dni = Objects.requireNonNull(dni, "El DNI no puede ser nulo.");
        this.nombre = Objects.requireNonNull(nombre, "El nombre no puede ser nulo.");
        this.apellido1 = Objects.requireNonNull(apellido1, "El primer apellido no puede ser nulo.");
        this.apellido2 = apellido2;
        this.direccion = Objects.requireNonNull(direccion, "La direccion no puede ser nula.");
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getDireccion() {
        return direccion;
    }

    public double calcularSueldo() {
        double sueldo = SUELDO_BASE;
        for (Transporte transporte : transportes) {
            sueldo += transporte.calcularPago();
        }
        return sueldo;
    }

    public void anhadirTransporte(Transporte transporte) {
        transportes.add(Objects.requireNonNull(transporte, "El transporte no puede ser nulo."));
    }
}
