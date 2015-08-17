package entidades;

public class Pieza {

/*
          __    __    __    __
       8 /__////__////__////__////
	  7 ////__////__////__////__/
	 6 /__////__////__////__////
    5 ////__////__////__////__/
   4 /__////__////__////__////
  3 ////__////__////__////__/
 2 /__////__////__////__////
1 ////__////__////__////__/
   a  b  c  d  e  f  g  h
*/
	/**[fila columna] Ej: 8a, 5d
	 * 
	 */
/*	
	protected char[] posicion;	
	public char[] getPosicion() {
		return posicion;
	}

	public void setPosicion(char[] posicion) {
		this.posicion = posicion;
	}
*/	
	// True == blancas; False == negras
	protected boolean lado;
	public boolean getLado() {
		return lado;
	}

	public void setLado(boolean lado) {
		this.lado = lado;
	}
	
	protected int x, y;
	
	protected boolean sinMover = true; //Me interesa en peon para en passant, y en torre y rey para enroque
	
	public void mover(){
		sinMover = false;
	}
	
	protected char simbolo;  //Simbolo unicode de la pieza
	
	public char getSimbolo() {
		return simbolo;
	}

	public void setSimbolo(char simbolo) {
		this.simbolo = simbolo;
	}

	/**Inicializa la pieza 
	 * 
	 * @param L Lado para el que juega
	 */
	public Pieza(boolean L){
		lado = L;
	}

	/**Devuelve un Array 8x8 con 1 en las posiciones permitidas para esa pieza, ignorando las demas piezas
	 * 
	 */
	public int[][] movimientosPermitidos(int columna, int fila, char comer){  //Comer sirve para los peones solamente
		
		int[][] arregloPermitidos = new int[8][8];
			for(int m = 0; m < 8; m++){
				for(int n = 0; n < 8; n++){
					arregloPermitidos[m][n] = 0;
				}
			}
		
		return arregloPermitidos;
	}
	
	

	/**
	 * 
	 */
	
	public void mueve(){
		
	}
	
	/**
	 * 
	 */
	public void comer(){
		
	}
	
	
	/**
	 * 
	 */
	public void comida(){
		
	}
	
	

}
