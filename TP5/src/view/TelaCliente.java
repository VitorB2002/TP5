package view;

import java.awt.event.*;
import javax.swing.*;
import controle.*;


public class TelaCliente implements ActionListener{
	private JFrame janelaCliente = new JFrame("Gestor de Clientes");
	
	private JButton listar = new JButton("Listar Clientes");
	private JButton cadastrar = new JButton("Cadastrar Clientes");
	private JButton buscar = new JButton("Buscar Cliente");
	private JButton ajuda = new JButton("Ajuda");
	private static ControleDados dados;
	private String[] dadosCliente = new String[5];
	
	public void mostrarTela(ControleDados d) {
		
		dados = d;
		
		//Dimensionamento
		listar.setBounds(120, 40, 150 , 60);
		cadastrar.setBounds(120, 110, 150, 60);
		buscar.setBounds(120, 180 , 150, 60);
		ajuda.setBounds(120, 250, 150, 60);;
		
		//Adicionando componentes ao JFrame
		janelaCliente.setLayout(null);
		janelaCliente.add(ajuda);
		janelaCliente.add(listar);
		janelaCliente.add(cadastrar);
		janelaCliente.add(buscar);
		janelaCliente.setSize(400, 400);
		janelaCliente.setVisible(true);
		
		listar.addActionListener(this);
		cadastrar.addActionListener(this);
		buscar.addActionListener(this);
		ajuda.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if (src == listar) {
			new TelaAuxCliente().auxClient(1, dados, dadosCliente);
		}
		
		if (src == cadastrar) {
			new TelaAuxCliente().auxClient(2, dados, dadosCliente);
		}
		
		if (src == buscar) {
			new TelaAuxCliente().auxClient(3, dados, dadosCliente);
		}
		
		if (src == ajuda) {
			mensagemAjuda();
		}
		
	}
	
	public void mensagemAjuda() {
		JOptionPane.showMessageDialog(null, "Nesta tela poderemos manipular os dados de um cliente" 
				+ "\nClique nos botões e nas telas teremos mais informações para cada metodo", null, 
						JOptionPane.INFORMATION_MESSAGE);
	}
}
