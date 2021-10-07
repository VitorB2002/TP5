package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaProduto implements ActionListener{
	
	private JFrame janela = new JFrame("Gestor de Produtos");
	private JLabel titulo = new JLabel("PRODUTOS");
	private JButton cadastro = new JButton("Cadastro");
	private JButton busca = new JButton("Busca");
	private JButton deleta = new JButton("Deletar");
	private JButton ajuda = new JButton("Ajuda");
	private static ControleEstoque estoque;
	
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
	
	public void mensagemAjuda() {
		JOptionPane.showMessageDialog(null, "Nesta tela será possível manipular produtos" 
				+ "\nEscolha um dos 4 tipos de produto"
				+ "\nE você será capaz de realizar as funções mostradas", null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
	
}