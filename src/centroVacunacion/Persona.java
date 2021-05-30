package centroVacunacion;

public class Persona implements Comparable {
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
		
		int edad = fechaActual.anio() - getNacimiento().anio();
		if((fechaActual.mes() < nacimiento.mes()) || (fechaActual.mes() == nacimiento.mes() && fechaActual.dia() < nacimiento.dia()))
			edad = edad - 1;
		
		
		
		return edad;
	}
	
	//CompareTo
	public int compareTo(Persona p) {
		// TODO Auto-generated method stub
		return 0;
	}

	//Setters y Getters
	public int getDNI() {
		return DNI;
	}


	public void setDNI(int dNI) {
		DNI = dNI;
	}


	public Fecha getNacimiento() {
		return nacimiento;
	}


	public void setNacimiento(Fecha nacimiento) {
		this.nacimiento = nacimiento;
	}


	public boolean isEsEmpleadoSalud() {
		return esEmpleadoSalud;
	}


	public void setEsEmpleadoSalud(boolean esEmpleadoSalud) {
		this.esEmpleadoSalud = esEmpleadoSalud;
	}


	public boolean isTienePadecimientos() {
		return tienePadecimientos;
	}


	public void setTienePadecimientos(boolean tienePadecimientos) {
		this.tienePadecimientos = tienePadecimientos;
	}




	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		Persona pepe = new Persona(42948062, new Fecha(30, 5, 2000), false, false);
		System.out.println(pepe.getEdad());
		
		
	}
	
}
