package centroVacunacion;

public abstract class Vacuna  {
	
	private String edadPreferente;
	private int temperatura;
	
	/*
	 * edadPreferente debe ser "todas las edades"  o  "mayores de 60"
	 * dada la forma de implementacion de la herencia el irep siempre se cumple 
	 */
	
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
	
	abstract public boolean estaVencida();
	
	abstract public String getNombre();



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((edadPreferente == null) ? 0 : edadPreferente.hashCode());
		result = prime * result + temperatura;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vacuna other = (Vacuna) obj;
		if (edadPreferente == null) {
			if (other.edadPreferente != null)
				return false;
		} else if (!edadPreferente.equals(other.edadPreferente))
			return false;
		if (temperatura != other.temperatura)
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vacuna [edadPreferente=");
		builder.append(edadPreferente);
		builder.append(", temperatura=");
		builder.append(temperatura);
		builder.append("]");
		return builder.toString();
	}
	
	
}

