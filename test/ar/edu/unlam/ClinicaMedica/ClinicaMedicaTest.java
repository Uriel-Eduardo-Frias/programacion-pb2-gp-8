package ar.edu.unlam.ClinicaMedica;

import org.junit.Test;

public class ClinicaMedicaTest {

		//1
		@Test
	    public void dadoUnPacienteValidoCuandoSeRegistreEnElSistemaObtengoResultadoExitoso() throws RegistroDobleException, DatoNoEncontradoException {
	    }

		//2
	    @Test(expected = RegistroDobleException.class)
	    public void dadoUnPacienteQueExisteCuandoSeIntenteRegistrarDeNuevoLanzeExcepcion() throws RegistroDobleException, DatoNoEncontradoException {
	    }

	    //3
	    @Test(expected = DatoNoEncontradoException.class)
	    public void dadoUnPacienteNoRegistradoCuandoSeBuscaPorDniEntoncesLanzaExcepcion() throws DatoNoEncontradoException {
	    }

	    //4
	    @Test
	    public void dadoUnMedicoValidoCuandoSeRegistraObtengoResultadoExitoso() throws RegistroDobleException, DatoNoEncontradoException {
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
