package centroVacunacion;

public class Pfizer extends Vacuna {
	private Fecha fechaVencimiento;
	private Fecha aux;

	Pfizer(Fecha fechaIngreso) {
		super("mayores de 60", -18);

		aux = new Fecha(fechaIngreso.dia(), fechaIngreso.mes(), fechaIngreso.anio());

		for (int i = 0; i < 30; i++) {
			aux.avanzarUnDia();
		}
		this.fechaVencimiento = aux;
	}

	public Fecha getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Fecha fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	@Override
	public boolean estaVencida() {
		if (Fecha.hoy().compareTo(fechaVencimiento) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pfizer : Vence el = " + fechaVencimiento + " exclusiva para mayores de 60 años "+ " Guardar a -18º \n" );

		return builder.toString();
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Pfizer";
	}
	
	
}
