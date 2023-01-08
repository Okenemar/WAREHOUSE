package warehouse;
import java.util.Date;
import java.util.Iterator;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Factura {
	public static int IVA = 21;
	private int numero;
	private String nombreEmpresa;
	private Date fecha;
	private String concepto;
	private ArrayList<LineaFactura> linea;
	public Factura(int numero, String nombreEmpresa, Date fecha, String concepto, ArrayList<LineaFactura> linea) {
		
		this.numero = numero;
		this.nombreEmpresa = nombreEmpresa;
		this.fecha = fecha;
		this.concepto = concepto;
		this.linea = new ArrayList<LineaFactura>();
	}
	public Factura() {
		super();
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public void addLinea(LineaFactura lineas) {
		boolean esta=false;
		Iterator<LineaFactura> it=linea.iterator();
		while(it.hasNext() && !esta) {
			LineaFactura factura=(LineaFactura) it.next();
			if(factura.equals(lineas)) {
				System.out.println("ya existe esta linea");
				esta=true;
			}
			it.next();
		}
		if(!esta){
			linea.add(lineas);
		}
	}
	
	
	public double precioTotal() {
		double precioTotal=0.0;
		for(LineaFactura linea:linea) {
			precioTotal=precioTotal+linea.precioTotal();
		}
		return precioTotal;
	}
	
	public void mostrarEnPantalla() {
		System.out.println(this.toString());
		for(LineaFactura linea:linea) {
			System.out.println(linea.toString());
		}
		
	}
	
	public void guardarEnFichero()throws IOException {
		String fichero=numero+"_"+fecha+"_factura.txt";
		PrintWriter write=new PrintWriter("Facturas/"+fichero);
		write.println("Factura: \n IVA: "+Factura.IVA+", numero: "+this.numero+", nombre de empresa: "+this.nombreEmpresa+", fecha: "+this.fecha+", concepto: "+this.concepto);
		for(LineaFactura factura:linea) {
			write.println(factura.formato());
		}
		write.close();
		
	}
	

	@Override
	public String toString() {
		return "Factura: numero=" + numero + ", nombreEmpresa=" + nombreEmpresa + ", fecha=" + fecha + ", concepto="
				+ concepto + ", lineaList=" + linea;
	}
}
