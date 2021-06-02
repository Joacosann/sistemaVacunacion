package centroVacunacion;

public class Principal {

	public static void main(String[] args) {
		Fecha fTurnos = new Fecha(15, 7, 2021);
		CentroVacunacion centro = new CentroVacunacion("UNGS", 5);

		System.out.println("------------ Creacion -------------");
		System.out.println(centro);
		System.out.println("-----------------------------------");
		System.out.println();

		centro.ingresarVacunas("Moderna", 10, new Fecha(15,5,2021));
		centro.ingresarVacunas("Pfizer", 10, new Fecha(15,5,2021));

		centro.inscribirPersona(34701001, new Fecha(1, 5, 1989), false, false); 
		centro.inscribirPersona(29959003, new Fecha(20, 11, 1982), false, true);
		centro.inscribirPersona(24780204, new Fecha(1, 6, 1972), true, false);
		centro.inscribirPersona(29223003, new Fecha(2, 5, 1982), false, true);
		centro.inscribirPersona(13000004, new Fecha(1, 5, 1958), true, false);
		centro.inscribirPersona(13000053, new Fecha(20, 6, 1958), false, true);
		
		centro.generarTurnos(fTurnos);

		System.out.println("-------------- Turnos -------------");
		System.out.println(centro.turnosConFecha(fTurnos));
		System.out.println("-----------------------------------");
		System.out.println();
		
		centro.vacunarInscripto(24780204, fTurnos);
		centro.vacunarInscripto(13000004, fTurnos);

		System.out.println("------------- Centro --------------");
		System.out.println(centro);
		System.out.println("-----------------------------------");

	}
}
