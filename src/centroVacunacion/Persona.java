package centroVacunacion;

public class Persona implements Comparable<Persona> {
	private int DNI;
	private Fecha nacimiento;
	private boolean esEmpleadoSalud;
	private boolean tienePadecimientos;
	
	
	/**IREP
	 * DNI debe ser < 99.999.999 && >1.000.000
	 * el año de nacimiento debe ser > 1900 y <2003
	 * 
	 * @param DNI
	 * @param nacimiento
	 * @param tienePadecimientos
	 * @param esEmpleadoSalud
	 */
	
	Persona(int DNI, Fecha nacimiento, boolean tienePadecimientos, boolean esEmpleadoSalud){
		this.DNI = DNI;
		this.nacimiento = nacimiento;
		this.esEmpleadoSalud = esEmpleadoSalud;
		this.tienePadecimientos = tienePadecimientos;
	}
	

	public int getEdad() {
		Fecha fechaActual = Fecha.hoy();
		
		int edad = fechaActual.anio() - this.nacimiento.anio();
		if((fechaActual.mes() < nacimiento.mes()) || (fechaActual.mes() == nacimiento.mes() && fechaActual.dia() > nacimiento.dia()))
			edad = edad - 1;

		return edad;
	}
	
	//CompareTo
	@Override
	public int compareTo(Persona persona) {
			
		
		if (this.esEmpleadoSalud || persona.esEmpleadoSalud) {
			if (this.esEmpleadoSalud && !persona.esEmpleadoSalud)
				return 1;

			else if (persona.esEmpleadoSalud && !this.esEmpleadoSalud)
				return -1;
		}
		if (this.getEdad() >= 60 || persona.getEdad() >= 60) {
			if (this.getEdad() >= 60 && persona.getEdad() < 60)
				return 1;

			else if (persona.getEdad() >= 60 && this.getEdad() < 60)
				return -1;
		}
		if (this.tienePadecimientos || persona.tienePadecimientos) {
			if (this.tienePadecimientos && !persona.tienePadecimientos)
				return 1;

			else if (persona.tienePadecimientos && !this.tienePadecimientos)
				return -1;
		}
		return 0;
			
	}
	
	
	//getter
	public int getDNI() {
		return DNI;
	}

	


	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + DNI;
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
		Persona other = (Persona) obj;
		if (DNI != other.DNI)
			return false;
		return true;
	}


	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DNI : ");
		builder.append(DNI + " | ");
		builder.append("Edad : " + getEdad() + " | ");
		builder.append("Trabaja en salud : ");
		if(this.esEmpleadoSalud) builder.append("SI | ");
		else builder.append("NO | ");
		builder.append("Tiene padecimientos : ");
		if(this.tienePadecimientos) builder.append("SI");
		else builder.append("NO");
		return builder.toString();
	}




	
}
