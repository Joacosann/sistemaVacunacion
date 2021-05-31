package centroVacunacion;

public class Sinopharm extends Vacuna {

	Sinopharm() {
		super("todas las edades", 3);
		
	}

	@Override
	public boolean estaVencida() {
		// TODO Auto-generated method stub
		return false;
	}

}
