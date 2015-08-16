package entidades;

public class Partida {
	
	private Tablero tablero = new Tablero();
	
	private Jugador blancas;
	public Jugador getBlancas() {
		return blancas;
	}
	public void setBlancas(Jugador blancas) {
		this.blancas = blancas;
	}
	
	private Tablero tab;
	public Tablero getTab() {
		return tab;
	}
	public void setTab(Tablero tab) {
		this.tab = tab;
	}
	
	private Jugador negras;
	public Jugador getNegras() {
		return negras;
	}
	public void setNegras(Jugador negras) {
		this.negras = negras;
	}
	
	private int idPartida;
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	private StringBuffer movimientos;
	public StringBuffer getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(StringBuffer movimientos) {
		this.movimientos = movimientos;
	}
	public char[][] Posiciones() {		
		return tablero.Posiciones();
	}
	public char movimiento(StringBuilder desde, StringBuilder hasta) {
		return tablero.movimiento(desde, hasta);
	}
	public int[][] movimientosPosibles(StringBuilder desde) {
		return tablero.movimientosPosibles(desde);
	}
	
}
