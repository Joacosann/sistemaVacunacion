package centroVacunacion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class Almacen {
	
	private HashMap <String, ArrayList<Vacuna>> vacunasDisponibles;
	private HashMap <String, Integer> vacunasVencidas;
	
	/*
	 * IREP
	 * el value de todas las keys en vacunasVencidas no puede ser < 0
	 * las keys en los diccionarios vacunasDisponibles y vacunasVencidas solo pueden ser : 
	 *  {Sputnik , Moderna , AstraZeneca , Sinopharm , Pfizer}
	 */
	
	
	Almacen(){
		
		//instanciamos las vacunas disponibles
		
		this.vacunasDisponibles = new HashMap<>();
		vacunasDisponibles.put("Pfizer", new ArrayList<>());
		vacunasDisponibles.put("Moderna", new ArrayList<>());
		vacunasDisponibles.put("AstraZeneca", new ArrayList<>());
		vacunasDisponibles.put("Sputnik", new ArrayList<>());
		vacunasDisponibles.put("Sinopharm", new ArrayList<>());
		
		//instanciamos las vacunas vencidas
		
		this.vacunasVencidas = new HashMap<>();
		vacunasVencidas.put("Pfizer", 0);
		vacunasVencidas.put("Moderna", 0);
		vacunasVencidas.put("AstraZeneca", 0);
		vacunasVencidas.put("Sputnik", 0);
		vacunasVencidas.put("Sinopharm", 0);
	}
	
	/**
	 * Devuelve una vacuna correspondiente a la edad pasada por parametro
	 * de no haber vacunas o de ser menor de 18 a�os lanza una excepcion
	 *
	 *@param edad del paciente a vacunar
	 */
	public Vacuna dameVacuna(int edad) {
		// pfizer sputnik > 60
		// casos base
		if (vacunasDisponibles() == 0)
			throw new RuntimeException("no hay vacunas disponibles en el centro");
		if (edad < 18)
			throw new RuntimeException("la edad minima de vacunacion es 18 a�os");

		// si entra una persona mayor de 60
		if (edad > 60) {
			// intento dar pfizer
			if (hayVacuna("Pfizer")) {
				return this.vacunasDisponibles.get("Pfizer").remove(0);
			}
			// intento dar sputnik
			if (hayVacuna("Sputnik"))
				return this.vacunasDisponibles.get("Sputnik").remove(0);
		}
		// si no hay ninguna o si la edad es menor a 60 intento el resto

		if (hayVacuna("Moderna"))
			return this.vacunasDisponibles.get("Moderna").remove(0);
		else if (hayVacuna("AstraZeneca"))
			return this.vacunasDisponibles.get("AstraZeneca").remove(0);
		else if (hayVacuna("Sinopharm")) 
			return this.vacunasDisponibles.get("Sinopharm").remove(0);
		else {
			return null;
		}

	}
	
	public boolean hayVacuna(String nombreVacuna) {
		return this.vacunasDisponibles.get(nombreVacuna).size() > 0; 
	}
	
	public int vacunasDisponibles() {
		int contador = 0;
		for (String nombreVacuna : this.vacunasDisponibles.keySet()) {
			contador += this.vacunasDisponibles.get(nombreVacuna).size();
		}
		return contador;
	}

	public int vacunasDisponibles(String nombreVacuna) {
		return this.vacunasDisponibles.get(nombreVacuna).size();
	}
		
	public HashMap<String, Integer> reporteVacunasVencidas(){
		return this.vacunasVencidas;
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
			case "AstraZeneca":
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
	public void agregarVacunas(Vacuna vacuna) {
		String nombreVacuna = vacuna.getNombre();
		switch (nombreVacuna) {
		case "Sputnik":
				vacunasDisponibles.get(nombreVacuna).add(vacuna);
			break;
		case "Moderna":
				vacunasDisponibles.get(nombreVacuna).add(vacuna);
			break;
		case "AstraZeneca":
				vacunasDisponibles.get(nombreVacuna).add(vacuna);
			break;
		case "Pfizer":
				vacunasDisponibles.get(nombreVacuna).add(vacuna);
			break;
		case "Sinopharm":
				vacunasDisponibles.get(nombreVacuna).add(vacuna);
			break;

		default:
			break;
		}
	}
	
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
	
	private int cantVacunasVencidas() {
		int cont = 0 ;
		
		for (String vacuna : this.vacunasVencidas.keySet()) {
			cont += vacunasVencidas.get(vacuna);
		}
		
		return cont;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n------ALMACEN------ \n");
		builder.append("\nVacunas Disponibles: "+ vacunasDisponibles() +"\n\n");
		for (String key : this.vacunasDisponibles.keySet()) {
			builder.append(key + " Cantidad de vacunas disponibles : " + this.vacunasDisponibles.get(key).size() + "\n");
		}
		builder.append("\nVacunas Vencidas: "+ cantVacunasVencidas() + "\n\n");
		for (String key : this.vacunasVencidas.keySet()) {
			builder.append(key +": "+ this.vacunasVencidas.get(key) + "\n");
		}
		
		
		return builder.toString();
	}

	
	
}
