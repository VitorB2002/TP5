package modelo;

/**
 * Define os atributos e metodos do objeto Cliente
 * @author Vitor
 * @version 1.0
 */

public class Cliente {
	
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	
	/**
	 * Construtor Cliente
	 */
	
	public Cliente() {
		
	}
	
	/**
	 * Construtor Cliente
	 * @param nome informa o nome do cliente
	 * @param cpf informa o cpf do cliente
	 * @param endereco informa o endereço do cliente
	 * @param email informa o email do cliente
	 * @param telefone informa o telefone do cliente
	 */
	
	public Cliente(String nome, String cpf, String endereco, String email, String telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}
	
	//Getters e Setters
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
