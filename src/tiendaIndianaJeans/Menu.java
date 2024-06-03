package tiendaIndianaJeans;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
	
	
	public static int menuPrincipal() {
		Scanner scan = new Scanner(System.in);	
		ArrayList<Producto> productoNoListado = new ArrayList<>();
		
		String entradaStr;
		int entradaInt;

		
		System.out.println("1 Listar Producto");
		System.out.println("2 Agregar Producto");
		System.out.println("3 Mostrar Listas");
		System.out.println("4 Exportar Datos");
		System.out.println("5 Salir");
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
	
	public static void listarProducto(ArrayList<Producto>productosNoListados, ArrayList<Producto> categoria1, ArrayList<Producto> categoria2, ArrayList<Producto> categoria3) {

		Scanner scan = new Scanner(System.in);
		int i = 0;
		
		System.out.println("Productos no Listados:");
		
		System.out.println("");

		
		if(!productosNoListados.isEmpty()) {
			
			System.out.println("Selecciona el producto a Listar:");
			for(i = 0; i<productosNoListados.size(); i++) {
				System.out.println(i+"-"+ productosNoListados.get(i));
			}
			String respuesta = scan.nextLine();
			int respuestaInt = Integer.parseInt(respuesta);
			
			System.out.println("Selecciona la categoria del producto:");
			System.out.println("1-Categoria1");
			System.out.println("2-Categoria2");
			System.out.println("3-Categoria3");
			
			String respuesta2 = scan.nextLine();
			int respuesta2Int = Integer.parseInt(respuesta2);
			
			switch(respuesta2Int) {
			case 1: {
				categoria1.add(productosNoListados.get(respuestaInt));
				productosNoListados.remove(respuestaInt);

				break;
				
			}	case 2: {
				categoria2.add(productosNoListados.get(respuestaInt));
				productosNoListados.remove(respuestaInt);
				

				break;
				
			}
			case 3: {
				categoria3.add(productosNoListados.get(respuestaInt));
				productosNoListados.remove(respuestaInt);
				
				break;
			}
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + menuPrincipal());
			}
			
			
			
		}else {
			System.out.println("No hay productos sin listar.");
			
		}

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
	
	
	
	public static void exportarDatos() {
		
	}
	
	
	
}
