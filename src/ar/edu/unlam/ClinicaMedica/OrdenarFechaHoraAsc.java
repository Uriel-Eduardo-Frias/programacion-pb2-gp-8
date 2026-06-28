package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenarFechaHoraAsc implements Comparator<Turno> {

	@Override
	public int compare(Turno o1, Turno o2) {

		int resultado = o1.getFechaYHora().compareTo(o2.getFechaYHora());
		
		
		
		return resultado;
	}

	
	
	
	
}
