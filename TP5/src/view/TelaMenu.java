package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controle.*;

/**
 * Cria a primeira tela e constroi o estoque e os dados a partir de dados pr� cadastrados
 * @author Vitor
 * @version 1.0
 */

public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Acess�rios p/ Celular");
	private static JLabel titulo = new JLabel("MENU");
	private static JButton clientes = new JButton("Clientes");
	private static JButton produto = new JButton("Produtos");
	private static JButton venda = new JButton("Vendas");
	private static JButton relatorio = new JButton("Relatorios");
	private static JButton historico = new JButton("Historicos");
	private static JButton ajuda = new JButton("Ajuda");
	private static ControleDados dados = new ControleDados();
	private static ControleEstoque estoque = new ControleEstoque(); 
	
	/**
	 *Constr�i a tela inicial do c�digo
	 */
	
	public TelaMenu() {
		
		//Titulo inicial
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 10, 150, 30);
		
		
		//Tamanho e posicionamento dos bot�es
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
	
	/**
	 * Inicia a main
	 * @param args Par�metro padr�o da main
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TelaMenu menu = new TelaMenu();
		
		//Leitor de a��o
		clientes.addActionListener(menu);
		relatorio.addActionListener(menu);
		produto.addActionListener(menu);
		historico.addActionListener(menu);
		venda.addActionListener(menu);
		ajuda.addActionListener(menu);
	}
	
	/**
	 * Define o que acontece quando um bot�o foi apertado
	 * @param e evento gerado ao apertar um JButton
	 */
	
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
	
	/**
	 *Gera uma mensagem para mostrar ao usu�rio o que o programa faz
	 */
	
	public void mensagemAjuda() {
			
			JOptionPane.showMessageDialog(null, "O programa possui 5 objetos de cada cadastrados" 
			+ "\nAs vendas n�o possuem dados pr� cadastrados", null, 
					JOptionPane.INFORMATION_MESSAGE);
			
		}
	
	/**
	 *Gera uma mensagem para informar as partes n�o implementadas
	 */
	
	public void mensagemInfo() {
		
		JOptionPane.showMessageDialog(null, "Fun��o de Prioridade 3" 
				+ "\nN�o implementado ainda", null, 
						JOptionPane.INFORMATION_MESSAGE);
		}

}
