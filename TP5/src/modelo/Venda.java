package modelo;

/**
 * Define os atributos e metodos da Venda
 * @author Vitor
 * @version 1.0
 */

public class Venda {
	private Cliente cliente;
	private Produto prod;
	
	/**
	 * Construtor Venda 
	 */
	
	public Venda() {
		
	}
	
	/**
	 * Construtor Venda
	 * @param cliente passa um objeto cliente com todos os dados
	 * @param prod passa uma capa, carregador, pelicula ou fone apenas com os atributos herdados de produto
	 */
	
	public Venda(Cliente cliente, Produto prod) {
		this.cliente = cliente;
		this.prod = prod;
	}
	
	//Getters e Setters
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProd() {
		return prod;
	}

	public void setProd(Produto prod) {
		this.prod = prod;
	}

}