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
		
	/**Devuelve un arreglo 8x8 con 2 en las posiciones libres, 4 en las posiciones ocupadas por piezas de distinto color , 6 para peones en passant y
	 * 	-2 en las posciones ocupadas por piezas del mismo color
	 */
	public int[][] lugaresLibres(boolean Lado){		
		int[][] arregloLibres = new int[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if(piezas[i][j] == null){ //Vacio
					arregloLibres[i][j] = 2;
				}else{
					if(piezas[i][j].getLado() == Lado){ //Propias
						arregloLibres[i][j] = -2;
					}else{	//Enemigas
						arregloLibres[i][j] = 4;
					}
				}
			}
			
		}
		
		return arregloLibres;
	}
	
	/**Toma las posiciones permitidas y devuelve un Array 8x8 con 0 en las pocisiones inválidas, 
	 *  1 en las pocisiones válidas para esa pieza
	 * @param arregloPermitidos arreglo 8x8
	 * @return arregloPosibles arreglo 8x8 con 0 en las posiciones no posibles, 1 en las pocisiones libres posibles 
	 */
	public int[][] movimientosLegales(int[][] arregloPermitidos, boolean Lado, StringBuilder desde){
		
		int[][] arregloPosibles = new int[8][8];
		
		for(int m = 0; m < 8; m++){
			for(int n = 0; n < 8; n++){
				arregloPosibles[m][n] = 0;
			}
		} 
		
		int[][] arregloLibres = lugaresLibres(Lado);
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				arregloPosibles[i][j] = arregloPermitidos[i][j] + arregloLibres[i][j];
			}
			
		}								
		return controlarMovimientos(arregloPosibles, desde);
	}
	
	public int[][] movimientosPosibles(StringBuilder desde){
		char comer = 'N';	//N: no come|A:come 2 lados|D: come derecha|I:come izquierda
		int columnaDesde = Character.getNumericValue(desde.charAt(0))-10;
		int filaDesde = Character.getNumericValue(desde.charAt(1))-1;
		if ((columnaDesde+1 < 8) && (columnaDesde-1 > -1) && (filaDesde+1 < 8) && (filaDesde+1 > -1)) {
			if ((piezas[filaDesde][columnaDesde].getSimbolo() == '\u2659')
					|| (piezas[filaDesde][columnaDesde].getSimbolo() == '\u265F')) {
				//Si es peon y puede comer también se puede mover diagonalmente
				boolean derecha, izquierda = false;
				if (piezas[filaDesde][columnaDesde].getLado()) {
					derecha = (piezas[filaDesde + 1][columnaDesde + 1] == null) ? false : true;
					izquierda = (piezas[filaDesde + 1][columnaDesde - 1] == null) ? false : true;
				} else {
					derecha = (piezas[filaDesde - 1][columnaDesde + 1] == null) ? false : true;
					izquierda = (piezas[filaDesde - 1][columnaDesde - 1] == null) ? false : true;
				}

				if (derecha && izquierda) {
					comer = 'A';
				} else {
					if (derecha) {
						comer = 'D';
					} else {
						if (izquierda) {
							comer = 'I';
						}
					}
				}
			}
		}
		return piezas[filaDesde][columnaDesde].movimientosPermitidos(columnaDesde, filaDesde, comer); //TODO: agregar parámetro indiando si es caballo
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
		piezas[filaHasta][columnaHasta].mover();
		
		return piezas[filaHasta][columnaHasta].getSimbolo();
	}
	
	private int[][] controlarMovimientos(int[][] arregloPosibles, StringBuilder desde){ //Controla el movimiento en las 8 direcciones para que no atraviese otra pieza
		
		int dx = 0, dy = 0;
		boolean flagPiezaEnemiga = false, flagVacio = true, flagPiezaPropia = false;
		int[][] posiblesControlado = new int[8][8];
		posiblesControlado = arregloPosibles;
		int columnaDesde = Character.getNumericValue(desde.charAt(0))-10;
		int filaDesde = Character.getNumericValue(desde.charAt(1))-1;
		
		for (int i = 0; i < 8; i++) {
			
			for (int j = 0; j < 8; j++) {
				
				switch(posiblesControlado[filaDesde + dx][columnaDesde + dy]){
				case -2:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 0; flagVacio = false; break;							//mismo color & no posible 	->NO
				case -1:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 0; flagVacio = false; flagPiezaPropia = true; break;	//mismo color & posible		->NO
				case  2:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 0;	break;												//libre & no posible		->NO
				case  3:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 1;	break;												//libre & posible			->SI, solo si hay "3" al origen
				case  4:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 0; flagVacio = false; flagPiezaEnemiga = true; break;	//enemiga & no posible		->NO
				case  5:posiblesControlado[filaDesde + dx][columnaDesde + dy] = 1; flagVacio = false; break;							//enemiga & posible			->SI, solo si hay "3" al origen
				}
				
				if((!flagVacio && flagPiezaEnemiga) || (flagPiezaPropia)){
					break;
				}
				
				switch(i){
				case 0 :dy+=1;break;			//N
				case 1 :dx+=1;dy+=1;break;		//NE
				case 2 :dx+=1;break;			//E
				case 3 :dx+=1;dy-=1;break;		//SE
				case 4 :dy-=1;break;			//S
				case 5 :dx-=1;dy-=1;break;		//SO
				case 6 :dx-=1;break;			//O
				case 7 :dx-=1;dy+=1;break;		//NO
				}	
				
				if((columnaDesde+dy >= 8) || (columnaDesde+dy <= -1) || (filaDesde+dx >= 8) || (filaDesde+dx <= -1)){
					j = 8;
				}
			}
			
			dx = dy = 0;
			flagPiezaEnemiga = flagPiezaPropia = false; flagVacio = true;
			
		}
			
		return posiblesControlado;
	}

	public boolean getLado(StringBuilder desde) {
		int columnaDesde = Character.getNumericValue(desde.charAt(0))-10;
		int filaDesde = Character.getNumericValue(desde.charAt(1))-1;
		return piezas[filaDesde][columnaDesde].getLado();
	}

}
