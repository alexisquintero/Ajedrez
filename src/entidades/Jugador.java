package entidades;

import java.sql.Time;

public class Jugador {
	
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private String nick;
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private int ganadas;
	public int getGanadas() {
		return ganadas;
	}
	public void setGanadas(int ganadas) {
		this.ganadas = ganadas;
	}
	
	private int perdidas;
	public int getPerdidas() {
		return perdidas;
	}
	public void setPerdidas(int perdidas) {
		this.perdidas = perdidas;
	}
	
	private int abandonadas;
	public int getAbandonadas() {
		return abandonadas;
	}
	public void setAbandonadas(int abandonadas) {
		this.abandonadas = abandonadas;
	}
	
	private Time tiempoTotal;
	public Time getTiempoTotal() {
		return tiempoTotal;
	}
	public void setTiempoTotal(Time tiempoTotal) {
		this.tiempoTotal = tiempoTotal;
	}

}
