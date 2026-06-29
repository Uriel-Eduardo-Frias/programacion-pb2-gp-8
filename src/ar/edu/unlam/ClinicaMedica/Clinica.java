package ar.edu.unlam.ClinicaMedica;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		return null;
	}

	public void registrarMedico(Medico medico) throws RegistroDobleException {
		if (existeMedico(medico.getMatricula())) {
			throw new RegistroDobleException("El medico ya fue registrado");
		}
		this.medicos.add(medico);
	}

	public Medico buscarMedico(String matricula) throws DatoNoEncontradoException {
		for (Medico medico : medicos) {
			if (medico.getMatricula().equals(matricula)) {
				return medico;
			}
		}
		return null;
	}

	public void agendarTurno(Turno turno)
			throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {

		if (buscarTurno(turno.getIdentificador()) != null) {
			throw new RegistroDobleException("El turno ya fue registrado anteriormente");
		}

		Paciente pacienteEncontrado = buscarPaciente(turno.getPaciente().getDni());
		Medico medicoEncontrado = buscarMedico(turno.getMedico().getMatricula());

		if (pacienteEncontrado == null || medicoEncontrado == null) {
			throw new DatoNoEncontradoException("Medico o Paciente no encontrado");
		}

		Boolean fechaValida = validarFechaYHora(turno);
		if (!fechaValida) {
			throw new SolicitudDenegadaException("La fecha u hora no son válidas");
		}
		this.turnos.put(turno.getIdentificador(), turno);
	}

	public Turno buscarTurno(String identificador) {

		Turno turno = turnos.get(identificador);

		if (turno != null) {
			return turno;
		}

		return null;
	}

	public HashMap<Medico, List<Paciente>> reporteMedicoConPacientes() {

		HashMap<Medico, List<Paciente>> reporteMedicoConPaciente = new HashMap<>();
		for (Map.Entry<String, Turno> entry : turnos.entrySet()) {
			Turno val = entry.getValue();

			if (!reporteMedicoConPaciente.containsKey(val.getMedico())) {
				List<Paciente> listaDePacientes = new ArrayList<>();
				listaDePacientes.add(val.getPaciente());
				reporteMedicoConPaciente.put(val.getMedico(), listaDePacientes);
			} else {
				reporteMedicoConPaciente.get(val.getMedico()).add(val.getPaciente());
			}
		}

		return reporteMedicoConPaciente;
	}

	public Boolean validarFechaYHora(Turno turnoNuevo) throws SolicitudDenegadaException {

		LocalDateTime inicioNuevo = turnoNuevo.getFechaYHora();
		Integer duracionNuevo = turnoNuevo.getMedico().calcularDuracionDeUnTurno();
		LocalDateTime finNuevo = inicioNuevo.plusMinutes(duracionNuevo);

		for (Turno turnoExistente : turnos.values()) {
			if (turnoExistente.getMedico().getMatricula().equals(turnoNuevo.getMedico().getMatricula())) {
				LocalDateTime inicioExistente = turnoExistente.getFechaYHora();
				Integer duracionExistente = turnoExistente.getMedico().calcularDuracionDeUnTurno();
				LocalDateTime finExistente = inicioExistente.plusMinutes(duracionExistente);

				if (inicioNuevo.isBefore(finExistente) && finNuevo.isAfter(inicioExistente)) {
					throw new SolicitudDenegadaException("El turno se superpone con otro turno asignado a este médico");
				}
			}
		}
		return true;
	}

	public void atenderTurno(String identificador) throws SolicitudDenegadaException, DatoNoEncontradoException {

		Turno turnoBuscado = buscarTurno(identificador);
		if (turnoBuscado == null) {
			throw new DatoNoEncontradoException("El turno no fue encontrado");
		}
		if (validarFechaYHora(turnoBuscado) == true && turnoBuscado.getEstado().equals(Estado.PENDIENTE)) {
			turnoBuscado.setEstado(Estado.ATENDIDO);
		}

	}

	public void cancelarTurno(String identificador) throws SolicitudDenegadaException, DatoNoEncontradoException {
		Turno turnoBuscado = buscarTurno(identificador);
		if (turnoBuscado == null) {
			throw new DatoNoEncontradoException("El turno no fue encontrado");
		}
		if (validarFechaYHora(turnoBuscado) == true && turnoBuscado.getEstado().equals(Estado.PENDIENTE)) {
			turnoBuscado.setEstado(Estado.CANCELADO);
		}
		if (turnoBuscado.getEstado().equals(Estado.ATENDIDO)) {
			throw new SolicitudDenegadaException("El turno ya fue atendido, no se puede cancelar");
		}

	}

	public void reprogramarTurno(String identificador, LocalDateTime nuevaFecha)
			throws SolicitudDenegadaException, DatoNoEncontradoException {
		Turno turnoBuscado = buscarTurno(identificador);
		if (turnoBuscado == null) {
			throw new DatoNoEncontradoException("El turno no fue encontrado");
		}
		if (validarFechaYHora(turnoBuscado) == true && turnoBuscado.getEstado().equals(Estado.CANCELADO)) {
			turnoBuscado.setEstado(Estado.PENDIENTE);
		}

	}

	public double obtenerCostoDeLaConsultaDeUnTurno(String identificador) throws DatoNoEncontradoException {
		return buscarTurno(identificador).getMedico().calcularCostoDeLaConsulta();
	}

	public TreeSet<Turno> obtenerListaOrdenadaDeFormaAscendentePorFechaYHora() {

		TreeSet<Turno> turnosOrdenadosPorFechaHora = new TreeSet<>(new OrdenarFechaHoraAsc());

		turnosOrdenadosPorFechaHora.addAll(this.turnos.values());

		return turnosOrdenadosPorFechaHora;
	}

	public TreeSet<Turno> obtenerListaOrdenadaDeFormaDescendentePorFechaYHora() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Turno> obtenerTurnosPendientesFiltradoPorDniDePaciente(String dni) {
		List<Turno> lista = new ArrayList<>();

		for (Turno turnoActual : this.turnos.values()) {
			if (turnoActual.getPaciente().getDni().equals(dni) && turnoActual.getEstado().equals(Estado.PENDIENTE)) {
				lista.add(turnoActual);
			}
		}

		return lista;
	}

	public List<Medico> obtenerListaDeMedicosPorEspecialidad(Especialidad especialidadBuscada) {
		List<Medico> listaDeMedicosPorEspecialidad = new ArrayList<>();
		for (Medico medico : this.medicos) {
			if (medico.getEspecialidad().equals(especialidadBuscada)) {
				listaDeMedicosPorEspecialidad.add(medico);

			}
		}

		return listaDeMedicosPorEspecialidad;
	}

	public List<Paciente> obtenerListaDePacientosAtendidosFiltradoPorMedico(String matricula) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Paciente> obtenerListaDePacientesOrdenadosPorDniAscendente() {
		List<Paciente> lista = new ArrayList<>(this.pacientes);

		lista.sort(new OrdenarPorDniAsc());

		return lista;
	}

	public List<Paciente> obtenerListaDePacientesOrdenadosPorDniDescendente() {
		List<Paciente> lista = new ArrayList<>(this.pacientes);

		lista.sort(new OrdenarPorDniDesc());

		return lista;
	}

	public TreeSet<Paciente> obtenerListaDePacientesOrdenadosPorApellidoYNombreAscendente() {
		TreeSet<Paciente> lista = new TreeSet<Paciente>(new OrdenarPorApellidoYNombreAsc());

		lista.addAll(this.pacientes);

		return lista;
	}

	private boolean existePaciente(String dni) {
		for (Paciente paciente : this.pacientes) {
			if (paciente.getDni().equals(dni)) {
				return true;
			}
		}
		return false;
	}

	private boolean existeMedico(String matricula) {
		for (Medico medico : this.medicos) {
			if (medico.getMatricula().equals(matricula)) {
				return true;
			}
		}
		return false;
	}
}
