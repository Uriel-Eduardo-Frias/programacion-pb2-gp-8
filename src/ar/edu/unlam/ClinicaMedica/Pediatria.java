package ar.edu.unlam.ClinicaMedica;

public class Pediatria extends Medico {

	public Pediatria(String matricula, String nombre, String apellido, String telefono, String email) {
		super(matricula, nombre, apellido, telefono, email);
		super.setEspecialidad(Especialidad.PEDIATRIA);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer calcularDuracionDeUnTurno() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calcularCostoDeLaConsulta() {
		// TODO Auto-generated method stub
		return 50000.00;
	}

}
