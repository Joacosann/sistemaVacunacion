package centroVacunacion;

public class Pfizer extends Vacuna {
	private Fecha fechaVencimiento;
	private Fecha aux;

	/*IREP
	 * fechaIngreso debe ser menor o igual a Fecha.hoy()
	 */
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((fechaVencimiento == null) ? 0 : fechaVencimiento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pfizer other = (Pfizer) obj;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		return true;
	}
	
	
	
	
}
