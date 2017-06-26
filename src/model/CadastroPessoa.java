package model;

import controller.RepositorioPessoas;

public class CadastroPessoa {
	private RepositorioPessoas pessoas;
	
	public CadastroPessoa (RepositorioPessoas repositorio) {
		this.pessoas = repositorio;
	}

	public void cadastrar (Paciente paciente) {
		if (paciente != null)
			if (!(this.pessoas.existe(paciente.getCPF())))
				this.pessoas.cadastrar(paciente);
			else
				System.out.println("Paciente j� cadastrado.");
		else
			System.out.println("Paciente inv�lido.");
	}
	
	public void cadastrar (Medico medico) {
		if (medico != null)
			if (!(this.pessoas.existe(medico.getCPF())))
				this.pessoas.cadastrar(medico);
			else
				System.out.println("M�dico j� cadastrado.");
		else
			System.out.println("M�dico inv�lido.");
	}

	public Pessoa procurar (int cpf) {
		return this.pessoas.procurar(cpf);
	}

	public void remover (int cpf) {
		if (this.pessoas.existe(cpf))
			this.pessoas.remover(cpf);
		else
			System.out.println("Pessoa n�o encontrada.");
	}

	public void atualizar (Paciente paciente) {
		this.pessoas.atualizar(paciente);
	}
	
	public void atualizar (Medico medico) {
		this.pessoas.atualizar(medico);
	}
	
	public String toString () {
		return this.pessoas.toString();
	}

}
