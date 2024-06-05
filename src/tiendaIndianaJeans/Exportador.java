package tiendaIndianaJeans;

import java.util.ArrayList;

public abstract class Exportador {

	protected String ubicacionDir;
	protected String nombreDir;
	protected String nombreArchivo;
	
	
	public Exportador(String ubicacionDir, String nombreDir) {
		
	}
	
	public String getUbicacionDir() {
		return ubicacionDir;
	}

	public void setUbicacionDir(String ubicacionDir) {
		this.ubicacionDir = ubicacionDir;
	}

	public String getNombreDir() {
		return nombreDir;
	}

	public void setNombreDir(String nombreDir) {
		this.nombreDir = nombreDir;
	}
	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}


	public abstract void crearDir(String nombreDir);
	public abstract void crearArchivo(String nombreArchivo);	
	public abstract ArrayList<Producto> esribirArchivo(ArrayList<Producto> listaExistente, ArrayList<Producto> listaNoExportada ,String nombreArchivo);
	public abstract ArrayList<Producto>leerArchivo(String nombreArchivo);



	
	
}
