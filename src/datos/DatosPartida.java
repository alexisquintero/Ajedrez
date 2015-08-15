package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.*;


public class DatosPartida {
	
	MySQL sql = MySQL.getInstance();	
	private Connection myConn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rsl = null;
	
	/**Crea una nueva partida
	 * 
	 * @param p
	 * @return Devuelve un String con los datos del proceso
	 */
	public String nuevaPartida(Partida p){
		
		Jugador j1 = p.getBlancas();
		Jugador j2 = p.getNegras();
		String resp = "";
		String movimientos = "";
	
		try{								
			myConn = sql.Connect();	
			//Crea nueva partida
			String query = "INSERT INTO partida(movimientos) VALUES (?)";
			pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				 
			pstm.setString(1, movimientos);
			 
			pstm.executeUpdate();
			rsl = pstm.getGeneratedKeys();
			rsl.next();
			
			//Actualiza p y crea la respuesta
			p.setIdPartida(rsl.getInt(1));	
			resp = "Juego número " + String.valueOf(rsl.getInt(1)) + " creado"; 
			
			//Crea asociación en la tabla jugador-partida
			String query2 = "INSERT INTO jugador-partida(idJuego, idBlancas, idNegras) VALUES (?, ?, ?)";
			pstm = myConn.prepareStatement(query2);
				 
			pstm.setString(1, String.valueOf(rsl.getInt(1)));
			pstm.setInt(2, j1.getId());
			pstm.setInt(3, j2.getId());
			
			pstm.executeUpdate();
														
		}
		catch(SQLException e){
			
			resp = e.getMessage();
			
		}
		finally{			
			sql.Close(rsl, stm, myConn);			
		}							
	
		return resp;

	}
	
	public String actualizaPartida(Partida p){
		String resp = "Partida actualizada";
		
		try {
				myConn = sql.Connect();
				String query = "UPDATE partida SET movimientos = ? WHERE ( idPartida = " + String.valueOf(p.getIdPartida()) + ")" ;
			
				pstm = myConn.prepareStatement(query);
				
				pstm.setString(1, p.getMovimientos().toString());
			
				pstm.executeUpdate();                      
			
		} catch (SQLException e) {
			resp = e.getMessage();
		} finally{
			sql.Close(rsl, stm, myConn);
		}
		
		return resp;
	}

}
