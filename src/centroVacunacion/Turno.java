package centroVacunacion;

public class Turno {
	private Persona persona;
	private Vacuna vacuna;
	private Fecha fecha;
	
	
	Turno(Persona p, Vacuna v, Fecha f){
		this.persona = p;
		this.vacuna = v;
		this.fecha = f;
	}
	
	public String dameDni(){
		return "" + this.persona.getDNI();
	}

	
	//Setters y Getters
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public void setFecha(Fecha fecha) {
		this.fecha = fecha;
	}

	public boolean esTurnoVencido() {
		if(Fecha.hoy().compareTo(this.fecha) >0) {
			return true;
		}
		else {
			return false;
		}
	}
}
