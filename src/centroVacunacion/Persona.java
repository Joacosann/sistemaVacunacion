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




	
	
	public static void main(String[] args) {
		Persona pepe = new Persona(42948062, new Fecha(31, 5, 2000), true, true);
		Persona juan = new Persona(42948062, new Fecha(31, 5, 1930), true, true);
		System.out.println(pepe.getEdad());
		System.out.println(juan.getEdad());
		System.out.println(pepe.compareTo(juan));
		
		
		
	}


	
}
