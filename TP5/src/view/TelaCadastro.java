package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.ControleEstoque;

public class TelaCadastro implements ActionListener{
	
	private JFrame janela = new JFrame("Cadastro");
	private JFrame cadastra = new JFrame("Cadastrar");
	
	private JFrame lista = new JFrame("Lista Produtos");
	private JLabel titulo = new JLabel("PRODUTOS");
	private JButton capa = new JButton("Capa");
	private JButton carregador = new JButton("Carregador");
	private JButton fone = new JButton("Fone");
	private JButton listar = new JButton("Listar");
	private JButton ajuda = new JButton("Ajuda");
	private JButton pelicula = new JButton("Pelicula");
	private JButton salvar = new JButton("Salvar");
	private String[] dadosProduto = new String[9];
	private static ControleEstoque estoque;
	private int aux;
	
	private JLabel modelo = new JLabel("Modelo:");
	private JLabel descricao = new JLabel("Descrição:");
	private JLabel valor = new JLabel("Valor:");
	private JLabel marca = new JLabel("Marca:");
	private JLabel material = new JLabel("Material: ");
	private JLabel celularCompativel = new JLabel("Celular compatível:");
	private JLabel peso = new JLabel("Peso(g):");
	private JLabel cor = new JLabel("Cor:");
	
	
	private JTextField inModelo;
	private JTextField inDescricao;
	private JTextField inValor;
	private JTextField inMarca;
	private JTextField inMaterial;
	private JTextField inCelularCompativel;
	private JTextField inPeso;
	private JTextField inCor;
	
	private boolean sucesso;
	
	public void cadastra(ControleEstoque e) {
		
		estoque = e;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(135, 30, 150, 30);
		
		capa.setBounds(140, 90, 100, 30);
		carregador.setBounds(140, 140, 100, 30);
		pelicula.setBounds(140, 190, 100, 30);
		fone.setBounds(140, 240, 100, 30);
		
		janela.add(titulo);
		janela.setLayout(null);
		janela.setSize(400, 400);
		janela.add(capa);
		janela.add(carregador);
		janela.add(fone);
		janela.add(pelicula);
		
		janela.setVisible(true);
		
		capa.addActionListener(this);
		carregador.addActionListener(this);
		pelicula.addActionListener(this);
		fone.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == capa) {
			aux = 1;
			cadastraCapa(aux);
			
		}
		
		if (src == carregador) {
		
			
		}
		
		if (src == pelicula) {
			
			
		}
		
		if (src == fone) {
			
			
		}
		
		if (src == salvar) {
			
			switch(aux) {
			
				case 1:
					
					dadosProduto[0] = inModelo.getText();
					dadosProduto[1] = inDescricao.getText();
					dadosProduto[2] = inValor.getText();
					dadosProduto[3] = inMarca.getText();
					dadosProduto[4] = inMaterial.getText();
					dadosProduto[5] = inCelularCompativel.getText();
					dadosProduto[6] = inPeso.getText();
					dadosProduto[7] = inCor.getText();
					
					sucesso = estoque.editarCadastrarProduto(dadosProduto, aux, 0);
					
					if(sucesso) {
						salvar.removeActionListener(this);
						mensagemSucessoCadastro();
					}	else {
						mensagemFalhaCadastro();
					}
					
				break;
				
				case 2:
				break;
				
				case 3:
				break;
					
				case 4:
				break;
				
			}
			
		}
		
	}
	
	public void cadastraCapa(int aux) {
		
		switch(aux) {
		
			case 1:
				cadastra = new JFrame("Cadastro Capa");
				titulo = new JLabel("--Cadastrar--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(135, 10, 150, 30);
				
				inModelo = new JTextField(40);
				inDescricao = new JTextField(100);
				inValor = new JTextField(10);
				inMarca = new JTextField(20);
				inMaterial = new JTextField(30);
				inCelularCompativel = new JTextField(30);
				inPeso = new JTextField(10);
				inCor = new JTextField(25);
				
				inModelo.setBounds(120, 80, 200, 25);
				inDescricao.setBounds(120, 120, 200, 25);
				inValor.setBounds(120, 160, 200, 25);
				inMarca.setBounds(120, 200, 200, 25);
				inMaterial.setBounds(120, 240, 200, 25);
				inCelularCompativel.setBounds(180, 280, 140, 25);
				inPeso.setBounds(120, 320, 200, 25);
				inCor.setBounds(120, 360, 200, 25);
				
				modelo.setBounds(50, 80, 200, 25);
				descricao.setBounds(50, 120, 200, 25);
				valor.setBounds(50, 160, 200, 25);
				marca.setBounds(50, 200, 200, 25);
				material.setBounds(50, 240, 200, 25);
				celularCompativel.setBounds(50, 280, 200, 25);
				peso.setBounds(50, 320, 200, 25);
				cor.setBounds(50, 360, 200, 25);
				
				salvar.setBounds(120, 400, 75, 25);
				
				cadastra.add(titulo);
				cadastra.add(modelo);
				cadastra.add(descricao);
				cadastra.add(valor);
				cadastra.add(marca);
				cadastra.add(material);
				cadastra.add(celularCompativel);
				cadastra.add(peso);
				cadastra.add(cor);
				
				cadastra.add(inModelo);
				cadastra.add(inDescricao);
				cadastra.add(inValor);
				cadastra.add(inMarca);
				cadastra.add(inMaterial);
				cadastra.add(inCelularCompativel);
				cadastra.add(inPeso);
				cadastra.add(inCor);
				cadastra.add(salvar);
				
				cadastra.setLayout(null);
				cadastra.setSize(400, 500);
				cadastra.setVisible(true);
				
				salvar.addActionListener(this);
			break;
			
		}
		
	}
	
	public void mensagemSucessoCadastro() {

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!" 
		+ "\nO mesmo pode ser visto na Lista agora", null, 
				JOptionPane.INFORMATION_MESSAGE);
		cadastra.dispose();
	}
	
	public void mensagemFalhaCadastro() {
		JOptionPane.showMessageDialog(null, "Falha ao cadastrar!" 
				+ "\nNenhum dos campos deve estar vazio", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	

}
