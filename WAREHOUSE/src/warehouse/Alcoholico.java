package warehouse;

public interface Alcoholico {
	static final double TASA_BEBIDAS_FUERTES=64.13;
	static final double TASA_BEBIDAS_SUAVES=38.48;
	
	public boolean esFuerte();
	public double calcularTasa();
}
