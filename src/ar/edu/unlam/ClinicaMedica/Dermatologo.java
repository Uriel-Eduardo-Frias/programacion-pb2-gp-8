package ar.edu.unlam.ClinicaMedica;

public class Dermatologo extends Medico {

	public Dermatologo(String matricula, String nombre, String apellido, String telefono, String email) {
		super(matricula, nombre, apellido, telefono, email);
		super.setEspecialidad(Especialidad.DERMATOLOGO);
	}

	@Override
	public Integer calcularDuracionDeUnTurno() {
		// TODO Auto-generated method stub
		return 14;
	}

	@Override
	public Double calcularCostoDeLaConsulta() {
		// TODO Auto-generated method stub
		return 45000.00;
	}

	

}
