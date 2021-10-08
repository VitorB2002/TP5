package controle;

import modelo.*;

/**
 * Manipula e valida os dados do cliente para efetuar cadastro ou edi��o
 * @author Vitor
 * @version 1.0
 */

public class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * Inicia o banco de dados cadastrando 5 clientes pr� definidos
	 */
	
	public ControleDados() {
		d.gerarDados();
	}

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}
	
	/**
	 * Valida os dados para cadastrar ou editar um Cliente
	 * @param dadosCliente passa todos os dados necess�rios para construir um cliente na forma de strings
	 * @param opcao informa para o metodo se ser� realizado um cadastro ou uma edi��o
	 * @param pos informa a posi��o do objeto Cliente na lista para que o mesmo seja alterado
	 * @return verdadeiro ou falso para indicar o sucesso ou falha do cadastro/edi��o do cliente
	 */
	
	public boolean editarCadastrarCliente(String[] dadosCliente, int opcao, int pos) {
		
		if(opcao == 1) {
			
			//Valida��o de Strings cpf e telefone
			if(dadosCliente[0].isEmpty() || dadosCliente[1].isEmpty() || dadosCliente[2].isEmpty() || dadosCliente[3].isEmpty() || dadosCliente[4].isEmpty()) {
				return false;
				
			} else {
				
				//Verifica se o telefone e cpf apenas possuem n�meros
				if(dadosCliente[1].matches("[0-9]+") && dadosCliente[4].matches("[0-9]+")) {
					Cliente c = new Cliente(dadosCliente[0],dadosCliente[1],dadosCliente[2],dadosCliente[3],dadosCliente[4]);
					d.cadastraCliente(c);
					return true;
				} else {
					return false;
				}
				
			}
				
		}	else {
			
			Cliente c = new Cliente(dadosCliente[0],dadosCliente[1],dadosCliente[2],dadosCliente[3],dadosCliente[4]);
			
			//Valida��o de Strings cpf e telefone
			if(dadosCliente[1].matches("[0-9]+") && dadosCliente[4].matches("[0-9]+")) {
					d.editaCliente(c, pos);
					return true;
				} else {
					return false;
				}
			
		}
		
	}
	
}