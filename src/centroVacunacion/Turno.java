package centroVacunacion;

public class Turno {
	private Persona persona;
	private Vacuna vacuna;
	private Fecha fecha;
	
	
	/**IREP
	 * si la edad de persona es <60 la vacuna no puede ser : {Pfizer , Sputnik}
	 * 
	 *  
	 * @param p
	 * @param v
	 * @param f
	 */
	
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
		builder.append("Turno para: ");
		builder.append(persona);
		builder.append(" | Vacuna a aplicar: ");
		builder.append(vacuna.getNombre());
		return builder.toString();
	}
	
	

}
