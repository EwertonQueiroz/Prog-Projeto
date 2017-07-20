package controller;

import model.RepositorioAtendimentos;
import model.RepositorioAtendimentosLista;
import model.RepositorioPessoas;
import model.RepositorioPessoasLista;

public class Fachada {
	private CadastroPessoa pessoas;
	private CadastroAtendimento atendimentos;
	private static Fachada instance;
	
	private Fachada () {
		RepositorioPessoas repositorioPessoas = new RepositorioPessoasLista();
		RepositorioAtendimentos repositorioAtendimentos = new RepositorioAtendimentosLista();
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
	
	public void cadastrar (Atendimento atendimento) {
		this.atendimentos.cadastrar(atendimento);
	}
	
	public Pessoa pesquisar (int cpf) throws ExceptionPessoaNaoEncontrada {
		return this.pessoas.procurar(cpf);
	}
	
	public Atendimento pesquisarAtendimento (int id) {
		return this.atendimentos.procurar(id);
	}
	
	public void remover (int cpf) throws ExceptionPessoaNaoEncontrada {
		this.pessoas.remover(cpf);
	}
	
	public void removerAtendimento (int id) {
		this.atendimentos.remover(id);
	}
	
	public void atualizar (Pessoa pessoa) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada {
		if (pessoa instanceof Paciente)
			this.pessoas.atualizar(((Paciente) pessoa));
		else
			this.pessoas.cadastrar(((Medico) pessoa));
	}
	
	public void atualizar (Atendimento atendimento) {
		this.atendimentos.atualizar(atendimento);
	}
	
	public String toString () {
		return "Pessoas:\n" + this.pessoas.toString() + "\n\nAtendimentos:\n" + this.atendimentos.toString();
	}
	 
}
