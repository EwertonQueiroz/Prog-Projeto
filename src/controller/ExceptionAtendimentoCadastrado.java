package controller;

import java.util.Date;

public class ExceptionAtendimentoCadastrado extends Exception {
	private int cod;
	private Pessoa paciente;
	private Pessoa medico;
	private Date dataAtendimento;
	
	public ExceptionAtendimentoCadastrado (int cod, Pessoa paciente, Pessoa medico, Date dataAtendimento) {
		super("Atendimento já cadastrado.");
		this.cod = cod;
		this.paciente = paciente;
		this.medico = medico;
		this.dataAtendimento = dataAtendimento;
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
