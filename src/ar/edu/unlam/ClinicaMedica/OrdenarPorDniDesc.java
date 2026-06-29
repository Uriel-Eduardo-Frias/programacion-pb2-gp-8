package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenarPorDniDesc implements Comparator<Paciente> {

	@Override
	public int compare(Paciente o1, Paciente o2) {
		return o2.getDni().compareTo(o1.getDni());
	}

}
