package modelo;

import java.util.ArrayList;

public class Dados {
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	public void cadastraCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	public void editaCliente(Cliente c, int pos) {
		this.clientes.set(pos, c);
	}
	
	public void gerarDados(){
		int aux;
		aux = 5;
		
		for (int i = 0; i < aux; i++) {
			clientes.add(new Cliente("Cliente" + i
					, "" + (i + 42234533)
					, "Casa" + (i + 1)
					, "Cliente" + i + "@gmail.com"
					, "40028921" + i));
		}
			
	}
}
