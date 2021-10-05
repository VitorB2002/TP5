package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import controle.*;

public class TelaAuxProduto implements ActionListener{
	
	private static ControleEstoque estoque;
	private static JFrame edita = new JFrame();
    private static JFrame capas = new JFrame("Capas");
    private static JFrame fones = new JFrame("Fones");
    private static JFrame peliculas = new JFrame("Peliculas");
    private static JFrame carregadores = new JFrame("Carregadores");
    private static JFrame cadastra = new JFrame();
    private static JFrame busca = new JFrame();
    private static JLabel titulo = new JLabel();
	private static JButton deletar = new JButton("Deletar");
	private static JButton cadastrar = new JButton("Cadastrar");
	private static JButton buscar = new JButton("Buscar");
	private static JButton pesquisar = new JButton("Pesquisar");
	private static JButton salvar = new JButton("Salvar");
	private static JButton editar = new JButton("Editar");
	private static String[] produtos;
	private static int posicao = 0;
	
	private JTextField inModelo;
	private JTextField inDescricao;
	private JTextField inValor;
	private JTextField inMarca;
	private JTextField inMaterial;
	private JTextField inTamanhoCabo;
	private JTextField inPotencia;
	private JTextField inEspessura;
	private JTextField inCelularCompativel;
	private JTextField inPeso;
	private JTextField inCor;
	private JTextField inTipoConexao;
	private JTextField inFiltroRuido;
	private JTextField inMaterialBorracha;
	
	private JLabel modelo = new JLabel("Modelo:");
	private JLabel descricao = new JLabel("Descrição:");
	private JLabel valor = new JLabel("Valor:");
	private JLabel marca = new JLabel("Marca:");
	private JLabel material = new JLabel("Material: ");
	private JLabel tamanhoCabo = new JLabel("Tamanho Cabo(cm):");
	private JLabel potencia = new JLabel("Potência(w) :");
	private JLabel espessura = new JLabel("Espessura(cm):");
	private JLabel celularCompativel = new JLabel("Celular compatível:");
	private JLabel peso = new JLabel("Peso(g):");
	private JLabel cor = new JLabel("Cor:");
	private JLabel tipoConexao = new JLabel("Conexão:");
	private JLabel filtroRuido = new JLabel("Filtro de ruido (s/n):");
	private JLabel materialBorracha = new JLabel("Material borrachas:");
	
	int opcao;
	boolean sucesso = false;
	
	public void auxProduto(int op, String[] dadosProduto, ControleEstoque e) {
		
		estoque = e;
		produtos = dadosProduto;
		opcao = op;
		
		switch(opcao) {
		
			case 1:
				
				titulo = new JLabel("--Capas--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(150, 8, 150, 30);
				
				deletar.setBounds(120, 40, 150 , 60);
				cadastrar.setBounds(120, 110, 150, 60);
				buscar.setBounds(120, 180 , 150, 60);
				
				
				capas.add(titulo);
				capas.add(deletar);
				capas.add(cadastrar);
				capas.add(buscar);
				capas.setLayout(null);
				capas.setSize(400,300);
				capas.setVisible(true);
				
				deletar.addActionListener(this);
				cadastrar.addActionListener(this);
				buscar.addActionListener(this);
				
				
			break;
			
			case 2:
				
				titulo = new JLabel("--Carregadores--");
				titulo.setFont(new Font("Arial", Font.BOLD, 18));
				titulo.setBounds(123, 8, 150, 30);
				
				deletar.setBounds(120, 40, 150 , 60);
				cadastrar.setBounds(120, 110, 150, 60);
				buscar.setBounds(120, 180 , 150, 60);
				
				
				carregadores.add(titulo);
				carregadores.add(deletar);
				carregadores.add(cadastrar);
				carregadores.add(buscar);
				carregadores.setLayout(null);
				carregadores.setSize(400,300);
				carregadores.setVisible(true);
				
				deletar.addActionListener(this);
				cadastrar.addActionListener(this);
				buscar.addActionListener(this);
				
			break;
			
			case 3:
				
				titulo = new JLabel("--Peliculas--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(140, 8, 150, 30);
				
				deletar.setBounds(120, 40, 150 , 60);
				cadastrar.setBounds(120, 110, 150, 60);
				buscar.setBounds(120, 180 , 150, 60);
				
				
				peliculas.add(titulo);
				peliculas.add(deletar);
				peliculas.add(cadastrar);
				peliculas.add(buscar);
				peliculas.setLayout(null);
				peliculas.setSize(400, 300);
				peliculas.setVisible(true);
				
				deletar.addActionListener(this);
				cadastrar.addActionListener(this);
				buscar.addActionListener(this);
				
			break;
			
			case 4:
				
				titulo = new JLabel("--Fones--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(150, 8, 150, 30);
				
				deletar.setBounds(120, 40, 150 , 60);
				cadastrar.setBounds(120, 110, 150, 60);
				buscar.setBounds(120, 180 , 150, 60);
				
				
				fones.add(titulo);
				fones.add(deletar);
				fones.add(cadastrar);
				fones.add(buscar);
				fones.setLayout(null);
				fones.setSize(400,300);
				fones.setVisible(true);
				
				deletar.addActionListener(this);
				cadastrar.addActionListener(this);
				buscar.addActionListener(this);
				
			break;
		
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if (src == deletar) {
			mensagemInfo();
		}
		
		if (src == cadastrar) {
			//Dispose para evitar bug de sobreposição de texto ao trocar de telas
			capas.dispose();
			carregadores.dispose();
			fones.dispose();
			peliculas.dispose();
			cadastra.dispose();
			cadastroProduto(opcao);
		}
		
		
		
		if (src == buscar) {
			buscarProduto(opcao);
			
		}
		
		if (src == pesquisar) {
			produtos[0] = inModelo.getText();
			
			int tamanho = 0;
			sucesso = false;
			
			switch(opcao) {
			
				case 1:
					
					tamanho = estoque.getEstoque().getCapas().size();
					
					for(int i = 0; i < tamanho; i++) {
						
						if(produtos[0].equals(estoque.getEstoque().getCapas().get(i).getModelo())){
							sucesso = true;
							posicao = i;
							i = tamanho;
						}
						
					}
					
					if(sucesso) {
						mensagemSucessoBusca();
						busca.dispose();
						editaProduto(posicao, opcao);
					}	else {
						mensagemFalhaBusca();
					}
					
				break;
				
				case 2:
					
					tamanho = estoque.getEstoque().getCarregadores().size();
					
					for(int i = 0; i < tamanho; i++) {
						
						if(produtos[0].equals(estoque.getEstoque().getCarregadores().get(i).getModelo())){
							sucesso = true;
							posicao = i;
							i = tamanho;
						}
						
					}
					
					if(sucesso) {
						mensagemSucessoBusca();
						busca.dispose();
						editaProduto(posicao, opcao);
					}	else {
						mensagemFalhaBusca();
					}
					
				break;
				
				case 3:
					
					tamanho = estoque.getEstoque().getPeliculas().size();
					
					for(int i = 0; i < tamanho; i++) {
						
						if(produtos[0].equals(estoque.getEstoque().getPeliculas().get(i).getModelo())){
							sucesso = true;
							posicao = i;
							i = tamanho;
						}
						
					}
					
					if(sucesso) {
						mensagemSucessoBusca();
						busca.dispose();
						editaProduto(posicao, opcao);
					}	else {
						mensagemFalhaBusca();
					}
					
				break;
				
				case 4:
					
					tamanho = estoque.getEstoque().getFones().size();
					
					for(int i = 0; i < tamanho; i++) {
						
						if(produtos[0].equals(estoque.getEstoque().getFones().get(i).getModelo())){
							sucesso = true;
							posicao = i;
							i = tamanho;
						}
						
					}
					
					if(sucesso) {
						mensagemSucessoBusca();
						busca.dispose();
						editaProduto(posicao, opcao);
					}	else {
						mensagemFalhaBusca();
					}
					
				break;
			}
			
		}
		
		
		
		if (src == salvar) {
			
			int aux = 0;
			
			//Atributos herdados da classe produto
			produtos[0] = inModelo.getText();
			produtos[1] = inDescricao.getText();
			produtos[2] = inValor.getText();
			produtos[3] = inMarca.getText();
			
			//Atributos de cada objeto
			switch(opcao) {
			
				case 1:
					produtos[4] = inMaterial.getText();
					produtos[5] = inCelularCompativel.getText();
					produtos[6] = inPeso.getText();
					produtos[7] = inCor.getText();
					aux = 1;
				break;
				
				case 2:
					produtos[4] = inTamanhoCabo.getText();
					produtos[5] = inPotencia.getText();
					aux = 3;
				break;
				
				case 3:
					produtos[4] = inMaterial.getText();
					produtos[5] = inEspessura.getText();
					produtos[6] = inCelularCompativel.getText();
					aux = 5;
				break;
				
				case 4:
					produtos[4] = inPeso.getText();
					produtos[5] = inTipoConexao.getText();
					produtos[6] = inFiltroRuido.getText();
					produtos[7] = inCor.getText();
					produtos[8] = inMaterialBorracha.getText();
					aux = 7;
				break;
			
			}
			
			sucesso = estoque.editarCadastrarProduto(produtos, aux, 0);
			
			if(sucesso) {
				mensagemSucessoCadastro();
			} else {
				mensagemFalhaCadastro();
			}
			
		}
		
		if (src == editar) {
			
			int aux2 = 0;
			//Atributos herdados da classe produto
			produtos[0] = inModelo.getText();
			produtos[1] = inDescricao.getText();
			produtos[2] = inValor.getText();
			produtos[3] = inMarca.getText();
			
			//Atributos de cada objeto
			switch(opcao) {
			
				case 1:
					produtos[4] = inMaterial.getText();
					produtos[5] = inCelularCompativel.getText();
					produtos[6] = inPeso.getText();
					produtos[7] = inCor.getText();
					aux2 = 2;
				break;
				
				case 2:
					produtos[4] = inTamanhoCabo.getText();
					produtos[5] = inPotencia.getText();
					aux2 = 4;
				break;
				
				case 3:
					produtos[4] = inMaterial.getText();
					produtos[5] = inEspessura.getText();
					produtos[6] = inCelularCompativel.getText();
					aux2 = 6;
				break;
				
				case 4:
					produtos[4] = inPeso.getText();
					produtos[5] = inTipoConexao.getText();
					produtos[6] = inFiltroRuido.getText();
					produtos[7] = inCor.getText();
					produtos[8] = inMaterialBorracha.getText();
					aux2 = 8;
				break;
			
			}
			
			sucesso = estoque.editarCadastrarProduto(produtos, aux2, posicao);
			
			if(sucesso) {
				mensagemSucessoEditar();
				edita.dispose();
			} else {
				mensagemFalhaEditar();
			}
		}
		
	}
	
	public void mensagemSucessoBusca() {
		JOptionPane.showMessageDialog(null, "Produto encontrado!", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemFalhaBusca() {
		JOptionPane.showMessageDialog(null, "Produto não encontrado!", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoCadastro() {
		
		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!" 
		+ "\nO mesmo pode ser visto na Lista agora", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemFalhaCadastro() {
		JOptionPane.showMessageDialog(null, "Falha ao cadastrar!" 
				+ "\nNenhum dos campos deve estar vazio", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemSucessoEditar() {
		JOptionPane.showMessageDialog(null, "Produto editado com sucesso!" 
				+ "\nAgora o mesmo pode ser buscado"
				+ "\nOu pode ser visto na lista", null, 
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mensagemFalhaEditar() {
		JOptionPane.showMessageDialog(null, "Falha ao editar!" 
				+ "\nOs campos não podem estar vazios" , null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void buscarProduto(int opcao) {
		
				switch(opcao) {
					case 1:
						busca = new JFrame("Busca Capa");
					break;
					
					case 2:
						busca = new JFrame("Busca Carregador");
					break;
					
					case 3:
						busca = new JFrame("Busca Pelicula");
					break;
					
					case 4:
						busca = new JFrame("Busca Fones");
					break;
				}
				
				
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
	
	public void cadastroProduto(int opcao) {
		
		switch(opcao) {
			
			//Tela cadastro Capa
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
			
			//Tela cadastro carregador
			case 2:
				
				cadastra = new JFrame("Cadastro carregador");
				titulo = new JLabel("--Cadastrar--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(135, 10, 150, 30);
				
				inModelo = new JTextField(40);
				inDescricao = new JTextField(100);
				inValor = new JTextField(10);
				inMarca = new JTextField(20);
				inTamanhoCabo = new JTextField(10);
				inPotencia = new JTextField(10);
				
				inModelo.setBounds(120, 80, 200, 25);
				inDescricao.setBounds(120, 120, 200, 25);
				inValor.setBounds(120, 160, 200, 25);
				inMarca.setBounds(120, 200, 200, 25);
				inTamanhoCabo.setBounds(150, 240, 170, 25);
				inPotencia.setBounds(120, 280, 200, 25);
				
				modelo.setBounds(50, 80, 200, 25);
				descricao.setBounds(50, 120, 200, 25);
				valor.setBounds(50, 160, 200, 25);
				marca.setBounds(50, 200, 200, 25);
				tamanhoCabo.setBounds(50, 240, 200, 25);
				potencia.setBounds(50, 280, 200, 25);
				
				salvar.setBounds(120, 320, 75, 25);
				
				cadastra.add(titulo);
				cadastra.add(modelo);
				cadastra.add(descricao);
				cadastra.add(valor);
				cadastra.add(marca);
				cadastra.add(tamanhoCabo);
				cadastra.add(potencia);
				
				cadastra.add(inModelo);
				cadastra.add(inDescricao);
				cadastra.add(inValor);
				cadastra.add(inMarca);
				cadastra.add(inTamanhoCabo);
				cadastra.add(inPotencia);
				cadastra.add(salvar);
				
				cadastra.setLayout(null);
				cadastra.setSize(400, 400);
				cadastra.setVisible(true);
				
				salvar.addActionListener(this);
				
			break;
			
			//Cadastro pelicula
			case 3:
				
				cadastra = new JFrame("Cadastro Pelicula");
				titulo = new JLabel("--Cadastrar--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(135, 10, 150, 30);
				
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
				inEspessura.setBounds(150, 240, 170, 25);
				inCelularCompativel.setBounds(180, 280, 140, 25);
				
				modelo.setBounds(50, 80, 200, 25);
				descricao.setBounds(50, 120, 200, 25);
				valor.setBounds(50, 160, 200, 25);
				marca.setBounds(50, 200, 200, 25);
				espessura.setBounds(50, 240, 200, 25);
				celularCompativel.setBounds(50, 280, 200, 25);
				
				salvar.setBounds(120, 320, 75, 25);
				
				cadastra.add(titulo);
				cadastra.add(modelo);
				cadastra.add(descricao);
				cadastra.add(valor);
				cadastra.add(marca);
				cadastra.add(espessura);
				cadastra.add(celularCompativel);
				
				
				cadastra.add(inModelo);
				cadastra.add(inDescricao);
				cadastra.add(inValor);
				cadastra.add(inMarca);
				cadastra.add(inEspessura);
				cadastra.add(inCelularCompativel);
				cadastra.add(salvar);
				
				cadastra.setLayout(null);
				cadastra.setSize(400, 400);
				cadastra.setVisible(true);
				
				salvar.addActionListener(this);
				
			break;
			
			case 4:
				
				cadastra = new JFrame("Cadastra fone");
				titulo = new JLabel("--Cadastrar--");
				titulo.setFont(new Font("Arial", Font.BOLD, 20));
				titulo.setBounds(135, 10, 150, 30);
				
				inModelo = new JTextField(40);
				inDescricao = new JTextField(100);
				inValor = new JTextField(10);
				inMarca = new JTextField(20);
				inPeso = new JTextField(20);
				inTipoConexao = new JTextField(4);
				inFiltroRuido = new JTextField(10);
				inCor = new JTextField(25);
				inMaterialBorracha = new JTextField(30);
				
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
				
				salvar.setBounds(120, 440, 75, 25);
				
				cadastra.add(titulo);
				cadastra.add(modelo);
				cadastra.add(descricao);
				cadastra.add(valor);
				cadastra.add(marca);
				cadastra.add(peso);
				cadastra.add(tipoConexao);
				cadastra.add(filtroRuido);
				cadastra.add(cor);
				cadastra.add(materialBorracha);
				
				cadastra.add(inModelo);
				cadastra.add(inDescricao);
				cadastra.add(inValor);
				cadastra.add(inMarca);
				cadastra.add(inPeso);
				cadastra.add(inTipoConexao);
				cadastra.add(inFiltroRuido);
				cadastra.add(inCor);
				cadastra.add(inMaterialBorracha);
				cadastra.add(salvar);
				
				cadastra.setLayout(null);
				cadastra.setSize(400, 520);
				cadastra.setVisible(true);
				
				salvar.addActionListener(this);
				
			break;
			
		}
		
	}
	
	public void editaProduto(int pos, int opcao){
		
		String s = null;
		
		switch(opcao) {
		
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
				inEspessura.setBounds(150, 240, 170, 25);
				inCelularCompativel.setBounds(180, 280, 140, 25);
				
				inModelo.setText(estoque.getEstoque().getPeliculas().get(pos).getModelo());
				inDescricao.setText(estoque.getEstoque().getPeliculas().get(pos).getDescricao());
				inValor.setText(s);
				inMarca.setText(estoque.getEstoque().getPeliculas().get(pos).getMarca());
				s = Double.toString(estoque.getEstoque().getPeliculas().get(pos).getEspessura());
				inEspessura.setText(s);
				inCelularCompativel.setText(estoque.getEstoque().getPeliculas().get(pos).getCelularCompativel());
				
				modelo.setBounds(50, 80, 200, 25);
				descricao.setBounds(50, 120, 200, 25);
				valor.setBounds(50, 160, 200, 25);
				marca.setBounds(50, 200, 200, 25);
				espessura.setBounds(50, 240, 200, 25);
				celularCompativel.setBounds(50, 280, 200, 25);
				
				editar.setBounds(120, 320, 75, 25);
				
				edita.add(titulo);
				edita.add(modelo);
				edita.add(descricao);
				edita.add(valor);
				edita.add(marca);
				edita.add(espessura);
				edita.add(celularCompativel);
				
				
				edita.add(inModelo);
				edita.add(inDescricao);
				edita.add(inValor);
				edita.add(inMarca);
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
				s = Boolean.toString(estoque.getEstoque().getFones().get(pos).isFiltroRuido());
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
	
	public void mensagemInfo() {
		JOptionPane.showMessageDialog(null, "Função não implementada" , null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
}