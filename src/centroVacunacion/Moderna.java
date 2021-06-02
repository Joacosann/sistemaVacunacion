package centroVacunacion;


public class Moderna extends Vacuna {
	
	private Fecha fechaVencimiento;
	private Fecha aux;
	
	/*IREP
	 * fechaIngreso debe ser menor o igual a Fecha.hoy()
	 */
	
	
	Moderna(Fecha fechaIngreso) {
		super("todas las edades", -18);
		
		//variable auxiliar para establecer la fecha de vencimiento
		aux =new Fecha(fechaIngreso.dia() , fechaIngreso.mes() , fechaIngreso.anio());
		
		//avanzamos los dias necesarios para que se venza 
		for (int i = 0; i < 60; i++) {
			aux.avanzarUnDia();
		}
		this.fechaVencimiento = aux;
	}
	
	
	//getters y setters
	public Fecha getFechaVencimiento() {
		StringBuilder fecha = new StringBuilder();
		fecha.append(fechaVencimiento.dia());
		fecha.append("/");
		fecha.append(fechaVencimiento.mes());
		fecha.append("/");
		fecha.append(fechaVencimiento.anio());
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Fecha fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	@Override
	public boolean estaVencida() {
		if(Fecha.hoy().compareTo(fechaVencimiento) >=0) {
			return true;
		}
		else {
			return false;
		}
	}


	@Override
	public String getNombre() {
		return "Moderna";
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
		Moderna other = (Moderna) obj;
		if (fechaVencimiento == null) {
			if (other.fechaVencimiento != null)
				return false;
		} else if (!fechaVencimiento.equals(other.fechaVencimiento))
			return false;
		return true;
	}




	


	
	
	
	
	
}

