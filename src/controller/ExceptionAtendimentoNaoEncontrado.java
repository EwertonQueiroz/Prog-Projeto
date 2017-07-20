package controller;

public class ExceptionAtendimentoNaoEncontrado extends Exception {
	private int cod;
	private Pessoa paciente;
	private Pessoa medico;
	private String dataAtendimento;
	
	public ExceptionAtendimentoNaoEncontrado (int cod, Pessoa paciente, Pessoa medico, String dataAtendimento) {
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
	
	public String getDataAtendimento () {
		return this.dataAtendimento;
	}
}
