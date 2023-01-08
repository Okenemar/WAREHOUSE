package warehouse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;



public class GestorAlmacenApp {
	public static void run() throws IOException, ParseException {
		final int VENTA=1;
		final int COMPRA=2;
		final int LISTA_SALUDABLES=3;
		final int ARTICULO_MAS_CARO=4;
		final int ARTICULOS_MENOS_STOCK=5;
		final int SALIR=0;
		
		Scanner teclado=new Scanner(System.in);
		Almacen almacen=new Almacen();
		Factura factura=new Factura();
		int opcion_menu=0;
		
		almacen.cargarDatos();
		do {
			System.out.println("----------MENU----------");
			System.out.println(VENTA+". realizar una venta");
			System.out.println(COMPRA+". realizar una compra");
			System.out.println(LISTA_SALUDABLES+". lista de articulos saludables");
			System.out.println(ARTICULO_MAS_CARO+". el articulo mas caro");
			System.out.println(ARTICULOS_MENOS_STOCK+". lista de articulos con menos stock que el articulo introducido");
			System.out.println(SALIR+". salir");
			opcion_menu=Integer.parseInt(teclado.nextLine());
			switch(opcion_menu) {
				case VENTA:
					realizarVenta(factura,almacen);
					System.out.println("Mostrando factura...");
					factura.mostrarEnPantalla();
					System.out.println("Guardando factura...");
					factura.guardarEnFichero();
					break;
				case COMPRA:
					realizarCompra(factura,almacen);
					break;
				case LISTA_SALUDABLES:
					for(Articulos art: almacen.articulos) {
						if(art.esSaludable()) {
							System.out.println(art);
						}
					}
					break;
				case ARTICULO_MAS_CARO:
					almacen.elMasCaro();
					break;
				case ARTICULOS_MENOS_STOCK:
					Articulos min=almacen.articulos.get(0);
					for(Articulos art: almacen.articulos) {
						if(art.getStock()<min.getStock()) {
							min=art;
						}
					}
					System.out.println(min);
					break;
				case SALIR:
					break;
				default:
					break;
			}
		}while(opcion_menu!=SALIR);
		teclado.close();
	}

	private static void realizarCompra(Factura factura, Almacen almacen) {
		
		
	}

	private static void realizarVenta(Factura factura,Almacen almacen) throws ParseException {
		Scanner teclado=new Scanner(System.in);
		String opcion="";
		SimpleDateFormat fecha= new SimpleDateFormat("dd-MM-yyyy");
		System.out.println("Introduce el numero de la factura:");
		factura.setNumero(Integer.parseInt(teclado.nextLine()));
		System.out.println("Introduce la fecha de hoy:");
		factura.setFecha(fecha.parse(teclado.nextLine()));
		System.out.println("Introduce el concepto de la factura:");
		factura.setConcepto(teclado.nextLine());
		do {
			LineaFactura linea=crearLinea(teclado, almacen);
			factura.addLinea(linea);
			System.out.println("Introduzca S si quiere comprar un articulo o en caso de querer dejar de seguir comprando introduzca N");
			opcion=teclado.nextLine();
		}while(!opcion.equals("N"));
	}
	
	private static LineaFactura crearLinea(Scanner teclado,Almacen almacen) {
		LineaFactura linea=new LineaFactura();
		boolean esta=false;
		int cantidad=0;
		Articulos art=null;
		String nombre="";
		Refresco ref=new Refresco();
		Vino vin=new Vino();
		Cerveza cer=new Cerveza();
		Iterator<Articulos> it=almacen.articulos.iterator();
		System.out.println("Introduce el numero de la linea:");
		linea.setNumero(Integer.parseInt(teclado.nextLine()));
		System.out.println("Introduce el nombre del articulo que quieres comprar");
		nombre=teclado.nextLine();
		while(it.hasNext()&& !esta) {
			art=(Articulos) it.next();
			if(nombre.equals(art.getNombre())) {
				esta=true;
				if(art instanceof Refresco) {
					art=(Articulos)ref;
				}
				else if(art instanceof Vino) {
					art=(Articulos)vin;
				}
				else if(art instanceof Cerveza) {
					art=(Articulos)cer;
				}
			}
			it.next();
		}
		linea.setArticulo(art);
		if(!esta) {
			System.out.println("No se ha encontrado el articulo");
		}
		System.out.println("Introduce la cantidad del articulo que quieres comprar:");
		cantidad=Integer.parseInt(teclado.nextLine());
		if(almacen.disponibilidad(cantidad, art.getCodigo())) {
			linea.setCantidad(cantidad);
		}
		else if(!almacen.disponibilidad(cantidad, art.getCodigo())) {
			System.out.println("No hay stock");
		}
		else if(art.getStock()>0 && art.getStock()<cantidad){
			linea.setCantidad(art.getStock());
			System.out.println("No hay suficiente cantidad");
			art.setStock(0);
		}
		return linea;
	}
}
