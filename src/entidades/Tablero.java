package entidades;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[8][8];
	
	public Tablero(){
		
		boolean lado = true;	//Empieza con blancas
		
		for (int j = 0; j < 2; j++) {
			
			int fila = lado ? 1 : 6;			//Creo los peones
			
			for (int i = 0; i < 8; i++) {
				piezas[fila][i] = new Peon(lado);
			}
			fila = lado ? 0 : 7;
			
			piezas[fila][0] = new Torre(lado);
			piezas[fila][7] = new Torre(lado);
			
			piezas[fila][1] = new Caballo(lado);
			piezas[fila][6] = new Caballo(lado);
			
			piezas[fila][2] = new Alfil(lado);
			piezas[fila][5] = new Alfil(lado);
			
			int columna = 3;
			piezas[fila][columna] = new Reina(lado);
			
			columna = 4;
			piezas[fila][columna] = new Rey(lado);
			
			lado = false;
		}
	}
		
	/**Devuelve un arreglo 8x8 con 0 en las posiciones libres, 1 en las posiciones ocupadas y 2 para peones en passant
	 * 
	 */
	public char[][] lugaresLibres(){		
		char[][] arregloLibres = new char[7][7];
		
		
		return arregloLibres;
	}
	
	/**Toma las posiciones permitidas y devuelve un Array 8x8 con 0 en las pocisiones inválidas, 
	 *  1 en las pocisiones válidas para esa pieza, y 2 en las pocisiones en las que come a otra
	 *  pieza 		
	 * @param arregloPermitidos arreglo 8x8
	 * @return arregloPosibles arreglo 8x8 con 0 en las posiciones no posibles, 1 en las pocisiones libres posibles y
	 *  2 en las pocisiones posibles para comer
	 */
	public char[][] movimientosPosibles(char[][] arregloPermitidos){
		
		char[][] arregloPosibles = null;
		
		
		return arregloPosibles;	
	}
	
	public int[][] movimientosPosibles(StringBuilder desde){
		int columnaDesde = Character.getNumericValue(desde.charAt(0))-10;
		int filaDesde = Character.getNumericValue(desde.charAt(1))-1;
		return piezas[filaDesde][columnaDesde].movimientosPermitidos(columnaDesde, filaDesde);
	}
	
	
	/**Comprueba si hay algún rey en jaque
	 * 
	 */
	public void jaque(){
		
	}
	
	public char[][] Posiciones(){
		char[][] posicion = new char[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				posicion[i][j] = piezas[i][j] == null? '\u0000' : piezas[i][j].getSimbolo(); //\u200A
			}
			
		}
		
		return posicion;
	}
	
	
	public char movimiento(StringBuilder desde, StringBuilder hasta){
		
//		System.out.println(desde + " " + hasta);
		int columnaDesde = Character.getNumericValue(desde.charAt(0))-10;
		int filaDesde = Character.getNumericValue(desde.charAt(1))-1;
		int columnaHasta = Character.getNumericValue(hasta.charAt(0))-10;
		int filaHasta = Character.getNumericValue(hasta.charAt(1))-1;
//		System.out.println(filaDesde + " " + columnaDesde + " " + filaHasta + " " + columnaHasta);
		
		piezas[filaHasta][columnaHasta] = piezas[filaDesde][columnaDesde];  //mueve la pieza desde a hasta
		piezas[filaDesde][columnaDesde] = null;		 //pone null en desde
		
		return piezas[filaHasta][columnaHasta].getSimbolo();
	}

}
