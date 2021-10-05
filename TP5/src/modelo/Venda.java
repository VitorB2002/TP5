package modelo;

public class Venda {
	private Cliente cliente;
	private Produto prod;
	
	public Venda() {
		
	}
	
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