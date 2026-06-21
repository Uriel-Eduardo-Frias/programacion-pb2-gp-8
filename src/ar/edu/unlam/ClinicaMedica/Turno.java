package ar.edu.unlam.ClinicaMedica;

import java.time.LocalDateTime;

public class Turno implements Comparable<Turno>{
	
	private String identificador;
	private Paciente paciente;
	private Medico medico;
	private LocalDateTime fechaYHora;
	private Estado estado;
	private Integer duracionEnMinutos;
	private Double costoDeLaConsulta;
	
	public Turno(String identificador, Paciente paciente, Medico medico, LocalDateTime fechaYHora) {
		super();
		this.identificador = identificador;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaYHora = fechaYHora;
		this.estado = estado.PENDIENTE;
		this.duracionEnMinutos = medico.calcularDuracionDeUnTurno();
		this.costoDeLaConsulta = medico.calcularCostoDeLaConsulta();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getIdentificador() {
		return identificador;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	@Override
	public int compareTo(Turno o) {
		return o.fechaYHora.compareTo(this.fechaYHora);
	}

	public Medico getMedico() {
		return medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}
	
	
	
}
