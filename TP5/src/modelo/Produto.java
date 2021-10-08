package modelo;

/**
 * Classe pai produto, não instanciável
 * @author Vitor
 * @version 1.0
 */

public abstract class Produto {
	
	protected String modelo;
	protected String descricao;
	protected double valor;
	protected String marca;
	
	//Getters e Setters
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}