package modelo;

/**
 * Define os atributos e metodos do objeto Capa
 * @author Vitor
 * @version 1.0
 */

public class Capa extends Produto {
	
	private String material;
	private String celularCompativel;
	private double peso;
	private String cor;
	
	/**
	 * Construtor Carregador
	 */
	
	public Capa() {
		
	}
	
	/**
	 * Construtor Carregador
	 * @param modelo informa o modelo do produto
	 * @param descricao informa os detalhas do produto
	 * @param valor informa o valor do produto
	 * @param marca informa a marca do produto
	 * @param material informa o material
	 * @param celularCompativel informa o celular compatível com o produto
	 * @param peso informa o peso do produto
	 * @param cor informa a cor do produto
	 */
	
	public Capa(String modelo, String descricao, double valor, String marca, String material, String celularCompativel, double peso, String cor) {
		this.modelo = modelo;
		this.descricao = descricao;
		this.valor = valor;
		this.marca = marca;
		this.material = material;
		this.celularCompativel = celularCompativel;
		this.peso = peso;
		this.cor = cor;
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
		saida += "\nMaterial: " + this.material;
		saida += "\nCelular Compativel: " + this.celularCompativel;
		saida += "\nPeso: " + this.peso + "g";
		return saida;
	}
	
	//Getters e Setters
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public String getCelularCompativel() {
		return celularCompativel;
	}
	
	public void setCelularCompativel(String celularCompativel) {
		this.celularCompativel = celularCompativel;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
}
