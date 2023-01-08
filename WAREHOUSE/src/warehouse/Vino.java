package warehouse;

public class Vino extends Articulos implements Alcoholico{
	
	private String color;
	private String origen;
	private int anio;
	private String tipoDeUva;
	private double gradosAlcohol;
	
	public Vino(String codigo, String nombre, String tipo, String marca, int capacidadBotella, double precio, int stock,
			String color, String origen, int anio, String tipoDeUva, double gradosAlcohol) {
		super(codigo, nombre, tipo, marca, capacidadBotella, precio, stock);
		this.color = color;
		this.origen = origen;
		this.anio = anio;
		this.tipoDeUva = tipoDeUva;
		this.gradosAlcohol = gradosAlcohol;
	}
	
	public Vino() {
		super();
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public String getTipoDeUva() {
		return tipoDeUva;
	}
	public void setTipoDeUva(String tipoDeUva) {
		this.tipoDeUva = tipoDeUva;
	}
	public double getGradosAlcohol() {
		return gradosAlcohol;
	}
	public void setGradosAlcohol(double gradosAlcohol) {
		this.gradosAlcohol = gradosAlcohol;
	}
	@Override
	public String toString() {
		return "Vino: color=" + color + ", origen=" + origen + ", anio=" + anio + ", tipoDeUva=" + tipoDeUva + ", gradosAlcohol=" + gradosAlcohol+", "+super.toString();
	}
	@Override
	public void visualizarArticulo() {
		System.out.println(this.toString());
	}

	@Override
	public void precioTotal() {
		double precioTotal = 0.0;
		precioTotal=this.getStock()*this.getPrecio();
		System.out.println("El precio del stock total del vino es de: "+ precioTotal);
		
	}

	@Override
	public boolean esSaludable() {
		boolean saludable = false;
		if(this.origen.equals("navarra")) {
			saludable = true;
		}
		return saludable;
	}

	@Override
	public boolean esFuerte() {
		boolean fuerte = false;
		if(this.gradosAlcohol >= 13.5) {
			fuerte = true;
		}
		return fuerte;
	}

	@Override
	public double calcularTasa() {
		double tasa;
		if(this.esFuerte()) {
			tasa = TASA_BEBIDAS_FUERTES;
		}
		else {
			tasa = TASA_BEBIDAS_SUAVES;
		}
		return tasa;
	}
	

}
