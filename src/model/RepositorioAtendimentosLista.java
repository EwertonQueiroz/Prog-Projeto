package model;

import controller.Atendimento;

public class RepositorioAtendimentosLista implements RepositorioAtendimentos {

	private Atendimento atendimento;
	private RepositorioAtendimentosLista proximo;
	
	public RepositorioAtendimentosLista getProximo () {
		return this.proximo;
	}
	
	@Override
	public void agendar (Atendimento atendimento) {
		if (this.atendimento == null) {
			this.atendimento = atendimento;
			this.proximo = new RepositorioAtendimentosLista();
		}
		
		else
			this.proximo.agendar(atendimento);
	}

	@Override
	public Atendimento procurar (int id) {
		if (this.atendimento == null)
			return null;
		
		else if (this.atendimento.getCod() == id)
			return this.atendimento;
		
		return this.proximo.procurar(id);
	}

	@Override
	public void remover (int id) {
		if (this.existe(id))
			if (this.atendimento == null)
				return;
			
			/** Aqui vai dar erro quando tiver numa lista grande pois o "proximo" do anterior n�o est� sendo atualizado,
			 *  logo, ap�s uma remo��o, haver� um elemento nulo no meio da lista, dando origem a uma lista que pode
			 *  ser acessada pela cabe�a e outra que est� inacess�vel.
			 */
			else if (this.atendimento.getCod() == id)
				this.atendimento = this.proximo.atendimento;
		
		else
			this.proximo.remover(id);
	}

	@Override
	public void atualizar (Atendimento atendimento) {
		if (atendimento != null)
			if (this.existe(atendimento.getCod())) {
				Atendimento aux = this.procurar(atendimento.getCod());
				this.remover(atendimento.getCod());
				this.proximo.agendar(aux);
			}
		
		else
			System.out.println("Atendimento inv�lido.");
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
