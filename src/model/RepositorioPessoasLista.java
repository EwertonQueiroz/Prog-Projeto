package model;

import controller.ExceptionPessoaCadastrada;
import controller.Pessoa;

public class RepositorioPessoasLista implements RepositorioPessoas {

	private Pessoa pessoa;
	private RepositorioPessoasLista proximo;
	
	public RepositorioPessoasLista getProximo () {
		return this.proximo;
	}
	
	@Override
	public void cadastrar (Pessoa paciente) throws ExceptionPessoaCadastrada {
		if (this.pessoa == null) {
			this.pessoa = paciente;
			this.proximo = new RepositorioPessoasLista();
		}
		
		else
			this.proximo.cadastrar(paciente);
	}

	@Override
	public Pessoa procurar (int cpf) {
		if (this.pessoa == null)
			return null;
		
		else if (this.pessoa.getCPF() == cpf)
			return this.pessoa;
		
		return this.proximo.procurar(cpf);
	}

	@Override
	public void remover (int cpf) {
		if (this.existe(cpf))
			if (this.pessoa == null)
				return;
		
			/** Aqui vai dar erro quando tiver numa lista grande pois o "proximo" do anterior n�o est� sendo atualizado,
			 *  logo, ap�s uma remo��o, haver� um elemento nulo no meio da lista, dando origem a uma lista que pode
			 *  ser acessada pela cabe�a e outra que est� inacess�vel.
			 */
			else if (this.pessoa.getCPF() == cpf)
				this.pessoa = this.proximo.pessoa;
		
		else
			this.proximo.remover(cpf);
	}

	@Override
	public void atualizar (Pessoa paciente) throws ExceptionPessoaCadastrada {
		if (pessoa != null)
			if (this.existe(pessoa.getCPF())) {
				Pessoa aux = this.procurar(pessoa.getCPF());
				this.remover(pessoa.getCPF());
				this.proximo.cadastrar(aux);
			}
		
		else
			System.out.println("Pessoa inv�lida.");
	}

	@Override
	public boolean existe (int cpf) {
		
		if (this.pessoa == null)
			return false;
		
		else if (this.pessoa.getCPF() == cpf)
			return true;
		
		return this.proximo.existe(cpf);
	}

}
