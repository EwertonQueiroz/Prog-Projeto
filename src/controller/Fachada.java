package controller;

import model.RepositorioAtendimentos;
import model.RepositorioAtendimentosArray;
import model.RepositorioPessoas;
import model.RepositorioPessoasArray;

public class Fachada {
	private CadastroPessoa pessoas;
	private CadastroAtendimento atendimentos;
	private static Fachada instance;
	
	private Fachada () {
		RepositorioPessoas repositorioPessoas = new RepositorioPessoasArray();
		RepositorioAtendimentos repositorioAtendimentos = new RepositorioAtendimentosArray();
		this.pessoas = new CadastroPessoa(repositorioPessoas);
		this.atendimentos = new CadastroAtendimento(repositorioAtendimentos);
	}
	
	public static Fachada getInstance () {
		if (Fachada.instance == null)
			Fachada.instance = new Fachada();
		
		return Fachada.instance;
	}
	
	public void cadastrar (Pessoa pessoa) throws ExceptionPessoaCadastrada {
		if (pessoa instanceof Paciente)
			this.pessoas.cadastrar(((Paciente) pessoa));
		else
			this.pessoas.cadastrar(((Medico) pessoa));
	}
	
	public void cadastrarDependente (Paciente paciente, Dependente dependente) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		this.pessoas.cadastrarDependente(paciente, dependente);
	}
	
	public void cadastrar (Atendimento atendimento) throws ExceptionAtendimentoCadastrado {
		this.atendimentos.cadastrar(atendimento);
	}
	
	public Pessoa pesquisar (String cpf) throws ExceptionPessoaNaoEncontrada {
		return this.pessoas.procurar(cpf);
	}
	
	public Atendimento pesquisarAtendimento (int id) throws ExceptionAtendimentoNaoEncontrado {
		return this.atendimentos.procurar(id);
	}
	
	public void remover (String cpf) throws ExceptionPessoaNaoEncontrada {
		this.pessoas.remover(cpf);
	}
	
	public void removerAtendimento (int id) throws ExceptionAtendimentoNaoEncontrado {
		this.atendimentos.remover(id);
	}
	
	public void atualizar (Pessoa pessoa) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		if (pessoa instanceof Paciente)
			this.pessoas.atualizar(((Paciente) pessoa));
		else
			this.pessoas.cadastrar(((Medico) pessoa));
	}
	
	public void atualizar (Atendimento atendimento) throws ExceptionAtendimentoNaoEncontrado, ExceptionAtendimentoCadastrado {
		this.atendimentos.atualizar(atendimento);
	}
	
	public String toString () {
		return "Pessoas:\n" + this.pessoas.toString() + "\n\nAtendimentos:\n" + this.atendimentos.toString();
	}
	 
}
