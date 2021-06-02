package centroVacunacion;

public class Sputnik extends Vacuna {

	
	Sputnik() {
		super("mayores de 60",3);
		
	}

	@Override
	public boolean estaVencida() {
		return false;
	}

	@Override
	public String getNombre() {
		return "Sputnik";
	}


	
}