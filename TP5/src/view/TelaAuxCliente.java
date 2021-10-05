package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import controle.*;

public class TelaAuxCliente implements ActionListener{
	
	private static JFrame janela = new JFrame();
	private static JLabel titulo = new JLabel();
	private static JLabel nome = new JLabel("Nome: ");
	private static JLabel cpf = new JLabel("CPF: ");
	private static JLabel endereco = new JLabel("Endereço: ");
	private static JLabel email = new JLabel("Email: ");
	private static JLabel telefone = new JLabel("Telefone: ");
	private static JButton salvar = new JButton("Salvar");
	private static JButton buscar = new JButton("Buscar");
	private static JButton ajuda = new JButton("Ajuda");
	private static ControleDados dados;
	private static JList<String> listaNomes = new JList<String>();
	private static JButton editar = new JButton("Editar");
	private static JLabel edita = new JLabel();
	private static String[] dadosCliente = new String[5];
	private int posicao;
	private JTextField inNome;
	private JTextField inCpf;
	private JTextField inEndereco;
	private JTextField inEmail;
	private JTextField inTelefone;
	
	
	int qtdClientes;
	int opcao;
	
	public void auxClient(int op, ControleDados d){
		
		opcao = op;
		dados = d;
		
		switch(opcao) {
			
			//Listar clientes
			case 1:
				
				janela = new JFrame("Lista de clientes");
				//Obtendo nomes para a lista
				qtdClientes = dados.getDados().getClientes().size();
				String[] nomes = new String[qtdClientes];
				
				//Array com nome dos clientes obtido
				for(int i = 0; i < qtdClientes; i++) {
					nomes[i] = (dados.getDados().getClientes().get(i).getNome());
				}
				
				//Jlist para view criado
				listaNomes = new JList<String>(nomes);
				listaNomes.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
				listaNomes.setVisibleRowCount(10);
				
				//Barra de rolagem para a lista
				JScrollPane scroll = new JScrollPane(listaNomes);   
		        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		        scroll.setBounds(20, 50, 200, 150);   
				
				janela.getContentPane().setLayout(new FlowLayout());
				janela.getContentPane().add(scroll);
				janela.setSize(300, 250);
				janela.setVisible(true);
				
			break;
			
			//Cadastro
			case 2:
				
				janela = new JFrame("CADASTRO");
				titulo = new JLabel("--Cadastrar--");
				salvar.setBounds(120, 290, 75, 25);
				ajuda.setBounds(230, 290, 75, 25);
				
				inNome = new JTextField(100);
				inCpf = new JTextField(11);
				inEndereco = new JTextField(100);
				inEmail = new JTextField(100);
				inTelefone = new JTextField(11);
				
				inNome.setBounds(120, 80, 200, 25);
				inCpf.setBounds(120, 120, 200, 25);
				inEndereco.setBounds(120, 160, 200, 25);
				inEmail.setBounds(120, 200, 200, 25);
				inTelefone.setBounds(120, 240, 200, 25);
				
				nome.setBounds(50, 80, 200, 25);
				cpf.setBounds(50, 120, 200, 25);
				endereco.setBounds(50, 160, 200, 25);
				email.setBounds(50, 200, 200, 25);
				telefone.setBounds(50, 240, 200, 25);
				
				
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(135, 10, 150, 30);
				
				janela.setLayout(null);
				janela.add(titulo);
				janela.add(ajuda);
				janela.add(salvar);
				janela.add(inNome);
				janela.add(inCpf);
				janela.add(inEndereco);
				janela.add(inEmail);
				janela.add(inTelefone);
				janela.add(nome);
				janela.add(cpf);
				janela.add(endereco);
				janela.add(email);
				janela.add(telefone);
				janela.setSize(400, 400);
				janela.setVisible(true);
				
				salvar.addActionListener(this);
				ajuda.addActionListener(this);
			break;
			
			//Busca
			case 3:
				
				janela = new JFrame("BUSCAR");
				titulo = new JLabel("--Busca--");
				inNome = new JTextField(100);
				buscar.setBounds(120, 100, 75, 25);
				
				
				nome.setBounds(50, 70, 200, 25);
				inNome.setBounds(120, 70, 200, 25);
				
				 
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(145, 10, 150, 30);
				
				janela.setLayout(null);
				janela.add(titulo);
				janela.add(buscar);
				janela.add(nome);
				janela.add(inNome);
				janela.setSize(400, 200);
				janela.setVisible(true);
				
				buscar.addActionListener(this);
				
			break;	
		}
		
		
	}
	
	public void editaCliente(int pos) {
		janela = new JFrame("Dados Cliente");
		edita = new JLabel("DADOS CLIENTE");
		editar = new JButton("Editar");
		editar.setBounds(120, 290, 75, 25);
		edita.setFont(new Font("Arial", Font.BOLD, 20));
		
		nome.setBounds(50, 80, 200, 25);
		cpf.setBounds(50, 120, 200, 25);
		endereco.setBounds(50, 160, 200, 25);
		email.setBounds(50, 200, 200, 25);
		telefone.setBounds(50, 240, 200, 25);
		
		edita.setBounds(145, 10, 150, 30);
		inNome = new JTextField(100);
		inCpf = new JTextField(11);
		inEndereco = new JTextField(100);
		inEmail = new JTextField(100);
		inTelefone = new JTextField(11);
		
		inNome.setBounds(120, 80, 200, 25);
		inCpf.setBounds(120, 120, 200, 25);
		inEndereco.setBounds(120, 160, 200, 25);
		inEmail.setBounds(120, 200, 200, 25);
		inTelefone.setBounds(120, 240, 200, 25);
		
		inNome.setText(dados.getDados().getClientes().get(pos).getNome());
		inCpf.setText(dados.getDados().getClientes().get(pos).getCpf());
		inEndereco.setText(dados.getDados().getClientes().get(pos).getEndereco());
		inEmail.setText(dados.getDados().getClientes().get(pos).getEmail());
		inTelefone.setText(dados.getDados().getClientes().get(pos).getTelefone());
		
		janela.add(nome);
		janela.add(cpf);
		janela.add(endereco);
		janela.add(email);
		janela.add(telefone);
		janela.add(editar);
		janela.add(inNome);
		janela.add(inCpf);
		janela.add(inEndereco);
		janela.add(inEmail);
		janela.add(inTelefone);
		janela.add(edita);
		janela.setLayout(null);
		janela.setSize(400,400);
		janela.setVisible(true);
		
		editar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == salvar) {
			boolean sucesso;
			dadosCliente[0] = inNome.getText();
			dadosCliente[1] = inCpf.getText();
			dadosCliente[2] = inEndereco.getText();
			dadosCliente[3] = inEmail.getText();
			dadosCliente[4] = inTelefone.getText();
			sucesso = dados.editarCadastrarCliente(dadosCliente, 1, 0);
			if(sucesso) {
				mensagemSucessoCadastro();
			}	else {
				mensagemFalhaCadastro();
			}
		}
		
		if (src == buscar) {
			
			boolean sucesso = false;
			int posicao = 0;
			
			dadosCliente[0] = inNome.getText();
			qtdClientes = dados.getDados().getClientes().size();
			
			for(int i = 0; i < qtdClientes; i++) {
				
				if (dadosCliente[0].equals(dados.getDados().getClientes().get(i).getNome())) {
					sucesso = true;
					posicao = i;
					i = qtdClientes;
				}
			}
			
			if(sucesso) {
				this.mensagemSucessoBusca();
				this.editaCliente(posicao);
			} else {
				this.mensagemFalhaBusca();
			}
		}
		
		if (src == editar) {
			String[] dadosCliente = new String[5];
			boolean sucesso = false;
			dadosCliente[0] = inNome.getText();
			dadosCliente[1] = inCpf.getText();
			dadosCliente[2] = inEndereco.getText();
			dadosCliente[3] = inEmail.getText();
			dadosCliente[4] = inTelefone.getText();
			sucesso = dados.editarCadastrarCliente(dadosCliente, 2, posicao);
			if(sucesso) {
				mensagemSucessoEditar();
			}	else {
				mensagemFalhaEditar();
			}
		}
		
		if (src == ajuda) {
			mensagemAjuda();
		}
		
	}
	
	public void mensagemAjuda() {
		JOptionPane.showMessageDialog(null, "Para cadastrar com sucesso" 
				+ "\n1 - Preencha todos os campos"
				+ "\n2 - O campo cpf deve ser preenchido apenas com números"
				+ "\n3 - O campo telefone deve ser preenchido apenas com números", null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemSucessoBusca() {
		JOptionPane.showMessageDialog(null, "Cliente encontrado!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemFalhaBusca() {
		JOptionPane.showMessageDialog(null, "Cliente não encontrado!", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoEditar() {
		JOptionPane.showMessageDialog(null, "Cliente editado!" 
				+ "\nO mesmo pode ser buscado"
				+ "\nOu pode ser visto na lista", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemFalhaEditar() {
		JOptionPane.showMessageDialog(null, "Falha ao editar!" 
				+ "\nOs campos cpf e telefone apenas aceitam números(0-9)" , null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemSucessoCadastro() {
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!" 
		+ "\nO mesmo pode ser visto na Lista agora", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
		
	}
	
	public void mensagemFalhaCadastro() {
		JOptionPane.showMessageDialog(null, "Falha ao cadastrar!" 
				+ "\nOs campos cpf e telefone apenas aceitam números(0-9)"
				+ "\nOu um(ou mais) dos campos está vazio", null, 
				JOptionPane.ERROR_MESSAGE);
		janela.dispose();
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaNomes) {
			
		}

	}
	
	
	
}
