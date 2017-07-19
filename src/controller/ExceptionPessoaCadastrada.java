package controller;

public class ExceptionPessoaCadastrada extends Exception {
	private String nome;
	private int cpf;
	private String dataNasc;
	
	public ExceptionPessoaCadastrada (String nome, int cpf, String dataNasc) {
		super("Pessoa já cadastrada.");
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
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
