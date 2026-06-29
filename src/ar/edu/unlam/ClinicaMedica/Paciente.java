package ar.edu.unlam.ClinicaMedica;

import java.time.LocalDate;

public class Paciente {

	private String dni;
	private String nombre;
	private String apellido;
	private LocalDate fechaNacimiento;
	private String telefono;
	private Integer numeroHistoriaClinica;
	private String obraSocial;
	private String email;

	public Paciente(String dni, String nombre, String apellido, LocalDate fechaNacimiento, String telefono,
			Integer numeroHistoriaClinica, String obraSocial, String email) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNacimiento = fechaNacimiento;
		this.telefono = telefono;
		this.numeroHistoriaClinica = numeroHistoriaClinica;
		this.obraSocial = obraSocial;
		this.email = email;
	}

	public String getDni() {
		return this.dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getTelefono() {
		return telefono;
	}

	public Integer getNumeroHistoriaClinica() {
		return numeroHistoriaClinica;
	}

	public String getObraSocial() {
		return obraSocial;
	}

	public String getEmail() {
		return email;
	}

}
