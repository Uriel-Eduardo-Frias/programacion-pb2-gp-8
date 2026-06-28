package ar.edu.unlam.ClinicaMedica;

public class Kinesiologo extends Medico {

	public Kinesiologo(String matricula, String nombre, String apellido, String telefono, String email) {
		super(matricula, nombre, apellido, telefono, email);
		super.setEspecialidad(Especialidad.KINESIOLOGO);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer calcularDuracionDeUnTurno() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public Double calcularCostoDeLaConsulta() {
		// TODO Auto-generated method stub
		return 30000.00;
	}

}
