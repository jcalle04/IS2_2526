/* Clase que representa un transporte realizado por un conductor */
/*
 * Metricas manuales de la clase (solo miembros explicitamente declarados en el codigo fuente):
 * - WMC = 9
 *   - Transporte(...) = 5 = 1 (base) + 1 (if) + 2 (condiciones adicionales con ||) + 1 (if)
 *   - horas() = 1
 *   - categoria() = 1
 *   - ton() = 1
 *   - getPersonas() = 1
 * - WMCn = 9 / 5 = 1.8
 * - CCog = 3
 *   - Transporte(...) = 3 = 1 (if) + 1 (secuencia de ||) + 1 (if)
 *   - resto de metodos = 0
 * - CCogn = 3 / 5 = 0.6
 */
public class Transporte {
	
	private double horas;
	private int ton;
	private int personas;
	private CategoriaTransporte cat;
	
	/**
	 * Constructor de la clase Transporte
	 * @param horas Horas que ha durado el transporte
	 * @param cat Categoria del transporte
	 * @param valor En caso de ser un transporte de tipo Personas, 
	 * representa el numero de personas, en caso de ser de tipo Mercancias 
	 * representa las toneladas
	 */ 
	public Transporte(double horas, CategoriaTransporte cat, int valor) throws IllegalArgumentException {
		if (horas <= 0 || valor <= 0 || cat == null) {
			throw new IllegalArgumentException();
		}
		this.horas = horas;
		this.cat = cat;
		if (cat.equals(CategoriaTransporte.Personas)) {
			this.personas = valor;
		} else  {
			this.ton = valor;
		}
	}
	
	public double horas() {
		return horas;
	}

	public CategoriaTransporte categoria() {
		return cat;
	}

	public int ton() {
		return ton;
	}

	public int getPersonas() {
		return personas;
	}
	
}
