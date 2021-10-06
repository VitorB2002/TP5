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

public class TelaDeleta implements ActionListener{
	
	private static ControleEstoque estoque;
	private JFrame janela = new JFrame("Deleta");
	private JFrame busca = new JFrame("Busca");
	private JLabel titulo = new JLabel("Deletar");
	
	private JButton capa = new JButton("Capa");
	private JButton carregador = new JButton("Carregador");
	private JButton fone = new JButton("Fone");
	private JButton ajuda = new JButton("Ajuda");
	private JButton pelicula = new JButton("Pelicula");
	
	private JButton pesquisar = new JButton("Pesquisar");
	
	private int aux;
	private int posicao;
	private boolean sucesso;
	private int tamanho;
	private String[] dadosProduto = new String[9];
	
	private JLabel modelo = new JLabel("Modelo:");

	private JTextField inModelo;
	
	
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
	
	public void mensagemSucessoDeleta() {
		JOptionPane.showMessageDialog(null, "Produto deletado com sucesso!" , null, 
				JOptionPane.INFORMATION_MESSAGE);
				busca.dispose();
	}
	
	public void mensagemFalhaDeleta() {
		JOptionPane.showMessageDialog(null, "Produto não encontrado!" , null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
