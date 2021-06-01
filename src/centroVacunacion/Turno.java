package centroVacunacion;

public class Turno {
	private Persona persona;
	private Vacuna vacuna;
	private Fecha fecha;
	
	
	Turno(Persona p, Vacuna v, Fecha f) {
		this.persona = p;
		this.vacuna = v;
		this.fecha = f;
	}
	
	public boolean esTurnoVencido() {
		if (Fecha.hoy().compareTo(this.fecha) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String dameDni() {
		return "" + this.persona.getDNI();
	}

	// Setters y Getters
	public Persona getPersona() {
		return persona;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public Fecha getFecha() {
		return fecha;
	}

}
