package controle;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.gerarDados();
	}

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}
	
	public boolean editarCadastrarCliente(String[] dadosCliente, int opcao, int pos) {
		
		if(opcao == 1) {
			
			//Validação de Strings cpf e telefone
			if(dadosCliente[0].isEmpty() || dadosCliente[1].isEmpty() || dadosCliente[2].isEmpty() || dadosCliente[3].isEmpty() || dadosCliente[4].isEmpty()) {
				return false;
				
			} else {
				
				if(dadosCliente[1].matches("[0-9]+") && dadosCliente[4].matches("[0-9]+")) {
					System.out.println(dadosCliente[0]);
					System.out.println("True");
					Cliente c = new Cliente(dadosCliente[0],dadosCliente[1],dadosCliente[2],dadosCliente[3],dadosCliente[4]);
					d.cadastraCliente(c);
					return true;
				} else {
					System.out.println("False");
					return false;
				}
				
			}
			
			
			
		}	else {
			
			Cliente c = new Cliente(dadosCliente[0],dadosCliente[1],dadosCliente[2],dadosCliente[3],dadosCliente[4]);
			
			//Validação de Strings cpf e telefone
			if(dadosCliente[1].matches("[0-9]+") && dadosCliente[4].matches("[0-9]+")) {
					System.out.println("True");
					d.editaCliente(c, pos);
					return true;
				} else {
					System.out.println("False");
					return false;
				}
			
		}
		
	}
	
}