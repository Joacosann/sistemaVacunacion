package centroVacunacion;

public abstract class Vacuna  {
	
	private String edadPreferente;
	private int temperatura;
	
	Vacuna(String edad, int temperatura){
		this.edadPreferente = edad;
		this.temperatura = temperatura;
	}
	
	
	//getters y setters
	public String getEdadPreferente() {
		return edadPreferente;
	}

	public void setEdadPreferente(String edadPreferente) {
		this.edadPreferente = edadPreferente;
	}

	public int getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(int temperatura) {
		this.temperatura = temperatura;
	}
	
	
	
}
