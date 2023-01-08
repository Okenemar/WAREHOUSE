package warehouse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;


import java.util.Iterator;

public class Almacen {
	ArrayList<Articulos> articulos;
	public Almacen(){
		articulos=new ArrayList<Articulos>();
	}
	
	public void cargarDatos() throws FileNotFoundException, IOException {
		File file=new File("articulos.txt");
		Scanner teclado=new Scanner(file);
		String[] partes;
		while(teclado.hasNextLine()) {
			partes = teclado.nextLine().split(";");
			if(partes[2].toLowerCase().equals("refresco")) {
				Refresco ref=new Refresco(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], Boolean.parseBoolean(partes[8]), Boolean.parseBoolean(partes[9]),Integer.parseInt(partes[10]));
				articulos.add(ref);
			}else if(partes[2].toLowerCase().equals("vino")) {
				Vino vin=new Vino(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Integer.parseInt(partes[9]), partes[10], Double.parseDouble(partes[11]));
				articulos.add(vin);
			}else if(partes[2].toLowerCase().equals("cerveza")){
				Cerveza cer=new Cerveza(partes[0], partes[1], partes[2], partes[3],Integer.parseInt(partes[4]), Double.parseDouble(partes[5]), Integer.parseInt(partes[6]), partes[7], partes[8], Double.parseDouble(partes[9]));
				articulos.add(cer);
			}
		}
		teclado.close();
	}
	
	public Articulos elMasCaro() {
		double precio = 0.0;
		Articulos caro = null;
		for(Articulos art:articulos) {
			if(art.getPrecio()>precio) {
				precio=art.getPrecio();
				caro=art;
			}
		}
		return caro;
	}
	public double precio(String codigoProducto) {
		double precio=0.0;
		Iterator<Articulos> here=articulos.iterator();
		boolean encontrado=false;
		while(here.hasNext()||!encontrado) {
			Articulos art=(Articulos) here.next();
			if(art.getCodigo().equals(codigoProducto)) {
				precio=art.getPrecio();
				encontrado=true;
			}
			here.next();
		}
		return precio;
	}
	
	public boolean hayStock(String codigoProducto) {
		boolean stock=false;
		Iterator<Articulos> here=articulos.iterator();
		boolean encontrado=false;
		while(here.hasNext()||!encontrado) {
			Articulos art=(Articulos) here.next();
			if(art.getCodigo().equals(codigoProducto) && art.getStock()>0) {
				encontrado=true;
				stock=true;
			}
			here.next();
		}
		return stock;
	}
	
	public ArrayList<Articulos> stockJusto(int stock){
		ArrayList<Articulos> stockJusto=new ArrayList<Articulos>();
		for(Articulos art:articulos) {
			if(art.getStock()==stock) {
				stockJusto.add(art);
			}
		}
		return stockJusto;
	}
	
	public Articulos articulo(String codigoProducto) {
		boolean encontrado=false;
		Articulos artic=null;
		Iterator<Articulos> here=articulos.iterator();
		while(here.hasNext()||!encontrado) {
			Articulos art=(Articulos) here.next();
			if(art.getCodigo().equals(codigoProducto)) {
				encontrado=true;
				artic=art;
			}
			here.next();
		}
		return artic;
	}
	
	public boolean disponibilidad(int cantidad, String codigoProducto) {
		boolean encontrado=false;
		boolean disponible= false;
		Iterator<Articulos> here=articulos.iterator();
		while(here.hasNext()||!encontrado) {
			Articulos art=(Articulos) here.next();
			if(art.getCodigo().equals(codigoProducto) && art.getStock()>cantidad) {
				disponible=true;
				encontrado=true;
			}
			here.next();
		}
		return disponible;
	}
	
	public ArrayList<Articulos> equivalente(Articulos articulo){
		ArrayList<Articulos> equivalente=new ArrayList<Articulos>();
		return equivalente;
	
	
	}
}