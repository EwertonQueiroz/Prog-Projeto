package padrao;

import java.util.ArrayList;

public class Cliente extends Pessoa {
	private ArrayList<Pessoa> dependentes;
	private String convenio;
	
	public Cliente(String nome, String dataNasc, int cpf, String convenio) {
		super(nome, dataNasc, cpf);
		this.convenio = convenio;
		this.dependentes = new ArrayList<Pessoa>();
	}
	
	public ArrayList<Pessoa> getDependentes () {
		return this.dependentes;
	}
	
	public String getConvenio () {
		return this.convenio;
	}
	
	public void setConvenio (String convenio) {
		this.convenio = convenio;
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
		sb.append("[Nome: " + this.getNome() + ", Data de Nascimento: " + this.getDataNasc() + ", CPF: " + this.getCPF() + ", Convênio: " + this.getConvenio() + ", Dependentes: ");
		
		if (this.dependentes != null) {
			for (int i = 0; i < this.dependentes.size(); i++) {
				sb.append(this.dependentes.get(i).getNome());
				
				if (i < this.dependentes.size() - 1)
					sb.append(", ");
			}
		}

		sb.append("]");
		
		return sb.toString();
	}
}
