package controller;

import model.RepositorioAtendimentos;

public class CadastroAtendimento {
	private RepositorioAtendimentos atendimentos;
	
	public CadastroAtendimento (RepositorioAtendimentos repositorio) {
		this.atendimentos = repositorio;
	}
	
	public void cadastrar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado {
		if (!(this.atendimentos.existe(atendimento.getCod())))
			this.atendimentos.agendar(atendimento);
		else {
			ExceptionAtendimentoCadastrado e = new ExceptionAtendimentoCadastrado(atendimento.getCod(), atendimento.getPaciente(), atendimento.getMedico(), atendimento.getDataAtendimento());
			throw e;
		}
	}
	
	public Atendimento procurar (int id) throws ExceptionAtendimentoNaoEncontrado {
		return this.atendimentos.procurar(id);
	}
	
	public void remover (int id) throws ExceptionAtendimentoNaoEncontrado {
		if (this.atendimentos.existe(id))
			this.atendimentos.remover(id);
	}
	
	public void atualizar (Atendimento atendimento) throws ExceptionAtendimentoNaoEncontrado, ExceptionAtendimentoCadastrado {
		this.atendimentos.atualizar(atendimento);
	}
	
	public String toString () {
		return this.atendimentos.toString();
	}
	
}
