package centroVacunacion;

public class Astrazeneca extends Vacuna {

	Astrazeneca() {
		super("todas las edades", 3);
		
	}

	@Override
	public boolean estaVencida() {
		// TODO Auto-generated method stub
		return false;
	}

}