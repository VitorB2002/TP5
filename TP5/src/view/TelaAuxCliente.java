package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import controle.*;

public class TelaAuxCliente implements ActionListener{
	
	private JFrame lista = new JFrame("Lista Clientes");
	private JFrame edita = new JFrame("Editar Cliente");
	private JFrame busca = new JFrame("Buscar Cliente");
	private JFrame cadastra = new JFrame("Cadastrar Clientes");
	private JLabel titulo = new JLabel();
	private JLabel nome = new JLabel("Nome: ");
	private JLabel cpf = new JLabel("CPF: ");
	private JLabel endereco = new JLabel("Endereço: ");
	private JLabel email = new JLabel("Email: ");
	private JLabel telefone = new JLabel("Telefone: ");
	private JButton salvar = new JButton("Salvar");
	private JButton buscar = new JButton("Buscar");
	private JButton ajuda = new JButton("Ajuda");
	private JButton refresh = new JButton("Refresh");
	private static ControleDados dados;
	private JList<String> listaNomes = new JList<String>();
	private JButton editar = new JButton("Editar");
	private String[] dadosCliente;
	private int posicao;
	private JTextField inNome;
	private JTextField inCpf;
	private JTextField inEndereco;
	private JTextField inEmail;
	private JTextField inTelefone;
	private boolean sucesso;
	private int qtdClientes;
	private int opcao;
	private int auxAjuda;
	
	public void auxClient(int op, ControleDados d, String[] vetor) {
		
		dados = d;
		opcao = op;
		dadosCliente = vetor;
		
		switch(opcao) {
		
		case 1:
			
			listaCliente();
			
		break;
		
		case 2:
			
			auxAjuda = 2;
			cadastraCliente();
			
		break;
		
		case 3:
			
			auxAjuda = 3;
			buscarCliente();
			
		break;
		
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == salvar) {
			
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
		
		if(src == buscar) {
			
			posicao = 0;
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
				mensagemSucessoBusca();
				auxAjuda = 4;
				editaCliente(posicao);
			} else {
				mensagemFalhaBusca();
			}
		}
		
		if(src == editar) {
			
			dadosCliente[0] = inNome.getText();
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
			sucesso = dados.editarCadastrarCliente(dadosCliente, opcao, posicao);
		}
		
		if(src == refresh) {
			lista.dispose();
			listaCliente();
		}
		
		if(src == ajuda) {
			mensagemAjuda(auxAjuda);
		}
		
	}
	
	public void cadastraCliente() {
		cadastra = new JFrame("CADASTRO");
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
		
		cadastra.setLayout(null);
		cadastra.add(titulo);
		cadastra.add(ajuda);
		cadastra.add(salvar);
		cadastra.add(inNome);
		cadastra.add(inCpf);
		cadastra.add(inEndereco);
		cadastra.add(inEmail);
		cadastra.add(inTelefone);
		cadastra.add(nome);
		cadastra.add(cpf);
		cadastra.add(endereco);
		cadastra.add(email);
		cadastra.add(telefone);
		cadastra.setSize(400, 400);
		cadastra.setVisible(true);
		
		salvar.addActionListener(this);
		ajuda.addActionListener(this);
	}
	
	public void editaCliente(int pos) {
		edita = new JFrame("Dados Cliente");
		titulo = new JLabel("DADOS CLIENTE");
		titulo.setFont(new Font("Arial", Font.BOLD, 15));
		editar = new JButton("Editar");
		editar.setBounds(120, 290, 75, 25);
		ajuda.setBounds(230, 290, 75, 25);
		
		
		nome.setBounds(50, 80, 200, 25);
		cpf.setBounds(50, 120, 200, 25);
		endereco.setBounds(50, 160, 200, 25);
		email.setBounds(50, 200, 200, 25);
		telefone.setBounds(50, 240, 200, 25);
		
		titulo.setBounds(145, 40, 150, 30);
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
		
		edita.add(nome);
		edita.add(cpf);
		edita.add(endereco);
		edita.add(email);
		edita.add(telefone);
		edita.add(editar);
		edita.add(ajuda);
		edita.add(inNome);
		edita.add(inCpf);
		edita.add(inEndereco);
		edita.add(inEmail);
		edita.add(inTelefone);
		edita.add(titulo);
		edita.setLayout(null);
		edita.setSize(400,400);
		edita.setVisible(true);
		
		editar.addActionListener(this);
		ajuda.addActionListener(this);
		
	}
	
	public void buscarCliente() {
		
		busca = new JFrame("BUSCAR");
		titulo = new JLabel("--Busca--");
		inNome = new JTextField(100);
		buscar.setBounds(120, 100, 75, 25);
		ajuda.setBounds(200, 100, 75, 25);;
		
		nome.setBounds(50, 70, 200, 25);
		inNome.setBounds(120, 70, 200, 25);
		
		 
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(145, 10, 150, 30);
		
		busca.setLayout(null);
		busca.add(titulo);
		busca.add(buscar);
		busca.add(ajuda);
		busca.add(nome);
		busca.add(inNome);
		busca.setSize(400, 200);
		busca.setVisible(true);
		
		buscar.addActionListener(this);
		ajuda.addActionListener(this);
	}
	
	public void listaCliente() {
		lista = new JFrame("Lista de clientes");
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
		
        lista.add(refresh);
		lista.getContentPane().setLayout(new FlowLayout());
		lista.getContentPane().add(scroll);
		lista.setSize(300, 250);
		lista.setVisible(true);
		refresh.addActionListener(this);
	}
	
	public void mensagemAjuda(int auxAjuda) {
		switch(auxAjuda) {
			
			case 2:
				JOptionPane.showMessageDialog(null, "Para cadastrar com sucesso" 
						+ "\n1 - Preencha todos os campos"
						+ "\n2 - O campo cpf deve ser preenchido apenas com números"
						+ "\n3 - O campo telefone deve ser preenchido apenas com números", null, 
								JOptionPane.INFORMATION_MESSAGE);
			break;
			
			case 3:
				JOptionPane.showMessageDialog(null, "Para buscar com sucesso" 
						+ "\n1 - Preencha o campo com um cliente cadastrado"
						+ "\n2 - Letras em caixa alta são consideradas na busca", null, 
								JOptionPane.INFORMATION_MESSAGE);
			break;
			
			case 4:
				JOptionPane.showMessageDialog(null, "Para editar com sucesso" 
						+ "\n1 - Preencha todos os campos"
						+ "\n2 - O campo cpf deve ser preenchido apenas com números"
						+ "\n3 - O campo telefone deve ser preenchido apenas com números", null, 
								JOptionPane.INFORMATION_MESSAGE);
			break;
			
		}
		
	}
	
	public void mensagemSucessoBusca() {
		JOptionPane.showMessageDialog(null, "Cliente encontrado!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		busca.dispose();
	}
	
	public void mensagemFalhaBusca() {
		JOptionPane.showMessageDialog(null, "Cliente não encontrado!"
				+ "\nInsira um cliente existente", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoEditar() {
		JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!" 
				+ "\nO mesmo pode ser buscado"
				+ "\nOu pode ser visto na lista", null, 
				JOptionPane.INFORMATION_MESSAGE);
		edita.dispose();
	}
	
	public void mensagemFalhaEditar() {
		JOptionPane.showMessageDialog(null, "Falha ao editar!"
				+ "\nNenhum campo deve estar Vazio"
				+ "\nOs campos cpf e telefone apenas aceitam números(0-9)" , null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		
		JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!" 
		+ "\nO mesmo pode ser visto na Lista agora", null, 
				JOptionPane.INFORMATION_MESSAGE);
		cadastra.dispose();
		
	}
	
	public void mensagemFalhaCadastro() {
		JOptionPane.showMessageDialog(null, "Falha ao cadastrar!" 
				+ "\nOs campos cpf e telefone apenas aceitam números(0-9)"
				+ "\nOu um(ou mais) dos campos está vazio", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaNomes) {
			
		}

	}
	
	
	
}
