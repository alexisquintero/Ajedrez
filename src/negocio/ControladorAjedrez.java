package negocio;

import java.util.ArrayList;

import datos.*;
import entidades.*;
import excepciones.ApplicationException;

public class ControladorAjedrez {
	

	private Partida partida = new Partida();
	private DatosJugador datosJugador = new DatosJugador();
	private Jugador jugador1 = new Jugador();
	private Jugador jugador2 = new Jugador();
	
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

	public ArrayList<Jugador> buscar(String Blancas, String Negras) throws ApplicationException{
//		Jugador[] jugadores = new Jugador[2];
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
//		jugadores[0] = datosJugador.buscaJugador(Blancas);
		jugadores.add(datosJugador.buscaJugador(Blancas));
//		jugadores[1] = datosJugador.buscaJugador(Negras);
		jugadores.add(datosJugador.buscaJugador(Negras));
		return jugadores;
	}

	public char promocion(String string) {
		return partida.promocion(string);
		
	}

}
