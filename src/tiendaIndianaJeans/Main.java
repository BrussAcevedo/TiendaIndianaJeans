package tiendaIndianaJeans;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Producto> productoNoListado = new ArrayList<>();
		ArrayList<Producto> categoria1 = new ArrayList<>();
		ArrayList<Producto> categoria2= new ArrayList<>();
		ArrayList<Producto> categoria3= new ArrayList<>();		
	
		boolean salir = false;

		do {
			switch (Menu.menuPrincipal()) {
			case 1: {
				Menu.listarProducto(productoNoListado, categoria1, categoria2, categoria3);
				break;
			}
			case 2: {
				Producto nuevoProducto = Menu.agregarProducto();
				productoNoListado.add(nuevoProducto);
				break;
			}
			case 3:{
				for(Producto producto: productoNoListado) {
					System.out.println("Productos no listados: "+producto);
				}
				
				for(Producto producto : categoria1 ) {
					System.out.println("Productos en categoria1: "+producto);
				}
				
				for(Producto producto : categoria2 ) {
					System.out.println("Productos en categoria2: "+producto);
				}
				
				for(Producto producto : categoria3 ) {
					System.out.println("Productos en categoria1: "+producto);
				}
				
				
			}
			case 4: {
				Menu.exportarDatos();
				break;
			}
			case 5: {
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
