package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

/**
 * Cria a tela para manipulação dos produtos
 * @author Vitor
 * @version 1.0
 */

public class TelaProduto implements ActionListener{

	private JFrame janela = new JFrame("Gestor de Produtos");
	private JLabel titulo = new JLabel("PRODUTOS");
	private JButton cadastro = new JButton("Cadastro");
	private JButton busca = new JButton("Busca");
	private JButton deleta = new JButton("Deletar");
	private JButton ajuda = new JButton("Ajuda");
	private static ControleEstoque estoque;
	
	/**
	 * Constrói a tela produtos
	 * @param e um estoque que armazena e manipula todos os produtos e vendas
	 */
	public void mostrarTela(ControleEstoque e) {
		estoque = e;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(135, 30, 150, 30);
		
		cadastro.setBounds(140, 90, 100, 30);
		busca.setBounds(140, 140, 100, 30);
		deleta.setBounds(140, 190, 100, 30);
		ajuda.setBounds(140, 240, 100, 30);
		
		janela.add(titulo);
		janela.setLayout(null);
		janela.setSize(400, 400);
		janela.add(cadastro);
		janela.add(busca);
		janela.add(deleta);
		janela.add(ajuda);
		
		janela.setVisible(true);
		cadastro.addActionListener(this);
		busca.addActionListener(this);
		deleta.addActionListener(this);
		ajuda.addActionListener(this);
		
	}
	
	/**
	 * Define o que acontece quando um botão foi apertado
	 * @param e evento gerado ao apertar um JButton
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == cadastro) {
			new TelaCadastro().cadastra(estoque);
		}
		
		if (src == busca) {
			new TelaBusca().buscaProduto(estoque);
		}
		
		if (src == deleta) {
			new TelaDeleta().buscaProduto(estoque);
		}
		
		if (src == ajuda) {
			mensagemAjuda();
		}
		
	}
	
	/**
	 * Gera uma mensagem de ajuda para guiar o usuário
	 */
	
	public void mensagemAjuda() {
		JOptionPane.showMessageDialog(null, "Nesta tela será possível manipular produtos" 
				+ "\nEscolha um dos 4 tipos de produto"
				+ "\nE você será capaz de realizar as funções mostradas", null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
	
}