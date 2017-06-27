package controller;

import model.RepositorioAtendimentos;

public class CadastroAtendimento {
	private RepositorioAtendimentos atendimentos;
	
	public CadastroAtendimento (RepositorioAtendimentos repositorio) {
		this.atendimentos = repositorio;
	}
	
	public void cadastrar (Atendimento atendimento) {
		if (atendimento != null)
			if (!(this.atendimentos.existe(atendimento.getCod())))
				this.atendimentos.agendar(atendimento);
			else
				System.out.println("Atendimento já cadastrado.");
		else
			System.out.println("Atendimento inválido.");
	}
	
	public Atendimento procurar (int id) {
		return this.atendimentos.procurar(id);
	}
	
	public void remover (int id) {
		if (this.atendimentos.existe(id))
			this.atendimentos.remover(id);
		else
			System.out.println("Atendimento não encontrado.");
	}
	
	public void atualizar (Atendimento atendimento) {
		this.atendimentos.atualizar(atendimento);
	}
	
	public String toString () {
		return this.atendimentos.toString();
	}
	
}
