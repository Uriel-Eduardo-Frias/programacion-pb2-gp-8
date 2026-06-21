package ar.edu.unlam.ClinicaMedica;

public abstract class Medico {
	private String matricula;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private Especialidad especialidad;
	
	public Medico(String matricula, String nombre, String apellido, String telefono, String email) {
		super();
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
	}
	
	public abstract Integer calcularDuracionDeUnTurno();
	
	public abstract Double calcularCostoDeLaConsulta();

	public String getMatricula() {
		return matricula;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
}
