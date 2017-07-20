package model;

import controller.Atendimento;
import controller.ExceptionAtendimentoCadastrado;
import controller.ExceptionAtendimentoNaoEncontrado;

public interface RepositorioAtendimentos {

	public void agendar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado;
	
	public Atendimento procurar (int id) throws ExceptionAtendimentoNaoEncontrado;
	
	public void remover (int id) throws ExceptionAtendimentoNaoEncontrado;
	
	public void atualizar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado, ExceptionAtendimentoNaoEncontrado;
	
	public boolean existe (int id);
}
