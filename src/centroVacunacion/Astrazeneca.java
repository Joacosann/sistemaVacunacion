package centroVacunacion;

public class Astrazeneca extends Vacuna {

	Astrazeneca() {
		super("todas las edades", 3);
		
	}

	@Override
	public boolean estaVencida() {
		return false;
	}

	@Override
	public String getNombre() {
		return "AstraZeneca";
	}

}
