package centroVacunacion;

public class Pfizer extends Vacuna {
	private Fecha fechaVencimiento;

	Pfizer(String edad, int temperatura, Fecha fechaVencimiento) {
		super(edad, temperatura);
		this.fechaVencimiento = fechaVencimiento;
	}

	public Fecha getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Fecha fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	

}
