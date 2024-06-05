package tiendaIndianaJeans;

import java.util.ArrayList;

public class ProductoServicio {

	private ArrayList<Producto> listaProductos;

	public ProductoServicio(ArrayList<Producto> listaProductos) {
		
		this.listaProductos = listaProductos;
	}

	public ArrayList<Producto> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	
	
	public static void listarProductos(ArrayList<Producto>lista) {
		
		for (Producto producto : lista) {
	        System.out.println("Producto= "+producto.toString());
	    }System.out.println("");
	    
		
	}
	
	
	public static ArrayList<Producto> agregarProductos(Producto entradaProducto) {
		ArrayList<Producto> productoALista = new ArrayList<>();
		
		productoALista.add(entradaProducto);
		
		return productoALista;
	}
}
