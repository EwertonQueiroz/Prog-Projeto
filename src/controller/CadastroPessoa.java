package controller;

import model.RepositorioPessoas;

public class CadastroPessoa {
	private RepositorioPessoas pessoas;
	
	public CadastroPessoa (RepositorioPessoas repositorio) {
		this.pessoas = repositorio;
	}

	public void cadastrar (Paciente paciente) throws ExceptionPessoaCadastrada {
		if (!(this.pessoas.existe(paciente.getCPF())))
			this.pessoas.cadastrar(paciente);
		else {
			ExceptionPessoaCadastrada e = new ExceptionPessoaCadastrada(paciente.getNome(), paciente.getCPF());
			throw e;
		}
	}
	
	public void cadastrar (Medico medico) throws ExceptionPessoaCadastrada {
		if (!(this.pessoas.existe(medico.getCPF())))
			this.pessoas.cadastrar(medico);
		
		else {
			ExceptionPessoaCadastrada e = new ExceptionPessoaCadastrada(medico.getNome(), medico.getCPF());
			throw e;
		}
	}

	public Pessoa procurar (String cpf) throws ExceptionPessoaNaoEncontrada {
		return this.pessoas.procurar(cpf);
	}

	public void remover (String cpf) throws ExceptionPessoaNaoEncontrada {
		if (this.pessoas.existe(cpf))
			this.pessoas.remover(cpf);
	}

	public void atualizar (Paciente paciente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		this.pessoas.atualizar(paciente);
	}
	
	public void atualizar (Medico medico) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		this.pessoas.atualizar(medico);
	}
	
	public String toString () {
		return this.pessoas.toString();
	}

}
