package model;

import controller.RepositorioAtendimentos;
import controller.RepositorioAtendimentosArray;
import controller.RepositorioPessoas;
import controller.RepositorioPessoasArray;

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
	
	public void cadastrar (Pessoa pessoa) {
		if (pessoa instanceof Paciente)
			this.pessoas.cadastrar(((Paciente) pessoa));
		else
			this.pessoas.cadastrar(((Medico) pessoa));
	}
	
	public void pesquisar (int cpf) {
		this.pessoas.procurar(cpf);
	}
	
	public void remover (int cpf) {
		this.pessoas.remover(cpf);
	}
}
