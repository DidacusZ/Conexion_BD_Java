package controladores;

import java.sql.Connection;
import java.util.ArrayList;

import dtos.LibroDto;
import servicios.ConexionImplementacion;
import servicios.ConexionInterfaz;
import servicios.ConsultasImplementacion;
import servicios.ConsultasInterfaz;

public class Inicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConexionInterfaz conexionImpl= new ConexionImplementacion();
		ConsultasInterfaz consultas = new ConsultasImplementacion();
		ArrayList<LibroDto>listaLibros =new ArrayList<>();

		try {
			Connection conexion = conexionImpl.crearConexion();
			
			if(conexion != null) {
				listaLibros = consultas.seleccionaTodosLibros(conexion);
				
				
				for(int i=0;i<listaLibros.size();i++) {
					System.out.println(listaLibros.get(i).toString());
				}
			}
			
		} catch (Exception e) {
			System.out.println("[ERROR-Main] Se ha producido un error al ejecutar la aplicación: " + e);
		}
		
	}

}