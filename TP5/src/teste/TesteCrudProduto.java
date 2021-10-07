package teste;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controle.*;

class TesteCrudProduto {
	
	private ControleEstoque estoque = new ControleEstoque();
	String[] s = new String[9];
	String[] s2 = new String[9];
	String[] s3 = new String[9];
	/*
	 * Obs: O String[] que chega neste metodo j� est� tratado por um try catch na view
	 * Sendo assim n�o h� possibilidade dos campos que recebem n�meros ou boolean
	 * N�o estejam de acordo com seus respectivos tipos
	 * O metodo apenas converte o String[] para criar um objeto*/
	
	@Test
	void testCadastroProduto() {
		
		//Teste para Capas
		String[] s = {"Capinha", "Anti-Impacto", "25.6", "ASD", "Silicone", "A8", "0.5", "Vermelho"};
		assertTrue(estoque.editarCadastrarProduto(s, 1, 0));
		
		String[] s2 = {"Capinha", "", "25.6", "ASD", "Silicone", "A8", "0.5", "Vermelho"};
		assertFalse(estoque.editarCadastrarProduto(s2, 1, 0));
		
		String[] s3 = {"","","","","","","",""};
		assertFalse(estoque.editarCadastrarProduto(s3, 1, 0));
		
	}
	
	//As exig�ncias para edi��o s�o iguais as exig�ncias para oo cadastro
	@Test
	void testEdicaoProduto() {
		
		//Teste para Capas
		String[] s = {"Capinha", "Anti-Impacto","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		assertTrue(estoque.editarCadastrarProduto(s, 2, 0));
		
		String[] s2 = {"Capinha", "","25.6","ASD","Silicone","A8","0.5","Vermelho"};
		assertFalse(estoque.editarCadastrarProduto(s2, 2, 0));
		
		String[] s3 = {"","","","","","","",""};
		assertFalse(estoque.editarCadastrarProduto(s3, 2, 0));
		
	}

}
