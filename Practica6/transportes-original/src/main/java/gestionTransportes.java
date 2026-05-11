import java.util.ArrayList;
import java.util.List;

/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 6
 *   - buscaConductor(...) = 3 = 1 (base) + 1 (for) + 1 (if)
 *   - anhadeConductor(...) = 2 = 1 (base) + 1 (if)
 *   - conductores() = 1
 * - WMCn = 6 / 3 = 2.0
 * - CCog = 4
 *   - buscaConductor(...) = 3 = 1 (for) + 2 (if anidado)
 *   - anhadeConductor(...) = 1 = 1 (if)
 *   - conductores() = 0
 * - CCogn = 4 / 3 = 1.33
 */
public class gestionTransportes {

	private ArrayList<Conductor> cs = new ArrayList<Conductor>();
	
	public Conductor buscaConductor(String DNI) {		
		for(Conductor c: cs) 
			if (c.dni().equals(DNI))
				return c;
		
		return null;
	}
	
	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null)
			return false;
		cs.add(new Conductor(dni, nombre, apellido1, apellido2,direccion));
		return true;
	}

	public List<Conductor> conductores() {
		return cs;
	}
	
}
