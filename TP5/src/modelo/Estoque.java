package modelo;

import java.util.ArrayList;

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
	
	public void cadastraCapa(Capa capa) {
		this.capas.add(capa);
	}
	
	public void editaCapa(Capa capa, int pos) {
		this.capas.set(pos, capa);
	}
	
	public void cadastraCarregador(Carregador carregador) {
		this.carregadores.add(carregador);
	}
	
	public void editaCarregador(Carregador carregador, int pos) {
		this.carregadores.set(pos, carregador);
	}
	
	public void cadastraPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}
	
	public void editaPelicula(Pelicula pelicula, int pos) {
		this.peliculas.set(pos, pelicula);
	}
	
	public void cadastraFone(Fone fone) {
		this.fones.add(fone);
	}
	
	public void editaFone(Fone fone, int pos) {
		this.fones.set(pos, fone);
	}
	
	public void cadastraVenda(Venda venda) {
		this.vendas.add(venda);
	}
	
	public void editaVenda(Venda venda, int pos) {
		this.vendas.set(pos, venda);
	}
	
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
