package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenarFechaHoraDesc implements Comparator<Turno> {

	@Override
	public int compare(Turno o1, Turno o2) {

		int resultado = o2.getFechaYHora().compareTo(o1.getFechaYHora());

		return resultado;
	}

}
