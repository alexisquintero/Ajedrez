package negocio;

import java.util.ArrayList;

import datos.*;
import entidades.*;
import excepciones.ApplicationException;

public class ControladorAjedrez {
	
	public ControladorAjedrez(){		
		datosPartida = new DatosPartida();
		datosJugador = new DatosJugador();
		datosJugadorPartida = new DatosJugadorPartida();
	}

	private Partida partida;
	private DatosPartida datosPartida;
	private DatosJugador datosJugador;
	private DatosJugadorPartida datosJugadorPartida;
	
	public char[] movimiento(StringBuilder desde, StringBuilder hasta){
		return partida.movimiento(desde, hasta);
	}
	
	public void actualizarTablero(int estado){
		
	}
	/**Devuelve un array con los caracteres unicode en las posiciones de las piezas
	 * 
	 */
	public char[][] inicializarTablero(){
		return partida.Posiciones();
	}

	public int[][] getMovimientosPosibles(StringBuilder desde, boolean lado) {
		return partida.movimientosPosibles(desde, lado);
		
	}

	public ArrayList<Jugador> buscar(int Blancas, int Negras) throws ApplicationException{
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		jugadores.add(datosJugador.buscaJugador(Blancas));
		jugadores.add(datosJugador.buscaJugador(Negras));
		return jugadores;
	}

	public char promocion(String string) {
		return partida.promocion(string);
		
	}

	public void crearJugador(Jugador j) throws ApplicationException {
		datosJugador.creaJugador(j);
		
	}

	public void inicializaJugadores(ArrayList<Jugador> jugadores) {
//		jugador1 = jugadores.get(0);
//		jugador2 = jugadores.get(1);	
//		partida.setBlancas(jugadores.get(0));
//		partida.setNegras(jugadores.get(1));
		partida = new Partida(jugadores.get(0),jugadores.get(1));
	}

	public int inicializaPartida() throws ApplicationException {
		Serializador serializador = new Serializador();
		datosPartida.nuevaPartida(partida, serializador.serializar(partida.getTablero().getPiezas()));
		return partida.getIdPartida();
		
	}

	public Partida buscaJugadorPartida(ArrayList<Jugador> jugadores) throws ApplicationException {
		return datosJugadorPartida.buscarJugadorPartida(jugadores.get(0).getDni(), jugadores.get(1).getDni());
		
	}

	public ArrayList<Pieza> getComidasBlancas() {
		return partida.getComidasBlancas();	
	}

	public ArrayList<Pieza> getComidasNegras() {
		return partida.getComidasNegras();
	}

}
