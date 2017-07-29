package controller;

import java.time.LocalDate;

public class ExceptionPessoaCadastrada extends Exception {
	private String nome;
	private int cpf;
	private String dataNasc;
	
	public ExceptionPessoaCadastrada (String nome, int cpf) {
		super("Pessoa já cadastrada.");
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public int getCPF () {
		return this.cpf;
	}
	
}
