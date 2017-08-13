package controller;

import java.util.Date;

public class Pessoa {
	private String nome;
	private String cpf;
	private Date dataNasc;
	
	public Pessoa () {}

	public Pessoa (String nome, Date dataNasc, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public String getCPF () {
		return this.cpf;
	}
	
	public Date getDataNasc () {
		return this.dataNasc;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setCPF (String cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNasc (Date dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
