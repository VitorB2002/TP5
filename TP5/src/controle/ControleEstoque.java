package controle;

import modelo.*;

public class ControleEstoque {
private Estoque e = new Estoque();
	
	public ControleEstoque() {
		e.gerarDados();
	}

	public Estoque getEstoque() {
		return e;
	}

	public void setEstoque(Estoque e) {
		this.e = e;
	}
	
	public boolean cadastrarVenda(String[] dadosCliente, String[] dadosProduto, int opcao) {
		
		Cliente cliente = new Cliente(dadosCliente[0], dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
		Capa capa = new Capa();
		Carregador carregador = new Carregador();
		Pelicula pelicula = new Pelicula();
		Fone fone = new Fone();
		Venda venda = new Venda();
		
		double valor = Double.parseDouble(dadosProduto[2]);
		double peso;
		double tamanhoCabo;
		double potencia;
		double espessura;
		boolean filtroRuido;
		
		switch(opcao) {
		
			case 1:
				
				peso = Double.parseDouble(dadosProduto[6]);
				capa = new Capa(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, dadosProduto[4]
						, dadosProduto[5]
						, peso
						, dadosProduto[7]);
				venda = new Venda(cliente, capa);
				e.cadastraVenda(venda);
				
			break;
			
			case 2:
				
				tamanhoCabo = Double.parseDouble(dadosProduto[4]);
				potencia = Double.parseDouble(dadosProduto[5]);
				
				carregador = new Carregador(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, tamanhoCabo
						, potencia);
				venda = new Venda(cliente, carregador);
				e.cadastraVenda(venda);
				
			break;
			
			case 3:
				
				espessura = Double.parseDouble(dadosProduto[5]);
				
				pelicula = new Pelicula(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, dadosProduto[4]
						, espessura
						, dadosProduto[6]);
				venda = new Venda(cliente, pelicula);
				e.cadastraVenda(venda);
				
			break;
			
			case 4:
				
				filtroRuido = Boolean.parseBoolean(dadosProduto[6]);
				peso = Double.parseDouble(dadosProduto[4]);
				
				fone = new Fone(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, peso
						, dadosProduto[5]
						, filtroRuido
						, dadosProduto[7]
						, dadosProduto[8]);
				venda = new Venda(cliente, fone);
				e.cadastraVenda(venda);
				
			break;
			
		}
		
		return true;
	}
	
	public boolean editarVenda(String[] dadosCliente, String[] dadosProduto, int opcao, int pos) {
		
		Cliente cliente = new Cliente(dadosCliente[0], dadosCliente[1], dadosCliente[2], dadosCliente[3], dadosCliente[4]);
		Capa capa = new Capa();
		Carregador carregador = new Carregador();
		Pelicula pelicula = new Pelicula();
		Fone fone = new Fone();
		Venda venda = new Venda();
		
		double valor = Double.parseDouble(dadosProduto[2]);
		double peso;
		double tamanhoCabo;
		double potencia;
		double espessura;
		boolean filtroRuido;
		
		switch(opcao) {
		
			case 1:
				
				peso = Double.parseDouble(dadosProduto[6]);
				capa = new Capa(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, dadosProduto[4]
						, dadosProduto[5]
						, peso
						, dadosProduto[7]);
				venda = new Venda(cliente, capa);
				e.editaVenda(venda, pos);
				
			break;
			
			case 2:
				
				tamanhoCabo = Double.parseDouble(dadosProduto[4]);
				potencia = Double.parseDouble(dadosProduto[5]);
				
				carregador = new Carregador(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, tamanhoCabo
						, potencia);
				venda = new Venda(cliente, carregador);
				e.editaVenda(venda, pos);
				
			break;
			
			case 3:
				
				espessura = Double.parseDouble(dadosProduto[5]);
				
				pelicula = new Pelicula(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, dadosProduto[4]
						, espessura
						, dadosProduto[6]);
				venda = new Venda(cliente, pelicula);
				e.editaVenda(venda, pos);
				
			break;
			
			case 4:
				
				filtroRuido = Boolean.parseBoolean(dadosProduto[6]);
				peso = Double.parseDouble(dadosProduto[4]);
				
				fone = new Fone(dadosProduto[0]
						, dadosProduto[1]
						, valor
						, dadosProduto[3]
						, peso
						, dadosProduto[5]
						, filtroRuido
						, dadosProduto[7]
						, dadosProduto[8]);
				venda = new Venda(cliente, fone);
				e.editaVenda(venda, pos);
				
			break;
			
		}
		return true;
	}

	public void deletaProduto(int pos, int opcao) {
		switch(opcao) {
		
			case 1:
				e.deletaCapa(pos);
			break;
			
			case 2:
				e.deletaCarregador(pos);
			break;
			
			case 3:
				e.deletaPelicula(pos);
			break;
			
			case 4:
				e.deletaFone(pos);
			break;
			
		}
	}
	
	public boolean editarCadastrarProduto(String[] dadosProduto, int opcao, int pos) {
		
		//Validação das Strings apenas checka nulo
		if(dadosProduto[0].isEmpty() || dadosProduto[1].isEmpty() || dadosProduto[2].isEmpty() || dadosProduto[3].isEmpty()) {
			return false;
		}
		
		//Os objetos não são formados apenas por Strings, logo devemos converter algumas strings
		double valor = Double.parseDouble(dadosProduto[2]);
		double peso;
		double tamanhoCabo;
		double potencia;
		double espessura;
		boolean filtroRuido;
		
		Capa capa = new Capa();
		Carregador carregador = new Carregador();
		Pelicula pelicula = new Pelicula();
		Fone fone = new Fone();
		
		switch(opcao) {
		//Cases impares = cadastro
		//Cases pares = editar
			case 1:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty() || dadosProduto[6].isEmpty() || dadosProduto[7].isEmpty()) {
					return false;	
				} else{
					
					peso = Double.parseDouble(dadosProduto[6]);
					
					capa = new Capa(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, dadosProduto[4]
							, dadosProduto[5]
							, peso
							, dadosProduto[7]);
					
						e.cadastraCapa(capa);
				}
					
			break;
			
			case 2:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty() || dadosProduto[6].isEmpty() || dadosProduto[7].isEmpty()) {
					return false;
				} else {
					
					peso = Double.parseDouble(dadosProduto[6]);
					
					capa = new Capa(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, dadosProduto[4]
							, dadosProduto[5]
							, peso
							, dadosProduto[7]);
					e.editaCapa(capa, pos);
				}
				
				
			break;
			
			case 3:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty()) {
					
					return false;	
				} else {
					
					tamanhoCabo = Double.parseDouble(dadosProduto[4]);
					potencia = Double.parseDouble(dadosProduto[5]);
					
					carregador = new Carregador(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, tamanhoCabo
							, potencia);
					e.cadastraCarregador(carregador);
				}
				
				
			break;
			
			case 4:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty()) {
					return false;
				} else {
					
					tamanhoCabo = Double.parseDouble(dadosProduto[4]);
					potencia = Double.parseDouble(dadosProduto[5]);
					
					carregador = new Carregador(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, tamanhoCabo
							, potencia);
					e.editaCarregador(carregador, pos);
				}
				
			break;
			
			case 5:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[6].isEmpty()) {
					return false;
				}	else {
					
					espessura = Double.parseDouble(dadosProduto[5]);
					
					pelicula = new Pelicula(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, dadosProduto[4]
							, espessura
							, dadosProduto[6]);
					e.cadastraPelicula(pelicula);
				}
				
			break;
			
			case 6:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty() || dadosProduto[6].isEmpty()) {
					return false;
				} else {
					
					espessura = Double.parseDouble(dadosProduto[5]);
					
					pelicula = new Pelicula(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, dadosProduto[4]
							, espessura
							, dadosProduto[6]);
					e.editaPelicula(pelicula, pos);
				}
				
				
			break;
			
			case 7:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty() || dadosProduto[6].isEmpty() || dadosProduto[7].isEmpty() || dadosProduto[8].isEmpty()) {
					
					return false;	
				} else {
					
					if(dadosProduto[6].equals("s")) {
						filtroRuido = true;
					} else if(dadosProduto[6].equals("n")) {
						filtroRuido = false;
					} else {
						return false;
					}
					
					peso = Double.parseDouble(dadosProduto[4]);
					filtroRuido = Boolean.parseBoolean(dadosProduto[6]);
					
					fone = new Fone(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, peso
							, dadosProduto[5]
							, filtroRuido
							, dadosProduto[7]
							, dadosProduto[8]);
					e.cadastraFone(fone);
				}
				
				
			break;
			
			case 8:
				
				if(dadosProduto[4].isEmpty() || dadosProduto[5].isEmpty() || dadosProduto[6].isEmpty() || dadosProduto[7].isEmpty() || dadosProduto[8].isEmpty()) {
					return false;
				} else {
					
					if(dadosProduto[6].equals("s")) {
						filtroRuido = true;
					} else if(dadosProduto[6].equals("n")) {
						filtroRuido = false;
					} else {
						return false;
					}
					
					peso = Double.parseDouble(dadosProduto[4]);
					filtroRuido = Boolean.parseBoolean(dadosProduto[6]);
					fone = new Fone(dadosProduto[0]
							, dadosProduto[1]
							, valor
							, dadosProduto[3]
							, peso
							, dadosProduto[5]
							, filtroRuido
							, dadosProduto[7]
							, dadosProduto[8]);
					e.editaFone(fone, pos);
				}
				
			break;
		}
		
		return true;
	}
}
