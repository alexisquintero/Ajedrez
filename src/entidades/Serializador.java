package entidades;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import excepciones.ApplicationException;

public class Serializador {

	public ByteArrayOutputStream serializar(Pieza[][] piezas) throws ApplicationException {
		try{
			
			ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(byteArray);
			oos.writeObject(piezas);
			
			return byteArray;
		}catch(IOException e){
			throw new ApplicationException("Error al actualizar datos de persona", e);
		}
		
	}

}
