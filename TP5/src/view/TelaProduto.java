package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaProduto implements ActionListener{
	private static JFrame janela = new JFrame("Gestor de Produtos");
	private static JFrame lista = new JFrame("Lista Produtos");
	private static JLabel titulo = new JLabel("PRODUTOS");
	private static JButton capa = new JButton("Capa");
	private static JButton carregador = new JButton("Carregador");
	private static JButton fone = new JButton("Fone");
	private static JButton listar = new JButton("Listar");
	private static JButton ajuda = new JButton("Ajuda");
	private static JButton pelicula = new JButton("Pelicula");
	private static ControleEstoque estoque;
	
	int aux;
	
	public void mostrarTela(ControleEstoque e) {
		estoque = e;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(135, 30, 150, 30);
		
		capa.setBounds(140, 90, 100, 30);
		carregador.setBounds(140, 140, 100, 30);
		pelicula.setBounds(140, 190, 100, 30);
		fone.setBounds(140, 240, 100, 30);
		listar.setBounds(140, 290, 100, 30);
		ajuda.setBounds(140, 340, 100, 30);
		
		janela.add(titulo);
		janela.setLayout(null);
		janela.setSize(400, 450);
		janela.add(capa);
		janela.add(carregador);
		janela.add(fone);
		janela.add(pelicula);
		janela.add(listar);
		janela.add(ajuda);
		
		janela.setVisible(true);
		capa.addActionListener(this);
		carregador.addActionListener(this);
		pelicula.addActionListener(this);
		fone.addActionListener(this);
		listar.addActionListener(this);
		ajuda.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == capa) {
			aux = 8;
			String[] dadosProduto = new String[aux];
			new TelaAuxProduto().auxProduto(1, dadosProduto, estoque);
		}
		
		if (src == carregador) {
			aux = 6;
			String[] dadosProduto = new String[aux];
			new TelaAuxProduto().auxProduto(2, dadosProduto, estoque);
		}
		
		if (src == pelicula) {
			aux = 8;
			String[] dadosProduto = new String[aux];
			new TelaAuxProduto().auxProduto(3, dadosProduto, estoque);
		}
		
		if (src == fone) {
			aux = 9;
			String[] dadosProduto = new String[aux];
			new TelaAuxProduto().auxProduto(4, dadosProduto, estoque);
		}
		
		if (src == ajuda) {
			mensagemAjuda();
		}
		
		if (src == listar) {
			
			titulo = new JLabel("Filtrar Por");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(135, 30, 150, 30);
			
			lista.setLayout(null);
			lista.setSize(400, 400);
			lista.setVisible(false);
			mensagemInfo();
			lista.dispose();
		}
	}
	
	public void mensagemAjuda() {
		JOptionPane.showMessageDialog(null, "Nesta tela será possível manipular produtos" 
				+ "\nEscolha um dos 4 tipos de produto"
				+ "\nE você será capaz de realizar as funções mostradas", null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemInfo() {
		JOptionPane.showMessageDialog(null, "Função não implementada" , null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
}