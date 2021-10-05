package modelo;

public class Pelicula extends Produto{
	
	private String material;
	private double espessura;
	private String celularCompativel;
	
	//Constructor
	public Pelicula() {
		
	}
	
	public Pelicula(String modelo, String descricao, double valor, String marca, String material, double espessura, String celularCompativel) {
		this.modelo = modelo;
		this.descricao = descricao;
		this.valor = valor;
		this.marca = marca;
		this.material = material;
		this.espessura = espessura;
		this.celularCompativel = celularCompativel;
	}
	
	public String toString(){
		String saida;
		saida = "Modelo: " + this.modelo;
		saida += "\nDescrição: " + this.descricao;
		saida += "\nValor: " + this.valor + " R$";
		saida += "\nMarca: " + this.marca;
		saida += "\nMaterial: " + this.material;
		saida += "\nEspessura: " + this.espessura;
		saida += "\nCelular Compativel: " + this.celularCompativel;
		return saida;
	}
	
	//Getters e Setters
	
	public String getMaterial() {
		return material;
	}
	
	public void setMaterial(String material) {
		this.material = material;
	}
	
	public double getEspessura() {
		return espessura;
	}
	
	public void setEspessura(double espessura) {
		this.espessura = espessura;
	}
	
	public String getCelularCompativel() {
		return celularCompativel;
	}
	
	public void setCelularCompativel(String celularCompativel) {
		this.celularCompativel = celularCompativel;
	}
	
}

