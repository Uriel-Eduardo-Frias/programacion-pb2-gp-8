package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenarPorDniAsc implements Comparator<Paciente> {

	@Override
	public int compare(Paciente o1, Paciente o2) {
		return o1.getDni().compareTo(o2.getDni());
	}

}
