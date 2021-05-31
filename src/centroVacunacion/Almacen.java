package centroVacunacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Almacen {
	
	private HashMap <String, ArrayList<Vacuna>> vacunasDisponibles;
	private HashMap <String, Integer> vacunasVencidas;
	
	Almacen(){
		
		//instanciamos las vacunas disponibles
		
		this.vacunasDisponibles = new HashMap<>();
		vacunasDisponibles.put("Pfizer", new ArrayList<>());
		vacunasDisponibles.put("Moderna", new ArrayList<>());
		vacunasDisponibles.put("Astrazeneca", new ArrayList<>());
		vacunasDisponibles.put("Sputnik", new ArrayList<>());
		vacunasDisponibles.put("Sinopharm", new ArrayList<>());
		
		//instanciamos las vacunas vencidas
		
		this.vacunasVencidas = new HashMap<>();
		vacunasVencidas.put("Pfizer", 0);
		vacunasVencidas.put("Moderna", 0);
		vacunasVencidas.put("Astrazeneca", 0);
		vacunasVencidas.put("Sputnik", 0);
		vacunasVencidas.put("Sinopharm", 0);
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
	
	public void agregarVacunas(String nombreVacuna, int cantidad , Fecha ingreso) {
			switch (nombreVacuna) {
			case "Sputnik":
				for (int i = 0; i < cantidad; i++) {
					vacunasDisponibles.get(nombreVacuna).add(new Sputnik());
				}
				break;
			case "Moderna":
				for (int i = 0; i < cantidad; i++) {
					vacunasDisponibles.get(nombreVacuna).add(new Moderna(ingreso));
				}
				break;
			case "Astrazeneca":
				for (int i = 0; i < cantidad; i++) {
					vacunasDisponibles.get(nombreVacuna).add(new Astrazeneca());
				}
				break;
			case "Pfizer":
				for (int i = 0; i < cantidad; i++) {
					vacunasDisponibles.get(nombreVacuna).add(new Pfizer(ingreso));
				}
				break;
			case "Sinopharm":
				for (int i = 0; i < cantidad; i++) {
					vacunasDisponibles.get(nombreVacuna).add(new Sinopharm());
				}
				break;

			default:
				break;
			}
	}
	
//	public void sacarVacunas(String nombreVacuna, int cantidad) {
//		vacunasDisponibles.replace(nombreVacuna, cantidad);
//	}
	
	public void moverVacunas() {
		//por cada clave en vacuna disponible
		for (String nombreVacuna : vacunasDisponibles.keySet()) {
			//variable auxiliar
			ArrayList<Vacuna> aux = vacunasDisponibles.get(nombreVacuna);
			
			//itero sobre el arreglo de vacunas
			Iterator<Vacuna> it = aux.iterator();
			while (it.hasNext()) {
				//si esta vencida
				if(it.next().estaVencida()) {
					//la remuevo y aumento su cantidad en vacunas vencidas 
					it.remove();
					vacunasVencidas.put(nombreVacuna, vacunasVencidas.get(nombreVacuna)+1);
				}
			}
		}         
	}
	
	//setters y getters
	public HashMap<String, ArrayList<Vacuna>> getVacunasDisponibles() {
		return vacunasDisponibles;
	}

	public void setVacunasDisponibles(HashMap<String, ArrayList<Vacuna>> vacunasDisponibles) {
		this.vacunasDisponibles = vacunasDisponibles;
	}

	public HashMap<String, Integer> getVacunasVencidas() {
		return vacunasVencidas;
	}

	public void setVacunasVencidas(HashMap<String, Integer> vacunasVencidas) {
		this.vacunasVencidas = vacunasVencidas;
	}
		
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Almacen [vacunasDisponibles=");
		builder.append(vacunasDisponibles);
		builder.append(",  vacunasVencidas=");
		builder.append(vacunasVencidas);
		builder.append("]");
		return builder.toString();
	}

	public static void main(String[] args) {
		Almacen alma = new Almacen();
		alma.agregarVacunas("Pfizer", 2, Fecha.hoy());
		alma.agregarVacunas("Pfizer", 20, new Fecha(01,01,2021));

		System.out.println(alma);
		alma.moverVacunas();
		System.out.println(alma);
	}
	
	
}
