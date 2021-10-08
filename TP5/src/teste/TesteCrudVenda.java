package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controle.*;

class TesteCrudVenda {
	
	private ControleEstoque estoque = new ControleEstoque();
	private ControleDados dados = new ControleDados();
	
	String[] dadosCliente = new String[5];
	String[] dadosProduto = new String[9];
	private int aux;//Aux informa qual o tipo de produto vendido Capa = 1, Carregador = 2, Pelicula = 3, Fone = 4
	
	//Os dados que chegam para este metódo já são validados por códigos na view, logo o msm sempre retorna true
	@Test
	void testCadastroVenda() {
		
		//Passando dados do Cliente0 para o String[]
		dadosCliente[0] = dados.getDados().getClientes().get(0).getNome();
		dadosCliente[1] = dados.getDados().getClientes().get(0).getCpf();
		dadosCliente[2] = dados.getDados().getClientes().get(0).getEndereco();
		dadosCliente[3] = dados.getDados().getClientes().get(0).getEmail();
		dadosCliente[4] = dados.getDados().getClientes().get(0).getTelefone();
		
		dadosProduto[0] = estoque.getEstoque().getCarregadores().get(0).getModelo();
		dadosProduto[1] = estoque.getEstoque().getCarregadores().get(0).getDescricao();
		dadosProduto[2] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getValor());
		dadosProduto[3] = estoque.getEstoque().getCarregadores().get(0).getMarca();
		dadosProduto[4] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getTamanhoCabo()); 
		dadosProduto[5] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getPotencia());
		aux = 2;
		
		assertTrue(estoque.cadastrarVenda(dadosCliente, dadosProduto, aux));
	}
	
	//Os dados que chegam para este metódo já são validados por códigos na view, logo o msm sempre retorna true
	@Test
	void testEdicaoVenda() {
		
		String[] dadosProduto = {"A8","Turbo","25.9","Sam","1.5","2.5"};
		
		//Primeiro Cadastramos uma venda
		dadosCliente[0] = dados.getDados().getClientes().get(0).getNome();
		dadosCliente[1] = dados.getDados().getClientes().get(0).getCpf();
		dadosCliente[2] = dados.getDados().getClientes().get(0).getEndereco();
		dadosCliente[3] = dados.getDados().getClientes().get(0).getEmail();
		dadosCliente[4] = dados.getDados().getClientes().get(0).getTelefone();
		
		dadosProduto[0] = estoque.getEstoque().getCarregadores().get(0).getModelo();
		dadosProduto[1] = estoque.getEstoque().getCarregadores().get(0).getDescricao();
		dadosProduto[2] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getValor());
		dadosProduto[3] = estoque.getEstoque().getCarregadores().get(0).getMarca();
		dadosProduto[4] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getTamanhoCabo()); 
		dadosProduto[5] = Double.toString(estoque.getEstoque().getCarregadores().get(0).getPotencia());
		aux = 2;
		
		estoque.cadastrarVenda(dadosCliente, dadosProduto, aux);
		
		//Alterando dado nome do array
		dadosCliente[0] = "Vitor";
		estoque.editarVenda(dadosCliente, dadosProduto, aux, 0);
		
		//Verificando se o nome foi alterado
		assertFalse("Cliente0".equals(estoque.getEstoque().getVendas().get(0).getCliente().getNome()));
		
	}

}
