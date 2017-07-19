package model;

import controller.ExceptionPessoaCadastrada;
import controller.Pessoa;

public interface RepositorioPessoas {
	
	public void cadastrar (Pessoa pessoa) throws ExceptionPessoaCadastrada;
	
	public Pessoa procurar (int cpf);
	
	public void remover (int cpf);
	
	public void atualizar (Pessoa pessoa) throws ExceptionPessoaCadastrada;
	
	public boolean existe (int cpf);

}
