package entidades;

public class Peon extends Pieza {
	
//TODO:	private Bool sinMover = True;  
//TODO: crear getter y setter
	
	public Peon(boolean L) {
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
		
		int x = columna;
		int y = fila;
		
		if(lado){
			x += 1; y += 1;
		}
		else{
			x -= 1; y -= 1;
		}
		
		if((x > 0) && (x < 7) && (y > 0) && (y < 7)){
			arregloPermitidos[x][y] = 1;
		}
		
		if(sinMover){
			
			if(lado){
				x += 1; y += 1;
			}
			else{
				x -= 1; y -= 1;
			}
			
			if((x > 0) && (x < 7) && (y > 0) && (y < 7)){
				arregloPermitidos[x][y] = 1;
			}
			
		}

		
		return arregloPermitidos;
	}
	
	/**
	 * 
	 */
	public void promocion(){
		
	}
	
	/**
	 * 
	 */
	public void enPassant(){
		
	}

}
