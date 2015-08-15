package entidades;

public class Tablero {
	
	private Pieza[][] piezas = new Pieza[7][7];
	
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
			
			int columna = lado ? 3 : 4;
			piezas[fila][columna] = new Reina(lado);
			
			columna = lado ? 4 : 3;
			piezas[fila][columna] = new Rey(lado);
			
			lado = false;
		}
	}
	
/*
		boolean lado = true;
		int fila = 1; // para blancas
		
		//2 lados
		for(int i=0; i < 2; i++){

				//8 peones
				for(int k=0; k < 8; k++){

					Peon peon = new Peon(lado, fila, k); //lado , fila 2, columna k
					piezasActivas.add(peon);
					
				}
				fila = lado ? fila - 1 : fila + 1;
				//Alfiles
						
					Alfil alfil1 = new Alfil(lado, fila , 2);
					piezasActivas.add(alfil1);
					Alfil alfil2 = new Alfil(lado, 0, 5);
					piezasActivas.add(alfil2);
				
				//Caballos
					
					Caballo caballo1 = new Caballo(lado, fila, 1);
					piezasActivas.add(caballo1);
					Caballo caballo2 = new Caballo(lado, fila, 6);
					piezasActivas.add(caballo2);
					
				//Torres
					
					Torre torre1 = new Torre(lado, fila, 0);
					piezasActivas.add(torre1);
					Torre torre2 = new Torre(lado, fila, 7);
					piezasActivas.add(torre2);
					
				//Rey
					
					int col = lado ? 4 : 3;
					Rey rey = new Rey(lado, fila, col);
					piezasActivas.add(rey);
					
				//Reina
					
					col = lado ? 3 : 4;
					Reina reina = new Reina(lado, fila, col);
					piezasActivas.add(reina);
							
			lado = False;
			fila = 6; //para negras
		}
	}
	
	private ArrayList<Pieza> piezasActivas;
	private ArrayList<Pieza> piezasComidas;
*/
		
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
	
	
	/**Comprueba si hay algún rey en jaque
	 * 
	 */
	public void jaque(){
		
	}
	
	/**Actualiza el tablero ante un nuevo movimiento
	 * 
	 * @param posVieja Posición vieja. "Fila Columna"
	 * @param PosNueva Posición nueva. "Fila Columna"
	 */
	public void Movimiento(String posVieja, String PosNueva){
		
		
	}

}
