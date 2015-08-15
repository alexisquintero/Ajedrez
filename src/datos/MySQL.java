package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class MySQL {
	

	
	
	private static MySQL instance = null;

	public static MySQL getInstance() {
		if(instance == null) {
			
			instance = new MySQL();
			
			}
		
		return instance;
		
	}
	 
	 public Connection Connect() throws SQLException{   
		 
		 Connection conn = null;
			 
			 String url = "jdbc:mysql://201.212.117.27:3306/Ajedrez";		
			 String user = "Java";
			 String password = "Java";
//TODO: Usar la url, user y password desde un .ini
		 
			 conn = DriverManager.getConnection(url, user, password);
			 
		 return conn;
	 }

	 
	 protected void Close(ResultSet resultSet, Statement statement, Connection connect){
		    try {
		      if (resultSet != null) {
		        resultSet.close();
		      }

		      if (statement != null) {
		        statement.close();
		      }

		      if (connect != null) {
		        connect.close();
		      }
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		  }
	 
}

/*
 
	Base de datos			->	Ajedrez
	Usuario					->	Ajedrez
	Password				->	Java
	IP						->	201.212.117.27
		Jugador
			idJugador		->	int						->clave primaria
			nick			->	char(20)				
			pass			->	char(20)
			ganadas			->	int
			perdidas		->	int
			abandonadas(?)	->	int
		Partida
			idPartida		->	int(Autoincremental)	->Clave primaria
			movimientos		->	varchar
		Jugador-Partida
			idJuego			->	int	
			idBlancas		->	int
			IdNegras		->	int
					
*/