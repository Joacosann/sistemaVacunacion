package centroVacunacion;

import java.util.HashMap;

public class Almacen {
	
	private HashMap <String, Integer> vacunasDisponibles;
	private HashMap <String, Integer> vacunasVencidas;
	
	Almacen(){
		this.vacunasDisponibles = new HashMap<String, Integer>();
		this.vacunasVencidas = new HashMap<String, Integer>();
	}
	
	public Vacuna dameVacuna(int edad) {
		return null;
	}
	
	public boolean hayVacuna(String nombreVacuna) {
		return false;
	}
	
	public int vacunasDisponibles() {
		return 0;
	}
	
	public HashMap<String, Integer> reporteVacunasVencidas(){
		return null;
	}
	
	public void agregarVacunas(String nombreVacuna, int cantidad) {
		vacunasDisponibles.put(nombreVacuna, cantidad);
	}
	
	public void sacarVacunas(String nombreVacuna, int cantidad) {
		vacunasDisponibles.replace(nombreVacuna, cantidad);
	}
	
	public void moverVacunas(String nombreVacuna, int cantidad, HashMap<String, Integer> almacen) {
		
	}
	
	//setters y getters
	public HashMap<String, Integer> getVacunasDisponibles() {
		return vacunasDisponibles;
	}

	public void setVacunasDisponibles(HashMap<String, Integer> vacunasDisponibles) {
		this.vacunasDisponibles = vacunasDisponibles;
	}

	public HashMap<String, Integer> getVacunasVencidas() {
		return vacunasVencidas;
	}

	public void setVacunasVencidas(HashMap<String, Integer> vacunasVencidas) {
		this.vacunasVencidas = vacunasVencidas;
	}
	
	
}
