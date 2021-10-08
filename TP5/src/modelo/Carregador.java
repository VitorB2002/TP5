package modelo;

/**
 * Define os atributos e metodos do objeto Carregador
 * @author Vitor
 * @version 1.0
 */

public class Carregador extends Produto {
	
	private double tamanhoCabo;
	private double potencia;
	

	/**
	 * Construtor
	 */
	
	public Carregador() {
		
	}
	
	/**
	 * Construtor
	 * @param modelo informa o modelo do produto
	 * @param descricao informa os detalhas do produto
	 * @param valor informa o valor do produto
	 * @param marca informa a marca do produto
	 * @param tamanhoCabo informa o comprimento do cabo
	 * @param potencia informa a potencia
	 */
	
	public Carregador(String modelo, String descricao, double valor, String marca, double tamanhoCabo, double potencia) {
		this.modelo = modelo;
		this.descricao = descricao;
		this.valor = valor;
		this.marca = marca;
		this.tamanhoCabo = tamanhoCabo;
		this.potencia = potencia;
	}
	
	
	/**
	 * Metodo toString utilizado na antiga main
	 * @deprecated
	 */
	
	public String toString(){
		String saida;
		saida = "Modelo: " + this.modelo;
		saida += "\nDescrição: " + this.descricao;
		saida += "\nValor: " + this.valor + " R$";
		saida += "\nMarca: " + this.marca;
		saida += "\nComprimento do Cabo: " + this.tamanhoCabo + " cm";
		saida += "\nPotencia: " +this.potencia + " Watts";
		return saida;
	}
	
	//Getters e Setters
	
	public double getTamanhoCabo() {
		return tamanhoCabo;
	}
	
	public void setTamanhoCabo(double tamanhoCabo) {
		this.tamanhoCabo = tamanhoCabo;
	}
	
	public double getPotencia() {
		return potencia;
	}
	
	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}
	
}

