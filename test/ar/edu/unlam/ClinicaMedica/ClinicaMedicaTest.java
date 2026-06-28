package ar.edu.unlam.ClinicaMedica;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import org.junit.Test;

public class ClinicaMedicaTest {

		//1
		@Test
	    public void dadoUnPacienteValidoCuandoSeRegistreEnElSistemaObtengoResultadoExitoso() throws RegistroDobleException, DatoNoEncontradoException {
			Clinica sistemaClinica = new Clinica();	
			Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
			Paciente pacienteBuscado = sistemaClinica.buscarPaciente("12345678");
			assertEquals(pacienteBuscado, paciente);
		}

		//2
	    @Test(expected = RegistroDobleException.class)
	    public void dadoUnPacienteQueExisteCuandoSeIntenteRegistrarDeNuevoLanzeExcepcion() throws RegistroDobleException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
			Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			Paciente paciente2 = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
			sistemaClinica.registrarPaciente(paciente2);
	    }

	    //3
	    @Test(expected = DatoNoEncontradoException.class)
	    public void dadoUnPacienteNoRegistradoCuandoSeBuscaPorDniEntoncesLanzaExcepcion() throws DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();
	    	sistemaClinica.buscarPaciente("dniPaciente");
	    }

	    //4
	    @Test
	    public void dadoUnMedicoValidoCuandoSeRegistraObtengoResultadoExitoso() throws RegistroDobleException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
			Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
			sistemaClinica.registrarMedico(kinesiologo);
			Medico medicoBuscado = sistemaClinica.buscarMedico("1234567");
			assertEquals(medicoBuscado, kinesiologo);
	    }

	    //5
	    @Test(expected = RegistroDobleException.class)
	    public void dadoUnMedicoQueExisteCuandoSeIntenteRegistrarDeNuevoLanzeExcepcion() throws RegistroDobleException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
			Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
			Medico kinesiologo2 = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
			sistemaClinica.registrarMedico(kinesiologo);
			sistemaClinica.registrarMedico(kinesiologo2);
	    }

	    //6
	    @Test(expected = DatoNoEncontradoException.class)
	    public void dadoUnMedicoNoRegistradoCuandoSeBuscaPorMatriculaEntoncesLanzaExcepcion() throws DatoNoEncontradoException {
	    }

	    //7
	    @Test
	    public void dadoUnTurnoPendienteCuandoSeCanceleCambiaDeEstadoACancelado() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }

	    //8
	    @Test(expected = SolicitudDenegadaException.class)
	    public void dadoUnTurnoAtendidoCuandoSeIntentaCancelarLanzaExcepcion() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }

	    //9
	    @Test
	    public void dadoUnHorarioDisponibleCuandoSeSolicitaUnTurnoEntoncesSeAsignaCorrectamente() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }

	    //10
	    @Test
	    public void dadoQueExisteUnaClinicaConUnaListaDeTurnosOrdenarPorFechaYHoraDeFormaDescendente() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }

	    //11
	    @Test
	    public void dadoQueExisteUnaClinicaConUnaListaDeTurnosOrdenarPorFechaYHoraDeFormaAscendente() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
	    
	    	Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);

	    	Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo);
	    	Turno turno = new Turno("a12", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 22, 12, 0));
	    	Turno turno2 = new Turno("a13", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 23, 12, 0));
	    	Turno turno3 = new Turno("a15", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 23, 22, 0));

	    	sistemaClinica.agendarTurno(turno);
	    	sistemaClinica.agendarTurno(turno2);
	    	sistemaClinica.agendarTurno(turno3);
	    	TreeSet<Turno> turnos = sistemaClinica.obtenerListaOrdenadaDeFormaAscendentePorFechaYHora();
	    	
	    	assertEquals(turno.getFechaYHora(), turnos.first().getFechaYHora()); // primero turno 1
	    	assertEquals(turno3.getFechaYHora(), turnos.last().getFechaYHora()); // ultimo turno 3 

	    	
	    }

	    //12
	    @Test
	    public void dadoQueExisteUnaClinicaConMedicosYPacientesObtengoUnReporteDeTodosLosPacientesQueAtendioUnMedico() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
	    	Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
	    	Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo);
	    	Paciente paciente2 = new Paciente("12345671", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente2);
	    	Medico kinesiologo2 = new Kinesiologo("1234562", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo2);
	    	Turno turno = new Turno("a12", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 22, 12, 0));
	    	Turno turno2 = new Turno("a13", paciente2, kinesiologo2, LocalDateTime.of(2012, Month.JULY, 23, 12, 0));
	    	Turno turno3 = new Turno("a15", paciente2, kinesiologo, LocalDateTime.of(2012, Month.JULY, 23, 22, 0));

	    	sistemaClinica.agendarTurno(turno);
	    	sistemaClinica.agendarTurno(turno2);
	    	sistemaClinica.agendarTurno(turno3);
	    
	    	HashMap<Medico, List<Paciente>> reporte = sistemaClinica.reporteMedicoConPacientes();

	    	assertEquals(1, reporte.get(kinesiologo2).size()); // pacientes esperados
	    	assertEquals(2, reporte.get(kinesiologo).size());

	    	
	    	
	    }
	    
	    //13
	    @Test(expected = DatoNoEncontradoException.class)
	    public void dadoQueExisteUnaClinicaConTurnosCuandoPreguntoPorUnTurnoNoRegistradoLanzaException() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();
	    	Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
	    	Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo);
	    	Paciente paciente2 = new Paciente("12345671", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente2);
	    	Medico kinesiologo2 = new Kinesiologo("1234562", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo2);

	    	Turno turno = new Turno("a12", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 22, 12, 0));
	    	Turno turno2 = new Turno("a13", paciente2, kinesiologo2, LocalDateTime.of(2012, Month.JULY, 23, 12, 0));
	    	Turno turno3 = new Turno("a15", paciente2, kinesiologo, LocalDateTime.of(2012, Month.JULY, 23, 22, 0));

	    	sistemaClinica.agendarTurno(turno);
	    	sistemaClinica.agendarTurno(turno2);
	    	sistemaClinica.agendarTurno(turno3);
	    
	    	sistemaClinica.atenderTurno("a23"); // Turno no existente 
	    	sistemaClinica.atenderTurno("a12");
	    	sistemaClinica.atenderTurno("a13");

	    	
	    }

	    //14
	    @Test(expected = SolicitudDenegadaException.class)
	    public void dadoQueExisteUnaClinicaConUnTurnoProgramadoCuandoSeQuiereReprogramarEnUnaFechaNoDisponibleLanzaException() throws SolicitudDenegadaException, DatoNoEncontradoException, RegistroDobleException {
	    	Clinica sistemaClinica = new Clinica();
	    	Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
	    	Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo);
	    	Paciente paciente2 = new Paciente("12345671", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente2);
			
	    	Turno turno = new Turno("a12", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 22, 12, 0));
	    	Turno turno3 = new Turno("a15", paciente2, kinesiologo, LocalDateTime.of(2012, Month.JULY, 23, 12, 20));

	    	sistemaClinica.agendarTurno(turno);
	    	sistemaClinica.agendarTurno(turno3);

	    	sistemaClinica.cancelarTurno(turno.getIdentificador());
	    	sistemaClinica.reprogramarTurno(turno.getIdentificador(), turno3.getFechaYHora()); // reprograma para la fecha de otro turno con el mismo medico a la misma hora
	    	
	    }

	    //15
	    @Test
	    public void dadoQueExisteUnaClinicaRegistrarTresMedicosYObtenerListaDeMedicosFiltradoPorEspecialidad() throws RegistroDobleException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();	
	    	Medico medico = new Kinesiologo("4324354", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(medico);
	    	Medico medico2 = new Pediatria("2213232", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(medico2);
	    	Medico medico3 = new Kinesiologo("32313233", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(medico3);
	    	
	    	sistemaClinica.obtenerListaDeMedicosPorEspecialidad(Especialidad.KINESIOLOGO);
	    	assertEquals(2, sistemaClinica.obtenerListaDeMedicosPorEspecialidad(Especialidad.KINESIOLOGO).size());
	    }

	    //16
	    @Test
	    public void dadoUnTurnoPendienteCuandoSeMarcaComoAtendidoEntoncesCambiaDeEstadoAAtendido() throws RegistroDobleException, DatoNoEncontradoException, SolicitudDenegadaException {
	    }
	    
	    //17
	    @Test(expected = SolicitudDenegadaException.class)
	    public void dadoUnTurnoCanceladoCuandoSeIntentaMarcarComoAtendidoEntoncesLanzaExcepcion() throws SolicitudDenegadaException, RegistroDobleException, DatoNoEncontradoException {
	    	Clinica sistemaClinica = new Clinica();
	    	Paciente paciente = new Paciente("12345678", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente);
	    	Medico kinesiologo = new Kinesiologo("1234567", "nombre", "apellido", "telefono", "email");
	    	sistemaClinica.registrarMedico(kinesiologo);
	    	Paciente paciente2 = new Paciente("12345671", "nombre", "apellido", LocalDate.of(2000, 1, 1), "11 3243 4345", 777, "Obra Social", "correo@gmail.com");
			sistemaClinica.registrarPaciente(paciente2);
			
	    	Turno turno = new Turno("a12", paciente, kinesiologo, LocalDateTime.of(2012, Month.JULY, 22, 12, 0));
	    	sistemaClinica.agendarTurno(turno);
	    	
	    	sistemaClinica.atenderTurno(turno.getIdentificador());
	    	sistemaClinica.cancelarTurno(turno.getIdentificador());
	    
	    }

	    //18
	    @Test
	    public void dadoQueExisteUnaClinicaConTurnosCuandoObtengoLosTurnosDeUnPacienteEntoncesSeDevuelvenSoloSusTurnos() throws RegistroDobleException, DatoNoEncontradoException, SolicitudDenegadaException {
	    }

	    //19
	    @Test
	    public void dadoUnaClinicaAgendoUnTurnoConMedicoPediatraObtenerElCostoDeLaConsultaQueEsDe50000Pesos() throws RegistroDobleException, DatoNoEncontradoException, SolicitudDenegadaException {
	    }

	    //20
	    @Test
	    public void dadoQueExistenPacientesSeObtienenOrdenadosPorDniAscendente() throws RegistroDobleException, DatoNoEncontradoException {
	    }

	    //21
	    @Test
	    public void dadoQueExistenPacientesSeObtienenOrdenadosPorDniDescendente() throws RegistroDobleException, DatoNoEncontradoException {
	    }
	    
	    //22
	    @Test
	    public void dadoUnaClinicaCon3PacientesObtenerUnListadoDeClientesOrdenadosPorApellidoYNombre() throws RegistroDobleException, DatoNoEncontradoException {
	    }

	
	
	
	
	
	
	
	
}
