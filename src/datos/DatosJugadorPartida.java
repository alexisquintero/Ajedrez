package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.*;
import excepciones.ApplicationException;

public class DatosJugadorPartida {
	
	MySQL sql = MySQL.getInstance();	
	private Connection myConn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rsl = null;
	
	public Partida buscarJugadorPartida(int blancas, int negras) throws ApplicationException{
		Partida p = null;
		
		myConn = sql.Connect();
		String query = "SELECT * FROM JugadorPartida WHERE (dniBlancas = " + blancas + " and dniNegras = " + negras + ")";
			
		try {
			pstm = myConn.prepareStatement(query);
			stm = myConn.createStatement();
				 
			rsl = stm.executeQuery(query);
			while(rsl.next()){
				
				p.setIdPartida(rsl.getInt("idPartida"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Error al buscar JugadorPartida", e);
		}
		
		return p;
	
	}
	
}
