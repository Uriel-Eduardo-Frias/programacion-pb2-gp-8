package ar.edu.unlam.ClinicaMedica;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Clinica {
	    private Set<Paciente> pacientes;
	    private Set<Medico> medicos;
	    private Map<String, Turno> turnos;

	    public Clinica() {
	        this.pacientes = new HashSet<>();
	        this.medicos = new HashSet<>();
	        this.turnos = new HashMap<>();
	    }

	    public void registrarPaciente(Paciente paciente) throws RegistroDobleException {
	    	if (existePaciente(paciente.getDni())) {
	    		throw new RegistroDobleException("El paciente ya fue registrado");
			}
	    	this.pacientes.add(paciente);
	    }

	    public Paciente buscarPaciente(String dni) throws DatoNoEncontradoException {
	    	for (Paciente paciente : this.pacientes) {
				if (paciente.getDni().equals(dni)) {
					return paciente;
				}
			}
	    	throw new DatoNoEncontradoException("paciente no registrado");
	    }

	    public void registrarMedico(Medico medico) throws RegistroDobleException {
	    	// TODO Auto-generated method stub
	    }

	    public Medico buscarMedico(String matricula) throws DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public void agendarTurno(String identificador, Paciente paciente, Medico medico, LocalDateTime fechaYHora) throws RegistroDobleException, SolicitudDenegadaException {
	    	// TODO Auto-generated method stub    
	    }

	    public Turno buscarTurno(String identificador) throws DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public void atenderTurno(String identificador) throws SolicitudDenegadaException, DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    }

	    public void cancelarTurno(String identificador) throws SolicitudDenegadaException, DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    }

	    public void reprogramarTurno(String identificador, LocalDateTime nuevaFecha) throws SolicitudDenegadaException, DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    }

	    public double obtenerCostoDeLaConsultaDeUnTurno(String identificador) throws DatoNoEncontradoException {
	    	// TODO Auto-generated method stub
	    	return 0.0;
	    }

	    public TreeSet<Turno> obtenerListaOrdenadaDeFormaAscendentePorFechaYHora() {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public TreeSet<Turno> obtenerListaOrdenadaDeFormaDescendentePorFechaYHora() {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public List<Turno> obtenerTurnosPendientesFiltradoPorDniDePaciente(String dni) {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public List<Medico> obtenerListaDeMedicosPorEspecialidad(Especialidad especialidad) {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public List<Paciente> obtenerListaDePacientosAtendidosFiltradoPorMedico(String matricula) {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public TreeSet<Paciente> obtenerListaDePacientesOrdenadosPorDniAscendente() {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public TreeSet<Paciente> obtenerListaDePacientesOrdenadosPorDniDescendente() {
	    	// TODO Auto-generated method stub
	    	return null;
	    }

	    public TreeSet<Paciente> obtenerListaDePacientesOrdenadosPorApellidoYNombreAscendente() {
	    	// TODO Auto-generated method stub
	    	return null;
	    }
	    
	    private boolean existePaciente(String dni) {
	    	for (Paciente paciente : this.pacientes) {
	    		if (paciente.getDni().equals(dni)) {
	    			return true;
				}
			}
	    	return false;
	    }
}
	    
	    
	