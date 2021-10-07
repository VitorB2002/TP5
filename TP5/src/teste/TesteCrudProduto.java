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
	 * Obs: O String[] que chega neste metodo j� est� tratado por um try catch na view
	 * Sendo assim n�o h� possibilidade dos campos que recebem n�meros ou boolean
	 * N�o estejam de acordo com seus respectivos tipos
	 * O metodo apenas converte o String[] para criar um objeto
	 * */
	
	//Para o metodo de cadastro a posi��o � irrelevante, logo podemos inserir qualquer n�mero
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
	
	//As exig�ncias para edi��o s�o iguais as exig�ncias para o cadastro
	@Test
	void testEdicaoProduto() {
		
		//O aux exerce a mesma fun��o aqui por�m agora Capa = 2, Carregador = 4, Pelicula = 6 e Fone = 8
		aux = 2;
		
		//A posi��o aqui � importante, estaremos sobrescrevendo o modelo Capa0 posicao = 0
		posicao = 0;
		
		//Verificando que Capinha n�o ocupa a posi��o 0 do ArrayList
		assertFalse("Capinha".equals(estoque.getEstoque().getCapas().get(posicao).getModelo()));
		
		String[] s = {"Capinha", "Anti-Impacto","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		
		//Comprovando edi��o
		assertTrue(estoque.editarCadastrarProduto(s, 2, 0));
		assertTrue("Capinha".equals(estoque.getEstoque().getCapas().get(posicao).getModelo()));
		
		String[] s2 = {"Capinha", "","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		assertFalse(estoque.editarCadastrarProduto(s2, 2, 0));
		
		String[] s3 = {"","","","","","","",""};
		assertFalse(estoque.editarCadastrarProduto(s3, 2, 0));
		
		
		
	}
	
	//O metodo deletar n�o retorna boolean como os outros, logo o teste � um pouco diferente
	@Test
	void testDeletaProduto() {
		
		//O aux exerce a mesma fun��o aqui por�m agora Capa = 1, Carregador = 2, Pelicula = 3 e Fone = 4
		aux = 1;
		posicao = 0;
		
		//Obtendo o modelo do produto, o index 0 � equivalente ao modelo pr� cadastrado = Capa0
		s[0] = estoque.getEstoque().getCapas().get(0).getModelo();
		
		//Deletando o produto, no caso o modelo Capa0
		estoque.deletaProduto(posicao, aux);
		
		/*
		 * Como o produto Capa0 foi deletado, todos os objetos subsequentes do ArrayList
		 * s�o movimentados 1 index para a esquerda.
		 * Logo na compara��o abaixo estaremos comparando Capa0 com Capa1
		 * o que retornar� false
		 * */
		
		sucesso = s[0].equals(estoque.getEstoque().getCapas().get(0).getModelo());
		
		assertFalse(sucesso);
	}

}
