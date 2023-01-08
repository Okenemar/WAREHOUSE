package warehouse;

public class Refresco extends Articulos{
	private String sabor;
	private boolean zumo;
	private boolean gaseoso;
	private int cantidadAzucar;
	
	public Refresco(String codigo, String nombre, String tipo, String marca, int capacidadBotella, double precio,
			int stock, String sabor, boolean zumo, boolean gaseoso, int cantidadAzucar) {
		super(codigo, nombre, tipo, marca, capacidadBotella, precio, stock);
		this.sabor = sabor;
		this.zumo = zumo;
		this.gaseoso = gaseoso;
		this.cantidadAzucar = cantidadAzucar;
	}
	public Refresco() {
		super();
	}
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public boolean isZumo() {
		return zumo;
	}
	public void setZumo(boolean zumo) {
		this.zumo = zumo;
	}
	public boolean isGaseoso() {
		return gaseoso;
	}
	public void setGaseoso(boolean gaseoso) {
		this.gaseoso = gaseoso;
	}
	public int getCantidadAzucar() {
		return cantidadAzucar;
	}
	public void setCantidadAzucar(int cantidadAzucar) {
		this.cantidadAzucar = cantidadAzucar;
	}
	
	public void visualizarPropiedades() {
		System.out.println("Sabor: " + sabor + ", Zumo: " + zumo + ", Gaseoso: " + gaseoso + ", Cantidad de azucar: " + cantidadAzucar);		
	}
	@Override
	public String toString() {
		return "Refresco: sabor =" + sabor + ", zumo =" + zumo + ", gaseoso =" + gaseoso + ", cantidadAzucar =" + cantidadAzucar+","+ super.toString();
	}	
	@Override
	public void visualizarArticulo() {
		System.out.println(this.toString());
	}
	@Override
	public boolean esSaludable() {
		boolean saludable = false;
		if(cantidadAzucar<20) {
			saludable = true;
		}
		return saludable;
	}
	@Override
	public void precioTotal() {
		double precioTotal = 0.0;
		precioTotal = this.getStock() * this.getPrecio();
		System.out.println("El precio del stock total de los refrescos es de: "+ precioTotal);
		
	}

}
