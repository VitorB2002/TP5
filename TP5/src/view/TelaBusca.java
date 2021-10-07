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
	private JButton pelicula = new JButton("Pelicula");
	
	private JButton pesquisar = new JButton("Pesquisar");
	private JButton editar = new JButton("Editar");
	
	private int aux; //Direciona as telas para o produto desejado
	private int aux2; //Informa para o metodo de edição qual produto editar
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
	private JLabel tamanhoCabo = new JLabel("Tamanho Cabo:");
	private JLabel potencia = new JLabel("Potencia:");
	private JLabel espessura = new JLabel("Espessura:");
	private JLabel tipoConexao = new JLabel("Conexão: ");
	private JLabel filtroRuido = new JLabel("Filtra ruído(s/n):");
	private JLabel materialBorracha = new JLabel("Material Borrachas: ");
	
	private JTextField inModelo;
	private JTextField inDescricao;
	private JTextField inValor;
	private JTextField inMarca;
	private JTextField inMaterial;
	private JTextField inCelularCompativel;
	private JTextField inPeso;
	private JTextField inCor;
	private JTextField inTamanhoCabo;
	private JTextField inPotencia;
	private JTextField inEspessura;
	private JTextField inTipoConexao;
	private JTextField inFiltroRuido;
	private JTextField inMaterialBorracha;
	
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
				mensagemSucessoBusca();
				pesquisar.removeActionListener(this);
				editaProduto(posicao, aux);
			}	else {
				mensagemFalhaBusca();
			}
			
		}
		
		if (src == editar) {
			
			dadosProduto[0] = inModelo.getText();
			dadosProduto[1] = inDescricao.getText();
			dadosProduto[2] = inValor.getText();
			dadosProduto[3] = inMarca.getText();
			
			switch(aux) {
			
				case 1:
					
					try {
						
						dadosProduto[0] = inModelo.getText();
						dadosProduto[1] = inDescricao.getText();
						dadosProduto[2] = inValor.getText();
						dadosProduto[3] = inMarca.getText();
						dadosProduto[4] = inMaterial.getText();
						dadosProduto[5] = inCelularCompativel.getText();
						dadosProduto[6] = inPeso.getText();
						dadosProduto[7] = inCor.getText();
						aux2 = 2;
						
						sucesso = estoque.editarCadastrarProduto(dadosProduto, aux2, posicao);
						
					} catch(NumberFormatException erro) {
						sucesso = false;
					}
					
					
				break;
				
				case 2:
					
					try {
						
						dadosProduto[0] = inModelo.getText();
						dadosProduto[1] = inDescricao.getText();
						dadosProduto[2] = inValor.getText();
						dadosProduto[3] = inMarca.getText();
						dadosProduto[4] = inTamanhoCabo.getText();
						dadosProduto[5] = inPotencia.getText();
						aux2 = 4;
						
						sucesso = estoque.editarCadastrarProduto(dadosProduto, aux2, posicao);
						
					} catch(NumberFormatException erro) {
						sucesso = false;
					}
					
					
				break;
				
				case 3:
					
					try {
						
						dadosProduto[0] = inModelo.getText();
						dadosProduto[1] = inDescricao.getText();
						dadosProduto[2] = inValor.getText();
						dadosProduto[3] = inMarca.getText();
						dadosProduto[4] = inMaterial.getText();
						dadosProduto[5] = inEspessura.getText();
						dadosProduto[6] = inCelularCompativel.getText();
						aux2 = 6;
						
						sucesso = estoque.editarCadastrarProduto(dadosProduto, aux2, posicao);
						
					} catch(NumberFormatException erro) {
						sucesso = false;
					}
					
				break;
					
				case 4:
					
					try {
						
						dadosProduto[0] = inModelo.getText();
						dadosProduto[1] = inDescricao.getText();
						dadosProduto[2] = inValor.getText();
						dadosProduto[3] = inMarca.getText();
						dadosProduto[4] = inPeso.getText();
						dadosProduto[5] = inTipoConexao.getText();
						dadosProduto[6] = inFiltroRuido.getText();
						dadosProduto[7] = inCor.getText();
						dadosProduto[8] = inMaterialBorracha.getText();
						aux2 = 8;
						
						sucesso = estoque.editarCadastrarProduto(dadosProduto, aux2, posicao);
						
					} catch(NumberFormatException erro) {
						sucesso = false;
					}
					
				break;
				
			}
			
			if(sucesso) {
				mensagemSucessoEditar();
				janela.dispose();
				editar.removeActionListener(this);
			} else {
				mensagemFalhaEditar(aux);
			}
			
		}
		
	}
	
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
			
			edita.setLayout(null);
			edita.setSize(400, 500);
			edita.setVisible(true);
			
			editar.addActionListener(this);
			
		break;
		
		case 2:
			
			edita = new JFrame("Editar Carregador");
			titulo = new JLabel("--Editar--");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(135, 10, 150, 30);
			
			s = Double.toString(estoque.getEstoque().getCarregadores().get(pos).getValor());
			
			inModelo = new JTextField(40);
			inDescricao = new JTextField(100);
			inValor = new JTextField(10);
			inMarca = new JTextField(20);
			inTamanhoCabo = new JTextField(10);
			inPotencia = new JTextField(10);
			
			inModelo.setText(estoque.getEstoque().getCarregadores().get(pos).getModelo());
			inDescricao.setText(estoque.getEstoque().getCarregadores().get(pos).getDescricao());
			inValor.setText(s);
			inMarca.setText(estoque.getEstoque().getCarregadores().get(pos).getMarca());
			s = Double.toString(estoque.getEstoque().getCarregadores().get(pos).getTamanhoCabo());
			inTamanhoCabo.setText(s);
			s = Double.toString(estoque.getEstoque().getCarregadores().get(pos).getPotencia());
			inPotencia.setText(s);
			
			inModelo.setBounds(120, 80, 200, 25);
			inDescricao.setBounds(120, 120, 200, 25);
			inValor.setBounds(120, 160, 200, 25);
			inMarca.setBounds(120, 200, 200, 25);
			inTamanhoCabo.setBounds(170, 240, 150, 25);
			inPotencia.setBounds(130, 280, 190, 25);
			
			modelo.setBounds(50, 80, 200, 25);
			descricao.setBounds(50, 120, 200, 25);
			valor.setBounds(50, 160, 200, 25);
			marca.setBounds(50, 200, 200, 25);
			tamanhoCabo.setBounds(50, 240, 200, 25);
			potencia.setBounds(50, 280, 200, 25);
			
			editar.setBounds(120, 320, 75, 25);
			
			edita.add(titulo);
			edita.add(modelo);
			edita.add(descricao);
			edita.add(valor);
			edita.add(marca);
			edita.add(tamanhoCabo);
			edita.add(potencia);
			
			edita.add(inModelo);
			edita.add(inDescricao);
			edita.add(inValor);
			edita.add(inMarca);
			edita.add(inTamanhoCabo);
			edita.add(inPotencia);
			edita.add(editar);
			
			edita.setLayout(null);
			edita.setSize(400, 400);
			edita.setVisible(true);
			
			editar.addActionListener(this);
			
		break;
		
		case 3:
			
			edita = new JFrame("Editar Pelicula");
			titulo = new JLabel("--Editar--");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(135, 10, 150, 30);
			
			s = Double.toString(estoque.getEstoque().getPeliculas().get(pos).getValor());
			
			inModelo = new JTextField(40);
			inDescricao = new JTextField(100);
			inValor = new JTextField(10);
			inMarca = new JTextField(20);
			inMaterial = new JTextField(30);
			inEspessura = new JTextField(10);
			inCelularCompativel = new JTextField(30);
			
			inModelo.setBounds(120, 80, 200, 25);
			inDescricao.setBounds(120, 120, 200, 25);
			inValor.setBounds(120, 160, 200, 25);
			inMarca.setBounds(120, 200, 200, 25);
			inMaterial.setBounds(120, 240, 200, 25);
			inEspessura.setBounds(150, 280, 170, 25);
			inCelularCompativel.setBounds(180, 320, 140, 25);
			
			inModelo.setText(estoque.getEstoque().getPeliculas().get(pos).getModelo());
			inDescricao.setText(estoque.getEstoque().getPeliculas().get(pos).getDescricao());
			inValor.setText(s);
			inMarca.setText(estoque.getEstoque().getPeliculas().get(pos).getMarca());
			s = Double.toString(estoque.getEstoque().getPeliculas().get(pos).getEspessura());
			inMaterial.setText(estoque.getEstoque().getPeliculas().get(pos).getMaterial());
			inEspessura.setText(s);
			inCelularCompativel.setText(estoque.getEstoque().getPeliculas().get(pos).getCelularCompativel());
			
			modelo.setBounds(50, 80, 200, 25);
			descricao.setBounds(50, 120, 200, 25);
			valor.setBounds(50, 160, 200, 25);
			marca.setBounds(50, 200, 200, 25);
			material.setBounds(50, 240, 200, 25);
			espessura.setBounds(50, 280, 200, 25);
			celularCompativel.setBounds(50, 320, 200, 25);
			
			editar.setBounds(120, 360, 75, 25);
			
			edita.add(titulo);
			edita.add(modelo);
			edita.add(descricao);
			edita.add(valor);
			edita.add(marca);
			edita.add(material);
			edita.add(espessura);
			edita.add(celularCompativel);
			
			
			edita.add(inModelo);
			edita.add(inDescricao);
			edita.add(inValor);
			edita.add(inMarca);
			edita.add(inMaterial);
			edita.add(inEspessura);
			edita.add(inCelularCompativel);
			edita.add(editar);
			
			edita.setLayout(null);
			edita.setSize(400, 400);
			edita.setVisible(true);
			
			editar.addActionListener(this);
			
		break;
			
		case 4:
			
			edita = new JFrame("Editar Fone");
			titulo = new JLabel("--Editar--");
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(135, 10, 150, 30);
			
			s = Double.toString(estoque.getEstoque().getPeliculas().get(pos).getValor());
			inModelo = new JTextField(40);
			inDescricao = new JTextField(100);
			inValor = new JTextField(10);
			inMarca = new JTextField(20);
			inPeso = new JTextField(20);
			inTipoConexao = new JTextField(4);
			inFiltroRuido = new JTextField(10);
			inCor = new JTextField(25);
			inMaterialBorracha = new JTextField(30);
			
			inModelo.setText(estoque.getEstoque().getFones().get(pos).getModelo());;
			inDescricao.setText(estoque.getEstoque().getFones().get(pos).getModelo());
			inValor.setText(s);
			inMarca.setText(estoque.getEstoque().getFones().get(pos).getMarca());
			s = Double.toString(estoque.getEstoque().getFones().get(pos).getPeso());
			inPeso.setText(s);
			inTipoConexao.setText(estoque.getEstoque().getFones().get(pos).getTipoConexao());
			
				if(estoque.getEstoque().getFones().get(pos).isFiltroRuido()) {
					s = "s";
				} else {
					s = "n";
				}
				
			inFiltroRuido.setText(s);
			inCor.setText(estoque.getEstoque().getFones().get(pos).getCor());
			inMaterialBorracha.setText(estoque.getEstoque().getFones().get(pos).getMaterialBorracha());
			
			inModelo.setBounds(120, 80, 200, 25);
			inDescricao.setBounds(120, 120, 200, 25);
			inValor.setBounds(120, 160, 200, 25);
			inMarca.setBounds(120, 200, 200, 25);
			inPeso.setBounds(120, 240, 200, 25);
			inTipoConexao.setBounds(120, 280, 200, 25);
			inFiltroRuido.setBounds(170, 320, 150, 25);
			inCor.setBounds(120, 360, 200, 25);
			inMaterialBorracha.setBounds(170, 400, 150, 25);
			
			modelo.setBounds(50, 80, 200, 25);
			descricao.setBounds(50, 120, 200, 25);
			valor.setBounds(50, 160, 200, 25);
			marca.setBounds(50, 200, 200, 25);
			peso.setBounds(50, 240, 200, 25);
			tipoConexao.setBounds(50, 280, 200, 25);
			filtroRuido.setBounds(50, 320, 200, 25);
			cor.setBounds(50, 360, 200, 25);
			materialBorracha.setBounds(50, 400, 200, 25);
			
			editar.setBounds(120, 440, 75, 25);
			
			edita.add(titulo);
			edita.add(modelo);
			edita.add(descricao);
			edita.add(valor);
			edita.add(marca);
			edita.add(peso);
			edita.add(tipoConexao);
			edita.add(filtroRuido);
			edita.add(cor);
			edita.add(materialBorracha);
			
			edita.add(inModelo);
			edita.add(inDescricao);
			edita.add(inValor);
			edita.add(inMarca);
			edita.add(inPeso);
			edita.add(inTipoConexao);
			edita.add(inFiltroRuido);
			edita.add(inCor);
			edita.add(inMaterialBorracha);
			edita.add(editar);
			
			edita.setLayout(null);
			edita.setSize(400, 520);
			edita.setVisible(true);
			
			editar.addActionListener(this);
			
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
	
	public void mensagemFalhaEditar(int aux) {
		
		switch(aux) {
		
		case 1:
			JOptionPane.showMessageDialog(null, "Falha ao editar!" 
					+ "\nOs campos não podem estar vazios"
					+ "\nOs campos valor e peso devem ser preenchidos por números", null, 
					JOptionPane.ERROR_MESSAGE);
		
		break;
			
		case 2:
			JOptionPane.showMessageDialog(null, "Falha ao editar!" 
					+ "\nNenhum dos campos deve estar vazio"
					+ "\nOs campos valor, tamanho cabo e potência devem ser preenchidos por números", null, 
					JOptionPane.ERROR_MESSAGE);
		break;
		
		case 3:
			JOptionPane.showMessageDialog(null, "Falha ao editar!" 
					+ "\nNenhum dos campos deve estar vazio"
					+ "\nOs campos valor e espessura devem ser preenchidos por números", null, 
					JOptionPane.ERROR_MESSAGE);
		break;
			
		case 4:
			JOptionPane.showMessageDialog(null, "Falha ao editar!" 
					+ "\nNenhum dos campos deve estar vazio"
					+ "\nOs campos valor e peso devem ser preenchidos por números"
					+ "\nFiltro Ruído deve ser respondido apenas com s(sim) ou n(não)", null, 
					JOptionPane.ERROR_MESSAGE);
		break;
		}
		
	}

}
