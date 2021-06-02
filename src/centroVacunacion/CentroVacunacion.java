package centroVacunacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CentroVacunacion {

	//valores del constructor
		private String nombreDelCentro;
		private int capacidadVacunacionDiaria;
		private Almacen almacen;
		HashMap<Integer, String> reporteVacunacion = new HashMap<>();
		ArrayList<Persona> listaDeEspera = new ArrayList<>();
		HashMap<Fecha, ArrayList<Turno>> turnos = new HashMap<>();
	//valores auxiliares
		
	/*
	 * IREP
	 * la capacidadVacunacionDiaria debe ser un entero mayor a 0
	 * 
	 */
		
		
	/**
	* Constructor.
	* recibe el nombre del centro y la capacidad de vacunación diaria.
	* Si la capacidad de vacunación no es positiva se debe generar una excepción.
	* Si el nombre no está definido, se debe generar una excepción.
	*/
	public CentroVacunacion(String nombreCentro, int capacidadVacunacionDiaria) {
		if(nombreCentro.startsWith(" ")) throw new RuntimeException("El nombre no está definido");
		this.nombreDelCentro = nombreCentro;
		if(capacidadVacunacionDiaria <=0) throw new RuntimeException("La vacunacion diaria no puede ser menor a 1");
		this.capacidadVacunacionDiaria = capacidadVacunacionDiaria;
		this.almacen = new Almacen();
	}
	
	
	
	/**
	* Solo se pueden ingresar los tipos de vacunas planteados en la 1ra parte.
	* Si el nombre de la vacuna no coincidiera con los especificados se debe generar
	* una excepción.
	* También se genera excepción si la cantidad es negativa.
	* La cantidad se debe
	* sumar al stock existente, tomando en cuenta las vacunas ya utilizadas.
	*/
	public void ingresarVacunas(String nombreVacuna, int cantidad, Fecha fechaIngreso) {
		if(!nombreVacuna.equals("Pfizer") && 
				!nombreVacuna.equals("Moderna") &&
				!nombreVacuna.equals("Sinopharm") &&
				!nombreVacuna.equals("AstraZeneca") &&
				!nombreVacuna.equals("Sputnik")) throw new RuntimeException("La vacuna no es valida");
	
		if(cantidad <=0) throw new RuntimeException("No es posible ingresar menos de una vacuna");
		almacen.agregarVacunas(nombreVacuna, cantidad, fechaIngreso);
	}

	/**
	* total de vacunas disponibles no vencidas sin distinción por tipo.
	*/
	public int vacunasDisponibles() {
		return almacen.vacunasDisponibles();
	}
	
	
	/**
	* total de vacunas disponibles no vencidas que coincida con el nombre de
	* vacuna especificado.
	*/
	public int vacunasDisponibles(String nombreVacuna) {
		return almacen.vacunasDisponibles(nombreVacuna);
	}
	
	
	
	/**
	* Se inscribe una persona en lista de espera.
	* Si la persona ya se encuentra inscripta o es menor de 18 años, se debe
	* generar una excepción.
	* Si la persona ya fue vacunada, también debe generar una excepción.
	*/
	public void inscribirPersona(int dni, Fecha nacimiento,boolean esEmpleadoSalud, boolean tienePadecimientos) {
		Persona perso = new Persona(dni, nacimiento, esEmpleadoSalud, tienePadecimientos);
		
		//dni no valido
		if(dni > 99999999 || dni<1000000) throw new RuntimeException("DNI no valido"); 
		//si es mayor de 18
		if(perso.getEdad() <18) throw new RuntimeException("La persona debe ser mayor de 18 años");
		//si no fue vacunada
		if(this.reporteVacunacion.keySet().contains(perso.getDNI())) throw new RuntimeException("La persona ya fue vacunada");
		//si no esta incripta
		if(this.listaDeEspera.contains(perso)) throw new RuntimeException("La persona ya esta inscripta");
		
		//se agrega
		this.listaDeEspera.add(perso);
	}
	
	
	
	
	/**
	* Devuelve una lista con los DNI de todos los inscriptos que no se vacunaron
	* y que no tienen turno asignado.
	* Si no quedan inscriptos sin vacunas debe devolver una lista vacía.
	*/
	public List<Integer> listaDeEspera() {
		ArrayList<Integer> lista = new ArrayList<>();
		
		for (Persona perso : this.listaDeEspera) {
			lista.add(perso.getDNI());
		}
		
		return lista;
	}
	
	
	
	/**
	* Primero se verifica si hay turnos vencidos. En caso de haber turnos
	* vencidos, la persona que no asistió al turno debe ser borrada del sistema
	* y la vacuna reservada debe volver a estar disponible.
	*
	* Segundo, se deben verificar si hay vacunas vencidas y quitarlas del sistema.
	*
	* Por último, se procede a asignar los turnos a partir de la fecha inicial
	* recibida según lo especificado en la 1ra parte.
	* Cada vez que se registra un nuevo turno, la vacuna destinada a esa persona
	* dejará de estar disponible. Dado que estará reservada para ser aplicada
	* el día del turno.
	*/
	public void generarTurnos(Fecha fechaInicial) {
		
		if(fechaInicial.compareTo(Fecha.hoy())<0) throw new RuntimeException("No se pueden generar turnos para fechas pasadas");
		
		
		/********************primera parte*************************/
		
		//recorro todas las fechas
		Iterator<Fecha> fechas = turnos.keySet().iterator();
		while(fechas.hasNext()) {
			Fecha fechaAux = fechas.next();
			//si la fecha esta vencida
			if(fechaAux.compareTo(Fecha.hoy())<0) {
				System.out.println(turnos.get(fechaAux));
				//guardo las vacunas
				for (Turno t : turnos.get(fechaAux)) {
					almacen.agregarVacuna(t.getVacuna());
				}
				fechas.remove();
			}
		}
		/********************segunda parte*************************/
		
		almacen.moverVacunas();
		
		/********************tercera parte*************************/
		ordenarListaDeEspera();
		//si no hay turnos con esa fecha la define
		if(!this.turnos.keySet().contains(fechaInicial)) {
				this.turnos.put(fechaInicial, new ArrayList<Turno>());
		}
		
		Iterator<Persona> it = listaDeEspera.iterator();
		Fecha auxFecha = new Fecha(fechaInicial.dia(),fechaInicial.mes(),fechaInicial.anio());
		while(it.hasNext()) {
			
			//si hay vacunas disponibles
			Persona perso = it.next();
			if(almacen.vacunasDisponibles()>0) {
				Vacuna aux = almacen.dameVacuna(perso.getEdad());
				
				if (aux != null) {	
					
					if(this.turnos.get(auxFecha).size()<capacidadVacunacionDiaria) {
						this.turnos.get(auxFecha).add(new Turno(perso,aux , auxFecha));
						it.remove();
					}
					else {
						auxFecha.avanzarUnDia();
						this.turnos.put(new Fecha(auxFecha.dia(),auxFecha.mes(),auxFecha.anio()), new ArrayList<Turno>());
						this.turnos.get(auxFecha).add(new Turno(perso, aux, auxFecha));
						it.remove();
					}
				}
			
			}
			//ya no hay mas vacunas
			else
				break;
			
		}
		
		
	} //fin del metodo
	

	
	
	/**
	* Devuelve una lista con los dni de las personas que tienen turno asignado
	* para la fecha pasada por parámetro.
	* Si no hay turnos asignados para ese día, se debe devolver una lista vacía.
	* La cantidad de turnos no puede exceder la capacidad por día de la ungs.
	*/
	public List<Integer> turnosConFecha(Fecha fecha) {
		ArrayList<Integer> aux =new ArrayList<Integer>();
		if(!this.turnos.keySet().contains(fecha)) return aux;
		
		for (Turno turno : turnos.get(fecha)) {
			aux.add(turno.dameDni());
		}
		return aux;
	}
	
	
	
	
	
	/**
	* Dado el DNI de la persona y la fecha de vacunación
	* se valida que esté inscripto y que tenga turno para ese dia.
	* - Si tiene turno y está inscripto se debe registrar la persona como
	* vacunada y la vacuna se quita del depósito.
	* - Si no está inscripto o no tiene turno ese día, se genera una Excepcion.
	*/
	public void vacunarInscripto(int dni, Fecha fechaVacunacion) {

		if (turnosConFecha(fechaVacunacion).contains(dni)) {

			Iterator<Turno> it = turnos.get(fechaVacunacion).iterator();
			while (it.hasNext()) {
				Turno aux = it.next();

				if (aux.dameDni() == dni) {

					reporteVacunacion.put(aux.dameDni(), aux.getVacuna().getNombre());
					it.remove();
				}

			}
		}
		else {
			throw new RuntimeException("esa persona no posee turno para esa fecha");
		}

	}
	
	
	
	
	/**
	* Devuelve un Diccionario donde
	* - la clave es el dni de las personas vacunadas
	* - Y, el valor es el nombre de la vacuna aplicada.
	*/
	public Map<Integer, String> reporteVacunacion() {
		return this.reporteVacunacion;
	}
	
	
	
	
	
	
	/**
	* Devuelve en O(1) un Diccionario:
	* - clave: nombre de la vacuna
	* - valor: cantidad de vacunas vencidas conocidas hasta el momento.
	*/
	public Map<String, Integer> reporteVacunasVencidas() {
		return almacen.reporteVacunasVencidas();
	}
	
	private void ordenarListaDeEspera() {
        for(int i = 0; i < listaDeEspera.size()-1; i ++) {
            for(int j = 0; j < listaDeEspera.size()-1; j ++) {
                if(listaDeEspera.get(j).compareTo(listaDeEspera.get(j + 1)) <0) {
              
                	Collections.swap(listaDeEspera, j, j+1);
                }
            }
        }
    }
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CentroVacunacion [nombreDelCentro=");
		builder.append(nombreDelCentro);
		builder.append(", capacidadVacunacionDiaria=");
		builder.append(capacidadVacunacionDiaria);
		builder.append(",\n lista de espera=");
		builder.append(listaDeEspera);
		builder.append(",\n turnos=");
		builder.append(turnos);
		builder.append(",\n almacen=");
		builder.append(almacen);
		builder.append("]");
		return builder.toString();
	}

	
	
}
