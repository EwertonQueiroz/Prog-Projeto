package controller;

import java.util.Date;

public class ExceptionAtendimentoNaoEncontrado extends Exception {
	private int cod;
	private Pessoa paciente;
	private Pessoa medico;
	private Date dataAtendimento;
	
	public ExceptionAtendimentoNaoEncontrado (int cod, Pessoa paciente, Pessoa medico, Date dataAtendimento) {
		super("Atendimento não encontrado.");
		this.cod = cod;
		this.paciente = paciente;
		this.medico = medico;
		this.dataAtendimento = dataAtendimento;
	}
	
	public ExceptionAtendimentoNaoEncontrado (int cod) {
		super("Atendimento não encontrado.");
		this.cod = cod;
	}
	
	public int getCod () {
		return this.cod;
	}
	
	public Pessoa getPaciente () {
		return this.paciente;
	}
	
	public Pessoa getMedico () {
		return this.medico;
	}
	
	public Date getDataAtendimento () {
		return this.dataAtendimento;
	}
}
