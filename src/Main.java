import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		showMenu();
		
	}
	
	private static void showMenu() {
		int opc = 0;
		List<Persona> personas = new ArrayList<Persona>();
		Persona persona;
		Cuenta cuenta;
		
		do {
			System.out.println("Ingrese la opción a capturar: ");
			System.out.print(" 1.Persona\n 2.Empleado\n :");
			
			if(getInt() == 1) {
				persona = new Persona();
			}else {
				persona = new Empleado();
			}
			
			System.out.println("Ingrese el nombre: ");
			persona.setNombre(getString());
			System.out.println("Ingrese la edad: ");
			persona.setEdad(getInt());
			System.out.println("Ingrese el sexo (H/M): ");
			persona.setSexo(getChar());
			System.out.println("Ingrese el peso: ");
			persona.setPeso(getDouble());
			
			do {
				System.out.println("Ingrese el número de tarjeta: ");
				cuenta = new Cuenta(getString());
			}while(cuenta.getTarjeta() == null);
			
			System.out.println("Ingrese la cantidad de la cuenta: ");
			cuenta.setCantidad(getDouble());
			persona.setCuenta(cuenta);
			
			System.out.println("Ingrese la altura: ");
			persona.setAltura(getDouble());
			
			if(persona instanceof Empleado) {				
				System.out.println("Ingrese el numero de empleado: ");
				((Empleado)persona).setNoEmpleado(getString());
				
				System.out.println("Ingrese el puesto: ");
				((Empleado)persona).setPuesto(getString());
			}
			
			System.out.println("\n" + persona.toString());
			personas.add(persona);
			
			System.out.println("\n\n Desea capturar otra persona?");
			System.out.print(" 1.Si\n 2.No\n :");
			opc = getInt();
		}while(opc == 1);
		
		Persona.serializa(personas);
	}

	private static String getString() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static int getInt() {
		Scanner scan = new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static double getDouble() {
		Scanner scan = new Scanner(System.in);
		return scan.nextDouble();
	}
	
	private static char getChar() {
		Scanner scan = new Scanner(System.in);
		return scan.nextLine().toUpperCase().charAt(0);
	}

}
