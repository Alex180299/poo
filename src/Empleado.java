
public class Empleado extends Persona {
	
	private String noEmpleado;
	private String puesto;
	
	public Empleado() {
		super();
	}
	
	@Override
	protected void generaDNI() {
		String dni = "";
		int rand;
		
		do {
			rand = (int) (Math.random() * 10);
			
			if(rand > 5) {
				rand = (int) (Math.random()*10);
				dni = dni.concat(String.valueOf(rand));
			}else {
				rand = (int)(Math.random()*25+65);
				dni = dni.concat(String.valueOf((char)rand));
			}
		}while(dni.length() < 10);		
		this.DNI = dni;
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		str += ", No. Empleado: " + noEmpleado
			+ ", Puesto: " + puesto;
		return str;
	}

	public String getNoEmpleado() {
		return noEmpleado;
	}

	public void setNoEmpleado(String noEmpleado) {
		this.noEmpleado = noEmpleado;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

}
