package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controle.*;

public class TelaBusca implements ActionListener{
	
	private static ControleEstoque estoque;
	private JFrame janela = new JFrame("Busca");
	private JFrame busca = new JFrame("Busca de Produtos");
	private JFrame edita = new JFrame("Editar");
	private JLabel titulo = new JLabel("Busca");
	
	private JButton capa = new JButton("Capa");
	private JButton carregador = new JButton("Carregador");
	private JButton fone = new JButton("Fone");
	private JButton ajuda = new JButton("Ajuda");
	private JButton pelicula = new JButton("Pelicula");
	
	private JButton pesquisar = new JButton("Pesquisar");
	private JButton editar = new JButton("Editar");
	private JButton deletar = new JButton("Deletar");
	
	private int aux;
	private int aux2;
	private int posicao;
	private boolean sucesso;
	private int tamanho;
	private String[] dadosProduto = new String[9];
	
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
	
	
	public void buscaProduto(ControleEstoque e) {
		
		estoque = e;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(160, 30, 150, 30);
		
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
			buscarProduto(aux);
		}
		
		if (src == carregador) {
		
			
		}
		
		if (src == pelicula) {
			
			
		}
		
		if (src == fone) {
			
			
		}
		
		if (src == pesquisar) {
			
			switch(aux) {
			
			case 1:
				
				tamanho = estoque.getEstoque().getCapas().size();
				dadosProduto[0] = inModelo.getText();
				
				
				for(int i = 0; i < tamanho; i++) {
					
					if(dadosProduto[0].equals(estoque.getEstoque().getCapas().get(i).getModelo())){
						sucesso = true;
						posicao = i;
						i = tamanho;
					}
					
				}
				
				if(sucesso) {
					mensagemSucessoBusca();
					pesquisar.removeActionListener(this);
					editaProduto(posicao, aux);
				}	else {
					mensagemFalhaBusca();
				}
				
				
			break;
			
			}
		}
		
		if (src == editar) {
			
			dadosProduto[0] = inModelo.getText();
			dadosProduto[1] = inDescricao.getText();
			dadosProduto[2] = inValor.getText();
			dadosProduto[3] = inMarca.getText();
			
			switch(aux) {
			
				case 1:
					
					dadosProduto[4] = inMaterial.getText();
					dadosProduto[5] = inCelularCompativel.getText();
					dadosProduto[6] = inPeso.getText();
					dadosProduto[7] = inCor.getText();
					aux2 = 2;
					
				break;
				
				case 2:
				break;
				
				case 3:
				break;
					
				case 4:
				break;
				
			}
			
			sucesso = estoque.editarCadastrarProduto(dadosProduto, aux2, posicao);
			
			if(sucesso) {
				mensagemSucessoEditar();
				editar.removeActionListener(this);
				deletar.removeActionListener(this);
			} else {
				mensagemFalhaEditar();
			}
			
		}
		
	}
	
	public void buscarProduto(int aux) {
		
		switch(aux) {
		
			case 1:
				
				titulo = new JLabel("--Busca--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(155, 10, 150, 30);
				
				inModelo = new JTextField(40);
				inModelo.setBounds(120, 80, 200, 25);
				modelo.setBounds(50, 80, 200, 25);
				
				pesquisar.setBounds(120, 120, 200, 25);
				
				busca.add(titulo);
				busca.add(inModelo);
				busca.add(modelo);
				busca.add(pesquisar);
				
				busca.setLayout(null);
				busca.setSize(400, 250);
				busca.setVisible(true);
				
				pesquisar.addActionListener(this);
				
			break;
			
			case 2:
			break;
			
			case 3:
			break;
				
			case 4:
			break;
				
		}
		
	}
	
	public void editaProduto(int pos, int aux) {
		
		String s = new String();
		
		switch(aux) {
		
		case 1:
			
			edita = new JFrame("Editar Capa");
			titulo = new JLabel("--Editar--");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(135, 10, 150, 30);
			
			s = Double.toString(estoque.getEstoque().getCapas().get(pos).getValor());
			
			inModelo = new JTextField(40);
			inDescricao = new JTextField(100);
			inValor = new JTextField(10);
			inMarca = new JTextField(20);
			inMaterial = new JTextField(30);
			inCelularCompativel = new JTextField(30);
			inPeso = new JTextField(10);
			inCor = new JTextField(25);
			
			inModelo.setText(estoque.getEstoque().getCapas().get(pos).getModelo());
			inDescricao.setText(estoque.getEstoque().getCapas().get(pos).getDescricao());
			inValor.setText(s);
			inMarca.setText(estoque.getEstoque().getCapas().get(pos).getMarca());
			inMaterial.setText(estoque.getEstoque().getCapas().get(pos).getMaterial());
			inCelularCompativel.setText(estoque.getEstoque().getCapas().get(pos).getCelularCompativel());
			
			s = Double.toString(estoque.getEstoque().getCapas().get(pos).getPeso());
			
			inPeso.setText(s);
			inCor.setText(estoque.getEstoque().getCapas().get(pos).getCor());
			
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
			
			editar.setBounds(120, 400, 75, 25);
			deletar.setBounds(200, 400, 75, 25);
			
			edita.add(titulo);
			edita.add(modelo);
			edita.add(descricao);
			edita.add(valor);
			edita.add(marca);
			edita.add(material);
			edita.add(celularCompativel);
			edita.add(peso);
			edita.add(cor);
			
			edita.add(inModelo);
			edita.add(inDescricao);
			edita.add(inValor);
			edita.add(inMarca);
			edita.add(inMaterial);
			edita.add(inCelularCompativel);
			edita.add(inPeso);
			edita.add(inCor);
			edita.add(editar);
			edita.add(deletar);
			
			edita.setLayout(null);
			edita.setSize(400, 500);
			edita.setVisible(true);
			
			editar.addActionListener(this);
			deletar.addActionListener(this);
			
		break;
		
		case 2:
		break;
		
		case 3:
		break;
			
		case 4:
		break;
			
	}
		
	}
	
	
	
	public void mensagemSucessoBusca() {
		JOptionPane.showMessageDialog(null, "Produto encontrado!", null, 
				JOptionPane.INFORMATION_MESSAGE);
				busca.dispose();
	}
	
	public void mensagemFalhaBusca() {
		JOptionPane.showMessageDialog(null, "Produto não encontrado!", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoEditar() {
		JOptionPane.showMessageDialog(null, "Produto editado com sucesso!" 
				+ "\nAgora o mesmo pode ser buscado"
				+ "\nOu pode ser visto na lista", null, 
				JOptionPane.INFORMATION_MESSAGE);
				edita.dispose();
	}
	
	public void mensagemFalhaEditar() {
		JOptionPane.showMessageDialog(null, "Falha ao editar!" 
				+ "\nOs campos não podem estar vazios" , null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
