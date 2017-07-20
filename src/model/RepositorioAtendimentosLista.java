package model;

import controller.Atendimento;
import controller.ExceptionAtendimentoCadastrado;
import controller.ExceptionAtendimentoNaoEncontrado;

public class RepositorioAtendimentosLista implements RepositorioAtendimentos {

	private Atendimento atendimento;
	private RepositorioAtendimentosLista proximo;
	
	public RepositorioAtendimentosLista getProximo () {
		return this.proximo;
	}
	
	@Override
	public void agendar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado {
		if (this.atendimento == null) {
			this.atendimento = atendimento;
			this.proximo = new RepositorioAtendimentosLista();
		}
		
		else
			this.proximo.agendar(atendimento);
	}

	@Override
	public Atendimento procurar (int id) throws ExceptionAtendimentoNaoEncontrado{
		if (this.atendimento == null) {
			ExceptionAtendimentoNaoEncontrado e = new ExceptionAtendimentoNaoEncontrado(id);
			throw e;
		}
		
		else if (this.atendimento.getCod() == id)
			return this.atendimento;
		
		return this.proximo.procurar(id);
	}

	@Override
	public void remover (int id) throws ExceptionAtendimentoNaoEncontrado {
		if (this.existe(id))
			if (this.atendimento == null)
				return;
			
			/** Aqui vai dar erro quando tiver numa lista grande pois o "proximo" do anterior não está sendo atualizado,
			 *  logo, após uma remoção, haverá um elemento nulo no meio da lista, dando origem a uma lista que pode
			 *  ser acessada pela cabeça e outra que está inacessível.
			 */
			else if (this.atendimento.getCod() == id)
				this.atendimento = this.proximo.atendimento;
		
		else
			this.proximo.remover(id);
	}

	@Override
	public void atualizar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado, ExceptionAtendimentoNaoEncontrado{
		if (this.existe(atendimento.getCod())) {
			Atendimento aux = this.procurar(atendimento.getCod());
			this.remover(atendimento.getCod());
			this.proximo.agendar(aux);
		}
	}

	@Override
	public boolean existe (int id) {

		if (this.atendimento == null)
			return false;
		
		else if (this.atendimento.getCod() == id)
			return true;
		
		return this.proximo.existe(id);
	}

}
