package controller;

import java.util.ArrayList;

public class Paciente extends Pessoa {
	private ArrayList<Pessoa> dependentes;
	private String convenio;
	private String login;
	private String passwd;
	
	public Paciente(String nome, String diaNasc, String mesNasc, String anoNasc, int cpf, String login, String passwd, String convenio) {
		super(nome, diaNasc, mesNasc, anoNasc, cpf);
		this.convenio = convenio;
		this.login = login;
		this.passwd = passwd;
		this.dependentes = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getDependentes () {
		return this.dependentes;
	}
	
	public String getConvenio () {
		return this.convenio;
	}
	
	public String getLogin () {
		return this.login;
	}
	
	public String getPasswd () {
		return this.passwd;
	}
	
	public void setConvenio (String convenio) {
		this.convenio = convenio;
	}
	
	public void setLogin (String login) {
		this.login = login;
	}
	
	public void setPasswd (String passwd) {
		this.passwd = passwd;
	}
	
	public void adicionarDependente (Pessoa dependente) {
		if (this.dependentes == null) {
			this.dependentes = new ArrayList<Pessoa>();
		}
		
		this.dependentes.add(dependente);
	}

	public void removerDependente (Pessoa dependente) {
		if (this.dependentes.contains(dependente) != false)
			this.dependentes.remove(dependente);
		
		else
			System.out.println("Dependente não encontrado.");
	}
	
	public void atualizarDependente (Pessoa dependente) {
		if (this.dependentes.contains(dependente) != false)
			this.dependentes.remove(dependente);
		
		else
			System.out.println("Dependente não encontrado.");
	}
	
	public Pessoa pesquisarDependente (Pessoa dependente) {
		if (this.dependentes.contains(dependente) != false)
			return this.dependentes.get(this.dependentes.indexOf(dependente));
		
		else
			return null;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("\nPaciente:\n\t");
		sb.append("[Nome: " + this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", CPF: " + this.getCPF() + ", Convênio: " + this.getConvenio() + ", Dependentes: {");
		
		if (this.dependentes != null) {
			for (int i = 0; i < this.dependentes.size(); i++) {
				sb.append(this.dependentes.get(i).getNome());
				
				if (i < this.dependentes.size() - 1)
					sb.append(", ");
			}
		}

		sb.append("}]");
		
		return sb.toString();
	}
}
