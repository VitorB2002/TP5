package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controle.*;

class TesteCrudProduto {
	
	private ControleEstoque estoque = new ControleEstoque();
	String[] s = new String[9];
	String[] s2 = new String[9];
	String[] s3 = new String[9];
	int aux;
	int posicao;
	boolean sucesso;
	
	/*
	 * Obs: O String[] que chega neste metodo já está tratado por um try catch na view
	 * Sendo assim não há possibilidade dos campos que recebem números ou boolean
	 * Não estejam de acordo com seus respectivos tipos
	 * O metodo apenas converte o String[] para criar um objeto
	 * */
	
	//Para o metodo de cadastro a posição é irrelevante, logo podemos inserir qualquer número
	@Test
	void testCadastroProduto() {
		
		/*
		 * O parametro aux informa para o metodo com que tipo de objeto queremos lidar
		 * Capa = 1, Carregador = 3, Pelicula = 5 e Fone = 7
		 * */
		aux = 1;
		
		//Teste para Capas
		String[] s = {"Capinha", "Anti-Impacto", "25.6", "ASD", "Silicone", "A8", "0.5", "Vermelho"};
		assertTrue(estoque.editarCadastrarProduto(s, aux, 0));
		
		String[] s2 = {"Capinha", "", "25.6", "ASD", "Silicone", "A8", "0.5", "Vermelho"};
		assertFalse(estoque.editarCadastrarProduto(s2, aux, 0));
		
		String[] s3 = {"","","","","","","",""};
		assertFalse(estoque.editarCadastrarProduto(s3, aux, 0));
		
	}
	
	//As exigências para edição são iguais as exigências para o cadastro
	@Test
	void testEdicaoProduto() {
		
		//O aux exerce a mesma função aqui porém agora Capa = 2, Carregador = 4, Pelicula = 6 e Fone = 8
		aux = 2;
		
		//A posição aqui é importante, estaremos sobrescrevendo o modelo Capa0 posicao = 0
		posicao = 0;
		
		//Verificando que Capinha não ocupa a posição 0 do ArrayList
		assertFalse("Capinha".equals(estoque.getEstoque().getCapas().get(posicao).getModelo()));
		
		String[] s = {"Capinha", "Anti-Impacto","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		
		//Comprovando edição
		assertTrue(estoque.editarCadastrarProduto(s, 2, 0));
		assertTrue("Capinha".equals(estoque.getEstoque().getCapas().get(posicao).getModelo()));
		
		String[] s2 = {"Capinha", "","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		assertFalse(estoque.editarCadastrarProduto(s2, 2, 0));
		
		String[] s3 = {"","","","","","","",""};
		assertFalse(estoque.editarCadastrarProduto(s3, 2, 0));
		
		
		
	}
	
	//O metodo deletar não retorna boolean como os outros, logo o teste é um pouco diferente
	@Test
	void testDeletaProduto() {
		
		//O aux exerce a mesma função aqui porém agora Capa = 1, Carregador = 2, Pelicula = 3 e Fone = 4
		aux = 1;
		posicao = 0;
		
		//Obtendo o modelo do produto, o index 0 é equivalente ao modelo pré cadastrado = Capa0
		s[0] = estoque.getEstoque().getCapas().get(0).getModelo();
		
		//Deletando o produto, no caso o modelo Capa0
		estoque.deletaProduto(posicao, aux);
		
		/*
		 * Como o produto Capa0 foi deletado, todos os objetos subsequentes do ArrayList
		 * são movimentados 1 index para a esquerda.
		 * Logo na comparação abaixo estaremos comparando Capa0 com Capa1
		 * o que retornará false
		 * */
		
		sucesso = s[0].equals(estoque.getEstoque().getCapas().get(0).getModelo());
		
		assertFalse(sucesso);
	}

}
