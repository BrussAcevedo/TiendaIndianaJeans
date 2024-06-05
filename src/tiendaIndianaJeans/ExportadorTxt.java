package tiendaIndianaJeans;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportadorTxt extends Exportador {

	

	public ExportadorTxt(String ubicacionDir, String nombreDir) {
		super(ubicacionDir, nombreDir);
		this.ubicacionDir= ubicacionDir;
		this.nombreDir= nombreDir;
	}
	
	


	@Override
	public void crearDir(String nombreDir) {
		
		File dir = new File (this.ubicacionDir+"/"+this.nombreDir);
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println("Carpeta creada existosamente.");
		}else {
			System.out.println("Advertencia: La carpeta ya existe.");
		}
		
		
		
	}


	@Override
	public void crearArchivo(String nombreArchivo) {
		File dir = new File (this.ubicacionDir+"/"+this.nombreDir);
		File arch = new File (dir +"/"+ nombreArchivo+".txt");
		if (dir.exists()) {
			try {
				if(!arch.exists()) {
					arch.createNewFile();
					System.out.println("Archivo creado existosamente.");
				}else {
					System.out.println("Advertencia: el archivo ya existe.");
				}
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Error no se pudo crear el archivo: La carpeta no existe.");
		}
		
		
	}


	@Override
	public ArrayList<Producto> esribirArchivo(ArrayList<Producto> listaExistente, ArrayList<Producto> listaNoExportada , String nombreArchivo) {

		File dir = new File (this.ubicacionDir+"/"+this.nombreDir);
		File arch = new File (dir+"/"+nombreArchivo+".txt");
		ArrayList<Producto> listaTemp = new ArrayList<>();
		
		System.out.println(listaNoExportada.toString());
		listaExistente.addAll(listaNoExportada);
		
				
		
		try (FileWriter fw = new FileWriter(arch); BufferedWriter bw = new BufferedWriter(fw)){
		
			for (Producto producto: listaExistente) {
				bw.write(producto.toString());				
				bw.newLine();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		listaNoExportada.clear();
		return listaExistente;
		
	}


	@Override
	public ArrayList<Producto> leerArchivo(String nombreArchivo) {
		ArrayList <Producto> listaStrAProducto = new ArrayList<>();
		
		File dir = new File (this.ubicacionDir+"/"+this.nombreDir);
		File arch = new File (dir+"/"+nombreArchivo+".txt");
		
		
		try (FileReader fr = new FileReader(arch); BufferedReader br = new BufferedReader(fr)){
			String linea;
			while((linea = br.readLine()) != null) {
				
				Producto lineaProducto = stringAProducto(linea);
				listaStrAProducto.add (lineaProducto);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
		return listaStrAProducto;
	}
	
	
	protected static Producto stringAProducto(String linea) {

		String [] parte = linea.split(",");

		String articulo = parte[0];
		String precio = parte[1];
		String descripcion = parte[2];
		String codigo = parte[3];
		String talla = parte [4];
		String marca = parte [5];
		String color = parte [6];
		
		Producto productoEnArchivo = new Producto(articulo, precio, descripcion, codigo, talla, marca, color);
		return productoEnArchivo;
	}
	
	
}
