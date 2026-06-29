package ar.edu.unlam.ClinicaMedica;

import java.util.Comparator;

public class OrdenarPorApellidoYNombreAsc implements Comparator<Paciente> {

	@Override
	public int compare(Paciente o1, Paciente o2) {
		if (o1.getApellido().compareTo(o2.getApellido()) == 0) {
			return o1.getNombre().compareTo(o2.getNombre());
		}

		return o1.getApellido().compareTo(o2.getApellido());
	}

}
