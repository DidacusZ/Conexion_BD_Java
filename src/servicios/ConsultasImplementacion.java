package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dtos.LibroDto;
import util.ADto;

/**
 * Implementacion de la interfaz de consultas
 * 021023 dpm
 */
public class ConsultasImplementacion implements ConsultasInterfaz {

	@Override
	public ArrayList<LibroDto> seleccionaTodosLibros(Connection conexion) {
		// TODO Auto-generated method stub

		// Declaración SQL estática que devuelve los resultados que produce
		Statement declaracionSQL = null;// Solo se puede abrir un objeto ResultSet por cada objeto Statement
		// El resultado de la consulta a la BD
		ResultSet resultadoConsulta = null;
		ArrayList<LibroDto> listaLibros = new ArrayList<>();
		ADto aDto = new ADto();
		

		try {
			// Se abre una declaración
			declaracionSQL = conexion.createStatement();//Crea un objeto Statement para enviar declaraciones SQL a la base de datos
	 
			//Se define la consulta de la declaración y se ejecuta la query
			resultadoConsulta = declaracionSQL.executeQuery("SELECT * FROM \"gbp_almacen\".\"gbp_alm_cat_libros\"");
			
			listaLibros = aDto.ResultSetALibroDto(resultadoConsulta);
			
			
			//siempre cerrar la conexion y demas para no sobrecargar el server
			conexion.close();
			declaracionSQL.close();
			resultadoConsulta.close();
			System.out.println("[INFO] Conexion, declaracion, resultado cerrados [ConsultasImplementacion-seleccionaTodosLibros]");
			

		} catch (SQLException e) {
			System.out.println("[ERROR] No se puede lanzar la Query [ConsultasImplementacion-seleccionaTodosLibros]");
		}

		return listaLibros;
		
	}

}
