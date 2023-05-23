
public class Cliente {
	private static int clientes = 1;
	
	private String name;
	private String registro;
	
	public Cliente() {
		
	}

	public Cliente(String name, String registro) {
		this.name = name;
		this.registro = registro;
		clientes++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegistro() {
		return registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
	
	public String toString() {
		return "\nName: " + this.getName() +
				"\nRegistro: " + this.getRegistro();
				
	}
	
}
