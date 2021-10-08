package modelo;

import java.util.ArrayList;

/**
 * Define os atributos e comportamento do banco de dados
 * @author Vitor
 * @version 1.0
 */

public class Dados {
	
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	/**
	 * Adiciona um objeto Cliente ao ArrayList
	 * @param c objeto cliente com todos os dados
	 */
	
	public void cadastraCliente(Cliente c) {
		this.clientes.add(c);
	}
	
	/**
	 * Edita um objeto Cliente previamente adicionado ao ArrayList
	 * @param c objeto cliente com todos os dados
	 * @param pos informa a posição do cliente a ser editado na lista
	 */
	
	public void editaCliente(Cliente c, int pos) {
		this.clientes.set(pos, c);
	}
	
	/**
	 * Cadastra 5 clientes ao banco de dados
	 */
	
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
