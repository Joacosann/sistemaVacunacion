package centroVacunacion;

public class Sputnik extends Vacuna {

	
	Sputnik() {
		super("mayores de 60",3);
		
	}

	@Override
	public boolean estaVencida() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return "Sputnik";
	}


	
}