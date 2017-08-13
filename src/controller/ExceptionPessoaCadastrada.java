package controller;

public class ExceptionPessoaCadastrada extends Exception {
	private String nome;
	private String cpf;
	
	public ExceptionPessoaCadastrada (String nome, String cpf) {
		super("Pessoa já cadastrada.");
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public String getCPF () {
		return this.cpf;
	}
	
}
