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

/**
 * Cria as telas para deletar os produtos
 * @author V1tor
 * @version 1.0
 */

public class TelaDeleta implements ActionListener{

	private static ControleEstoque estoque;
	private JFrame janela = new JFrame("Deleta");
	private JFrame busca = new JFrame("Busca");
	private JLabel titulo = new JLabel("Deletar");
	
	private JButton capa = new JButton("Capa");
	private JButton carregador = new JButton("Carregador");
	private JButton fone = new JButton("Fone");
	private JButton pelicula = new JButton("Pelicula");
	
	private JButton pesquisar = new JButton("Pesquisar");
	
	private int aux;
	private int posicao;
	private boolean sucesso;
	private int tamanho;
	private String[] dadosProduto = new String[9];
	
	private JLabel modelo = new JLabel("Modelo:");

	private JTextField inModelo;
	
	/**
	 * Cria tela para escolha de produto a ser buscado
	 * @param e um estoque que armazena e manipula todos os produtos e vendas
	 */
	
	public void buscaProduto(ControleEstoque e) {
		
		estoque = e;
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(155, 30, 150, 30);
		
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
	
	/**
	 * Define o que acontece quando um botão foi apertado
	 * @param e evento gerado ao apertar um JButton
	 */
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == capa) {
			aux = 1;
			buscarProduto();
		}
		
		if (src == carregador) {
			aux = 2;
			buscarProduto();
		}
		
		if (src == pelicula) {
			aux = 3;
			buscarProduto();
		}
		
		if (src == fone) {
			aux = 4;
			buscarProduto();
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
				
			break;
			
			case 2:
				
				tamanho = estoque.getEstoque().getCarregadores().size();
				dadosProduto[0] = inModelo.getText();
				
				for(int i = 0; i < tamanho; i++) {
					
					if(dadosProduto[0].equals(estoque.getEstoque().getCarregadores().get(i).getModelo())){
						sucesso = true;
						posicao = i;
						i = tamanho;
					}
					
				}
				
			break;
			
			case 3:
				
				tamanho = estoque.getEstoque().getPeliculas().size();
				dadosProduto[0] = inModelo.getText();
				
				for(int i = 0; i < tamanho; i++) {
					
					if(dadosProduto[0].equals(estoque.getEstoque().getPeliculas().get(i).getModelo())){
						sucesso = true;
						posicao = i;
						i = tamanho;
					}
					
				}
				
			break;
			
			case 4:
				
				tamanho = estoque.getEstoque().getFones().size();
				dadosProduto[0] = inModelo.getText();
				
				for(int i = 0; i < tamanho; i++) {
					
					if(dadosProduto[0].equals(estoque.getEstoque().getFones().get(i).getModelo())){
						sucesso = true;
						posicao = i;
						i = tamanho;
					}
					
				}
				
			break;
			
			}
			
			if(sucesso) {
				mensagemSucessoDeleta();
				pesquisar.removeActionListener(this);
				estoque.deletaProduto(posicao, aux);
				this.janela.dispose();
			}	else {
				mensagemFalhaDeleta();
			}
			
		}
		
	}
	
	/**
	 * Cria tela para busca de produtos atráves do modelo
	 */
	
	public void buscarProduto() {
				
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
		
	}
	
	/**
	 * Informa ao usuário que o produto foi deletado com sucesso
	 */
	
	public void mensagemSucessoDeleta() {
		JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!" , null, 
				JOptionPane.INFORMATION_MESSAGE);
				busca.dispose();
	}
	
	/**
	 * Informa ao usuário que o produto pesquisado não existe
	 */
	
	public void mensagemFalhaDeleta() {
		JOptionPane.showMessageDialog(null, "Produto não encontrado!" , null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
