package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controle.*;

public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Acessórios p/ Celular");
	private static JLabel titulo = new JLabel("MENU");
	private static JButton clientes = new JButton("Clientes");
	private static JButton produto = new JButton("Produtos");
	private static JButton venda = new JButton("Vendas");
	private static JButton relatorio = new JButton("Relatorios");
	private static JButton historico = new JButton("Historicos");
	private static JButton ajuda = new JButton("Ajuda");
	private static String[] dadosCliente = new String[5];
	private static ControleDados dados = new ControleDados();
	private static ControleEstoque estoque = new ControleEstoque(); 
	
	public TelaMenu() {
		
		//Titulo inicial
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 150, 30);
		
		
		//Tamanho e posicionamento dos botões
		produto.setBounds(140, 100, 100, 30);
		relatorio.setBounds(140, 150, 100, 30);
		clientes.setBounds(140, 50, 100, 30);
		historico.setBounds(140, 200, 100, 30);
		venda.setBounds(140, 250, 100, 30);
		ajuda.setBounds(140, 300, 100, 30);
		
		//Adicionando componentes ao Jframe
		janela.setLayout(null);
		janela.add(venda);
		janela.add(ajuda);
		janela.add(titulo);
		janela.add(clientes);
		janela.add(produto);
		janela.add(historico);
		janela.add(relatorio);
		
		janela.setSize(400, 400);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaMenu menu = new TelaMenu();
		
		//Leitor de ação
		clientes.addActionListener(menu);
		relatorio.addActionListener(menu);
		produto.addActionListener(menu);
		historico.addActionListener(menu);
		venda.addActionListener(menu);
		ajuda.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == clientes)
			new TelaCliente().mostrarTela(dados);
		
		if(src == produto)
			new TelaProduto().mostrarTela(estoque);
		
		if(src == relatorio)
			mensagemInfo();
		if(src == historico)
			mensagemInfo();
		
		if(src == venda)
			new TelaVenda().mostrarTela(estoque, dados);
		
		if(src == ajuda)
			mensagemAjuda();
	
	}
	
	public void mensagemAjuda() {
			
			JOptionPane.showMessageDialog(null, "O programa possui 5 objetos de cada cadastrados" 
			+ "\nAs vendas não possuem dados pré cadastrados", null, 
					JOptionPane.INFORMATION_MESSAGE);
			
		}
	
	public void mensagemInfo() {
		
		JOptionPane.showMessageDialog(null, "Função de Prioridade 3" 
				+ "\nNão implementado ainda", null, 
						JOptionPane.INFORMATION_MESSAGE);
		}

}
