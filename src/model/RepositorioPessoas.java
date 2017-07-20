package model;

import controller.ExceptionPessoaCadastrada;
import controller.ExceptionPessoaNaoEncontrada;
import controller.Pessoa;

public interface RepositorioPessoas {
	
	public void cadastrar (Pessoa pessoa) throws ExceptionPessoaCadastrada;
	
	public Pessoa procurar (int cpf) throws ExceptionPessoaNaoEncontrada;
	
	public void remover (int cpf) throws ExceptionPessoaNaoEncontrada;
	
	public void atualizar (Pessoa pessoa) throws ExceptionPessoaCadastrada, ExceptionPessoaNaoEncontrada;
	
	public boolean existe (int cpf);

}
