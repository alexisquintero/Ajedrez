package datos;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.*;
import excepciones.ApplicationException;


public class DatosPartida {
	
	MySQL sql = MySQL.getInstance();	
	private Connection myConn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rsl = null;
	
	public void nuevaPartida(Partida p, ByteArrayOutputStream byteArrayOutputStream) throws ApplicationException{
		
		Jugador j1 = p.getBlancas();
		Jugador j2 = p.getNegras();
		
		try{								
			myConn = sql.Connect();	
			//Crea nueva partida
			String query = "INSERT INTO partida(tablero, lado) VALUES (?, ?)";
			pstm = myConn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
				 
			pstm.setBytes(1, byteArrayOutputStream.toByteArray());
			pstm.setBoolean(2, true);
			 
			pstm.executeUpdate();
			rsl = pstm.getGeneratedKeys();
			rsl.next();	
			
			p.setIdPartida(rsl.getInt(1));	//Actualiza p 
			
			//Crea asociación en la tabla jugador-partida
			String query2 = "INSERT INTO jugadorPartida(idPartida, dniBlancas, dniNegras) VALUES (?, ?, ?)";
			pstm = myConn.prepareStatement(query2);
				 
			pstm.setString(1, String.valueOf(rsl.getInt(1)));
			pstm.setInt(2, j1.getDni());
			pstm.setInt(3, j2.getDni());
			
			pstm.executeUpdate();
			
														
		}
		catch(SQLException e){
			e.printStackTrace();
			throw new ApplicationException("Error al crear la partida", e);
			
		}
		finally{			
			sql.Close(rsl, stm, myConn);			
		}							

	}
	
	public void actualizaPartida(Partida p) throws ApplicationException{
		
		try {
				Serializador serializador = new Serializador();
				
				myConn = sql.Connect();
				String query = "UPDATE partida SET tablero = ?, lado = ? WHERE ( idPartida = " + String.valueOf(p.getIdPartida()) + ")" ;
			
				pstm = myConn.prepareStatement(query);
				
				pstm.setBytes(1, serializador.serializar(p.getTablero().getPiezas()).toByteArray());
				pstm.setBoolean(2, p.isTurno());
			
				pstm.executeUpdate();                      
			
		} catch (SQLException e) {
			throw new ApplicationException("Error al actualizar la partida", e);
		} finally{
			sql.Close(rsl, stm, myConn);
		}
		
	}
/*	
	public void buscarPartida(int id){
		Partida p = null;
		
		myConn = sql.Connect();
		String query = "SELECT * FROM Partida WHERE ( idPartida = " + id + " )";
			
		try {
			pstm = myConn.prepareStatement(query);
			stm = myConn.createStatement();
				 
			rsl = stm.executeQuery(query);
			while(rsl.next()){
				
				
				
				p = new Partida();
				
				ju.setNombre(rsl.getString("nombre"));
				ju.setApellido(rsl.getString("apellido"));
				ju.setDni(rsl.getInt("dni"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ApplicationException("Error al buscar jugador", e);
		}
		
		return ju;
	}
*/	

}
