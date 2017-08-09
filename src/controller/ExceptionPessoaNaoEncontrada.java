package controller;

public class ExceptionPessoaNaoEncontrada extends Exception {
	private String nome;
	private String cpf;
	private String dataNasc;
	
	public ExceptionPessoaNaoEncontrada (String nome, String cpf) {
		super("Pessoa não encontrada.");
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public ExceptionPessoaNaoEncontrada (String cpf) {
		super("Pessoa não encontrada.");
		this.cpf = cpf;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public String getCPF () {
		return this.cpf;
	}

}
