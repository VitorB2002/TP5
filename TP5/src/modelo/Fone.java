package modelo;

/**
 * Define os atributos e metodos do objeto Carregador
 * @author Vitor
 * @version 1.0
 */

public class Fone extends Produto {
	
	private double peso;
	private String tipoConexao;
	private boolean filtroRuido;
	private String cor;
	private String materialBorracha;

	/**
	 * Construtor
	 */
	
	public Fone() {
		
	}
	
	/**
	 * Construtor
	 * @param modelo informa o modelo do produto
	 * @param descricao informa os detalhas do produto
	 * @param valor informa o valor do produto
	 * @param marca informa a marca do produto
	 * @param peso informa o peso do produto
	 * @param tipoConexao informa a conexão do produto
	 * @param filtroRuido informa se o produto possui filtro de ruídos
	 * @param cor informa a cor do produto
	 * @param materialBorracha informa o material das borrachas do produto
	 */
	
	public Fone(String modelo, String descricao, double valor, String marca, double peso, String tipoConexao, boolean filtroRuido, String cor, String materialBorracha) {
		this.modelo = modelo;
		this.descricao = descricao;
		this.valor = valor;
		this.marca = marca;
		this.peso = peso;
		this.tipoConexao = tipoConexao;
		this.filtroRuido = filtroRuido;
		this.cor = cor;
		this.materialBorracha = materialBorracha;
	}
	
	/**
	 * Metodo toString utilizado na antiga main
	 * @deprecated
	 */
	
	public String toString() {
		String saida;
		saida = "Modelo: " + this.modelo;
		saida += "\nDescrição: " + this.descricao;
		saida += "\nValor: " + this.valor + " R$";
		saida += "\nMarca: " + this.marca;
		saida += "\nPeso: " + this.peso;
		saida += "\nFiltra Ruídos: " + this.filtroRuido;
		saida += "\nCor: " + this.cor;
		saida += "\nMaterial da Borracha: " + this.materialBorracha;
		return saida;
	}
	
	//Getters e Setters
	
	public double getPeso() {
		return peso;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String getTipoConexao() {
		return tipoConexao;
	}
	
	public void setTipoConexao(String tipoConexao) {
		this.tipoConexao = tipoConexao;
	}
	
	public boolean isFiltroRuido() {
		return filtroRuido;
	}
	
	public void setFiltroRuido(boolean filtroRuido) {
		this.filtroRuido = filtroRuido;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getMaterialBorracha() {
		return materialBorracha;
	}
	
	public void setMaterialBorracha(String materialBorracha) {
		this.materialBorracha = materialBorracha;
	}
	
}
