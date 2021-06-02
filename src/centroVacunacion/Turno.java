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
	

	public int dameDni() {
		return this.persona.getDNI();
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Turno [persona=");
		builder.append(persona);
		builder.append("]");
		return builder.toString();
	}
	
	

}
