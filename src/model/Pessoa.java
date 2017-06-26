package model;

public abstract class Pessoa {
	private String nome;
	private int cpf;
	private String dataNasc;

		
	public Pessoa (String nome, String dataNasc, int cpf) {
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
	
	public String getDataNasc () {
		return this.dataNasc;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setCPF (int cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNasc (String dataNasc) {
		this.dataNasc = dataNasc;
	}
	
}
