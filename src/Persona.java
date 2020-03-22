import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class Persona{
	
	public final static int PESO_POR_DEBAJO = -1;
	public final static int PESO_IDEAL = 0;
	public final static int SOBREPESO = 1;

	protected String nombre;
	protected int edad;
	protected String DNI;
	protected char sexo;
	protected double peso;
	protected Cuenta cuenta;
	protected double altura;
	
	public Persona(){
		nombre = "";
		edad = 0;
		sexo = ' ';
		peso = 0;
		altura = 0;
		generaDNI();
	}
	
	public Persona(String nombre, int edad, char sexo){
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		peso = 0;
		altura = 0;
		generaDNI();
	}
	
	
	public Persona(String nombre, int edad, String dNI, char sexo, double peso, Cuenta cuenta, double altura) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		DNI = dNI;
		this.sexo = sexo;
		this.peso = peso;
		this.cuenta = cuenta;
		this.altura = altura;
		generaDNI();
	}
	
	public int calcularIMC() {
		double formula = this.peso/Math.pow(this.altura, 2);
		
		if(formula < 20) return PESO_POR_DEBAJO;
		else if(formula >= 20 && formula < 26) return PESO_IDEAL;
		else return SOBREPESO;
	}
	
	public boolean esMayorDeEdad() {
		if(this.edad >= 18)
			return true;
		else 
			return false;		
	}
	
	private char comprobarSexo(char sexo) {
		if(sexo != 'M' && sexo != 'H') 
			return 'H';
		else 
			return sexo;
	}
	
	@Override
	public String toString() {
		String imc = (calcularIMC() == PESO_POR_DEBAJO)?"Peso por debajo de su peso ideal":
			(calcularIMC() == PESO_IDEAL)?"Peso ideal":"Sobrepeso";
		
		return "Nombre: " + nombre
			+ ", Edad: " + edad
			+ ", DNI: " + DNI
			+ ", Sexo: " + sexo
			+ ", Peso: " + peso + "(" + imc + ")"
			+ ", Cuenta: " + cuenta.getTarjeta()
			+ ", Cantidad en cuenta: " + cuenta.getCantidad()
			+ ", Altura: " + altura;
	}
	
	protected void generaDNI() {
		String dni;
		int generado;
		
		generado = (int) (Math.random() * 100000000);
		dni = String.valueOf(generado);
		
		dni = dni.concat(generaLetra(dni));
		
		this.DNI = dni;
	}
	
	private String generaLetra(String dni) {
		int letra = 0, i;
		
		for (i = 0; i < dni.length(); i++) {
			letra += Integer.valueOf(String.valueOf(dni.charAt(i)));
		}
		
		i = 0;
		while(letra < 65 || letra > 90) {
			letra += (letra < 65)? Integer.valueOf(dni.charAt(i)):0;
			letra -= (letra > 90)? Integer.valueOf(dni.charAt(i)):0;
			i = (i >= dni.length()-1)? 0:i+1;
		}
		
		return String.valueOf((char)letra);
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDNI() {
		return DNI;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public static void serializa(List<Persona> personas){
		File file = new File("personas.txt");
		FileWriter writer;
		String text;
		DecimalFormat formato = new DecimalFormat("0.00");
		
		try {
			writer = new FileWriter(file);
		} catch (IOException e1) {
			e1.printStackTrace();
			return;
		}
		
		text = "Nombre | Edad | DNI | Sexo | Peso | Altura | Cuenta | Cantidad | No. Empleado | Puesto";
		
		for (int i = 0; i < personas.size(); i++) {
			Persona p = personas.get(i);
			text += "\n" + p.getNombre() + "|" + p.getEdad() + "|" + p.getDNI() + "|" + p.getSexo() + "|" + 
					p.getPeso() + "|" + formato.format(p.getAltura()) + p.getCuenta().getTarjeta() + "|" + 
					p.getCuenta().getCantidad() + "|";
			
			if(p instanceof Empleado) {
				text += ((Empleado)(p)).getNoEmpleado() + "|" + ((Empleado)(p)).getPuesto();
			}
		}
		
		try {
			writer.write(text);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	
}
