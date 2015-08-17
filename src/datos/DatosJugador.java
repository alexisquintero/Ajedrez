package datos;

import entidades.*;
import excepciones.ApplicationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatosJugador {
	
	MySQL sql = MySQL.getInstance();	
	private Connection myConn = null;
	private Statement stm = null;
	private PreparedStatement pstm = null;
	private ResultSet rsl = null;
	
	
	/**Crea un nuevo usuario, devuelve un String con los datos del proceso
	 * 
	 * @param u Objeto usuario con los datos a guardar
	 * @throws ApplicationException 
	 */
	public String creaUsuario(Jugador j) throws ApplicationException{
		
		String resp = "Usuario " + j.getNick() + " creado";
		try{
			Jugador busqueda = this.buscaJugador(j.getNick());
			
			if(busqueda.equals(null)){
				
				myConn = sql.Connect();
				String query = "INSERT INTO usuario(nick, password) VALUES (?,?)";
				pstm = myConn.prepareStatement(query);
				 
				pstm.setString(1, j.getNick());
				pstm.setString(2, j.getPassword());
			 
				pstm.executeUpdate();
				rsl = pstm.getGeneratedKeys();
				
			}else{
				resp = "Nick no disponible";
			}
						
		}
		catch(SQLException e){
			
			resp = e.getMessage();
			throw new ApplicationException("Error al actualizar datos de persona", e);
			
		}
		finally{			
			sql.Close(rsl, stm, myConn);			
		}	
							
		return resp;
	}
	
	
	/**Devuelve un objeto jugador en caso de existir un usuario con el nick usado, devuelve un objeto null en caso de no existir
	 * 
	 * @param nick
	 * @throws SQLException 
	 */
	public Jugador buscaJugador(String DNI) throws ApplicationException{
	
		Jugador ju = null;
		
		myConn = sql.Connect();
		String query = "SELECT * FROM usuario WHERE ( dni = " + DNI + " )";
			
		try {
			pstm = myConn.prepareStatement(query);
				 
			rsl = stm.executeQuery(query);
			while(rsl.next()){
				ju = new Jugador();
				
				ju.setNick(rsl.getString("nick"));
				ju.setGanadas(rsl.getInt("ganadas"));
				ju.setPerdidas(rsl.getInt("perdidas"));
				ju.setAbandonadas(rsl.getInt("abandonadas"));
				ju.setId(rsl.getInt("idJugador"));
			}
		} catch (SQLException e) {
			throw new ApplicationException("Error al actualizar datos de persona", e);
		}
		
		return ju;
	}

}
