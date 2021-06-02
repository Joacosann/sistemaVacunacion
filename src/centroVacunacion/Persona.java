package centroVacunacion;

public class Persona implements Comparable<Persona> {
	private int DNI;
	private Fecha nacimiento;
	private boolean esEmpleadoSalud;
	private boolean tienePadecimientos;
	
	
	Persona(int DNI, Fecha nacimiento, boolean esEmpleadoSalud, boolean tienePadecimientos){
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
		
//		int contEste = 0;
//		int contOtra = 0;
//		
//		if(this.tienePadecimientos)contEste =2;
//		if(persona.tienePadecimientos)contOtra =2;
//		
//		if (this.getEdad()>=60) contEste =3;
//		if (persona.getEdad()>=60) contOtra =3;
//		
//		if (this.esEmpleadoSalud) contEste =4; 
//		if (persona.esEmpleadoSalud) contOtra =4; 
//		
//		
		
		
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
		builder.append("Persona [DNI=");
		builder.append(DNI);
		builder.append("]");
		return builder.toString();
	}




	
}
