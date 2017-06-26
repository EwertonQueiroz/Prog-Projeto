package model;

public class Medico extends Pessoa {
	private int crm;
	private String login;
	private String passwd;
	
	public Medico(String nome, String dataNasc, int cpf, String login, String passwd, int crm) {
		super(nome, dataNasc, cpf);
		this.crm = crm;
		this.login = login;
		this.passwd = passwd;
	}
	
	public int getCRM () {
		return this.crm;
	}
	
	public String getLogin () {
		return this.login;
	}
	
	public String getPasswd () {
		return this.passwd;
	}
	
	public void setCRM (int crm) {
		this.crm = crm;
	}
	
	public void setLogin (String login) {
		this.login = login;
	}
	
	public void setPasswd (String passwd) {
		this.passwd = passwd;
	}
	
	public String toString () {
		return "Médico:\n\t[Nome: " + this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", CPF: " + this.getCPF() + ", CRM: " + this.getCRM() + "]";
	}

}
