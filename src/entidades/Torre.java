package entidades;

public class Torre extends Pieza {
	
	public Torre(boolean L) {
		super(L);
		// TODO Auto-generated constructor stub
	}

	/**Devuelve un Array 8x8 con 1 en las posiciones permitidas para esa pieza, ignorando las demas piezas
	 * 
	 */
	public char[][] movimientosPermitidos(int fila, int columna){
		
		//Inicializo el arreglo
		char[][] arregloPermitidos = new char[7][7];
		for(int m = 0; m < 8; m++){
			for(int n = 0; n < 8; n++){
				arregloPermitidos[m][n] = 0;
			}
		} 
		
		//Como máximo 4 posibilidades de movimiento
		for(int i=0; i < 4; i++){
			
			int x = columna;
			int y = fila;
			
			//Como máximo 7 movimientos contiguos (es una palabra contiguo? Creo que si)
			for(int j = 0; j < 8; j++){
				
				switch(i){
				case 0:
					x += 0; y += 1;
					break;
				case 1:
					x += 1; y -= 0;
					break;
				case 2:
					x -= 1; y += 0;
					break;
				case 3:
					x -= 0; y -= 1;
					break;
				}
				
				//Mientras no se salga de los límites del tablero
				while((x > 0) && (x < 7) && (y > 0) && (y < 7)){
					arregloPermitidos[x][y] = 1;
				}
			}
			
		}

		
		return arregloPermitidos;
	}

}
