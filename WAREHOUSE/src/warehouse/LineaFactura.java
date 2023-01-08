package warehouse;
public class LineaFactura  {
	private int numero;
	private Articulos articulo;
	private int cantidad;
	
	public LineaFactura(int numero, Articulos articulo, int cantidad) {
		this.numero = numero;
		this.articulo = articulo;
		this.cantidad = cantidad;
	}
	public LineaFactura() {
		
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Articulos getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulos articulo) {
		this.articulo = articulo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double precioTotal(){
		double precioTotal=0.0;
		precioTotal=cantidad*articulo.getPrecio();
		return precioTotal;
	}


	public String formato() {
		String formato = this.numero+";"+this.articulo.getNombre()+";"+this.cantidad;
		return formato;
	}
	
	@Override
	public String toString() {
		return "LineaFactura: numero =" + numero + ", articulo =" + articulo + ", cantidad =" + cantidad;
	}
}
