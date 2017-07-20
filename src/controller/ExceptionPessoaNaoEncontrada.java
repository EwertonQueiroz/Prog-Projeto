package controller;

public class ExceptionPessoaNaoEncontrada extends Exception {
	private String nome;
	private int cpf;
	private String dataNasc;
	
	public ExceptionPessoaNaoEncontrada (String nome, int cpf, String dataNasc) {
		super("Pessoa não encontrada.");
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	public ExceptionPessoaNaoEncontrada (int cpf) {
		super("Pessoa não encontrada.");
		this.cpf = cpf;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public int getCPF () {
		return this.cpf;
	}
	
	public String getDataNascimento () {
		return this.dataNasc;
	}
}
