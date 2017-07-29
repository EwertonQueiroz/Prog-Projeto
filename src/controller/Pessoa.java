package controller;

import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private int cpf;
	private LocalDate dataNasc;

	// LANÇAR EXCEPTION DO LOCALDATE	-	 LANÇAR EXCEPTION DO LOCALDATE	-	LANÇAR EXCEPTION DO LOCALDATE	-	LANÇAR EXCEPTION DO LOCALDATE
	public Pessoa (String nome, String diaNasc, String mesNasc, String anoNasc, int cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNasc = LocalDate.parse(anoNasc.concat("-").concat(mesNasc).concat("-").concat(diaNasc));
	}
	
	public String getNome () {
		return this.nome;
	}
	
	public int getCPF () {
		return this.cpf;
	}
	
	public LocalDate getDataNasc () {
		return this.dataNasc;
	}
	
	public void setNome (String nome) {
		this.nome = nome;
	}
	
	public void setCPF (int cpf) {
		this.cpf = cpf;
	}
	
	public void setDataNasc (String dia, String mes, String ano) {
		this.dataNasc = LocalDate.parse(ano.concat("-").concat(mes).concat("-").concat(dia));
	}
	
}
