package presentacion;

import entidades.*;

public class Menu {
	
	public Menu(Jugador j){
		jugadorActual = j;
	}
	
	private Jugador jugadorActual;
	
	public Jugador getJugadorActual() {
		return jugadorActual;
	}
	public void setJugadorActual(Jugador jugadorActual) {
		this.jugadorActual = jugadorActual;
	}

	/**Muestra opciones para juego local u online
	 * 
	 */
	public void juegoNuevo(){
		
	}
	
	/**Inicia juego local
	 * 
	 */
	public void local(){
		
	}
	
	/**Inicia juego online
	 * 
	 */	
	public void online(){
		
	}
	
	/**Crea un nuevo usuario
	 * 
	 */
	public void creaUsuario(){
		
	}
	
	/**Busca un usuario ya creado
	 * 
	 */
	public void buscaUsuario(){
		
	}
	
	/**Muestra opciones para mostrar un juego ya jugado o ingresar movimientos
	 * 
	 */
	public void replay(){
		
	}
	
	/**Muestra replay desde base de datos
	 * 
	 */
	public void enBaseDeDatos(){
		
	}
	
	/**Crea un juego nuevo en la base de datos a partir de un string con los movimientos
	 * 
	 */
	public void cargarMovimientos(){
		
	}
	
	/**Termina el programa
	 * 
	 */
	public void salir(){
		
	}

}
