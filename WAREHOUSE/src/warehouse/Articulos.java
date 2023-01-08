package warehouse;

public abstract class Articulos implements Comparable<Articulos> {
	private String codigo;
	private String nombre;
	private String tipo;
	private String marca;
	private int capacidadBotella;
	private double precio;
	private int stock;
	
	public Articulos(String codigo, String nombre,String tipo, String marca, int capacidadBotella, double precio, int stock) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.tipo=tipo;
		this.marca = marca;
		this.capacidadBotella = capacidadBotella;
		this.precio = precio;
		this.stock = stock;
	}

	public Articulos() {
		
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String code) {
		this.codigo = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCapacidadBotella() {
		return capacidadBotella;
	}

	public void setCapacidadBotella(int capacidadBotella) {
		this.capacidadBotella = capacidadBotella;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void incrementarStock(int cantidad) {
		this.stock = this.stock + cantidad;
	}
	
	public void disminuirStock(int cantidad) {
		if(this.stock < cantidad || this.stock == 0) {
			System.out.println("No hay suficiente stock");
		}
		else {
			this.stock = this.stock - cantidad;
		}
	}
	
	public abstract void visualizarArticulo();
	public abstract boolean esSaludable();
	public abstract void precioTotal();

	@Override
	public String toString() {
		return "codigo =" + codigo + ", nombre =" + nombre + ", marca =" + marca + ", capacidadBotella ="
				+ capacidadBotella + ", precio =" + precio + ", stock =" + stock;
	}
	
	@Override
	public int compareTo(Articulos i) {
		if(this.getPrecio() < i.getPrecio()) {
			return -1;
		}
		else{
			if(this.getPrecio() > i.getPrecio()){
				return 1;
			}
			else {
				return 0;
			}
		}
	}
	
}