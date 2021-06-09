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






	


	
	
	
	
	
}

