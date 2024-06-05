package tiendaIndianaJeans;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Producto> productos = new ArrayList<>();
		ArrayList<Producto> productosExportados = new ArrayList<>();
		
	
		boolean salir = false;

		do {
			switch (Menu.menuPrincipal()) {
			case 1: { 
				System.out.println("Productos disponibles para Exportar: ");
				if(!productos.isEmpty()) {
					ProductoServicio.listarProductos(productos);
				}else {
					System.out.println("(No existen datos).");
					System.out.println("");
				}
				System.out.println("");
				System.out.println("Productos Exportados");
				if(!productosExportados.isEmpty()) {
					
					ProductoServicio.listarProductos(productosExportados);
					
				}else {
					System.out.println("(No existen Datos)");
					System.out.println("");
				}
				
				break;
			}
			case 2:{
				productos.addAll(ProductoServicio.agregarProductos(Menu.agregarProducto()));
				break;
			}

			case 3: { // Exportar datos
				productosExportados = Menu.exportarDatos(productos);
				System.out.println("Flag6" + productosExportados.toString());
				break;
			}
			case 4: { // Salir del programa
				System.out.println("Saliendo del programa...");			
				salir = true;

				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + Menu.menuPrincipal());
			}
			
			
			
		}while (!salir); 
		
		
	}

}
