package controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Paciente extends Pessoa {
	private Map<String, Pessoa> dependentes;
	private String convenio;
	private String login;
	private String passwd;
	
	public Paciente () {
		this.dependentes = new HashMap<String, Pessoa>();
	}
	
	public Paciente(String nome, Date dataNasc, String cpf, String login, String passwd, String convenio) {
		super(nome, dataNasc, cpf);
		this.convenio = convenio;
		this.login = login;
		this.passwd = passwd;
		this.dependentes = new HashMap<String, Pessoa>();
	}
	
	public Map<String, Pessoa> getDependentes () {
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
		this.dependentes.put(this.getCPF(), dependente);
	}

	public Pessoa removerDependente (Pessoa dependente) {
		return this.dependentes.remove(dependente);
	}
	
	public void atualizarDependente (Pessoa dependente) {
		this.dependentes.replace(this.getCPF(), dependente);
	}
	
	public Pessoa pesquisarDependente (Pessoa dependente) {
		return this.dependentes.get(this.getCPF());
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
