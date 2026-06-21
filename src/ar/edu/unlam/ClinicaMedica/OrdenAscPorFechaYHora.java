package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenAscPorFechaYHora implements Comparator<Turno> {

	@Override
	public int compare(Turno o1, Turno o2) {
		return o1.getFechaYHora().compareTo(o2.getFechaYHora());
	}

}
