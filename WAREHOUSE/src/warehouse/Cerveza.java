package warehouse;

public class Cerveza extends Articulos implements Alcoholico{
	
	private String origen;
	private String cereales;
	private double gradosAlcohol;
	
	public Cerveza(String codigo, String nombre, String tipo, String marca, int capacidadBotella, double precio,
			int stock, String origen, String cereales, double gradosAlcohol) {
		super(codigo, nombre, tipo, marca, capacidadBotella, precio, stock);
		this.origen = origen;
		this.cereales = cereales;
		this.gradosAlcohol = gradosAlcohol;
	}
	public Cerveza() {
		super();
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getCereales() {
		return cereales;
	}
	public void setCereales(String cereales) {
		this.cereales = cereales;
	}
	public double getGradosAlcohol() {
		return gradosAlcohol;
	}
	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}
	@Override
	public String toString() {
		return "Cerveza: origen =" + origen + ", cereales =" + cereales + ", gradosAlcohol =" + gradosAlcohol +", "+super.toString();
	}
	@Override
	public void visualizarArticulo() {
		System.out.println(this.toString());
	}
	@Override
	public boolean esSaludable() {
		return false;
	}
	@Override
	public void precioTotal() {
		double precioTotal = 0.0;
		precioTotal=this.getStock()*this.getPrecio();
		System.out.println("El precio del stock total de las cervezas es de: "+ precioTotal);
	}
	@Override
	public boolean esFuerte() {
		boolean fuerte = false;
		if(this.gradosAlcohol >= 7) {
			fuerte = true;
		}
		return fuerte;
	}
	@Override
	public double calcularTasa() {
		double tasa;
		if(this.esFuerte()) {
			tasa=TASA_BEBIDAS_FUERTES;
		}
		else {
			tasa=TASA_BEBIDAS_SUAVES;
		}
		return tasa;
	}
}
