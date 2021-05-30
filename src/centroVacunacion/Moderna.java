package centroVacunacion;

public class Moderna extends Vacuna {
	private Fecha fechaVencimiento;
	
	Moderna(String edad, int temperatura, Fecha fechaVencimiento) {
		super(edad, temperatura);
		this.fechaVencimiento = fechaVencimiento;
	}
	
	
	//getters y setters
	public Fecha getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Fecha fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

}
