package tiendaIndianaJeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	
	public static int menuPrincipal() {
		Scanner scan = new Scanner(System.in);	
		
		String entradaStr;
		int entradaInt;

		
		System.out.println("1 Listar Producto");
		System.out.println("2 Agregar Producto");
		System.out.println("3 Exportar Datos");
		System.out.println("4 Salir");
		System.out.println("Ingrese una opcion:");
		
		entradaStr = scan.nextLine();
		
		entradaInt = validacionEntrada(entradaStr);
		
		return entradaInt;

	}
	
	public static int validacionEntrada(String entradaStr) {

		int entradaInt = 0;
		String formato = "\\d{1,9}";
		
		if (entradaStr.matches(formato)) {
			entradaInt = Integer.parseInt(entradaStr);
			if (entradaInt > 0 && entradaInt <= 5) {
				
				return entradaInt;
			}
		}else {
			return 0;
		}
		
		return 0;	
	}

	
	
	public static  Producto agregarProducto() {
		Scanner scan = new Scanner(System.in);
	
		System.out.println("Crear Producto");
		
		System.out.println("Ingresar nombre articulo:");
		String nombreArticulo = scan.nextLine();

		
		System.out.println("Ingresa precio:");
		String precio = scan.nextLine();	
	
		System.out.println("Ingresa descripción:");
		String descripcion = scan.nextLine();	

		System.out.println("Ingresa código:");
		String codigo = scan.nextLine();	
	
		System.out.println("Ingresa talla:");
		String talla = scan.nextLine();	

		System.out.println("Ingresa marca:");
		String marca = scan.nextLine();	

		
		System.out.println("Ingresa color:");
		String color = scan.nextLine();	

		
		Producto nuevoProducto = new Producto(nombreArticulo, precio, descripcion, codigo, talla, marca, color);
		
		return nuevoProducto;
		
	}
	
	
	
	public static ArrayList<Producto> exportarDatos(ArrayList<Producto> ListaSinExportar) {
		ExportadorTxt proceso = new ExportadorTxt("src", "ficheros");
		proceso.crearDir("ficheros");
		proceso.crearArchivo("RegistroProductos");
		
		return proceso.esribirArchivo(proceso.leerArchivo("RegistroProductos"), ListaSinExportar, "RegistroProductos");
		
	}
	
	
	
	
}
