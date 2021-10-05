package modelo;

public class Capa extends Produto {
	
	private String material;
	private String celularCompativel;
	private double peso;
	private String cor;
	
	//Constructor
	public Capa() {
		
	}
	
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
