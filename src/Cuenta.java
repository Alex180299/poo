
public class Cuenta {
	
	private String tarjeta;
	private double cantidad;
	
	public Cuenta(String tarjeta, double cantidad) {
		this.tarjeta = compruebaTarjeta(tarjeta);
		this.cantidad = cantidad;
	}
	
	public Cuenta(String tarjeta) {
		this.tarjeta = compruebaTarjeta(tarjeta);
	}
	
	private String compruebaTarjeta(String tarjeta) {
		if(tarjeta.length() > 16 || tarjeta.length() < 15) 
			return null;
		else 
			try {
				for (int i = 0; i < tarjeta.length(); i++) {
					Integer.valueOf(String.valueOf(tarjeta.charAt(i)));
					
				}
			}catch(Exception e) {
				return null;
			}
		
		
		return tarjeta;
	}
	
	public void ingresar(double cantidad) {
		if(cantidad > 0) {
			this.cantidad += cantidad;
		}
	}
	
	public void retirar(double cantidad) {
		this.cantidad -= cantidad;
		if(this.cantidad < 0) this.cantidad = 0;
	}

	public String getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(String tarjeta) {
		this.tarjeta = compruebaTarjeta(tarjeta);
	}
	public double getCantidad() {
		return cantidad;
	}
	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}
	
	
	

}
