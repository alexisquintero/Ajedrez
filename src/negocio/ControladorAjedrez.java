package negocio;

import entidades.*;

public class ControladorAjedrez {
	

	private Partida partida = new Partida();
	
	public char movimiento(StringBuilder desde, StringBuilder hasta){
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

	public int[][] getMovimientosPosibles(StringBuilder desde) {
		return partida.movimientosPosibles(desde);
		
	}

}
