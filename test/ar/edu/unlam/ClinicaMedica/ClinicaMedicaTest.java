package ar.edu.unlam.ClinicaMedica;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

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
	    }

	    //12
	    @Test
	    public void dadoQueExisteUnaClinicaConMedicosYPacientesObtengoUnReporteDeTodosLosPacientesQueAtendioUnMedico() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }
	    
	    //13
	    @Test(expected = DatoNoEncontradoException.class)
	    public void dadoQueExisteUnaClinicaConTurnosCuandoPreguntoPorUnTurnoNoRegistradoLanzaException() throws RegistroDobleException, SolicitudDenegadaException, DatoNoEncontradoException {
	    }

	    //14
	    @Test(expected = SolicitudDenegadaException.class)
	    public void dadoQueExisteUnaClinicaConUnTurnoProgramadoCuandoSeQuiereReprogramarEnUnaFechaNoDisponibleLanzaException() throws SolicitudDenegadaException, DatoNoEncontradoException, RegistroDobleException {
	    }

	    //15
	    @Test
	    public void dadoQueExisteUnaClinicaRegistrarTresMedicosYObtenerListaDeMedicosFiltradoPorEspecialidad() throws RegistroDobleException, DatoNoEncontradoException {
	    }

	    //16
	    @Test
	    public void dadoUnTurnoPendienteCuandoSeMarcaComoAtendidoEntoncesCambiaDeEstadoAAtendido() throws RegistroDobleException, DatoNoEncontradoException, SolicitudDenegadaException {
	    }
	    
	    //17
	    @Test(expected = SolicitudDenegadaException.class)
	    public void dadoUnTurnoCanceladoCuandoSeIntentaMarcarComoAtendidoEntoncesLanzaExcepcion() throws SolicitudDenegadaException, RegistroDobleException, DatoNoEncontradoException {
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
