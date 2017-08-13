package controller;

import java.util.Date;

public class Atendimento {
	private static int id = 1;
	private int cod;
	private String sintoma;
	private String prontuario;
	private Pessoa paciente;
	private Pessoa medico;
	private Date dataAtendimento;
	private String receita;
	private String tipoAtendimento;
	
	public Atendimento () {}
	
	public Atendimento (Pessoa medico, Pessoa paciente, String tipoAtendimento, Date data, String sintoma, String prontuario, String receita) {
		this.medico = medico;
		this.paciente = paciente;
		this.tipoAtendimento = tipoAtendimento;
		this.dataAtendimento = data;
		this.sintoma = sintoma;
		this.prontuario = prontuario;
		this.receita = receita;
		this.cod = Atendimento.id++;
	}
	
	public int getCod () {
		return this.cod;
	}
	
	public String getSintoma () {
		return this.sintoma;
	}
	
	public String getProntuario () {
		return this.prontuario;
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
	
	public String getReceita () {
		return this.receita;
	}
	
	public String getTipoAtendimento () {
		return this.tipoAtendimento;
	}
	
	public void setSintoma (String sintoma) {
		this.sintoma = sintoma;
	}
	
	public void setProntuario (String prontuario) {
		this.prontuario = prontuario;
	}
	
	public void setPaciente (Pessoa paciente) {
		this.paciente = paciente;
	}
	
	public void setMedico (Pessoa medico) {
		this.medico = medico;
	}
	
	public void setDataAtendimento (Date data) {
		this.dataAtendimento = data;
	}
	
	public void setReceita (String receita) {
		this.receita = receita;
	}
	
	public void setTipoAtendimento (String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
	
	public String toString () {
		return "[ID: " + this.getCod() + ", Médico: " + this.getMedico().getNome() + ", Paciente: "
				+ this.getPaciente().getNome() + ", Tipo de atendimento: " + this.getTipoAtendimento()
				+ ", Data: " + this.getDataAtendimento() + ", Sintomas: " + this.getSintoma()
				+ ", Prontuário: " + this.getProntuario() + ", Receita: " + this.getReceita() + "]";
	}
}
