package model;

public class Atendimento {
	private static int id;
	private String sintoma;
	private String prontuario;
	private Pessoa paciente;
	private Pessoa medico;
	private String dataAtendimento;
	private String receita;
	private String tipoAtendimento;
	
	public Atendimento () {}
	
	public Atendimento (Pessoa medico, Pessoa paciente, String tipoAtendimento, String data, String sintoma, String prontuario, String receita) {
		this.medico = medico;
		this.paciente = paciente;
		this.tipoAtendimento = tipoAtendimento;
		this.dataAtendimento = data;
		this.sintoma = sintoma;
		this.prontuario = prontuario;
		this.receita = receita;
		Atendimento.id++;
	}
	
	public int getId () {
		return Atendimento.id;
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
	
	public String getDataAtendimento () {
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
	
	public void setDataAtendimento (String data) {
		this.dataAtendimento = data;
	}
	
	public void setReceita (String receita) {
		this.receita = receita;
	}
	
	public void setTipoAtendimento (String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}
}
