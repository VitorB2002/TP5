package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import controle.*;

class TesteCrudCliente {
	
	private ControleDados dados = new ControleDados();
	String[] s = new String[5];
	String[] s2 = new String[5];
	private int aux;
	private int posicao;
	
	/*
	 * O metodo editarCadastrarCliente realiza o cadastro e a edição do mesmo
	 * Para isso o mesmo valida se os dados recebidos são validos
	 * Ou seja:
	 * Nenhum campo deve estar vazio 
	 * Os campos cpf e telefone apenas recebem números
	 */
	
	@Test
	void testCadastroCliente() {
		
		//Aux informa para o metodo se queremos cadastrar ou editar, aux = 1 (cadastra), aux!= 1 (edita)
		aux = 1;
		
		String[] s = {"Vitor Borges", "05395016201", "Q.18 C.08", "vitorb.santos@gmail.com", "61992151043"};
		
		assertTrue(dados.editarCadastrarCliente(s, aux, 0));
		
		String[] s2 = {"Vitor Borges", "cpf", "Q.18 C.08", "vitorb.santos@gmail.com", "telefone"};
		
		assertFalse(dados.editarCadastrarCliente(s2, aux, 0));
		
	}
	
	//O metodo de edição realiza as mesmas validações logo o String[] s2 não pode editar um cliente
	@Test
	void testEdicaoCliente() {
		
		aux = 2;
		posicao = 0;//O cliente cadastrado no index 0 é o Cliente0
		
		assertFalse("Vitor Borges".equals(dados.getDados().getClientes().get(posicao).getNome()));
		
		String[] s = {"Vitor Borges", "05395016201", "Q.18 C.08", "vitorb.santos@gmail.com", "61992151043"};
		
		assertTrue(dados.editarCadastrarCliente(s, aux, posicao));
		assertTrue("Vitor Borges".equals(dados.getDados().getClientes().get(posicao).getNome()));
		
		String[] s2 = {"Vitor Borges", "cpf", "Q.18 C.08", "vitorb.santos@gmail.com", "telefone"};
		
		assertFalse(dados.editarCadastrarCliente(s2, aux, posicao));
	}

}
