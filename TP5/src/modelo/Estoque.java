package modelo;

import java.util.ArrayList;

/**
 * Define os atributos e comportamento do estoque
 * @author Vitor
 * @version 1.0
 */

public class Estoque {
	
	private ArrayList<Capa> capas = new ArrayList<>();
	private ArrayList<Carregador> carregadores = new ArrayList<>();
	private ArrayList<Pelicula> peliculas = new ArrayList<>();
	private ArrayList<Fone> fones = new ArrayList<>();
	private ArrayList<Venda> vendas = new ArrayList<>();

	private int qtdCarregador = 0;
	private int qtdPelicula = 0;
	private int qtdCapa = 0;
	private int qtdFone = 0;
	private int qtdVenda = 0;
	
	/**
	 * Adiciona um objeto Capa ao ArrayList
	 * @param capa objeto capa com todos os dados
	 */
	
	public void cadastraCapa(Capa capa) {
		this.capas.add(capa);
	}
	
	/**
	 * Edita um objeto Capa previamente adicionado ao ArrayList
	 * @param capa objeto capa com todos os dados
	 * @param pos informa a posição da capa a ser editada na lista
	 */
	
	public void editaCapa(Capa capa, int pos) {
		this.capas.set(pos, capa);
	}
	
	/**
	 * Retira o objeto Capa do ArrayList
	 * @param pos
	 */
	
	public void deletaCapa(int pos) {
		this.capas.remove(pos);
	}
	
	/**
	 * Adiciona um objeto Carregador ao ArrayList
	 * @param carregador objeto carregador com todos os dados
	 */
	
	public void cadastraCarregador(Carregador carregador) {
		this.carregadores.add(carregador);
	}
	
	/**
	 * Edita um objeto carregador previamente adicionado ao ArrayList
	 * @param carregador objeto carregador com todos os dados
	 * @param pos informa a posição do carregador a ser editada na lista
	 */
	
	public void editaCarregador(Carregador carregador, int pos) {
		this.carregadores.set(pos, carregador);
	}
	
	/**
	 * Retira o objeto Carregador do ArrayList
	 * @param pos
	 */
	
	public void deletaCarregador(int pos) {
		this.carregadores.remove(pos);
	}
	
	/**
	 * Adiciona um objeto Pelicula ao ArrayList
	 * @param pelicula objeto pelicula com todos os dados
	 */
	
	public void cadastraPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}
	
	/**
	 * Edita um objeto pelicula previamente adicionado ao ArrayList
	 * @param pelicula objeto pelicula com todos os dados
	 * @param pos informa a posição do pelicula a ser editada na lista
	 */
	
	public void editaPelicula(Pelicula pelicula, int pos) {
		this.peliculas.set(pos, pelicula);
	}
	
	/**
	 * Retira o objeto pelicula do ArrayList
	 * @param pos
	 */
	
	public void deletaPelicula(int pos) {
		this.peliculas.remove(pos);
	}
	
	/**
	 * Adiciona um objeto Fone ao ArrayList
	 * @param fone objeto fone com todos os dados
	 */
	
	
	public void cadastraFone(Fone fone) {
		this.fones.add(fone);
	}
	
	/**
	 * Edita um objeto fone previamente adicionado ao ArrayList
	 * @param fone objeto fone com todos os dados
	 * @param pos informa a posição do fone a ser editada na lista
	 */
	
	public void editaFone(Fone fone, int pos) {
		this.fones.set(pos, fone);
	}
	
	/**
	 * Retira o objeto fone do ArrayList
	 * @param pos
	 */
	
	public void deletaFone(int pos) {
		this.fones.remove(pos);
	}
	
	/**
	 * Adiciona um objeto Venda ao ArrayList
	 * @param venda objeto venda com todos os dados
	 */
	
	public void cadastraVenda(Venda venda) {
		this.vendas.add(venda);
	}
	
	/**
	 * Edita um objeto venda previamente adicionado ao ArrayList
	 * @param venda objeto venda com todos os dados
	 * @param pos informa a posição do venda a ser editada na lista
	 */
	
	public void editaVenda(Venda venda, int pos) {
		this.vendas.set(pos, venda);
	}
	
	/**
	 * Cadastra 5 Capas, 5 Carregadores, 5 Peliculas e 5 Fones ao ArrayList
	 */
	
	public void gerarDados(){
		int aux;
		aux = 5;
		for (int i = 0; i < aux; i++) {
			
			capas.add(new Capa("Capa" + i
					, "Proteção"
					, (aux*i + 5)
					, "Marca" + i
					, "Material" + i
					, "Celular" + i
					, (aux*0.4)
					, "Cor" + i));
			
			carregadores.add(new Carregador("Carregador" + i
					, "Turbo"
					, (aux*i + 5)
					, "Marca" + (i*2)
					, (i + 0.5)
					, (i*0.5 + 0.1)));
			
			peliculas.add(new Pelicula("Pelicula" + i
					, "Proteção"
					, (aux*i + 3)
					, "Sam" + i
					, "Vidro"
					, (aux*0.5 + 0.2)
					, "Celular A" + (i + 2)));
			
			fones.add(new Fone("Fone" + i
					,"Audio nota" + (i + 5)
					,(aux*i + 35)
					,"Marca" + (i*3)
					,(aux*i) + 0.2
					,"Bluetooth"
					, true
					,"Azul"
					,"Silicone"));
		}
			
	}
	
	/**
	 * Metodo que gerava o relatorio na main antiga
	 * @deprecated
	 * @param qtdCarregador informa a quantidade de Carregadores no estoque
	 * @param qtdPelicula informa a quantidade de Peliculas no estoque
	 * @param qtdCapa informa a quantidade de Capas no estoque
	 * @param qtdFone informa a quantidade de Fones no estoque
	 * @param vendas informa a quantidade de Vendas no estoque
	 */
	
	public void relatorioProdutos(int qtdCarregador, int qtdPelicula, int qtdCapa, int qtdFone, int vendas) {
		String saida;
		int qtdProduto = qtdCarregador + qtdPelicula + qtdCapa + qtdFone;
		saida = "\nCarregadores registrados: " + qtdCarregador;
		saida += "\nPeliculas registradas: " + qtdPelicula;
		saida += "\nCapas registradas: " + qtdCapa;
		saida += "\nFones registrados: " + qtdFone;
		saida += "\nTotal de produtos: " + qtdProduto;
		saida += "\nVendas realizadas: " + vendas;
		System.out.println(saida);
	}
	
	/**
	 * Metodo que gerava o historico na main antiga
	 * @deprecated
	 * @param qtdVenda informa a quantidade de Vendas no estoque
	 * @param venda objeto venda para que seja possível pegar os dados do cliente e o produto comprado
	 */
	
	public void gerarHistorico(int qtdVenda, Venda venda) {
		String saida;
		saida = "\nComprador: " + venda.getCliente().getNome();
		saida += "\nModelo comprado: " + venda.getProd().getModelo();
		saida += "\nValor: " + venda.getProd().getValor() + " R$";
		System.out.println(saida);
	}
	
	//Getters e Setters
	
	public ArrayList<Capa> getCapas() {
		return capas;
	}
	
	public void setCapas(ArrayList<Capa> capas) {
		this.capas = capas;
	}
	
	public ArrayList<Carregador> getCarregadores() {
		return carregadores;
	}
	
	public void setCarregadores(ArrayList<Carregador> carregadores) {
		this.carregadores = carregadores;
	}
	
	public ArrayList<Pelicula> getPeliculas() {
		return peliculas;
	}
	
	public void setPeliculas(ArrayList<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}
	
	public ArrayList<Fone> getFones() {
		return fones;
	}
	
	public void setFones(ArrayList<Fone> fones) {
		this.fones = fones;
	}
	
	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

	public int getQtdCarregador() {
		return qtdCarregador;
	}

	public void setQtdCarregador(int qtdCarregador) {
		this.qtdCarregador = qtdCarregador;
	}

	public int getQtdPelicula() {
		return qtdPelicula;
	}

	public void setQtdPelicula(int qtdPelicula) {
		this.qtdPelicula = qtdPelicula;
	}

	public int getQtdCapa() {
		return qtdCapa;
	}

	public void setQtdCapa(int qtdCapa) {
		this.qtdCapa = qtdCapa;
	}

	public int getQtdFone() {
		return qtdFone;
	}

	public void setQtdFone(int qtdFone) {
		this.qtdFone = qtdFone;
	}
	
	public int getQtdVenda() {
		return qtdVenda;
	}

	public void setQtdVenda(int qtdVenda) {
		this.qtdVenda = qtdVenda;
	}
	
}
