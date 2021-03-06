package model;

import java.util.ArrayList;

import controller.Dependente;
import controller.ExceptionPessoaCadastrada;
import controller.ExceptionPessoaNaoEncontrada;
import controller.Paciente;
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
	public void cadastrarDependente(Paciente titular, Dependente dependente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		Pessoa aux = this.procurar(titular.getCPF());
		
		if (aux == null) {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(titular.getCPF());
			throw e;
		}
		
		else
			((Paciente) aux).adicionarDependente(dependente);
	}


	@Override   
	public Pessoa procurar (String cpf) throws ExceptionPessoaNaoEncontrada {
		Pessoa aux = null;
		
		if (this.pessoa == null) {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(cpf);
			throw e;
		}
		
		else if (this.pessoa.getCPF().equals(cpf))
			aux = this.pessoa;
		
		else
			this.proximo.procurar(cpf);
		
		return aux;
	}

	@Override
	public void remover (String cpf) throws ExceptionPessoaNaoEncontrada {
		if (this.existe(cpf))
			if (this.pessoa == null)
				return;
		
			/** Aqui vai dar erro quando tiver numa lista grande pois o "proximo" do anterior n�o est� sendo atualizado,
			 *  logo, ap�s uma remo��o, haver� um elemento nulo no meio da lista, dando origem a uma lista que pode
			 *  ser acessada pela cabe�a e outra que est� inacess�vel.
			 */
			else if (this.pessoa.getCPF().equals(cpf))
				this.pessoa = this.proximo.pessoa;
		
		else
			this.proximo.remover(cpf);
	}

	@Override
	public void atualizar (Pessoa paciente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		if (this.existe(pessoa.getCPF())) {
			Pessoa aux = this.procurar(pessoa.getCPF());
			this.remover(pessoa.getCPF());
			this.proximo.cadastrar(aux);
		}
		
		else {
			ExceptionPessoaNaoEncontrada e = new ExceptionPessoaNaoEncontrada(paciente.getNome(), paciente.getCPF());
			throw e;
		}
	}

	@Override
	public boolean existe (String cpf) {
		
		if (this.pessoa == null)
			return false;
		
		else if (this.pessoa.getCPF().equals(cpf))
			return true;
		
		return this.proximo.existe(cpf);
	}

	@Override
	public ArrayList<Pessoa> listarPessoas() {
		//return this.proximo;
		return null;
	}

}
